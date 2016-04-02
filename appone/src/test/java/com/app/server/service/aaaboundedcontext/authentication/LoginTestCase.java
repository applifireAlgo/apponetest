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
        corecontacts.setNativeTitle("3cs97RMwLGy90UzlaBkOWdK4zJBMAj5HfFmVXIJSS2AvUzW5Y1");
        corecontacts.setFirstName("IeKKnUMkqz6nqzIp0IvLRwmm0FF1lgRiqgGBJXAGrce9S1SoO7");
        Gender gender = new Gender();
        gender.setGender("2bymzkLzCUu8gCUMHJJwmRxUq9pIrsVjnUxTJmHr3Rx1Zeihni");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("62a98j2PWYtLeXrMMhz5eO1IxeLqhBCN1kZeITYisl5YfuKg7W");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguage("fC81S64XkjTas3Y3OsRV6ZprtU6LtxbvK3ma3kernRovxPdyyA");
        language.setAlpha4parentid(2);
        language.setLanguageDescription("qYxpvIVTeEnQ7fE7CFx7bUSGKKdpftDzjs3litDIJf5Dt7AGNw");
        language.setLanguageType("clnR6zBIM1dNynBqUjDo72LVRWtJwDHd");
        language.setAlpha4("4o7l");
        language.setLanguageIcon("YFjAslRBqhAZ6d9xtbgol5pwXLAFdSylcxeukyigXpMlwFiYUQ");
        language.setAlpha3("sgZ");
        language.setAlpha2("ZG");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("P6eb18fiHfJhKA56OAViwcRgBVq7yJYj17AFOCyjDtprzpuzaC");
        timezone.setCities("PpT3sZ7EGc0psduBuREKoJ6wuvnqSAOGU5f1j4MwiSNeDtFeeo");
        timezone.setGmtLabel("vsCeu8MQxKCLpragVMUslFps90gqToKPr20pszKk8qZrjqfdpv");
        timezone.setUtcdifference(10);
        timezone.setTimeZoneLabel("WtbPXLnOcXA9szLzsQTYGpQEjpG9vzdDtHpo6QBJ28YWtGympH");
        corecontacts.setNativeTitle("82udtDn9c1dUjKAKN8HST9UBmURo6rme2DeP879h86tmCky9pN");
        corecontacts.setFirstName("9TAVzumk6qDCHnZjuoVusaRXO8ZTgBDUOTqeYR8zvThTG9puhe");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("IuSUFTxOKzxufzu5adJk4whMiLBFmuZFU3PwB3bVgvqK9EuCTv");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(46);
        corecontacts.setLastName("LiSKQfkSj4QoIwer34Q0xiazhm4WCUoprI4ZiSNgaXCZYCuA0j");
        corecontacts.setMiddleName("6kPFaKNE5QgHTY4QzYAk5g0oSaiGS8LoXMHoBjPgnjUytSRgjq");
        corecontacts.setPhoneNumber("JnzXeRK3dnYJvXUP0KKi");
        corecontacts.setEmailId("g6xPANv98X1WrRbZZuaYZG3k3aa0cID9G7vXcJJW0a6xJypCY2");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("8u6DJRwBZsolSA71Kif7EYNRaetTmMFAwl2kkA0NOHUXprwOe9");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459578741418l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459578741418l));
        corecontacts.setNativeLastName("hcdcaBeVgeC1YEJiPj5oOzWqYlXZsYkAiqYfIAhqoizW1PvwN1");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        State state = new State();
        state.setStateFlag("DwUO8RZC8ofF309BuQjR0pqt6YVfaLfJt5z8jWTK7S0JEwiyku");
        Country country = new Country();
        country.setCountryFlag("MocWpiww0aapGRxEbIsWHwzRP7IsxgKQuiPjF2mBiXoEeqOpAv");
        country.setCurrencyCode("fa8");
        country.setIsoNumeric(557);
        country.setCapitalLongitude(10);
        country.setCountryCode2("Pnh");
        country.setCountryName("l78W3kDO2R4RUYG0D9m1suH03yhYsu6cop7VTsOfnXmlvNqCDS");
        country.setCurrencySymbol("JIogrpBq8uhMuoRlLoTbVL9Idzgj80jP");
        country.setCountryCode1("uWV");
        country.setCapital("wZu3J08nCyVfRs5q8nFpY3HWfie1ZR5q");
        country.setCurrencyName("nVeU456apFjADyA12B4XjPXNwd9NIGRXaidLPAYW0PunWvH2rj");
        country.setCapitalLatitude(8);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("JxTJvEGPXeUDtl7vfDiAMgqfop8O0sagkxfzZk3E0A159bXboc");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("cLnLUA9vSF51lbifbvJMlDHHDJMhAeh1cXPPbOfcGissDZlXcp");
        state.setStateCode(1);
        state.setStateName("otJhccFMGXbfKd29ngmx9Xq8AFOMzeqv2XccDD7AIGGb1cvuNc");
        state.setStateDescription("8VyVYgw7bF7tKaVapkooaI029etMmWvJN8r9NVO2NSbsh1zaQw");
        state.setStateCapitalLongitude(3);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar3("kZjkVPpAlaDEhV5Z5vEUUXtrTp93Kdei");
        state.setStateCodeChar2("wTQB4w8pGXGeveh22lWUujWKGHtDMMHJ");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("kgwBkNWilyt8eVLtl3VeFRF24kaIlpaZcT1yHp89ZYd9owq5jf");
        city.setCityFlag("xpSXeORY1yEJFlIlLcXL07pkWhso3gBJuS2MV0ZwqMkz3OE7de");
        city.setCityLatitude(8);
        city.setCityCode(2);
        city.setCityDescription("0vuOcHi4VYC2yAiUsaqS5KdalVaupQN4Ntjta4CD0CsTMOEktX");
        city.setCityName("JtdpXU3bitnkNNhRG00bPVH2K780vudXcOOsXqTJrZhY0ef89Y");
        city.setCityFlag("cjjV5QcRZRKJRl0libLy8vkzFOfvi2eBh7SMWE08LjVinVQIbH");
        city.setCityLatitude(2);
        city.setCityCode(2);
        city.setCityDescription("Cu6K6Qo2nvVeWDF65IfFJ9lTuAw3QLz2DM7cFRg44fHJh5OBLb");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("JvnkQ7zCqTG6lcTUflZZFWpsbRZwCzxS");
        city.setCityLongitude(8);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("JYMEgdXhYs01dTR8r5hD4PdEATfcyijJmbiWYIl7rEEO5srlGB");
        addresstype.setAddressTypeIcon("1tutv3xHzqTCOthtQSrLAmuLatoYqEe8Yn82qi2pGFQZ5KsQH7");
        addresstype.setAddressType("OeMuTKe7HeVoPEgjv46PBirdnN8KhjeIML5YLaVJnShj28wuLh");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("FtYIwFAc7hVcLKMXvwO4NmWf39V6cWEvmA66qILD21gKHCSxvh");
        address.setAddress3("YEaUelw6DWd3T6MsBAvXqjtjgLpzzDDrgAwi7o7hfSJKkiTwJV");
        address.setLatitude("MPPGKpMyTKtsjOhKisP52sfzeo4Rp0D0cpkXbsFzFaPdnwRKKf");
        address.setAddress1("TvpYrbgHmiXmFfwvNtuoXGPMa72EmGHD0BkOKo2ka6bh0U3s5Z");
        address.setAddressLabel("K8O1WdDaY6f");
        address.setZipcode("2kluys");
        address.setLongitude("0oKsUHKzd88QKvRHgekt66nJuA0aoOPZqrFlDg9DwdgVq2QfOl");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("fCizxoRG4T");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("j8StvHms6b4Kf4dXlukOtaokxNMPCbWhmALFN7dsWEMeYaCr8J");
        communicationtype.setCommTypeDescription("k1TfpVvuSZ4b0wV4raMp7XxTEatljsFZPOAVb7h1y9Z0qXp0RY");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("AMGJh92VRHygGkvEli87ezyCWeFQQRYNm7g8b3WnfSE1ekOjKb");
        communicationgroup.setCommGroupName("vplsJvHCxnuCqGJbDS9VP4dwOGjA7VINsXaRLqAy8wmx9ficYS");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("yvzWmE0PcKAptfHIBlnrmSW8HP7cqkH4Ookg4JS39oUIcugx0g");
        communicationtype.setCommTypeDescription("Pka1QmAMgOpEggc9pB8BV8CCEz2WvJC7tFmyXFWXbIZzzEt9e6");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("c03OMzifqq");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setSessionTimeout(2891);
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("0keufVZAPG2zwqhzMNddLLWOJWyfOvRDh2R3jCaD7bOAC69gDy");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("ZzOJ0XaKRtg4OxCQftxwp1axxtFW3rKISW9RrCRnxMXVdMosQU");
        useraccessdomain.setDomainName("5PQZczMATf3MctJEZBF7dkX95j0t9VtOaXygHXd3Tzx3YiyB0Z");
        useraccessdomain.setDomainIcon("F4WGgNjJYIRuJVRirs74Oq0UUrH8JlZpxh0h2CQlZupK6ZL01M");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("m7upiueu1NTJPh10DoI37Gbj4J0eNvB7KdtiS5E21wzNJjMYdR");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("0wUCYIeHLJn8T2mbXWmxLN4wcckuHVU2SLjE1TtruGFGjLJGNP");
        useraccesslevel.setLevelHelp("iXRlPLZfjOKhryenCEyInpFRh2sVMFBvNNNu4heFGyUOqwKNju");
        useraccesslevel.setLevelDescription("xR9oZJehu3nhinqPq7iqWihOUkh4LvlUtSafwF9dvZAPBcZMIH");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("bfYUDLJJsDCgNpJBIHN5AL7wh41csbmUGPbRVdS0Wqx4o1Vjoi");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setSessionTimeout(1048);
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("nV56wQtdZI6XUZxzVVQhrwBgWsRQNhyjJbNPvkdsBcrrnsZ8j8");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459578742682l));
        user.setUserAccessCode(1324);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459578742682l));
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("tseKPzmH4U");
        question.setQuestion("mfKQFkii0QnFD2iNG9wSsL3PjF7eUtj5blgrKynScvuDvCnrIy");
        question.setLevelid(8);
        question.setQuestionIcon("neTAOCdbL8rCnkrdTIjssJOa6xvWG4ppRibMUnU6266eyjRtKb");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("qd53qv6XSn2kyKd4mrB1NpiuvZ86WOjj5Je8eVf28AEEVbiUzU");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459578743148l));
        userdata.setOneTimePassword("qn0ALSTCtb1xydvzJ2OGjqtu0zxl4kWl");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459578743197l));
        userdata.setOneTimePassword("4jyn6MolDcYqKIU6r4RWWVJsxKoqRiWL");
        userdata.setUser(user);
        userdata.setPassword("Jb8KFUc1Fyn0N8Tf7zylYtn3dhRKczeNYA7m4eyreiNqEnHfJb");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setLast5Passwords("mdGVgRheOTvkgzGqMI2oHftieFBvkBFpxAE9MnV637Z9Iydzpn");
        user.setUserData(userdata);
        Login login = new Login();
        login.setServerAuthText("aumI1qJyJ4hiBWHT");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(4);
        login.setLoginId("Pmr1Oe4EaoId24kbYv0c02ngeGf9lNwxqrSBvldyudCnQU9cPp");
        login.setServerAuthImage("YD4UBXRcnIGgkQTH2hluUpcGSJYXIHQI");
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
            login.setServerAuthText("or1kf3c4RpAmG4tl");
            login.setFailedLoginAttempts(1);
            login.setLoginId("VqKXlFMd70lyEnY8lVbrLB2ZjawJVl3N7MavMXDmxrIaeb4wGE");
            login.setServerAuthImage("vFlTOGC8jz2aRuBHtfAE5gjXWV9dW411");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "fUEZW1mQjRueksPzOcv51eGK5v5lMmnixgMTgEholjbGSAcxjUNYPGeIvnF8mrGxFW3tAg4M1llQPwCAFx9vaDevwpEsBsHkJlxLUcZFpLxCfjT08ljjI2YaKT2WxPTBo9CqT9qZ2MFBigvxIxSgvgrbdX5HB5gubAeTUP8X81Z7LsdtF9KzrUNyh0zSdJJtaqls9mWNC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "X1pD0WiDSFQWS11vysgrqiW9VvwRpk3Ha"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "zACQ8ha0dQ5JX8tXu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 22));
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
