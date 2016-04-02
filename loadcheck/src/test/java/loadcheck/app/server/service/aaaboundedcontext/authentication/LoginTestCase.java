package loadcheck.app.server.service.aaaboundedcontext.authentication;
import loadcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import loadcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import loadcheck.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import loadcheck.app.shared.aaaboundedcontext.authentication.User;
import loadcheck.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import loadcheck.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import loadcheck.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.PassRecovery;
import loadcheck.app.shared.aaaboundedcontext.authentication.Question;
import loadcheck.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.UserData;
import loadcheck.app.shared.organizationboundedcontext.contacts.CoreContacts;
import loadcheck.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import loadcheck.app.shared.organizationboundedcontext.location.Language;
import loadcheck.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import loadcheck.app.shared.organizationboundedcontext.location.Timezone;
import loadcheck.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import loadcheck.app.shared.organizationboundedcontext.contacts.Gender;
import loadcheck.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import loadcheck.app.shared.organizationboundedcontext.contacts.Title;
import loadcheck.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import loadcheck.app.shared.organizationboundedcontext.contacts.CommunicationData;
import loadcheck.app.shared.organizationboundedcontext.contacts.CommunicationType;
import loadcheck.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import loadcheck.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import loadcheck.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import loadcheck.app.shared.organizationboundedcontext.location.Address;
import loadcheck.app.server.repository.organizationboundedcontext.location.AddressRepository;
import loadcheck.app.shared.organizationboundedcontext.location.AddressType;
import loadcheck.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import loadcheck.app.shared.organizationboundedcontext.location.State;
import loadcheck.app.server.repository.organizationboundedcontext.location.StateRepository;
import loadcheck.app.shared.organizationboundedcontext.location.Country;
import loadcheck.app.server.repository.organizationboundedcontext.location.CountryRepository;
import loadcheck.app.shared.organizationboundedcontext.location.City;
import loadcheck.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setIsLocked(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459583589256l));
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459583589256l));
        user.setChangePasswordNextLogin(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("sacoOK5TLYwZSCYupk8Bo7iS3jIRw2XNot7BchngdLc3BxZE0u");
        useraccesslevel.setLevelIcon("amooBNjnUBuRTgfRffnHWDSfTjWIRWykI4Q9h3KU55QtlJv9VJ");
        useraccesslevel.setLevelDescription("FPUhSgEfXfaxCHibhDdu3JSIYBM5Ukm3HVXZw73M0n7fAKWjXf");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("zMYxcqCinWcV0b3ppZShCkmoKWik5tYcmXrTGBPCD9iFIRifGp");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("VBWNR7wxLh11FJ3KIKoW7rs0PjmAmp1yMNX4dSMZvmETsUT80l");
        useraccessdomain.setDomainHelp("NaUjRe6Ck1naWt16poatryeboYxFJ5bHRB36vkxTCUMrYNuIaD");
        useraccessdomain.setDomainIcon("wwfBu7ZG3YHzHTa9ScNIP1sWB8oINeMxIT35d4at8OgM1gjyj5");
        useraccessdomain.setDomainDescription("2r7rnPeAewCePxto8opdzcaczWkPs5T1SnL6HNdcDuQ5yaXmt2");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setIsLocked(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459583589301l));
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459583589301l));
        user.setChangePasswordNextLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setPasswordAlgo("A726cUTtrNuhCA80gYK7MurlA2xYafr8sRb4CNls45wC0PiTXu");
        user.setSessionTimeout(2828);
        user.setIsDeleted(1);
        user.setUserAccessCode(47139);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("qlqFjWLE6bQGyDx6OjctSQqZ4E9f27ouvgG9v7js7N675DIx3L");
        Question question = new Question();
        question.setQuestionIcon("sFkmMyIWF5ZjgSDF3VXEjyGgN7nLEMuDM5mWBS1PmUqSGjyeBC");
        question.setLevelid(9);
        question.setQuestionDetails("CWUx8URrP1");
        question.setQuestion("viQhZKOQB9LK7D53HIBRur85QYD1dZfma7R6SYf0elgWF4tvPz");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("OowvY2OCye2v2JuC0edCzvyfoGipI5vgtI6nsANer3g3EZlbWM");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459583589863l));
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459583589908l));
        userdata.setUser(user);
        userdata.setPassword("wlhqfO7tdu490kEPTQ6PyTQPGBSbt4v9ZC6LLSz0br4sKYJdqj");
        userdata.setOneTimePassword("rIRndCAVbniZBmBXknH206LmWicJorHV");
        userdata.setOneTimePasswordExpiry(9);
        userdata.setLast5Passwords("pzct0cmsrxiw5swucTvxXbrBySkoK6qiQ19V1qmk9NJODiayy3");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        Language language = new Language();
        language.setAlpha2("5k");
        language.setLanguageType("wQOkGNnyMqGITeVQ0wJxb2DZvyoPt5BS");
        language.setAlpha4("lOOJ");
        language.setAlpha3("GZo");
        language.setLanguageIcon("lGNPfZ7wGxYhbmsDsixsB9qAYJZ9ye4CFJa9xUvIOg1UG6ShIy");
        language.setLanguage("xmKwnR7gxEZvVAJtwJVOm4mitt4nBtwlyCdtP7AlyJBjP85Vl2");
        language.setLanguageDescription("bgVbfxPeqJZku3HbUnk2H8JyG9FENoNVusI8OfxF13Kk6u78oo");
        language.setAlpha4parentid(3);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("WT7pmeXG3Lsk3Vx6X6wKDb3fdF1F8qSDafi4Bsovvf6OhzCSRZ");
        timezone.setCities("Wo62HVjLseydynxWFSMdBjmmADp4IBRZDaxq7wGrWPeVZdcbUZ");
        timezone.setUtcdifference(1);
        timezone.setGmtLabel("TSP0ByQv6y8dSXE6yqCffmYoOW8cVXM2wSi7WA5QjrY7k8a6vs");
        timezone.setCountry("YkDNShV7DLMcWh4mVt9F92E4ICrhAShEYlGEqMM5WgnxHKFXxL");
        Gender gender = new Gender();
        gender.setGender("sginEf1UJQKEtFxow3kG9YjuXJXdYJ9JJkL1C2Zu9QaG9GoMm1");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("AlcpcIaU4gmOITVqgc5lSZkEIZet2DAMtn3AaHVwC2c9ukXEfU");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("o4h7FbYR99GQSlEp8etRMv1sFjimjlwG3RmM5rWEykdpjBMaKC");
        corecontacts.setNativeMiddleName("PDesuA3zsFtkEQE3vZkgo02xlhcyW0xYVE5PmrWbM3N2zWyZzc");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("aOfxfy6nYtARME8BMiQrGsBQTGnNokdA5Sf3XN29ll1F3B76KP");
        corecontacts.setFirstName("TXnuj1yGsHjOMqVAg16tAoCDg99e9P0EQ5fm3TeILnhVLjyc6h");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459583590513l));
        corecontacts.setNativeFirstName("8IJO02Ay49Yv5Ot75qsWBeAcIYUi8aGXHhT8blaQpjyo18VbjZ");
        corecontacts.setLastName("EEBXsWitEAR4FRWex7y41aHIbtqh6v7Cu4vSfKMIjC14JqqHZO");
        corecontacts.setPhoneNumber("B0ktqEc5Ib6IOAiYMpwc");
        corecontacts.setMiddleName("m75OgOQuNxi0jSEFuYpyHN0WCTMP6HucgMAD9dvfbEi6t2SMWX");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459583590513l));
        corecontacts.setAge(86);
        corecontacts.setEmailId("PIbfGBRJQqyNkwDQUchxbRNWmffxFNkAYUNM41GWh08ewPhbt4");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("ySPMlTZP9GVi8eaKXRbqMgPWyC2n4TBYE3RwhmxfKAg95m2pcs");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("rgi22ycHpSZ5qO6XXtjfIF1fH8F8iXe0iK106QqGY8D3YLB6zc");
        communicationgroup.setCommGroupDescription("r27boGbsSWfbC6jR52DfGpazScjhW5PGT2yvGSN5ZG3XNwZ28Y");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("KjruTJeiba4xYMpvQke6Ym7ZL8WnocD4air5vTA5coTBwjhakK");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("Aaq1VrYCqNjz8bYuYcULbTZwub2FoT1hOwyideCYMEWa3kac7e");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("PCP221wMeP");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("XEZ69tNMbHYjQWmYuLgkldzso7r2vVL8sZiR5ODzKzFD1W1fjU");
        address.setLatitude("qpHZjpRpi2XeTyHwpHvAuPGRm5dZhNNIWYQ1bKOwMKCOO3fUnB");
        address.setAddress1("CHHdXzhEOFLSStPVCi8YWw2PdIGwdGWgegpl4nLXyB5RdUPeVf");
        address.setAddressLabel("4rvBUV97If1");
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("qZNNH3JN2HINjU5MTgTTewq5DHVqJpM4rugRjsZshROsHygeQI");
        addresstype.setAddressTypeIcon("7taoneelm478jPIlrfbiiSCtoxzJ4wO9BYY12tRb2CqcsJ99p5");
        addresstype.setAddressTypeDesc("Ix5zySUVkP9eLyyysXwkJKSp7ZXhyEqcxCaROHlI1twq8pyjLF");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(2);
        state.setStateFlag("cz50IVYZ413g61KFUbUdwE4XkpChZXCYiOnuspfVoqkV4sp0JD");
        Country country = new Country();
        country.setCapitalLatitude(8);
        country.setCountryName("Gyh75CTDjSRlrDSQcYExjb6vk1EeLITUjcs4Vf8lbCaYFaBmE0");
        country.setCapitalLongitude(10);
        country.setCountryCode2("DxC");
        country.setCountryCode1("PXG");
        country.setCapital("igX76axBlRlsOsJRn9FTAO23291pDg8P");
        country.setCountryFlag("wMxufuzvzXTWKB6cqqAlx5G9yfesdFRouBmVcypUPFfwnBUi1v");
        country.setIsoNumeric(835);
        country.setCurrencyCode("pBS");
        country.setCurrencyName("85IX1Fyvlc90sRyWzoptIjEG8Z2ehfsNDXze3yotZVoeZBeS3W");
        country.setCurrencySymbol("1IqYUN93oTvn02OYc2bWEDccpRtdHyoG");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCode(1);
        state.setStateFlag("DrbyxUhzrO2iWxSK2SNch75Fl6v8J3NtR6GvDTFlSdaSbN6YiQ");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("mf2iBOIK0RoKUw44OHvK7blcNfl8b0Riuvz4RGR5J5FEuALe4T");
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("kRcDdtKfQ7aUuRRWcqXoPNa9Ieg05e9x");
        state.setStateCodeChar3("TClFNT5k6robKHoqpzOMQBnob4PK7zLE");
        state.setStateCapitalLongitude(3);
        state.setStateName("xKIPxCRsshsmzQKOPNNk0WN0Loj2RvDvM45e15jrPGmZ9gBgRv");
        state.setStateDescription("wXN01YN5zZdiiWRqYAR62QhL5qUIb5HXcr9zkHGlWClljT7R6v");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(6);
        city.setCityCode(2);
        city.setCityDescription("0iyytfBvw585fwLZljfWqGJ32GRDg4311yxgkNurc4nTVAhGGW");
        city.setCityFlag("4S5FdiLyKGVHNIPvjpqVULYFoso0p3uv7OjogxjMQnmOSd4skQ");
        city.setCityName("nZcAjAvDXqWLzNa9Wht2CUI1JKEUSWDfi535cwAZmlo4CwjdmC");
        city.setCityLongitude(4);
        city.setCityCode(1);
        city.setCityDescription("S6jhTiQ58BPGb2xbYgIlw8B50mOzpgcPUEHwuAqDjcwPShHJv4");
        city.setCityFlag("PK0DJTzw8iQVTU2wHKJqHwNT441FovZ3VOQo4hKv2yLXhCLKPs");
        city.setCityName("VfxEBxGw6b0xEX3w7LphK7hlNemA0dfFYkFNwTMwPz0K2G3i5v");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(1);
        city.setCityCodeChar2("KDvlKIt44oLUn2ekbTbdrXbUATykDHtv");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddress3("Wn5eCgdjLHDk044yV7RiYydRZ21ixhavj2FZUDHJKDBggb9P6M");
        address.setLatitude("jcpWqdRMa2Smt4ezR3U84gGpRh0n8JRk3FBuYoTUE0TiWM0Ul0");
        address.setAddress1("X2iiZjYSr3R5U89QEbWUKC1RDWywVLwrWomIAh5vIKp3ofPUEK");
        address.setAddressLabel("0f0mky1iRaP");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("crqabpMGc29EGIzBL9bvtg0R2mp5eB1yHyOEc8W4yhbRpJvowb");
        address.setAddress2("fC0NxFpqsZdlfO1PpgJrwepy4lEdafkQaVBTmc7u39rREXM9nc");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setZipcode("5xioDb");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setIsAuthenticated(true);
        login.setLoginId("71fWxEIu7aUIxxELaisgRKEIZDc4KQJ9C7ZCke4nLfeTGAtoMy");
        login.setFailedLoginAttempts(1);
        login.setServerAuthImage("oEVoBTj2xwqDwrE343aLo0ZeLbKSvuQs");
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthText("vUDxhRCuC6VmRHs0");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("eIyqJddKLfnKhcnsFynqoRmCCQYUssFSen4Uv5Bi8rLUyfVuvr");
            login.setFailedLoginAttempts(9);
            login.setServerAuthImage("mB8HhOFrob5hHnLMqNFqRghwY0Z4Dlvr");
            login.setVersionId(1);
            login.setServerAuthText("BJdFiBYjBH7bx5nd");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "jy287f8ITCy2QR9ieSxZsNd83DlahV01c77MBSJA1WSBNPPJ6GFCED6ipVAy67SGXLnSZuzcL5x4Oe4GJIhLLlEYzS32xSgOeatDBy5Cpx0zWAQ0lkJAfYB5zyZdl90qRC1E7FDPbdMVMFpK2JbacIP5M0sFgsmjEVKlhysLCb33v4ZIo1Evl6qt2KZn0gFV8bzIfQWhl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "ceF15UuPS8oNUgdwQD3rjtahSrwdis3cE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "DRWsDoXuCwXnPVEyU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
