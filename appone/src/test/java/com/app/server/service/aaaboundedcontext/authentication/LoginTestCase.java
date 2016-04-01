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
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
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
        corecontacts.setNativeTitle("XCgDlFeI0rmn0KSlKnlsigoSUYLlxgaz7k06OeL9Pz6pzK70J2");
        corecontacts.setFirstName("18OVReIDb4Sp6tjDwA7g0tIJ0S9rWYLMIzswfjQrV8VfQ6j8RX");
        Gender gender = new Gender();
        gender.setGender("lqGtyNLjDsInMb2bFJdwUjHYHNkZC2BJQwZWt9KK2b778WVN5d");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("0BHJEYeGrjzcvGVyTiUEwg2kAX9sERHGWja0zkL3d3LToR59c9");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguage("6Ay9v1c6aws2rAeI9SfytiVH6b3VPp15YdkpjoIqcLMJsYrcdm");
        language.setAlpha4parentid(9);
        language.setLanguageDescription("toA8nUioJazHsV9nfMfb1q20xG2E0Go9hhBUGB9JDONH3qKdWM");
        language.setLanguageType("eeXV0wGwMZEA0jMiAgAKJ2sAjio6vqBM");
        language.setAlpha4("ZZWn");
        language.setLanguageIcon("GOezZ4fB7L5ZkgYqYWutc1tZNWwZ96hSaRbOOdZx0aidJGdJEB");
        language.setAlpha3("L0O");
        language.setAlpha2("qE");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("hDj536tqEcOEjYTk01coaSUJPK40HcBsUBfPX9Ykg7kCBkcCoH");
        timezone.setCities("87ywR9iNeTBxYnfxFfwAbXf1Kcm0YbCWCkD5gN8IgNOEaiPeii");
        timezone.setGmtLabel("Wx4EzvJfSvSyy1fD9ZcZq7GKlBhqhhMLrne8ZiuYWYo353dfWe");
        timezone.setUtcdifference(10);
        timezone.setTimeZoneLabel("T4fBAxnx5MpyTTI3LxQQNWwJYhKKp5hwhi1ZHEi0UoQRcDJVQI");
        corecontacts.setNativeTitle("Jju1m4PzZOLokEKb231TgRpSJoPyDyVtk7heOrlvCDztaDZKqu");
        corecontacts.setFirstName("3vBMDsaWZoxdLOpnhG0AaF5S0c3qsA1lsuu9O0jVkIjUWMey5b");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("aF6YX9nizJZogwVBhnJt1MWS6OE6utAZXswTb1dPEGQukZvqts");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(27);
        corecontacts.setLastName("nnOoN9aJWqcjoyanvVvTfvh9Mhe4PYs1M6krzXFNHjYJB6kR5S");
        corecontacts.setMiddleName("bIldT3GDdqI4QKbZkQzaEwn3muYVLeiyfuKwezbwpTlk7Y1tZy");
        corecontacts.setPhoneNumber("6PckNKN1uEWUiLT1o8Ef");
        corecontacts.setEmailId("fhWhuCUD9ObPz7PzJIzFenUlXL44fIKXTDgFxsX1mC7cK40Qnc");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("scQqXAFncc440KdleBir4aKDKjwu7PuqzQRoTSrsXzG37v88Ix");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459520626893l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459520626893l));
        corecontacts.setNativeLastName("ZGXGeKQf2TyEu8tSVwjUWGE0Dxer3dnVtJ91K695Gdg4RDMhI6");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        State state = new State();
        state.setStateFlag("EFHWi0xZCvBYeMePtAE7hrGDSAgHLF1P84xwoidfr6UAgvNeBG");
        Country country = new Country();
        country.setCountryFlag("twegjxeAlDhHQIGUwMGJrWMXy8JCqDNpqTc5EwwSA2i81HgqNN");
        country.setCurrencyCode("ijq");
        country.setIsoNumeric(701);
        country.setCapitalLongitude(7);
        country.setCountryCode2("og2");
        country.setCountryName("ujdPx0n4RQVvo5lxTRQxhhndic4vTgdq1DFOvuaR33coGHs1M4");
        country.setCurrencySymbol("05sw8guivr66fje2abvQQZvPUSBtVvBZ");
        country.setCountryCode1("LIy");
        country.setCapital("T1toQ6jUh0uuZdCBfQ6gjrHT4nkX4aen");
        country.setCurrencyName("DGIS2m8YfLgzP4XOjze9pajrRTysHqaJvHckr4hc54RJAYavZ4");
        country.setCapitalLatitude(2);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("NFm1nGRa1q0HbZiqj5to24xywdXGF9Q13HvdyPxVfvoqMDBMza");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("nLCMoYDz7uyYZOoIOmvAHdGNb81CYI1sdh8Gtwlv7w8o1u53IQ");
        state.setStateCode(1);
        state.setStateName("y9oIVNvxBOT0K1smXvcCiWR6L1qzTPGq38Wzi7TRyUQAoMF4xi");
        state.setStateDescription("WTNZQKyc7O9Wlxy4hDU995ZtQBy1o35hQZZkudhqRLOus28I1d");
        state.setStateCapitalLongitude(6);
        state.setStateCapitalLatitude(8);
        state.setStateCodeChar3("MO2RqLfLkKfZPDW33yHlZMRIP6YPDDct");
        state.setStateCodeChar2("3Mt4X76GWh3ciPUUKzt8Wax0HHaoJrJK");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("Arq3YomUhTN8MeBQnsfQWTRu4JlHmxefwsxGiojwN2ZDQR6kUr");
        city.setCityFlag("QK7WoYbrrXiSM7z1F9TUpImSnc0WlB830pQUlLmvou0dOwn7OG");
        city.setCityLatitude(4);
        city.setCityCode(1);
        city.setCityDescription("G0pONVBPvQrVjVAgwAXOiRUiAhS9mPpNhpWV1Vs4p43DW7qlF1");
        city.setCityName("gizHrEVADdwotFNv8ge5Lmixd4X3I35rAauIlCLVfiWtw2ea10");
        city.setCityFlag("1EqgiW9pJmFr1Dgsuu2kMXhszuiZx14kCo97OfUxHerdEoP6yT");
        city.setCityLatitude(1);
        city.setCityCode(2);
        city.setCityDescription("Bw59Oi0OfeyUkWseVNGrvYWLBva1R3JTOpUyXmyxUpZHzUIFmB");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("xL2A3TH8K4IBcGFto9D2Ahn7YHYFTZgG");
        city.setCityLongitude(4);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("DZGH2gODJRfItL89HkhMbTUK5yPLRG2XpF477w3M9jkAjcG2Pa");
        addresstype.setAddressTypeIcon("KCMEFhOOTNAQVnUMI7N6ELubYTJ8e3MhKkQtM9PPc1Ny4UAuYN");
        addresstype.setAddressType("v3QalePUPLerFZnP34aifFp9Q5cGDAjlcOMo1CCr4v6cyPQo36");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("PgAwFO5zzG5s3lbCOsI2kaaqn162djfGldtZHyGKF7p0ioPxYe");
        address.setAddress3("4SPhHmtrvgzyZwLFIgChpJjRYoZ7NczcltWISDWQNUxGeVNZcq");
        address.setLatitude("Jaio1MNf6IhWm3QrMkpMdtvAX3yIbzJ7FXzfP9NaU7nxxmJIZQ");
        address.setAddress1("Tpdxqf25lxrjSLBUBokCWJM6wzuh1JpHmCYRg4C0DKRx1lk0A5");
        address.setAddressLabel("acQ3vH1Q1Vn");
        address.setZipcode("RVWyq8");
        address.setLongitude("YAJZFUIJUyTzgDTg74R5Bsic5fqxlCpTtxlEYeJNsGFUseY8QL");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("kZoHqz1nOT");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("zYaq1NCpIJFfGXrdJ0vnjwcumsixw4CMO4JUlfKmMk6ybXLcOg");
        communicationtype.setCommTypeDescription("TRR8PuW998nss5xMnIzCQdDCX5CdoJ9v5ZjtesuS0EpJzhEMrE");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("Puzhp4P9YrIO5VhIuYX9XMnKs2Gfo0LdRsZlw3LOw3CxisGLlX");
        communicationgroup.setCommGroupName("98Rs9Ywv11aFOySREcvn3CAxcd65bzc3yIlJrlFJAVodYbqSYY");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("0kp1XPJldD3lSIXXFNr5Aj6op2Wos097GOMOjvMa7NjZTaJ6jZ");
        communicationtype.setCommTypeDescription("P4z7oSIZCdfzPX0PZNTvek8uozrVXG96xYP21nPOWG37Mf1p1D");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("U5BL1prtFX");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setSessionTimeout(637);
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("tWzWqjhX7c8yKuC20ZfwP9RI5eQhMhcn2vzKpP0k5FDqDpRAcg");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("D906Q7C8mMa5eGfotzGwl0oOUXWlLSkaBnaHj2gp5rj90IorUk");
        useraccessdomain.setDomainName("rhGRwQ1QIWSOM7Pl9236hK0aw5YwmcaqEPTYgOb1ifr75IcRbf");
        useraccessdomain.setDomainIcon("LWKhg1OPqRcjXHBdLkb1xnUcOfo8w2AcNUfat3i0LUFpFiAeuI");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("dW3TpldXXhZql4MzDxo3wxMep5odsQf7xVbLQzQp16RUQmRJQX");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("4Xd3vih3kHg49sTmZdYdTYVbUX21IDmtw72Glyz1giQdltjBkv");
        useraccesslevel.setLevelHelp("4FUQ7mRBzXfESLA32mDNlIAhmJxK8L2xeSaLx09VN2ZVRZWr27");
        useraccesslevel.setLevelDescription("crtUCuYE4MQdPJ1t7Sgc2YzO2YxuHbDTGHJMvdBLHL6b4H42TQ");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("4WgElMAxpQJH4osYGsp8qzmCXtRxOHjYMsLjGFZbjVynZXqeii");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setSessionTimeout(1877);
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("crW4JDMapADimpVCmSZrv1JTkqukXlPeYlMY8etmJ842B9Qkft");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459520627963l));
        user.setUserAccessCode(31780);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459520627963l));
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("HNhgudyuOP");
        question.setQuestion("ItIRYbr1Kob3TeqJ34rSl1ZIwdApuRBuYt0aUJfs6HiNIM7spM");
        question.setLevelid(11);
        question.setQuestionIcon("GmNa7bq5QcfGzNhROWw6meriKDMLzH3on03LKwjmNLInZ0Ygdb");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("HfD1PHJIbrMqiOExfCktoEGHZcuiivMTMDGATevxLRzw2HHaSE");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459520628358l));
        userdata.setOneTimePassword("X4wmpVK6AHIsEfvq5y81oRKfbFJJIWzL");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459520628400l));
        userdata.setOneTimePassword("L0VtFT1q7vWrdvGaQtjh408GbHdSJoVr");
        userdata.setUser(user);
        userdata.setPassword("sNutZ3VCzdRxdQD0KUhCLp7LoWYiAH39FuA8BB4kNFgRPcgZKv");
        userdata.setOneTimePasswordExpiry(2);
        userdata.setLast5Passwords("lVTkw3aNLvR6zuVbahS9fjuqGr8YIELrzHcuV5BI4hg8SEhZt5");
        user.setUserData(userdata);
        Login login = new Login();
        login.setServerAuthText("ULznyrvtu6q7Mk7u");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(6);
        login.setLoginId("dXTBQ5uCs37rHHarQHEoH873V8JdtlipiF1MRCcQfxwR0oX176");
        login.setServerAuthImage("e21eYzDfjDP10X94dly5F9M8P6PhRdsF");
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setServerAuthText("pGRT1yUgfKd2BaeS");
            login.setFailedLoginAttempts(9);
            login.setLoginId("x5MsJSmRvM4pHGstgHTisbrOPbf4eRLpciagGX22i3dmtSWRyL");
            login.setServerAuthImage("mzDTwAWei2QKLvDEJtiJZKj4tNTPB7aH");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "S368Z3N4Uaal3wlaWrd4WRJ3lQ2kqo3yC2zqfljEw0UqXwD9QZWxrp4R72Tq4Dga0mXffvQd2giji4CsVmlA14WeHe5Z3vb6w2TkLpaM68JGr7SsZLcGriqz1E2dSc4lfsfZKtowYSzxL1WGxlyn6KnaJA4UL4EePbzTDUwKwrayRk3HZjsRrDiIaFRaq4mLz8PKvFI9F"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "3YfM9VpxMlcWrLWb5SIsDvVMztAzCeopy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "sCU7J6RBpB4E4x4nF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 16));
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
