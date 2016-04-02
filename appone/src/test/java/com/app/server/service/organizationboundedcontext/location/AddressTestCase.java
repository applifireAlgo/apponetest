package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        State state = new State();
<<<<<<< HEAD
        state.setStateFlag("m3dAqQkfzEN14FoBVwxO7jCGpV0r8pk9DgT23imFgVGTuM5xKG");
        Country country = new Country();
        country.setCountryFlag("7QpqXnI95EBpYuP5H6vb9SN4KnGRVtPBDsSuM9ru5Sx25ylVft");
        country.setCurrencyCode("01M");
        country.setIsoNumeric(828);
        country.setCapitalLongitude(3);
        country.setCountryCode2("amO");
        country.setCountryName("wXH91w62T0u5CCrPVFIJYoKZ1PBC6tS7LukVSBn0WtWTe9jaul");
        country.setCurrencySymbol("TLc2DO5CvZN2gHll7KicsH1aKmcEA16R");
        country.setCountryCode1("uKV");
        country.setCapital("tEirJIfKBlPaAr3NsY7ssEHQlpHIzehR");
        country.setCurrencyName("zZK0Ee5EprKzDHxO14gesQCAIJTZMWAR7cs4ABaS3DigVvVd8I");
        country.setCapitalLatitude(7);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("xs7inywuMy1Lwj9052kxT6D6O7S4EyDaFUABayGWOSqlQUvtoG");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("GKYjuA0g3uzGvmn2v0gRBSzSA1WR3bD9soyB2vRNqbRTcjmxSI");
        state.setStateCode(2);
        state.setStateName("Saj6bMYAw3ah5IPmcIgJmsWngHGCJhsyaDbdupdX7LT84fq9dc");
        state.setStateDescription("mG5BJkqQCzGNnLf3qYaNTWAB4SRF5NPhVxGqFaOpFyFD9Mv6Mp");
        state.setStateCapitalLongitude(6);
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar3("H8zE2bFZSVJhBdOmXwRNGm0OrMyjm1YE");
        state.setStateCodeChar2("HsMGFnDdkklefKPtWZ8JFaNQsMCNrE82");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("u4zVQjwQyJUnWraCxugl5guxrpkuHV7xscqnmksQBnlAfqGvA5");
        city.setCityFlag("h5esFvbx32TrsPf3ZtaAB6Wb7Wy0r87B1t0eHTrZcBEWDXLgrU");
        city.setCityLatitude(8);
        city.setCityCode(2);
        city.setCityDescription("DtmbfHc5DBsrcLgViIrdAfDjJQYDfEf4SAIbhACQXdcPLAvAFM");
        city.setCityName("nP5GAfmmOdnSSFCZMAad0NL0T85UAfQlQ2JXHHkCG14RRgOBeE");
        city.setCityFlag("m7ZuI9vXRgIYYcB8ruAdsiBPAlz0v5KZEdoNWx4VfNzbg5I8a9");
        city.setCityLatitude(1);
        city.setCityCode(1);
        city.setCityDescription("oNLMhIMosvQ9JDXT1IgoI637aMXbB7aCQWilSvfAvIHcdllA31");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("2CReCOBhjvqiBpDcHUsHJw9k9TjORqgK");
        city.setCityLongitude(6);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("KB8xyGDSTN4j5R8uY9bgwPCYZiy2fdp9YTcQmkrBhezSfFRRMS");
        addresstype.setAddressTypeIcon("JpUhCYGGeyhuAygcUjwVApql3rgyLnP4dcRvF0WfsXnZGzuwov");
        addresstype.setAddressType("Aea6ocO637qfKxLc6U0qUTRXsj9mRx2nTeeM2hbratYa2lqpAu");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("fVi6jSv1WX740tpezXb0cK2H9r7aaBqvdyQ9CjzqUJB35PpjRH");
        address.setAddress3("xFcQdxtaJLpwUPsGDv4fnqNIkqcW6Zgwo9IAe5t0E7i8N3YImD");
        address.setLatitude("gHniSy9kMmc9CGBdxVmHtjk54ufv9CgADKBLGtFl60XKOiaCGZ");
        address.setAddress1("ZJ0fqtq5rTWGT8t3MmSplRMBnB05LGQZwSoXtAlyzQ7oMZlhcZ");
        address.setAddressLabel("k6B6eeDD2lI");
        address.setZipcode("KVLVbp");
        address.setLongitude("zCfXugoSeuG4dNtagkIEtRpvSzu2KkGXggyBU56SKoiqq1hQCp");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress2("TEcSaQD3bUxWiQu5aHcM7Ly8DOwrCTRtdlNQLdRDS1VJY2Rqng");
            address.setAddress3("SBgKDaXlzZnvG3DHw4tPtPbDjs5brQ770hLa9SpmNXBaTuZNQs");
            address.setLatitude("9wfVIwi9vNQmMTxBe68H0P8wgPSnFVctqTjlZWDdOeWZefEj1T");
            address.setVersionId(1);
            address.setAddress1("rc99n77Fl24LbHBbhJANQ9ms3c7PjhMa2cRqpAaXOswS37HL7A");
            address.setAddressLabel("LW20XX9mTU3");
            address.setZipcode("MP0Afb");
            address.setLongitude("jj52sF0R82ggV9FkKi83ecYQAJx8cw8iWLcEzyAbTVggsX22NK");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "YMdbDQVLLSV5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "AhqUJwuRYWPYMWcofswR35WkrBzK5Jb0CT2p8moDCYhMcbER6Jf7ez12K"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "qQh7v5TZjeRDbVHKX1FA6OYamMAcTsMD3cxODl5jNsOzIsOxbBIdk2szg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "KCzOd3rbZ9CB90vAx7bHTGb4mXOMvEhrnW6sdi2XUlXl3HXSjsxViUbKc"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "TlGwLrV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "ZVmNyWFx1IAchwWejogx8GqFJpvcl4l7eVfBgyoBCpiD1cR651b5Pf2jIRhHJ45qX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "BKZDMcXoWvYRGsg34usjvJL3B8cVop6nNRuAilKIP5Soxv5tgzEYdiMSVr31GVl7Z"));
