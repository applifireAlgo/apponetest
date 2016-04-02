package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
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
        CoreContacts corecontacts = new CoreContacts();
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("VKlSV6hMtrC2hKDppwYVqg5sF4FtFSWWRWmygQxNVdfx7QTEKs");
        timezone.setGmtLabel("Bjwi9tpDqBEVBYp30ccoPIOPDwvzOTQZjMBw0azHNkpOArjdyq");
        timezone.setCountry("n5ukBB2qQwoyMJzaaUvQxWAyqChvcMBn4mUFOb7VDajRWoDD2z");
        timezone.setUtcdifference(7);
        timezone.setCities("ER3cGCCxQwuEAuHqEvXnSOTsReISqfP3Vd1rOUIGxLzgSzEeau");
        Gender gender = new Gender();
        gender.setGender("C5qUw5Bmzh77GjGYuvCEoi69yZlmyZqMr6FDBi2w7rp4HkipKN");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("kGvrdnQ4Lsk9NelxNE6HoHU1OHzmhQqvNcZ0n6GxW1OrNw9PGp");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha3("taf");
        language.setLanguageType("tJYdyPZFwf23rHceODOLNaY7nL2TqRqR");
        language.setLanguageIcon("gN9K6SGDv6hplXqY13WkYHoejrnR7G0cjZh8m37QZRnvmxeUfr");
        language.setLanguageDescription("F0aoMkPUgA3U2BE436CtvxP3TjKvUfjswY8PZ41Pq2bQWKe2sc");
        language.setAlpha4parentid(7);
        language.setLanguage("ofUvplyRDzIFPNZCZsFNxxrrTeOs0nRCxJ3kkPqQhcmmKQ1gPK");
        language.setAlpha2("hA");
        language.setAlpha4("XpaT");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setMiddleName("tNHIWfSoI53GabmlPrkszP6UqQe9n7cLiftVHaPof9JjyDnSzo");
        corecontacts.setEmailId("byIz7657cmb2HtiJ9rVsFwh1Z7OONcl6y4rIBweblivjS4B1P7");
        corecontacts.setAge(38);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459587676891l));
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459587677104l));
        corecontacts.setNativeMiddleName("BOIOes5mf92llNva5Pe0f5XTWr8Epl2lxKEOBT5S3sFHgmu0f4");
        corecontacts.setNativeTitle("uku8AKvt6d1QqVIDa7kKzNpWe7WQBdBdWPrrtZxAZWGRl17AU8");
        corecontacts.setLastName("XZCPHGjUtHlqiQ0Bf9TRU8bbMoi3qAgughNIc2AMlx7KANFerT");
        corecontacts.setPhoneNumber("j9CM86Au6a2jdqGbpmaK");
        corecontacts.setNativeLastName("3EjUDz9vMvHDoxt8EtP0Ggto2XsmujQUsKSKaWBSpcWS1u4QBc");
        corecontacts.setFirstName("R2X2J8vU6O5YLGfAvZWtmMdrW6QaWTM4X3PvrdfnacIb5teog9");
        corecontacts.setNativeFirstName("66UIURMywgzzkteu5sJLwZL3ym0cy2jihJrGQyx5LXpVX6EfLS");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("wMaHEBKFWHtVs843Q7C5h0wE5NqQP9gniAEijn18kqgvDnsqod");
        communicationgroup.setCommGroupDescription("4gHunrJT1pwHqalKwl9gWUhjxrKaErawhKZlfdlopQkYgVEETG");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("1z3hrSNmoeOGEGDE9CAHtINwuhqowQjoj5KUiySXLiNPBg8roX");
        communicationtype.setCommTypeDescription("hJWSfXW2qtzEoomM5D0XFlGtCniP7FhhVACy0qtMk8RRIwlETM");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("vQjJd2LwiP");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("JExRG3JqRA4xEYHp3X7jtwFrM4NWgAiVX2WB49bX4EnDgQrQbv");
        addresstype.setAddressTypeIcon("KUdkb6kao1FuAfYUcqlX8ZPJoDsbypFNK3rBFgvKjuXwqdtLkf");
        addresstype.setAddressType("YtjIQkL6D5qKv7mBYsjBHz6G89GeaEJZ6F3CfEP161Roi6wqMi");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCountryCode2("mQI");
        country.setCapital("aceCfO5gq9zL4lXA53cDcdg339ASCTLZ");
        country.setCapitalLatitude(1);
        country.setCountryFlag("sWFXzTKWi0Thg2zJMxJcphqTjvPo3yAdmF9R765drSp60XVX5p");
        country.setIsoNumeric(122);
        country.setCountryCode1("dgs");
        country.setCountryName("C1N3VnbHZG0cn560qLe25ImqzNmaOEk1jxNP6t2pd6ThMwpMuH");
        country.setCapitalLongitude(5);
        country.setCurrencyCode("pkM");
        country.setCurrencyName("3CYwiyhMH4d1VKH2F5tb9Yg6UlDe0okVMWJPCwI0wKbXgco7vt");
        country.setCurrencySymbol("vpuSthmp0JvPSoLSojC0zWsOrBZn3mvx");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("D4X809egn3D5UA2Ugi0NkVaJzGgH3AMTCFqq1sTgn4IKTOmzcx");
        city.setCityLongitude(4);
        city.setCityCode(1);
        State state = new State();
        state.setStateCapital("nomMStU70WFwW3HsLpi9sa1997WVSaZ99XcxOop7MbtairGuta");
        state.setStateCapital("adgGwx3s8GuVvPk275CuxV07S2DJIzKKhLgIPJianfYy5Lj5qT");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("D2Ng8zOboCe1KzxQ0E3hPsfVaxcRdNxR");
        state.setStateCapitalLatitude(7);
        state.setStateDescription("gHF14Is55Lex4iwUXe5GTxNDW3REcaDcRpKenPc3KajhcZMSYO");
        state.setStateCode(1);
        state.setStateCapitalLongitude(5);
        state.setStateFlag("8gyABulrHhEC65980qxcDTbgVpM5bpP8RdYB6RXtdPkWyO4PbT");
        state.setStateName("UOXL2IVU3U3YghbzkAEARAKIoaNaNUkDvEdtVpy4dmEgekXSUp");
        state.setStateCodeChar2("juCzcHkGZOp39f7SXPpN56cYymgJByEP");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("tAFbokRwVXwwvDIZxvb6vqFx6i6b4kCMA4HT68touwIDq3COpi");
        city.setCityLongitude(3);
        city.setCityCode(2);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("TtsMqGVi1BcQw0Whd1y938m8cR4wltk1ZJKJ4CnQLhmv62wF2X");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("Fewbog796POyGLoAlksIRpQYNIUfImxdyFoUY7wdWMuQKUWObW");
        city.setCityLatitude(4);
        city.setCityCodeChar2("J8zFJ2Vf924m8Gyw4TdUJy5MgekhKI94");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("n3ezN87d1d6");
        address.setAddress1("Xk2AjOBuh3BLXQl07cmziy8CZkaF1bnb9dp2ImH9UujQ4wDrEN");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("wqt2Gq4G14bURWMlLeogB8PJAm6005LGtPJoQS8EJ1JXsJ1BZz");
        address.setAddress3("P2eQTOwrjYBSfDcpy6R8CMpbyyqBoAxV2wsyITK0Z7PBd9sI3P");
        address.setLatitude("SAKBHEsukvTzDtKJyxtWQMuaYjLtjJej9iCU6toRf1gD1XS72o");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("hEyUzy");
        address.setLongitude("O6kbwsVsD4ePJRUT4GLvMd0fxxoWhv7lMIzFokWNxHqeJcQIT4");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(18724);
        user.setIsLocked(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelIcon("P1sFoKjC2y3UH9iyYxtCyVqKoBGgrrbNNX7F3xXCoFhlvMw7Ej");
        useraccesslevel.setLevelDescription("uJ3zEmAdtDpp8q5MT6wxrHXIYKud3zimgxitJt5WOzZExlCaSC");
        useraccesslevel.setLevelName("NFG8GiQlmsfDQzE8VlUGwx3P8oKfRSlXwa6UvG4yjf5CvGFoQY");
        useraccesslevel.setLevelHelp("KJ8HVO6v8025Cd0kqwMKaBQZxqBsANaaDvT0b0F5KhM9w0vzs5");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("7MlUWbRcgcNJpvQpLozEINmFhgMbEQT9iEzicdeWndwt3MGUus");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("HuDX0ooB1ctsy3rfMRsWWiHjIRkDqyt7qWox0VJ8n693jInVKs");
        useraccessdomain.setDomainName("KMfvRx4iqZE7vrasRzgrT6Fb41MzqYspE8KKez0WfQax9fD3bI");
        useraccessdomain.setDomainDescription("5VKfhTrdmoDW1AshwtV2S3xrPicFevzc6I7jLqagleOfB3OrxY");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(3298);
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("wB9FKWLldCOosJAmxxp6AuE6B5vh0VbdiKvg1s1GyCQL64Lorj");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setSessionTimeout(1731);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459587678469l));
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459587678469l));
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("xAhcAdEszeNkDXaOIaqbxWDM85aWxkbL1pZ3AdTHVEEDUrjeoY");
        question.setLevelid(4);
        question.setQuestion("PG6CRslodcsdoLAt2uxoOjTkEa9Cj3x5glMj4JahO3taqGPxvE");
        question.setQuestionDetails("rAAKkDyE6d");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("b1jmf1z2FY20cXXRRC85ppmmGsx7eNA2a5JlVSAMOhSZTDqYam");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setOneTimePassword("Qt2Zv9j1PC0F7UTORcsWTlN3H8NFrgPb");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459587679013l));
        userdata.setOneTimePasswordExpiry(8);
        userdata.setLast5Passwords("ZzQiRw3lCho8wsSUlLQyyWm3qiXGa1P8YbmdqCgOd1BGbDJ47K");
        userdata.setPassword("02mXzlwd0osGDkp8rQ5g7yusiQxgapjYve5MWyYF25TQrJTCqx");
        user.setUserData(userdata);
        Login login = new Login();
        login.setLoginId("TTIdhruamLYyu4GLNeNtO7n8YGALFbth1DItBStpsiGKAxjDdG");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        user.setUserId(null);
        login.setUser(user);
        login.setFailedLoginAttempts(5);
        login.setIsAuthenticated(true);
        login.setServerAuthText("OXr3LD16SZITKxZL");
        login.setServerAuthImage("ifaBbSxEHGkpEwYbxlqKT8K1czxfMXQB");
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
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("D8TKs2iDYCrj2xIgBNf32kaZbHdCnCbeRguwoMX6alsAKC8g26");
            login.setVersionId(1);
            login.setFailedLoginAttempts(4);
            login.setServerAuthText("CaqDSsXWc8U4OCU5");
            login.setServerAuthImage("4MdXKz1ZP3AisYf2Ts4Sq1YJzAcPTyUK");
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
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "vJGNaOnsHts9ecIeIuxKKKC4st0KB8RwAYXzU6sqfYNGwwNkVxk9AJ3KoIatTO37DpFRqiE3XjOLgZwkA3yn9UucBFN0tDY4uyce2PwmvR9E8JLEm92Z4kBTO7uh5zUtTEJY2bSjS8qMH00S4W9p1tpmsTCKa1jp4o4YJmtPTfsu1tl5NiX5ERWPhrx84b7qRd3za8fzl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "TZEauDNl0rX0bJFMaRbglRuFELExRtiuo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "rl5VCxqHJ9opeTjiZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 18));
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
