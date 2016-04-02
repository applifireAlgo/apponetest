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
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("kv3WvukEt8RnPvzvdSuZZF7S6MxpPDeSumVVU4n5vAtd2dA7mA");
        timezone.setGmtLabel("Lp0k01JhqNcmxPBSJhmYnpFjBtXNIAO4oYcXhbGDO5Kqlu1HTE");
        timezone.setCountry("coFq6APXSORWT2tpzFPeapFU29LblXvocHz82ndJ9X6eXjnoKN");
        timezone.setUtcdifference(7);
        timezone.setCities("70jtbTw1IPuRXJtOCfXmzooQt47fxYxVw3it75ksRkKz8f42Kb");
        Gender gender = new Gender();
        gender.setGender("UBH4jfMUhQHBpfHZDCmotldzJbUxaqmdb4py2qgF08BhkhBaZA");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("yyx6L9baAp5C8qWciyVKh85gwraFzvrXR6s3oBxMcAn0Uj09MX");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha3("hJL");
        language.setLanguageType("mOfBCvb23eLwwRUeHGvcSi84LrJZZFtY");
        language.setLanguageIcon("FDkaidKuKUnlSLkP6VaeLinpjVg0sdZMh5hclkIM9MdxIP1Hx3");
        language.setLanguageDescription("sL7JbT6tr9bPfJlVdanTseVnXU10J0BtkhuktwOsM0ArxpTGph");
        language.setAlpha4parentid(9);
        language.setLanguage("vT4wPzOBT7TExTaWeSHEKmPCLE6uiEaQNgOGtwfVq0ND7LUbSp");
        language.setAlpha2("10");
        language.setAlpha4("jr5j");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setMiddleName("EazcUIIrpujGJK0dPMaLmAn5rXAzbdwxKebCtYCLat4TOf7vkq");
        corecontacts.setEmailId("YHu743uIWJTqkzRhN5Q816sCYGvKEDu9L6GFzBdMwAmixxj2fJ");
        corecontacts.setAge(14);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459587655645l));
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459587655818l));
        corecontacts.setNativeMiddleName("aN8g5xgyww2Ek5j5EaprqsWumRITVcPKXq3XeMy4190eqamGPi");
        corecontacts.setNativeTitle("5Mr8LcyN8kvuGDqXQioUNnoqhiHOJ6e3IqnMNJgGnyB9WhBivn");
        corecontacts.setLastName("BCHk3kH45w5bNZik3LazmKRljSUyZU0bTuAG5TXaZCAUn4ZMdV");
        corecontacts.setPhoneNumber("xjnz75hSfvs2TwhcXuCD");
        corecontacts.setNativeLastName("VyV51phAotg1P1DiLmxDJ1WmBbubQAMjpvpdZU8xTlv1TB0Jrd");
        corecontacts.setFirstName("U2dFOhfSYKpHPEOF6l2czi8LtfEQEK2bE74AJRosYLuLXQ0bZg");
        corecontacts.setNativeFirstName("nZizg9huCLpEOCQCbtDOesNW7R6lZF66PqudFJ9vViKShX7zUT");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("512mWa5Hpdr4TvM15QnP2Zyz3CVkWa8phmLoYaMYUjvkcmh57W");
        communicationgroup.setCommGroupDescription("FsiMKzuGt7Mv3EzELoiiyxdYJiU010yUjX9aS8hRaJpvGcEDuE");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("xjGCTW5jv0U9vqGbksybo4J4tovPEB42xPmRDzcBFmuRY3a95Y");
        communicationtype.setCommTypeDescription("kVb6ktVMPgqQCQk3CAuV1KdMfN1aq3HD9EU2OYvCaifI0F1KYN");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("6Zo7EqdVIT");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("aVsfQhLlWXdnABO468EgIdY3Lx5DutkAXlac21w48kUZG9qJNT");
        addresstype.setAddressTypeIcon("yE7tPnDj2FOhDpsE2CPps2O93Jhth6Zonwk45iia18qCJF3FcE");
        addresstype.setAddressType("G7tGN1PyhEON6R6VNnvTia62O2wk6cnqlCDPz67CaobOWpEAST");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Country country = new Country();
        country.setCountryCode2("Ipj");
        country.setCapital("pIayWZ36vVfC9m23vMdXmHVyxspgdMJE");
        country.setCapitalLatitude(2);
        country.setCountryFlag("FUJJsaNvyADZxaPW2QoLSrAys2pSvgd0Qwayjzffj9BHmBy7IR");
        country.setIsoNumeric(270);
        country.setCountryCode1("Ouq");
        country.setCountryName("AhOdviXmkQovCRhaZ6tGiPWYBrXpbpptk85LqcBQXJauD5U6Q6");
        country.setCapitalLongitude(2);
        country.setCurrencyCode("kTF");
        country.setCurrencyName("aqnTvN1WDYpxptTn5CB5ZDsIWa4sNFJbaBmuyYUCmOpg9luksk");
        country.setCurrencySymbol("cN6kq5Q1NWtsWrvd8GmnG2y398BZgVOV");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("ZDccrxVXQG6TOQjHmlUM1S6UeLeV1XmmYoegxT74Z1BGgpsdOY");
        city.setCityLongitude(11);
        city.setCityCode(2);
        State state = new State();
        state.setStateCapital("2OEMkpUlUQfNbJfR0BfiYrq0OVDBmYBmydTSAD5tuZiNGfrZ3P");
        state.setStateCapital("MNMzu1hkycKphgBf1U9vcqwmCTcrNM2Z9qOsIgCXh2ewpXDueZ");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("LzGBuFiUMrYNj3UVVje2DMZ3X4dwoUl2");
        state.setStateCapitalLatitude(7);
        state.setStateDescription("5WNthGYgxPVlYF206lkSokjopzMRzJ2DKZNtusge9SmVTc5BJY");
        state.setStateCode(1);
        state.setStateCapitalLongitude(8);
        state.setStateFlag("VLlbY6MXdCRB5c94rfeNv69PT6JtzE1EhtxJsJpWykWMYVGYUe");
        state.setStateName("dqb6qGf8KEX1nkmKvJT5EfgOj4CeCCPoCFcQvnowsDdaUJLfpN");
        state.setStateCodeChar2("TyybKXYWhoJILohUwyvaeITtTTzdZf4P");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("VelBMTAgUH0PWo7CvHFDwzZJC9suy2gypYz9en4DiSGiri8qSl");
        city.setCityLongitude(10);
        city.setCityCode(1);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("MSQSPDWHgVPNzxtaFUcSI42aydfOpNQHDLjDOplBEfJWS2Wwy3");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("8IlJicywD8Z4uanWMI8frO11QTsSEugkjR8R3FPyfYGV7D5wei");
        city.setCityLatitude(11);
        city.setCityCodeChar2("bmTRBl8VY0xyoNSNQz0g07vrMgtVVkO4");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("31RnuK960gk");
        address.setAddress1("6L6mthViDFks040S0OxGHl01OXYeerpvHlzh9Du0CTpn17ucRd");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("tojemw0wGRxHjBEARbe8rdgvpRrSQ7Xl56l6PC6tgdtR3tRCtt");
        address.setAddress3("RCkb0KsD0QSU5wXt8nUUWcvRDFIjq98cPXpnQyRxv8sfku9qPm");
        address.setLatitude("PORhWU85QYjkdEDws5HB2Kpa9fSk44iMwwhyoEd5w17B9I6PH7");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setZipcode("ui4zHv");
        address.setLongitude("XTiDp8uLZDvtheceZggJYqCclovDIW5hyGffJjjDnK67bK9Vef");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setMiddleName("6eVNDVDfQOlpzmB02hYMMZUa4djvPY0z5W13gburpCzzX5WK4J");
            corecontacts.setEmailId("wX1ZXeCi7FVyVGeu6XVONhXtNf7mzsHg1Lk5itvC0vg7wuSIF4");
            corecontacts.setAge(54);
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459587656842l));
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459587656932l));
            corecontacts.setNativeMiddleName("tXepYI0KazZjGjmSsznPoGVfc5nrKBbLTbbrnoebqhyH4qK9Xg");
            corecontacts.setNativeTitle("T3PrKwK9gX0ksNbc9eNrCflSSsFqaqpcU75rW2EqiODzh44Q4k");
            corecontacts.setLastName("qb6n9EKwTGpAyru31rCMNiHmA2duYyErP3ziM1kvJa9AK0bMEW");
            corecontacts.setPhoneNumber("61HxD1wkegQQ5NtksUbj");
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("ebLuFpDml6DuBuzWz3siTtg6cjvequ2c9IwjyKcFh6Av8kCDLQ");
            corecontacts.setFirstName("OE5KjHpoYfrQXEdYFyeExZcu20yy8H7i3BFRYmIUXSrnMfUXIn");
            corecontacts.setNativeFirstName("707Nik05MFb2T3yEBjxbU9jWqDLXlq6iyZBnFsvPC8uiANOTG3");
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "o2Ft6wfr0ICLlY5MMvzzInkCvWCusIxuK6gQ7WGGCq39dKg0C8O5qrBAuFvxGMUWxRV1Tyn9r2wmfbP2BlXPxemtZR4Al82FbAsPX7hjrEiNeHwmtSYzc46zuYJACYeCehH6isqhTcR2U4zNEFdn8uKVBhwckvWomIMpq7AqknJMmTUJEz5tWZI5m00O2IvCrSU4UkHv42b25z5jDcSITLdSAzLbJtyh9ELcz9MTMlfgWSI97ppK7Yv6hHRY34V9T"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "KOvk4M36qubELNKNYI6VDVKZZ5FrK10V2BkAD8srzoyCxEPDhVbSLkhXdPOiklvB9cXfXELrp1lYr751zaJTskg2dJZIgoZQV40WpLl1XHGbMx7QrnyDbLgeuDy1jS3ZZPfixS2qlgEQltsWPjqKDxMEUgLqx7ZGrrEk5rXAvZeizBNNTPmXQOHaHsSzYEqKtyDBpZqRQnEWxQzLuf1nYXuFGjoJWBepe9YJBrulvqIO7Az6sWsh0FoPsuyVlM613"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "Kthd3hwAqe79cgc8xyyxpMXpXwIhL0l2XIauQenNzdqRDH5cRNI9qXCpk57ks5ltDjJpVSoCTF8moPYu4V4HeFqtqbyKZCz1QcVqKcpktZyxqFZ9SccftjXZJ2Y9iUNqELVp6JCaNB3bPhWTwJI63deUtLsoLWLKctFPy42wuYvkvi5D0O6302aJpayPG3jaUAgR6yfMQwJqpqAgg4AUIuZUJI5xvOZ7arNInCVpT9KN40AKAJPeX4Cpj9xT4uG79"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "kqC0V2f1LthNQfrgKp3wAGaQ7atXGYKfW1Dpu0OKM98NlPVBfHhLHJSGmJt0kv9Sv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "PQVEsZnkyfcQcRm62PaVSLHQrA7Tk4rrSmNvhbf9PyL2jBTF46m9lRkrO1Lh5XwUV54mngIjHW8GeDw0umM0Dg1VsAEft9P8xh8vJMaulOEXwXfdGwKH2KYohiQv37udDJUZGQLq6W4KqZsiCr5LYX560kA8zD37iKTEaZrbMfEEOv8hHXsJYn8yYsL8brGOSjrXeBDk6bQeyGIQq1MU8fyahEJgQmRqC83bkoznGFMF9aYBhlqY4gKx1fxWgw5bf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "TkvFzQH0wIu59pidT6eUlCBrQmhaeVXftU3OqMAcZRp4msnXXDAOHw9NlBohRQd79cZ4PRLdxOZcGygCBNXAzWlqFPAQkPizbPYnbqCb28gbnPKnTjXChQONqQmeGDwGBRBKQrTMI0DJNVF9Y8pJUHha3kTTmjYcDv5zaU067YcDeGEM1krLqAy8NUmuvMONLe9cxtuZC0YlPlkhbkuWN5nwuWy3cfaw5ttZ1RcCxoKld29Dcvu9IcwDdUguuW8Zc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "QN0Kq6T523zKneHGGsukrrMSG2jhfbl5y4SnKOL1CORUf2WDPJIdqUg37zEOTfoCqUZ801JVOEOKyxaCBcHHuHjVCN0YKn6ZWK7FkeC55iaRWLU27mRtXrij8B3wLvTspCCNq1RyZHr9cCiWZUmbRpUcPTJuO7I5u3qYqgcRc4BuyQ0eOfjNrBS8EScOZ6rYtxWgJ54eVQ4kEBiu3xoSBo7xALDk82Bs7XMxYpfMHm90zFw0wyuhphlExR6Qh4F2N"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 197));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "08vVq7fhDMxdrH6YXncKOZeacmlzEguThmgaxCqx0LhqSLCkMFzqWml0Wi1jiuCoJ65VK668VOuUIjRo3hSlLPsXkP1JyexfVcoAEYZxxN0aU21bRLSe19gi525T3jAkEjNXlY4muT6G7AlW8aQVmfomVlxZRkAAXDQftQ7iQ3NCzc8dXK8A4x3pEZiHja1QzaQNUgyierBx37SRxH8GKQPMluQaIufefI2XW7UDcebPhM67NFrx8h0adaS6wZP7i"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "ZulPvGjKJlcn21y7VKXWN"));
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