=======
        state.setStateFlag("lF4Savd4squArZH2KnFjIk4rPKEkJeJ6DqQsmmB43WV4LdnB6J");
        Country country = new Country();
        country.setCountryFlag("1tPJr5BmJlaE8T2Ocb8VY17Fa3YFMzkmcHR4qOTFJzlc6eR8fh");
        country.setCurrencyCode("2b1");
        country.setIsoNumeric(427);
        country.setCapitalLongitude(1);
        country.setCountryCode2("zVh");
        country.setCountryName("pkAX5P4F2qBA81db2nYPDdRNsOT7D9v5YNFOxFSGqE1at1dBn3");
        country.setCurrencySymbol("QEVXxH2GLCcM5NfgNHpNNm0hfXSm7tR2");
        country.setCountryCode1("62I");
        country.setCapital("qYADVSdSEsoPASpnLcN3kMKpgC0U6Xeo");
        country.setCurrencyName("CQchFBDBPWqb4H5wqENGuwvM7UEJw8N16kVhjqYzc9smTH9aXH");
        country.setCapitalLatitude(7);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("0XVYPqYTEUcaLPUR8nILxYs51QoHzkEcNXesEpvHxiuINCoSn7");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("ESfZOfkUrP0WxUmirxugLwRP8u08UTLHzPZDsmwrvMeTEO0Y8h");
        state.setStateCode(2);
        state.setStateName("C20ZBDyHARTV3TXtCPGY6mjjy5mE52f4JNuVLIGo07U34KfMEl");
        state.setStateDescription("SlrbquHsYnfhty6e1Nwc9AKq0MKYe88FvWjwuBw9C6MoRBhoQG");
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLatitude(9);
        state.setStateCodeChar3("XKFEYkeulo9jJmHytsEmFV3wsBwx4H2q");
        state.setStateCodeChar2("3pswBSgm8JgjVWzi8DIdoCY6JlDKW1vk");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("1oITfKKUWQ3pU4dYnyxvfBBuTpRfJGkiOPxuFJKBZzP7hded4B");
        city.setCityFlag("I5bRShmBvIU5eOc4YgkdP9NmNUqfBlBfPGiFrjGvzDYEWe0TBb");
        city.setCityLatitude(2);
        city.setCityCode(1);
        city.setCityDescription("Sjpxdmdoe6Ifb1fVybH9mdWLleChE3jhnwMCiUtwD8CaqiPkI8");
        city.setCityName("RWodJ59Vl9h5m1g01X6EpD1l6aPW43RobwgfFsAVG1Gwl9MqBO");
        city.setCityFlag("Cg13eB2p4wJ3klsT11MczScDwViyNXQnkrCkgBznpkZRDYwCII");
        city.setCityLatitude(11);
        city.setCityCode(1);
        city.setCityDescription("PLcKL8k5S7nBQzD7jVuH4CRCJfHZpbot10xKegl4OoNs704JEW");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("5CElwUGioXJllnMzP216wDlknndM18QE");
        city.setCityLongitude(5);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("pyjVPDdknChcBYTsTqqQJZq9lTdoKTlpyPmv7iG7PF8UZW1ICk");
        addresstype.setAddressTypeIcon("DzcR4eYXDCpm4Hds2dWyYqE06ibWWxv8yfMpZX2bkpVCeIjd5l");
        addresstype.setAddressType("aVjmYH6IIOnOXQtEw0r16KAAOgis08dDwNnTBvJ8BlpA2GIaqn");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("V2C24VYtmQpYacL8iStyMV66l66H1Hd1aF2Z03PpPMTsPUXmUU");
        address.setAddress3("ubIP5w7il4RbUYp4uxPVQjmzT8TTANHSjcrSy2jZKPiIeUvhpS");
        address.setLatitude("yRG2BlumP7cMrvqiXGiwxCp7r6PAu3ndOTDGnNnNGMgZzpQpaT");
        address.setAddress1("U1q8t2epCkvpaNjbJ8KvwFjoKw2TcI3RRlQ7JZwJv8UUbaY3Pl");
        address.setAddressLabel("730BFLSikPV");
        address.setZipcode("aXO6Wg");
        address.setLongitude("05h5oO7nZy55MPTijqK5hNncSB0Nj05wuzyacjhXvuFlQwjh0G");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress2("MBVTJRaj80aUoXyIUaxWVU8Q5AGu7TYQumEzTxKX65hMVNBnwn");
            address.setAddress3("FAhVcNw1Vu2vwGjZtOmbPosRSwJN931AD24pa9at0S1NOt5f54");
            address.setLatitude("GBt7ch5QkXbvJ8lTfZ3t7QJIjoRJCguFqUHVK7hxuACh2B78Mz");
            address.setVersionId(1);
            address.setAddress1("o38rQQAST9YT6nvSSJigdjZKWnIxTCXsGDYCr0d6ZA36egq6rP");
            address.setAddressLabel("UfmOgemTVpp");
            address.setZipcode("NAKFsu");
            address.setLongitude("qcWWVYz4Gu00GpdILv53wXB3QC7aTuVdBsaXLIoTh821LJO8TK");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "kvmXkQSr5ImS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "L1wZJd0ls0w3Mf6eECv33z09QgFyOYAfMbTVPlZbfUu05Vpse31LRWdNG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "OZr6QOILNcRoN5FUMrAzhK6xTZYwIr1khXgXebBY789s7f8LW5KUDI4bZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "BsHAc3S5Nptyl9VVaPW1qPIZ0tVMUJmnpGd0Wa4KL3to7EmOtGCUlE1gf"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "PNLmdE1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "NFpolqQxWNlVFqfRnK1OtBkwPxt0aEJwuAYoOnPmTMqL3v4SEVhVLev4qagKJbDQQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "DBQpZowMAKmUkBtcfvuE5WuQxWrpwo3gDlQcqz8CsqwLvIp6mRBDX0TLk3mBLEB7r"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
