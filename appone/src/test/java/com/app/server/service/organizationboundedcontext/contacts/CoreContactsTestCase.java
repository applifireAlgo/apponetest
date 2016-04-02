package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Gender gender = new Gender();
<<<<<<< HEAD
        gender.setGender("BzhWPXkGQFAi7YKNNGvmR13qqWQxCzG1LGgo5YhZPAp1Y0OVVM");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("qhgyw0zaDwYJGrx3MMlgX54CQfFhaf9kCSGOkA96AxyGvKosrt");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguage("hswysHgvi9xvdUTD175PtGmvxtiqnU04crVqwQabToVGBuJq7w");
        language.setAlpha4parentid(1);
        language.setLanguageDescription("IQasiX4C6a7L98BlxBvfkDYZYSpxaXKM0tdLl90XyQm0g42IOj");
        language.setLanguageType("Q9bOsOlITaz50uBwjJeUm8MKpofQaTet");
        language.setAlpha4("1vYM");
        language.setLanguageIcon("7IzCQeanQo7oLp0NwtUahyqxO2HUxwJGvcjAXh8xcQ5x5KIgg0");
        language.setAlpha3("DIJ");
        language.setAlpha2("Av");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("PbHVJXFNCyUA8gfX9tNeFdlM7aU6ETWIBw2WUM09qneVFOP7RP");
        timezone.setCities("n07naCn4MLRPdVJkHtQxfWSqaT8WP5vkadYiMEw10u6fBxRQEy");
        timezone.setGmtLabel("x3SjjVep8pKB8i85JwImvN40P8Fsy6N5oJG54OrdoJ5hmYxxuB");
        timezone.setUtcdifference(7);
        timezone.setTimeZoneLabel("QJheVoRNBETySTIn7aJuCc4btxFzhy7rm5aEOw7ANIq7XGT8wt");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeTitle("O95zH3iAjf97YSTNQGacAro1wi0L0shfvg3oiEKIp88UqwzD5n");
        corecontacts.setFirstName("PqcIgNYN65kvGEOBH1IkhA80QMUVoMuX4szo1BSEGd7FusGb4L");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("7qDk8Mv0nFieykmgT4ZsJ8b59zKmo07oFjtsWSQMHeNW1dwziu");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(102);
        corecontacts.setLastName("ipwaCALcmzw75Q6MgJ7JvJLfxGqhGaqf2RNEBGLqzaKnCs5lk8");
        corecontacts.setMiddleName("W1Ew4DFlBkTrkWLFGN437MEDtXC8M28YBBLpcQiHPSvhZVAdyX");
        corecontacts.setPhoneNumber("1LU8hLI6smjzR6X7n9bQ");
        corecontacts.setEmailId("bvWRyGLncHnDfs3kkRlV2IjImndKgIWYF7xMVzs4Zej7K7DzHP");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("RsJYAy0YJRkf0HlwqKT7qLkkTnyR0HjtKMjq2GD6qcsdIJe526");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459578711392l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459578711392l));
        corecontacts.setNativeLastName("KuJdHsKU2WSG4oj441h1J7ukXXsPZVsCPN1HKXUPS1Tev4oU2e");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        State state = new State();
        state.setStateFlag("pbSkTPPkBN7KIh9HERv3mU5stFezgpyioA43lKSiby0QK2b6q1");
        Country country = new Country();
        country.setCountryFlag("g2QU7d3mKFVG8LKCbPY9ms8qXPSVqIEuJYZMoHSPg8iZnXehN9");
        country.setCurrencyCode("PIq");
        country.setIsoNumeric(291);
        country.setCapitalLongitude(11);
        country.setCountryCode2("MIl");
        country.setCountryName("NGQajfeFdpzeogAkXg2ONdbOrejabBNoC1JgDTGgZJSSvTCD6W");
        country.setCurrencySymbol("fzICpYsAHPwECxDpT5YlhZeWRwhHWbS7");
        country.setCountryCode1("w08");
        country.setCapital("l7DBBzvjsie1eoTcgBSXq4MQ6iVkvgTh");
        country.setCurrencyName("wSSJTzRkcxcxHUWzbMKseN7JP78TnfUlQwYrtNXnQ7KIXgPiaq");
        country.setCapitalLatitude(9);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("eIGvt1qKkBVJnE227aH6iFYxSKs87mkeMqjOhdv4HmcqGZ3hxb");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("FaC16Z3GFtpXKQ6ovwDpt4xvrBSn656V9r0LeKW2MN3TC7GYxh");
        state.setStateCode(1);
        state.setStateName("RVWtC4FNCeFBqhXG0frsVhxyu5I4pwR1VXsY0oDxO4xUL7IT85");
        state.setStateDescription("Bh23JtOimgWDNdLQXN2lUW4UXwGcjHdOYb793IqjeJOEzIMiXK");
        state.setStateCapitalLongitude(6);
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar3("pqOgm7QZZYYR6gjhNOMkjSspsZttyPFR");
        state.setStateCodeChar2("xOCliwiKZ9tKjsEij0vFvNPbb17K3w90");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("NLV6gEY9SfYjf9dqxvamqG1PUVvyBupQ6qUFACDpAuMRk05448");
        city.setCityFlag("jSJ6mgVjDjc3AtpYJoMi1vVKLrfKMAnKLI8FfZBCF8YDeuzZEZ");
        city.setCityLatitude(1);
        city.setCityCode(1);
        city.setCityDescription("DXr1P4GUAUMnn9rNNP4WFujhYagNcLujTZ0htO5TQprh1gOnaW");
        city.setCityName("chGR3HmnKdxhQeYIhVrXZvSMorkOJ0LqTaPn5tuRysVuXwdfkZ");
        city.setCityFlag("Wa1JjEoPqRqr2hXrAOBaIIAyxMccbshRxtxnk5H5aZk42WSCI4");
        city.setCityLatitude(7);
        city.setCityCode(2);
        city.setCityDescription("YSYyaPoqltumtP6jwKtwh3kBgNhd2LYErxFYPKQRf4nAC5uxXy");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("JVWHQ6EB9AGEllQObDKC89jmsOSZsRNy");
        city.setCityLongitude(4);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("3CVbpzmub4oiQ8HnsLq1HOXdeyq4xVhOJ76LuAlShybeZadJ84");
        addresstype.setAddressTypeIcon("HevwSfY8ziL0BbkYsrHYNaQxfJ66raBlkrmfkE9bsbRQrh2KKm");
        addresstype.setAddressType("97NDkWMVLh4oPKZHk30cz4nFoVBBnwoo1Vn8curq79VVWL344s");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("ygGTqIVsqifJgJMSa8FHbGjYKI5erH6kiYFV2aiTYLV15QV7OI");
        address.setAddress3("irEBqvhEltEmfzZeMFYDHDi1B7reAlNgjDyxNIoNhUCDTVzYcx");
        address.setLatitude("1LbFokOb9lkFFEeGxoYqcKq4gMmCRulJYSfT0wTMQFEQb38Csf");
        address.setAddress1("E9HleOCx5lxdbfJZNFCBmAvDLhvrNUn3aMhQvuFdfajnQ5qZKG");
        address.setAddressLabel("6y3beAjqvEO");
        address.setZipcode("1kAgpd");
        address.setLongitude("L1Fu12P5L2iCElfiFkU6wm08CTrHm9lWHILqJjtFl2iHQgvvwU");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("KXo1qWPsGy");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("LDmZMVurfzdmauUIMK9tKquPhgBLscokBswMVPHAWlCwMtVySw");
        communicationtype.setCommTypeDescription("O6p7esqzL4y5gVJt2myzrPyDXy8UpuDuJh61E1vMTh06Yqx5pr");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("pmQ1Y71iNWcK4EuJvAHcGSQ99mQhn2xBzyNJcf0ywCy6TL3TBg");
        communicationgroup.setCommGroupName("3sTVBYm7dydxTEL7SU8z15oMiAbTW1Ye6xKUtKTZF3K4Da8CtM");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("CFm4vrfgVKW816kMhW6bEbiLMvo4GXTyoayyi9hRS5adcjkGPb");
        communicationtype.setCommTypeDescription("RZ8Y3TeqwcFQafKwQM5J606zTKD0RVz4lKWzflm5yeqFFIKpgg");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("ZKGMYtD8Oz");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeTitle("YXAMaHBV0R0VJuZsYjU7GywxWkxHFjNg5243AQNgHnwBsFpDDl");
            corecontacts.setVersionId(1);
            corecontacts.setFirstName("UE8Aj10ALvyUw4EPfbRSAUZV3aRlTvFoEqHSbRI224VTzx3bJz");
            corecontacts.setNativeMiddleName("HMdy9ZJcy1jycuvjvnTS09QjyUVyHqfnfJXjgSty8xq1v6lR1w");
            corecontacts.setAge(107);
            corecontacts.setLastName("A4H32LhI0mVY2LfYaHzvrMGgixgurpFdO1mVJGlf71ieB69GSC");
            corecontacts.setMiddleName("NimhiMuS22cHdYOsd5f3U6p9lQQxl4SrMTtWEntgY0SGQQVyGU");
            corecontacts.setPhoneNumber("gQrBdbGIpfGPoR5qgnJI");
            corecontacts.setEmailId("D1s9ye9SxZp2ratbGTAjhVCnFPYtPPJ4YJxCECD6ETd0oMKy2v");
            corecontacts.setNativeFirstName("qBKkncM7jhUvLHz1BLTr6UnsD5Dg3VicJSDgSDlMv54PvuWxs1");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459578712615l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459578712633l));
            corecontacts.setNativeLastName("qcKoLpalXwKj5RAW11ECHIrgHne612wBVQ1C1fKvmW6vvUJHn4");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
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

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "1UdirNmEFYKoRHDOswAoepq9xjYGYzeKANJ7s7qRKaGyDtwCTcWSEqLU6mSGORQB9DWH8PyUwRJFW65UFH37jcQUHGvmR17jdfyAF4gEEWGbtVFNqSkh59GdxyZozDbL96fKj67pSv7ji0VndRhxDGd5zGs5UwJAvVy4Qumav0kPd0WGT9TzN6mR1ws2f3XO6SNZBK9Mg452NYty8XrH7xGIK1P5WQajplcnn6Ubp0HsCUIRTgMSviAKDJqyzPRKX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "dqOrQ3Xo9Sfsww3bjLXV6B6gkLhYScmI0w8JfprwBBm2jkZvHEiWTPXefQ9UVWUDWqWx7fmHvfkAI1eldYvVnjvknJXoDlQ2wB91JlYbTzPG5ma1mrvcekqQ5URD3D0WsjrO8hWOCaJXsLtZpNqr6hXQQtabjqLG7HgtwqBSmopDVr3iNdbIvnt1yZgPWYoUCRnJk69TaAdSDz84Z1cRxLMNZyFoZIligkEcOCCdlEZzscgZa4Nh7VHfoC4SGkmma"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "LVaePrscK42RVSE5XPCwozNvZZH07soXiotYbJ240FBU4HoMg6TO7UFcpRtNAEK7XfdGnq4w5wI0MpAo3fOgeuWOdmkpiAMsMazd2a5hhrI1piXbFHVcHWzHhu9SMPgS1RcxtklupfBjFDdniMu5nVuaH2tSSO8bNyGZ77jqkztOiRav6i1ncD0KRhwhTR8GuZjk7KbM3PJks7fllzrHTIQgFZX1gT0KqqH0IrWXdRFBevwPr8v5NRavDSPMyccco"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "peCKMpf6bNDiDb4eCjNjXvcSjNy6o5YKHz1gYv3N4I8VWKvEd7hXru52WBHIjTzdg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "ghT0Q1OvYkYNE1YP9twjWM5gdl3vStEABinBI6Jkh3diud8kVRonC9FVrkEYXtLEZcfzR0jdKTPtBUO3g1dyIWe5AsY3hrMJCb1WQm8sDlQDZXHBr7NFoUNNglC9fYSJwEVVNEruQJsxleYOENhqzEQ8p62KzjfmqGVr4AxqMQyo0YhkCVNMkV9QWBnYFxK8yJbyAfUW34RGs9FS27dCIJCr1po0PZUQoaU8zj0sFADzWeULHM23OtriuXoXACmb3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "aKS1eEtXY7C7MDNn09k2N7ZQ7O0QjpfptWF0eA6fmMChFGMMkosV4qljmIBslJa4utpzX6Hn8ZqJ0Ck4o78xkue5RRgePnTfXIbfSAyZpJ4U3MMGfw7PsLQdSvatY1rczci9Z0BdCBWCyER0DW7O8JgrxasmdjovaLwVyehe3V8gqQlaw4CacTw72eMHhJidPQDmijxpMWfLGfc9esCVljTh5p73Dx7K4SMLYpD6i3YHnV9LAIGDIdOkcalfvQMCX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "iI6B35bI1UVWxnaXuBek9qnHtKaOM29uvfCLy6sa1IQs2YhBJ8N0zQRh7SOzRBk7K0krrzRavUlS9cSiIOpcN9KtDT8DrZzkDyy4i83suOVRJ1pZ1O5kG1JDJPhUbdEnrPF39nAzbiagCKXDkllHKYzSeaDVHIgXxRkw2eOjbdSR5UWU8isMtiSEY4fscmtADJpZfqwllcUrup4BRNl8vzSEz5MARzRfzK7juUCRSQFIXxPpCXZn8rLCKmqcP3xgO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 200));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "WP1zi3SIxOxm164cHKEn09vKJWDNNXDuPxIv2ViQfocLpxblzCVqRx1TJXu9wnPQQyRwRMfD63oVDkAKNX7dESenNrn88sQbUHAMbVHlO7j2QKE0sAG6vo8W19CMTGHnQ6tL0cSmHfyEjnFgp7XTdqHfzumNHrXFAMXPwtSxCQjpwnqDDu3MGZrHimNTHHGv2kdbpSZ0ZzpdBrb0MIbSeaiY1e1fipmRtJIZ37hS5xZHb9sykQQhPT0mIBpRefTt6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "DQ561IMlMqXSB5bCO5lfU"));
=======
        gender.setGender("rbwJTPBnIwIUlhagoDbrEixGjACoYQF9ojdzIv4QwgPLTRwyWE");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("hSapA6PaMl3gfXo3P1iD73qTuqigfmrAPIthSNvyN5SH1aj5co");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguage("VEQt1UqyNoyHXIt12qM2Xr1aoXE95lJaTqjZSkudi6JIM3JMji");
        language.setAlpha4parentid(1);
        language.setLanguageDescription("UKOS92XBBeobs2DpUsnTyZPIcz1AbRnCyPHiVAvwiGUdcotzCs");
        language.setLanguageType("XbZFoB5XstqDm1R634MEdte6MtAMhyiz");
        language.setAlpha4("OSVs");
        language.setLanguageIcon("2OiEQk82z33Feinhhv3fgnRYYNYQ4vPuU8hc3reOvb6ib2BdWG");
        language.setAlpha3("3iS");
        language.setAlpha2("i0");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("TdGaXzM28BW60eDkYP1Ll4ho3liaXG3YGzPZq9bSdQxAl98p9d");
        timezone.setCities("JeRebanoutDaIvEKtFpze35YVzZ13enhdFnFCdm7LYFD5be0H3");
        timezone.setGmtLabel("e9DnK94eHiYpubnD5e7FV6luQKtrsuVeDUBzakJLVrLN9ZDUzL");
        timezone.setUtcdifference(2);
        timezone.setTimeZoneLabel("fVNQokp9QR6gmN65AZU5Ozqfm4VZadrBrkw3ABw7RSzsMRTEXN");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeTitle("wbuxNowQb8xArzH89xwgkc1elMjRkOq9O2nTOBsjDcmGTiJ3m7");
        corecontacts.setFirstName("UBKb0dW8p3jG8u1eaIlcPKbMFTrMjSGlQZ8m3haD683Y4Xjcbe");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("mmN9QTtyYrD9w6WXgNTTPmRRmVrfb8gB6Xr8lPRmnURpqEZRyR");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(103);
        corecontacts.setLastName("S8zVqRknFDitKImuAoZAoxMC5I8Cvq8ssOjcHTV0YnlhGjqXFj");
        corecontacts.setMiddleName("u9fBC88ywy2sOf1DMGu245hfLukq1G0HmyDxrnL05O0lr5wX0M");
        corecontacts.setPhoneNumber("wKDh93W1UDx4gkThj3XE");
        corecontacts.setEmailId("RA1tIixv8ActHOonnexcfGUZtmN3k2khbaVuAnUNWbpL8OFb49");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("ajrT0nXINcePQFDo0pWisHyuAhFFCAAD8TumoWFgPky6El3yK3");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459520618652l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459520618652l));
        corecontacts.setNativeLastName("cYOGD4c50tULGfZ6eBRacpgebZ4cEOabwsxnwF1mQ4Ak43hXA5");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        State state = new State();
        state.setStateFlag("Tk0iMx6bQ17CHrdNPAf3XdlKBDqoii2BerciQZrSqzWDpiFxAL");
        Country country = new Country();
        country.setCountryFlag("U7CiQrtBY8GphWNxjFFc6E7HgG0qlO0F6ciBqQqWqHTBQReaSU");
        country.setCurrencyCode("Ahj");
        country.setIsoNumeric(139);
        country.setCapitalLongitude(11);
        country.setCountryCode2("ztv");
        country.setCountryName("v6Zf6bDYU1258xIKFmhN50ZRQadhbpOb8zsAIL8XzIg8y2vobE");
        country.setCurrencySymbol("70vxeLI60IyMDWq0o17DWxQBSmsrtPyT");
        country.setCountryCode1("zk0");
        country.setCapital("VZdjqMoCt97dYdSySkPujny47Tf3qHpS");
        country.setCurrencyName("YD63nP0lJrFMFHJr9GkiI0kygaJIVT6gfTMUvmqirxPcBTBL1r");
        country.setCapitalLatitude(2);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("le3Aca5CdLZYy1QmSbFGV3A8ktEomzkLx1E2MKAtHpdfTIf4BQ");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("wegfYYrnIrMg7Y69zTE5yeeZTCOGclr2AFpy7E9QkXOjsLYKE5");
        state.setStateCode(1);
        state.setStateName("qaVFQL7VYkKHJVRNlUnx9XkCpuEgMZ2zFy3Aya0I6dGWUhFx2b");
        state.setStateDescription("2LcbNJAIFD620wboQfdGpCC44pj4txHSsRYjKAO9FKVLrRJ0UL");
        state.setStateCapitalLongitude(8);
        state.setStateCapitalLatitude(1);
        state.setStateCodeChar3("Y2nUOx96TusUSjjOkbv58XhZQ93DTwW4");
        state.setStateCodeChar2("6s1v8nxRxfk3BY6WF7XzhBbAOXosdbvV");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("yaBzmD5JVcFsXVXDScjMvYPbRPyENXOJwI3kKom2XUg6RO2yew");
        city.setCityFlag("iyIZSMSWpfLCBADhNcRYYkV8FYf3ZT6JOUrf71z0BbrqNTQ17W");
        city.setCityLatitude(8);
        city.setCityCode(1);
        city.setCityDescription("bTa8cJBAPAruFMxwq2RxCjBhP1zKvjRMMpaYrAf2IbUfOiztLo");
        city.setCityName("nUedrTC1qqmnfKKOntTa4SO6AW7a70hb65rBNnaS6eMyQYcaqB");
        city.setCityFlag("C4v9N7dBKf2BwQtPxBIirIyraC69qu227dyTv260iI8WilGsX7");
        city.setCityLatitude(8);
        city.setCityCode(3);
        city.setCityDescription("8cWYvUp0J8ZGI2nkgu5PZwe8W8GLeTasZgjLAvq73HNnR7mtBd");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("uwYJZvdMo4Bg57PrSVwOzqSrUTMHDlXp");
        city.setCityLongitude(2);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("SgAYDpWbfJZY5bFfNvsZ7W8XHDMJVVarwkA18F2XlUseubjukL");
        addresstype.setAddressTypeIcon("tGJnzJUxZKVBfSmHEfCNukzPRWqpftXVMmHYXVh2m2q7XVTX5G");
        addresstype.setAddressType("o92zFAMfosgNoEkVHB17dhrPITF7sVs3uFiv9C0zi9khdaWyBm");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("D8sCkaH68N5zSh4usdbHM2TWf5H3BCEiYVggft5Sb0oRIpc2xo");
        address.setAddress3("0JcOC2w3B4ynJ668WLcBaa5ByZogbupeKidbx6dr1fxIcLwFst");
        address.setLatitude("yUkdayuauJCdJwEHVy220xIifSUKUBI1tvtArMMwbvTYnifAgQ");
        address.setAddress1("NPOVP3KooagUhKNTFZQQj1S1YCj0l8XTkptbISR5bNxZWYi9ui");
        address.setAddressLabel("dwCH4N6NGmZ");
        address.setZipcode("kl8pUX");
        address.setLongitude("9wG78c3iBRchHF3QUXUd0w4SmscHHvpxP2GLyXNQS2T3Bubun3");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("c1WA7iPZlJ");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("VLiuemz5THg2sAVCdQ4IYdrJtqp2UMwmI9lRm1tiwgGpZE4USe");
        communicationtype.setCommTypeDescription("9gkY0HH4rNkAPjmMywnQSoLnHiV01wcvZvTPevr3uKfUf46a1z");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("e3KhySZtZJVu2qT7oe4L0WaYFuk4ZOeDCueHcnsQTnnNoTV0eI");
        communicationgroup.setCommGroupName("UBg5suFp6m8m2yCs4Yu1tCkowLDO31MPOENbLM7UMO8MStRj0G");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("fesY5oFpvP69qTKWmT93aqttdG5DrUMKi2vrIcHMlJHeIDyjle");
        communicationtype.setCommTypeDescription("t1ZtdkvqZJsPiIs1lH3TS0irkCrzAO5vyJV5qwTmwnGLCun6KU");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("H5cwUIMbTY");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeTitle("QzVP7snblWlG8Um9Px9p3dlxVxxA83TKgyW4hLc18TB2JZSMZw");
            corecontacts.setVersionId(1);
            corecontacts.setFirstName("5t5gAJlYqGGbHFe6d31dKF20Jv3mUT63jTAnvcohTKo1zbCetr");
            corecontacts.setNativeMiddleName("S0N5O9CqTzrfXHOLmcGXQRL1bpLgqh8tvrJXy07KDiSspgxIAr");
            corecontacts.setAge(117);
            corecontacts.setLastName("vYNZvN80NOkaguvJHsPjvwIwsHCNjBtXhR6ivPWZyvAG8FsS27");
            corecontacts.setMiddleName("VnUQnGiw8b9NS21Y7h7qmoLGotJCi3qixWwNbqCHRiPFwkHK1f");
            corecontacts.setPhoneNumber("iAEsizhaQBAllVZ3Rmmt");
            corecontacts.setEmailId("8Q4Bt3cjTX8dCs9Vt09ONzckK0eV1ZEmJVGIlgnfMvfjsbXOFo");
            corecontacts.setNativeFirstName("DLCq0r3vvT6N2p9jRyCHeBLTcojl3jSJ7sgkmBWtohhN7ZgWCR");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459520619828l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459520619845l));
            corecontacts.setNativeLastName("gC8DE5LhxHJ7jY4189tMYV2OdBDhtTLzAroh7ug316AzdjITIU");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
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

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "f4WheLCiSpc6qL6X7TOsffDSLHfKYsYcUD4LQv8HPNRhs9fMIW8PwNm69R5BLO2G1Lu1cfgqNd3nrUCWgQKjnaVDTon67O4Qp3rH6472PxHsK0ZjjkIeo9uIobTG02qjxDAuyfWaT2uc9LLqaBYzBz3fniPsQn7oUL2eLMlfAELRIIwkDcPNWHf8Ta06T30NXtG9iGyJ29BQ7hhS3OigVtvBJokxt19fRUNEdWyzBBlbCheEGtNq1qrDoYwQ2qwTV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "IZBhkIG8J8wUWlBbc2RstCQlxqkMgmPgCQi0VEQdrPADZEwftfNNxdeZHWptKqoA96qvLWKKWZb4vYRzW5lCpu0f7Ld8XP3SGdBMmvHMPKn7Im7W1PNGl7R541AAw7GkGfbE4Kv4BfDybRBbhferGvsaxz11ygaZRyxTlxJLTUXjZS8pSBGplnWQy4ZKqNsn6n7DyF0E5nB57vSvF69oXHfpeqt1uvezbgXgbPIGkzSI2vVyJcziRVfExPFiHWzva"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "Pi8NrWqUmmR38fLDZQTwQR9nBMq01GhBB6NJaJQj9fJLJntchbPzHygsbzRQ8om54PXas9zl9jWWnZEcyBQ67bssOeyk5vmqWwOjPltzJVa50Pv4q6gQAHc8IRRQ48HsLDkmZyFt6637TE6QhmxmOEFWN6sJBAuXlEhKu3pKJxTWItUYrdZwD52sL5nOKH4RWNh8Iq6f6KalyHL10N0ljFyUnnOENyhPhEWnqGARvZMueAeJEjEQqckQgAN4IMLZI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "A86bcehMa77xbwlLfNyTT0bw1adrhlR9YU71CWll6ZdmNw4o8SKY7Ot10aVvif79q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "0DErnuuSz53uMo7I93eKb0kFXTW6j5qY9mHfIQ71EHShgVaR1cgTZ82XU0VhGXeksofhINdc0Xtx5OeANzs1olxIfBpsgBCQjFHw2ocni51bO7kNfDU0Hpf2ENYgcK1n5FbzN304qPat1yOQv3fFsTefCWa6W2505v5T4xIjvXp6G5295YUXirpEXLoA2r67dH0iRHEKj4SaG2GDoxla4VxLmjJ5D0bE1oL9SQytLP6gIZN0BI9j334UWPjNhKX5h"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "fEVCxiELeyV9nW6ZO1bo50YXinhU9gej2UG1SaCtk6xNCXCfWbekuwPpc6ypG2OC2RmlQoZv2tuhReWlb792uFvEomOTzOFVKECpDH8DOB0bnQytyqd5z9d01l1HuAXa1CaHJbJfkfxuRUSHT9Zcts1pas1AsgTneW4mOGCHjbfCNG5sdyIY8Mf1y2AC37V4gPAbqGrTJFIi9oY7bmYMAao1rziIPUbUGLvT6863IHS3NILcYwzE4lU4woBw8xm18"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "aaPIDigmyt0jvE8l2AwObjKBhvTw6CD3CoOsPqcKf5K9QTduC6XUapqMEkOVtHPK4XHY3EKWh8qBjKVaPoLFjlHL9hUhN4HsSOD6RCMtP2RgWJmP0F142xZ6oIVz15qIlaRJLkcEHv6kolkdxrGF9rvGlP0npEeWMeYPKSZccc4fX5IcZ4spFsxdENohA0dV7UH2q3PIKQ8XzTuOlN4erWP2pdGqOB3Wq2foGPCgk3rcH796ndwuvTg0o1X23R8PC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 188));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "mbdplAB1ozPup0qhrvspu2Hm6KQsZcVsWrT7ToslvjS4aZD24uKY1igJXr7ffLU6pexuFBKNBT170d8Piuv7gWt4DMBQvVl9IYFEKx6Nl8EwpkZGKiIm6aocWPAsFv8cpovsksEe2uFEgwTTVlCZhMg3XEvAh1oZNCAKNgvb5s4tV7cJHIOtPviw3mMSg4MCEDjqjZc5kmoJEtSzjdSGVZaJkQ1OjkYanwM0yGaZXuNZNTJb0ZPsHNV87ly3O730J"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "s8iTG0lFr3jlZH6k8DiHb"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
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
