package loadcheck.app.server.service.organizationboundedcontext.location;
import loadcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import loadcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import loadcheck.app.server.repository.organizationboundedcontext.location.AddressRepository;
import loadcheck.app.shared.organizationboundedcontext.location.Address;
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
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("GSaoInMeRfyZkdKA6Rm2fUHsnRvhmGzvGXSdN2rXbemSamZKvu");
        addresstype.setAddressTypeIcon("gyBT9ZEAdaZb35ltzL0oUpuOzOhCZkOWgG9FqnNUWJjOtSGoU9");
        addresstype.setAddressTypeDesc("Xkh3RLtyYhaH8Q9KkfPTbuMip06NItFWhkxOrq1WS7BEBAdFgJ");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("rkrgTEMbdTsYfglvqgeppoJOozuFsvt0udMMdGA1bznmAiMJDv");
        Country country = new Country();
        country.setCapitalLatitude(2);
        country.setCountryName("3X9kBnlxcgPr0kmhkHgvs6ym13F1LftO2ztDOW1O0zpHV2RtVC");
        country.setCapitalLongitude(1);
        country.setCountryCode2("aMT");
        country.setCountryCode1("3iJ");
        country.setCapital("LJgmFVXBtA2BZpEE1XoLGQ8d1j2Eyf8C");
        country.setCountryFlag("B1JkfQDMoJSvUexW21tddg8sktYnnE8IbqpFv277VAXJOPMPuX");
        country.setIsoNumeric(288);
        country.setCurrencyCode("Ozd");
        country.setCurrencyName("toOVJtXjrQy0vit2hmJzGcAYrRGcfNfBMTp4nLJjSMF9906zcN");
        country.setCurrencySymbol("CyOnATj42GdkvvhkWxjWxrIRZahO63gd");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCode(1);
        state.setStateFlag("ewUnbC1K0TC7DcDkY38imGTdfAgUpZbSTkokmtwSVTBFudsvBe");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("DLVNdmoVaVptl02HF46JMsMx2qpcR7VHrtMgSGW5aPeo67TycJ");
        state.setStateCapitalLatitude(5);
        state.setStateCodeChar2("M0kVeun79Kmo5NhLMaJyzl3QX3mhSqSQ");
        state.setStateCodeChar3("nrUl5x8lCRcYXNOY3IxQw6fw9HWDdwjT");
        state.setStateCapitalLongitude(6);
        state.setStateName("trApEB33Sl9aaedw5wPlgVz6IEKqn9ofCi8rxJy7RygvG2ZGKY");
        state.setStateDescription("f0y8j8Nopyb4tk0EMegm9oSBtKExfS2UFGIXWlbQPM4piqoihx");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(9);
        city.setCityCode(2);
        city.setCityDescription("U6M8bRMYDdt2srk2df595CzdVjut5GeU14ROtufqNOz4KNw3pq");
        city.setCityFlag("b0spQh8UeswD7sqvyNKSvPeXTCGuZJaFGHnmXuRO6uMkJZ8w7B");
        city.setCityName("5g1FSSEeCoxCaUC02Y5mljdeRvfVMXOx1uNYHkLroiGQcfz3Nk");
        city.setCityLongitude(1);
        city.setCityCode(1);
        city.setCityDescription("GoygCiDMRupK2rKt3zk44YKnnkARHGkYZd4MDDiKMZ4OBJAqE0");
        city.setCityFlag("C3WSnsNOOsaStxcz2rLD2ev64BOvqLcHiVz2cFPIjCRxU8Yi09");
        city.setCityName("4m5z599ZfjN11Xp2oa0NPQSrbu4dYhRWU82xBs6byiflmmBK55");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(2);
        city.setCityCodeChar2("HZUeFKu4Ujx1twWRnHcPdJMygjiHC4fG");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setAddress3("uPRJ7AMQVeJZ3gnEs7rtBeUVvvK54yaoRQAv7dMzmtEYlUUFnw");
        address.setLatitude("GuJvupyGKvaiActbYOvwgPkKtJI0tRkU2gfTAEwq2fj1sywPGk");
        address.setAddress1("t5PIBBpv1NvLzzxatgGdhgm5JO1RAlFuuLJXCDKYg111Aq4KOq");
        address.setAddressLabel("Iw0YwTk7BAM");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("U4ZjXcwoz7Mv3SvKgKjEdwrxkhwwQ6cd4m2Wm1vfL78vV9jo4b");
        address.setAddress2("JesgAOFrJdgi2lMCq7vDtyMe6798rjBwEYThc615jPCwuK9f09");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setZipcode("jHMrob");
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress3("vXCRBUSESGvSffG7PGN4QF6z6asI6Z0UE2ulZ99fx9jt30WeMn");
            address.setLatitude("zRTc5u8SGrYgL4dkJg8hlz9hjgd6JqijZzxwQrZJ1VRuNPr6yJ");
            address.setAddress1("nsUVkbL3p30TDr3GXch6HuSsK7dOYtSnrrUQgW049LW9OsnjLV");
            address.setAddressLabel("cREVv6uhqbB");
            address.setVersionId(1);
            address.setLongitude("QVKrkwfxZDbeC5dq1O7GNS2gFTGQWGWc6R0fmoi9mKrIlpYVxv");
            address.setAddress2("CaBcudTXcRv9dfnjr5vXzxIGd9mQVxZjbio6uDDvkSY5w0keQL");
            address.setZipcode("7LATSk");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "DpxLgwaQAy42"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "wJaY8A3pONSApZZ6CSPiKLkAeS2QqHi1CDOKBSZmfsl5CmFDxUwuehzfm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "J42l9phScV6Y1FwukC0kx311nk5kV5WmHzVVVlqEYnXesJjf5Ru2tH6tM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "f6fKkN4d4vSwUB9UYHn7Q06IoVveluzLkXCPG8yMKOXNIB7WDgCtaCCFK"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "0u5Nih7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "ydafhcscHZxhbwotKDui0N38Sqn02iwLtHrZLrFyYXVbwspKEHXfmffGWl1QGMWf9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "blqx7WwQOX0TQCpuMc6XZKJmxN7EnLmVRN5bz1CSrlNS4aM1RCEsPlk6L7c5oSl1c"));
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
