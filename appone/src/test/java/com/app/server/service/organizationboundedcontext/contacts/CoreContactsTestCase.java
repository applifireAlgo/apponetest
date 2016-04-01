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
