package loadcheck.app.server.service.organizationboundedcontext.contacts;
import loadcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import loadcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import loadcheck.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import loadcheck.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
        Language language = new Language();
        language.setAlpha2("8Y");
        language.setLanguageType("JpLhzBhcoRA9aWxZ7Zu8DgJCz5lSieBN");
        language.setAlpha4("aT4b");
        language.setAlpha3("p9I");
        language.setLanguageIcon("50CZXGQER7L83rnIpB19veWR8nqkV6ICCGbzTMBSO3zC0OmOnz");
        language.setLanguage("btQazAtdjI8kR4SNpHsTUsVEMhZEusSkAIW5QL2O8cTZ7M4yuW");
        language.setLanguageDescription("qhqWabD4RQZwrVUAuS1tW0z19inziWVbkKWgzrGYFBMxq84khx");
        language.setAlpha4parentid(3);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("988QuL62Q8w24p9cZEaPvMD9nAJTFLBbQyA6xiMqLLVwfO9stI");
        timezone.setCities("KSsiMfvkLPnWOLdYEw2eLFiKXeEloZVBIzrF1cXIpJt0GZZGTQ");
        timezone.setUtcdifference(1);
        timezone.setGmtLabel("NFBBMKT7JxVudX80Wy2Q0Unm0FOTdIbviimtBF5DIp7PCa2JZw");
        timezone.setCountry("XQpF9tIsdO4uaTfRT4iBz7HG2l04F2jG5d3P8XFO8qPaPgT3ac");
        Gender gender = new Gender();
        gender.setGender("NOY5TCjgagJvi2k61niq0O4vsYVCYDfOAi4QFnzQoeI9k23463");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("TyAmGxY2f9wysbTrpy8eP88XZ45cNABT5hCrlAogKWMZkgg8pq");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("TmQLE6VpEbrPHidw1ISxTyEDHUrr5x2uTwL3pWD50OGDH9bDIH");
        corecontacts.setNativeMiddleName("p3kfmNMhqY14AdKV4zkbQotxsaEyuJj6EjRRZI4TkQq2yJm8xJ");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("TpvTd73ucg3GRlj3FuMw9iYGvWgRCjIYvL3vP7PKj73Y0bj1hX");
        corecontacts.setFirstName("cMr19xq2TwZqTjLiLs4u5CvXJf3azRjsigm7j7vXVxWPFCs8qF");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459583581404l));
        corecontacts.setNativeFirstName("uQugqIf7moIkmnLrI4lNlFwn2Izm4bLSj5HaIATMra9xXuuXxT");
        corecontacts.setLastName("6qA2JkJepzuRw3Pek1i3Vi03XAEwmA5lfiREajw3PLG1AqmTJU");
        corecontacts.setPhoneNumber("SLxrwNoSDpKTCcaYHbPE");
        corecontacts.setMiddleName("2m6CxjPbWH7MoQNmTh2YfiGAUKN3BKp37cDhI399VZdRVdzYwf");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459583581404l));
        corecontacts.setAge(37);
        corecontacts.setEmailId("2HDC5xlLghNTHvL8NsRF9xdVf0Egrphj3IzWCevU6Xk210cJS9");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("tfpWUMZOVBFnK2HdjTYuZAI0tThKSfmny0Gyhe6RQp4oQ7c6ub");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("q8Wb75PCQkzKFnwPKfW6uZUVPC1tfZBCTyeZJgUUXwohkJ4lUT");
        communicationgroup.setCommGroupDescription("mGqX9kbGcMy0GakRQfTyiYgB9wxyefGET66OsMOUjautqhHMmz");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("Dp5vdtxCa3QlmjiEZJcXxfChSoH6jkDHR7MRfNQOslty3cC5mD");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("j4VXhUtvIyo8JBh1eiiH8xtzoZ3kNUfbiCfLl2oJaav0cY1A2W");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("0JczMahKL1");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("RCfS0xYsYXGsHv1rTecokwjeGCpQSkU8J70aUOHtDKSXCOIaOU");
        address.setLatitude("O5rQQHIt7vwJYy5wW5IT9PzqTfTCt1tPfX7OSTfwmc24dtl1Xy");
        address.setAddress1("FUslcKlu4dgACOkxUoNnZsiqHl45FT1WOGOfgRhO8wkxXLM97B");
        address.setAddressLabel("0f5rU0txxZH");
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("WSgl07h11amnHH8v1ijuYSCo3JZFgmGdmuwd77WGAsqT3l5hIN");
        addresstype.setAddressTypeIcon("Xz3uc90HePjnkIKdH1F8qCOQtOWeXMc7cypJk1eiCEPELgvft7");
        addresstype.setAddressTypeDesc("U0G8ntzcVA45sYv1MlmRlh46XbHcrOD3k0YNXFJ4xvmV4DnpTf");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("eM7DB20Du2a9Bp4N7BJAJUnYqx3Nbcji7pDacbLsMI15ckZ4LV");
        Country country = new Country();
        country.setCapitalLatitude(6);
        country.setCountryName("U2jE7bNCjJ9pdDXASuE0TZZ5QdK52YakbPdUsbBqE3xLj14grZ");
        country.setCapitalLongitude(2);
        country.setCountryCode2("fKK");
        country.setCountryCode1("34i");
        country.setCapital("PQ4KsSzXzqq2AhfMzWPhLFWhq9KskvAz");
        country.setCountryFlag("vEEu1EfwBZUXdACDEXMxVOKwKczqstBPWQ34Z3lmlk339TxPOE");
        country.setIsoNumeric(880);
        country.setCurrencyCode("uLJ");
        country.setCurrencyName("uoVKCyAeWTdEOGTq7MYyzsUq7m8g7cHlG29H5aEHTO0jEn3a7e");
        country.setCurrencySymbol("7OCN9sOkr4GK0f9JRE4m77nXoG8KGHZB");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCode(2);
        state.setStateFlag("Yi68XnOxYiIGip15E0k97EzqBFeM5nZCCh8gXdfwVRlXGmTXnF");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("5ObRMjNzeA3Im3DEu2awvorRvtCkwBJk5Dzk9IkVlvFF6ZPczw");
        state.setStateCapitalLatitude(11);
        state.setStateCodeChar2("t6cy3GWC3X8ouSYQCukPvugfGwsNBvIX");
        state.setStateCodeChar3("K1pCcEoIxemvbVKE2rM3yIR247A9ARJ1");
        state.setStateCapitalLongitude(11);
        state.setStateName("U14KfmcaQqSlq50yxvgTsLMjBQbLW2bZLWLLlVghuBjc3vlXZ5");
        state.setStateDescription("lDVurgFU9oJdYVU8tMbw5sPvfXo0AAz6fovG06s7ES4FGA4j0B");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(8);
        city.setCityCode(2);
        city.setCityDescription("NX3GEL1wIcBwyzvzyMcDIj6OQBwlC0oJgt9PeuZsO1mZRhiPfO");
        city.setCityFlag("N0GFMkeF6YiZ0Fy9o6F1AVUM3g6hUilEDu65PQGcdl1D8cSQul");
        city.setCityName("cDtIDyU52OypmOUp5A2faz14QjShs3Nm1u5Fz0lxsWxj6RdBZ7");
        city.setCityLongitude(1);
        city.setCityCode(2);
        city.setCityDescription("5WC6uWQyDMEQLxUzhfehuZaQll3ruM2bvAJrXUceW8kjveOXnm");
        city.setCityFlag("B06txKXTPHHmYmt8ZhYqbXJGfO2DNa4X2bVQdgg9AnRdyupvDT");
        city.setCityName("wtUk6nVPq4iSBbDZN1afhMp7oiyD27m3F2JgHT9ZZF4KTJyOv8");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(9);
        city.setCityCodeChar2("OSHW28AOVg7YdZHfLnuYJSfRnTeWVSLk");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddress3("lZ50bACTPCbAFYPqzWzmFVwlbpiTqEThqO06wCGd7eNFUgmrau");
        address.setLatitude("9k64FP1XFFaOJa3g05UcwiPvjWPiIKY4a5CkSZ5FMteJCn6Xve");
        address.setAddress1("kg6KVUoFMEk4sHJQnqnNQk3olr8SKFcgVuEBvsXsM7moDav37U");
        address.setAddressLabel("3tmkfCbuRia");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("y9u0Mu8ym2hoVf43cuz3lUYWLvVeJ3iGA4psf3vuaoUAbOAgmm");
        address.setAddress2("A7UZSfmwCQ9EwniSjzfSu7SZY716OHeCT59YEf4ESdmgiY52jo");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setZipcode("jou1HK");
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeLastName("d92OgzPgiVt6HnlRNOeZyt66mzcQMGTcmAcW24IEMCDZw32KhF");
            corecontacts.setNativeMiddleName("cuRrM3GHLdInTlnzDy2QnpEcA77BztroiHRzjJ34UsD91XstOu");
            corecontacts.setNativeTitle("MOy0WtUdCWeTmqh90E9eIU3EoFKMmArTZmzCBn6VLa28ePYTA7");
            corecontacts.setFirstName("FTNDh9aMgSXfKe8FMZDM0HqVCl767VePQ80PqAfEfs5knYSTaB");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459583582497l));
            corecontacts.setNativeFirstName("2yCk7kKFNWbRaQIlBm3QOLWvNTUHtJPJJvBzJAtzVRoCUbQfSk");
            corecontacts.setLastName("FbgC7BTqUhQkDBg7TK8i9sFDUnR8Qv8z5Z7CzAfd9lwTUaBQfm");
            corecontacts.setPhoneNumber("wWLbx6hpecstEbUJFK9Y");
            corecontacts.setMiddleName("y24CdX2EaAZUYFZ6Ocoquxwbv4wY9Jk6c7kY6XQfSBx0bADpGl");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459583582627l));
            corecontacts.setVersionId(1);
            corecontacts.setAge(39);
            corecontacts.setEmailId("ceWstEdcExNdd7lww3syR2l6C4UQogzXUOG39cKQkiP8iPENps");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "Ny3cdBaZp30x077jkyGPeGIj1XK0V0RWAMBzVJgmixTG3OQhfuQmMvmZVDHNwDTB62elNcCz5pDti8Wmi6vOXGnIhFtFsfsePXkVbFrNPAUPAS9X8jEvsjVnpZq830xuUDCtYg438xauV7YXAMlJ1fMfDGvGJddHMJntwJFbRftCT1ukwwYx6BAQtEeD0AUR0lJO5U1Z0cmkZPsLDOVvnfljrtYI4Yjxs20xusLqi27aJLvrzuSKzvGMF6gCuxNSH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "WkwRIERmK6uJ3tuPO1CwzlmZLlVXfbYWqBPYjNSgrMiSJz4q70r2Rp2G06hjIKML32x14dl7Gi8UpCSEDmywV7Ohsbre7uh2cN4jj69OzUgDdDRXRHcCd8OOyZkA16zm2Y8ACLhUZlLhXhxhlfHitvTgDCglAvkZefYQXxYZ2lRPP5F8Up3Lnl8fqC1EUIlXpV34VPsA3FW5dTkIklR9uAbGL49iowvkLqFatMByCDulXcotgKZKsb7E8QtqzVmYG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "TM3Ruk9ya8KnVJHPyqTQZfcEx6yZudH3PJvqWc661PQl8GQ4DCKeQFV1S6g4ePDu1uIa3eKFsbn33KqxzfJDej9LbLGca6WX2ECVAu1EFRuqtxdmBWCncEIjaCRUZyDDkMTSsOCmAB5Cs11nZumg219ropIAcIgCyGcli9WOlT2m7hpM6rNStyB670CgsrhJGwzRmBR9xsi21kRC8pnpyQvP5Itx51tzuaTYbTSQWETjMVZq3llZnrIJGCxf0chhp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "P64iO4VCs3JdkeH8XngJrA42G69AJhJx9A76CVHwxAayb9UpnvQviH6bWlndfQRvM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "aTM6ecG5ZoDEK8ecUnKQUWTvqPAznIAIKewEw7hKFSsVsLJFo3fXN1Ltd5JldZ4jWBfReIGmHVzgCKyW56JDAYJljDmd79lHIGcgo6X83slcJYjdCSDw1uLoAh9GDVEcP2UTa5msY2WTiMebZttoSfEquVQfz3DDjtmoMscabP7ihGIw0cgOTxxJ1V6Jy789MTmEZ7TyuhhaQnfwT9xse3C3WR5kV29BdrfEbn1i5ez1un1OFtW7mUOjtGAAphuwm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "9iuyBKCOFsnIN7vb8oumrDrAYGJRFddTSC7HyI3fPcPNasRmtPzvWA9ka6E9K0W3PEVd9xhvKEuILmY6CLQQanrh27aBNs4cg5CrvRWl1XiT5AxpDrkLA1Z2dDoKXRzkSoWsd9x5sUGXA6g7meIoj5PBN5dqTrp6a1J8NDb91wXxL4aBhkSdXh2WfQXd1FHmgK5Irjs3yrhHSTV8guF8lbMF8VgvlUMSMZqi6Xof22Cu4fbHpXORtQN86jiN02C8v"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "f4DqfTqr4TI8rXvoKt2Q8Gc5csq9qXxGmxuJCM8wynezqmnZ4cglOR2dfDFJ22TNjq3aGalBxgjvFemmYeb3tiqWl4ANoJyAbFw7p1GKpl3NndPzTi3dQgAqHSq8BQNXhr7zz16XtnsowKj5H4FJswMpsxczlYqz0tIN3L8zuW6lblikLpcs7nmf5Vgoa4YSdnkY3h8GxQR6UJGLugD6aglSESb9kMblmOMR47n1HOj55mWMEZsY3rRfYj4vDQOEw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 152));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "qLTjMIQvNnfWO6sjU4poEHjOJ54dGEaKPJo9xxnYnrtyyNxG2s0HL5yeblpqpuho95EVGg5k5tA9cXVHOUvq0hXQ5PCpu87r6EJvHHSslatAnE4DujFAoUuhPGuAVaW3gd1eHmr71xoGKVenHMDrtBXN6aHv6p2hGWxARYaHXqnO7TzV2CsNVrbRtyoDUtNxF5iH9NkZhoLT6PZ2lBGaBpI4zj0uco7zGY1fFQ1GVALD3G8pwt7EOs3PS1IDshQgh"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "F4B6r1RTB0tJxyX0XMCqp"));
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
