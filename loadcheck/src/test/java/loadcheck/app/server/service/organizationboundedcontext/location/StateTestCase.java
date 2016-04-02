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
import loadcheck.app.server.repository.organizationboundedcontext.location.StateRepository;
import loadcheck.app.shared.organizationboundedcontext.location.State;
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
import loadcheck.app.shared.organizationboundedcontext.location.Country;
import loadcheck.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCapitalLatitude(4);
        country.setCountryName("lwtqAUAL8ChmPUIQYhXWUSPcMu2s4jvAJqoRRlgGposXI7wuJ4");
        country.setCapitalLongitude(8);
        country.setCountryCode2("GPX");
        country.setCountryCode1("QBM");
        country.setCapital("JjgicQgq60TWAfpOMmVgHR6iBKOuX5Ls");
        country.setCountryFlag("pq5aiuAso8iY5AZM2Zne0UgdIymmPRF7ZUwVnDLOFVnJdhGG4r");
        country.setIsoNumeric(246);
        country.setCurrencyCode("bQ6");
        country.setCurrencyName("kAXBpYjdmizEmrGTheSicFGKEqzgdIgpQc3gYAMtau4SoM7oDa");
        country.setCurrencySymbol("r48AIIycMC8EfL4SnvlLBUdNXOH8N2x9");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(2);
        state.setStateFlag("s7r1KBVsED63LCVHqxTfL9Zi1T4DLWsXYVjwMMKgc1KGtor13B");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapital("QzoGswJoW9kjxfS4TUSmM8e4uKs4IETGVvquB3tpCOeI4wF1WT");
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("2omzupJcDHiDKOKzRjXhFkAFJj0o79XQ");
        state.setStateCodeChar3("bdzsJEu3D4GVkpBwMaB85rfurnOh0JGK");
        state.setStateCapitalLongitude(7);
        state.setStateName("vWuiZ1iIBoK4HQkkzEHZ3euQ1o6TG3J0eqoJyVZmToF39p3aGh");
        state.setStateDescription("zIlPdEUWtrFoWZDuLzylspg5g1bEdv4lx6yVhEKGYMm0AntY73");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCode(2);
            state.setStateFlag("MpkzP67YAeRXthzVKNmP02mw4tUClZhqglWomPC8lfjSJnu5jp");
            state.setStateCapital("x0ZAkvP1KkT1VWpPgiAHeToc0f85khCRY5DnUyPl2wCHTbpPjP");
            state.setStateCapitalLatitude(8);
            state.setStateCodeChar2("2Ct01XVzPO7e581u9ohJwEL9VyzGGalC");
            state.setStateCodeChar3("nTvwEEASnqnw2leWugVik4nwwdfJPf23");
            state.setStateCapitalLongitude(1);
            state.setStateName("jaMVC73BF4eLMyW8r201eFsXwF1qCe7X1SchEcrPf2Zgx6Rs7e");
            state.setStateDescription("uKJEpqOcWmz8vJ0015PjQMmI6jjA6FmMcZv22zIX0s2KenEDCR");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "LTCyZpfNP8suOdsAALGSNgjkhOL3oPV9EaHcSdgqF9C92lKY8iRReYvGd1NElOeP6tufycNKlzWmJqs4lKE3xya6NdftVTNbt2RtW7CQPgdm8F6nrn6mJWHb8koxNV85OpZAPLGhc4qAO8PWrGBPPneg1enkEx85AzBP9gJz2kUaLG1sCnwZ3TH95xkW6cJLEUM7iIPu30uX5mmNOvHyOGO8NlQu8eRlkNGLAuSByrKnRV8qXiINFPJkWwK7BDOfg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "7snm4QAPBxpADVdpb53RPPy6Gv13IU5yI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "kpeGMleIlEZ8vELAqEsBUyrFIkHJ1mC6S"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "EOR4J27kEJZIghHignKf8g91aQpkESzT779SFNwxFczbJLWVYrxjuNSPt9uhLqBMXa9wvNCfMrr8UMtsKEf1P5kzfUtw8FIN2gf4J99e0RA7T2SEvfpqeW3I7HaT4LwfMnIRcVxPVwglMztQ2OM6XE9zgUkGbIJbcmEzAfsPsjpv69UzVEZuW3tKCuNW3jj0roO7fZJjHlKLixB3vHbAA7FkbV1nqwL95ljYGYI29uMSSk79O1s4AlQ4TLtTDlWpc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "MS1kmwZVHmEEFAKbu5hO0bVOD8G1fqSz8gWLtCA9LaaxCxFZNYTG6icCUlgCIGn5kUW7UMK9sPA9G0pGLWjMbCwg5nuEO6joevdVtDKClRNdkCae7HG7NGPWTAeK4LL3i"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "6KpZmRvZMm3wNfetCj26WiZkgqdcf4N5K4g0j6N0f5v4KVPTMDlzCGMnq41YZkWZRZS4SBaDm6Qt4FZiEeao66tdbO0BPs2oqOV1ZV0tzSX65i16sHD4wZnc8pENpBgqH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 20));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 15));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
