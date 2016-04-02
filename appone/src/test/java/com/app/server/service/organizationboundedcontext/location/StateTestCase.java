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
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.State;
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
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
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
<<<<<<< HEAD
        country.setCountryFlag("LgpwXy8OfLm6F3fzb4AnWG2eGXuM1Wht2GZ1VxQgKSEFXr0pha");
        country.setCurrencyCode("jFa");
        country.setIsoNumeric(504);
        country.setCapitalLongitude(3);
        country.setCountryCode2("N3y");
        country.setCountryName("4DW5NxbJJ1uA4rTrLzjujkiU3BeziyoAvselZuLxGDsa4zSDBX");
        country.setCurrencySymbol("KkJTsyEE4yU3G36x8Iv6NT95hB4ezCZh");
        country.setCountryCode1("2Mm");
        country.setCapital("Pam9Kzc7VzN4ITRc3p05IjuCB2QF0Poo");
        country.setCurrencyName("c4E7Rp5VhrE5xUEOpOQQaZTw5Gfc9S6TMHXpLEegxNybPLofyA");
        country.setCapitalLatitude(1);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("2Ziwsmfn6nSz8gdBuQZaeHBHDeF5H8JawNOhaIV2Fg3cDzdywQ");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapital("X58z439QnIKKSfjgZGyyMA05HUQWhhNAVoMoGbeEL36PZg3WNQ");
        state.setStateCode(1);
        state.setStateName("ok055CzAUkdCqQR7T6G8TjGjRn6c0nQgE9s3W09ZYVTzKKNqVj");
        state.setStateDescription("vKY9zYgRcUqr2wjcx2THohIgpP29F94XLUefcv8dV82RT2qTfm");
        state.setStateCapitalLongitude(8);
        state.setStateCapitalLatitude(9);
        state.setStateCodeChar3("TcqO4IwvCaKp9oPAzfTmODxjRkw8w8dI");
        state.setStateCodeChar2("Qcf8QRDugnIrO5Y1hZWnrJ2PkEGycSip");
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
            state.setStateFlag("gVZlNZgxY2LfO6QHmgAaA1ux0dxdWoHfzLdXCZaFVBcAcQZjmq");
            state.setStateCapital("j3rgDKmHkRcdzJ31wK862cYW8YXA5sxPDcFGc25q2LY8obdf9b");
            state.setStateCode(2);
            state.setStateName("aQVsMiY8n8qRlvWPdks4ma2SudWdbixW9yswlnPRtBbrN4QKxR");
            state.setVersionId(1);
            state.setStateDescription("zvHu6RlGFLRAWmKxpgjr3ehOajLqTBoXFIzS5AF8diFEHbK23F");
            state.setStateCapitalLongitude(2);
            state.setStateCapitalLatitude(8);
            state.setStateCodeChar3("wMN3hwRkWQidMV66cY1wV09wisGGjLXB");
            state.setStateCodeChar2("BxpFkveTc1Ikuk9sj7SRiiOsveFLifiF");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "pxhnYqt7HROyQ1YiHtSRkoPSuGU3oNpn4IS0AoZNRaTbD4CvAN0WHUxfkPIqkparsqBGf1fnwnz7WhQcqQ0KrCLViZ4ZieagV0wiAhQcwiNTeRmhLtdfdMPGoEwOuqUf3iL969XRdlkrHbabTs8GOWyNO8geOVQvOyZPrB3LIh9GU5Ye4prVO2nMOPTEWdh1q3cXaJPvJl0lMjkBNwAKm7dCdjBwNlUoKmuTSrjyW3VI0KqK2RnKeu3z54kv9VQ9I"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "TQ8YxGNhboHLjkY34xFnsXe2OtktifT5k"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "AwrhBpUhcmE9cmYm7kFF2TNbwDcZhVwC2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "61gKBJwPBPIxRdHCCIfDcvjLadMJlu51CF9R0lZ3cdkTlhpszLsimOgs3A6mwrSrGoGPA2G93fCoQ39xtGvMinMiiWmxUWfEMxBocibTqgjv3zRruktOXY47i1qZuxEw2z6iwrnZBFHbJ4LQyvZcgkK52vkc4lyyWIvLSzxEjm2cuyChT0XRv9GhY21ZPbWYGJYbhrvsToqfqYByVI3y0UBBH6e99vGwM868jxPRhUfHyOrpdFb3ISQhMuLeUUUHo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "RxwwXnWujFZdRPVuorBy59G9aindHx7D68F9jAH60LYSORA4orTTZokpB8Pjav8jrgNn35w0ifkRHPlyW4V1ZMREMKC1jIT3fFr77eNcnIBF6VMTbqCzE7iIu0hSbH6LO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "G0QI7tdQNSSYTNF26dxGZxdopNphL91z4KNAteLakWXHaB97pmg4TsjOcSLbWvyt9QXbCeAtsWC9Yeb954uk6wE79LSS4s2G3uhfsEsTG9oQv8VT3Qg38ByAeZQgWmX5R"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 12));
=======
        country.setCountryFlag("RBNpAfG9QIRQnTYeNZxq8YW9gmA0jEkiiMpNCVeruPI9KZo3Tn");
        country.setCurrencyCode("Ncf");
        country.setIsoNumeric(157);
        country.setCapitalLongitude(4);
        country.setCountryCode2("26R");
        country.setCountryName("27ZXvxyCSg9H1gVnOpQM0q8YZiwE8jz0Ne4HneZrxo338uJzTo");
        country.setCurrencySymbol("2LutYjQoNqlGQ1zlkZXmgIFo5kSCf8vA");
        country.setCountryCode1("S54");
        country.setCapital("IRMnSHH00HEtAvhImJEB8m0zrcXZ9uOX");
        country.setCurrencyName("AlldwWazr8sCv9NmYM1q6PmUMSgXXFOfg8wPIlJdGkglBpFFxQ");
        country.setCapitalLatitude(7);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("uQ1kok6hYV2hHvN9qho3OHTLiaLei7qkFPi2v0Rys15IckUjmi");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapital("LOcWcmiJ8SY7mgJivUNWgEr2FtsAIBG6NQTfe5SE4Ql4su2XyJ");
        state.setStateCode(2);
        state.setStateName("zRnLSFJtnSajkqOSoFJUf82q6Bk9BHDPA1aYTra0fBfVE5LmxQ");
        state.setStateDescription("PvD5RyrfQSBD4leeiSweYFtGAGuUD1f4IOxr8cNspTtCvWBzR7");
        state.setStateCapitalLongitude(1);
        state.setStateCapitalLatitude(8);
        state.setStateCodeChar3("OFcB61V4rzIYv4C7aHqtEMMuCTeNHb8J");
        state.setStateCodeChar2("15I2CMO7126QhDVO44r0xOIRn8m2wB7y");
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
            state.setStateFlag("UiqjUmSHkwQCOxeJqn2MxQFDOVpSPsyIikpuEO510uuBXIa0Yi");
            state.setStateCapital("gyQ1tY8EhPC7uRew8AEwpNxeieuor1cHNREnmsKELO7Y7Nol4R");
            state.setStateCode(2);
            state.setStateName("nkN0AOkUnkTuUBgmeoxNhAGBUtxi7Sjypf1WXdyo1DEDS953Kv");
            state.setVersionId(1);
            state.setStateDescription("BnO7CVFEsa7TK6P3ZlPCOxtZua7TNq0brdxlufjdVTeGIKCU4I");
            state.setStateCapitalLongitude(5);
            state.setStateCapitalLatitude(3);
            state.setStateCodeChar3("Xx4avcqDbykcWqBlBM5ymQQ72ep9QrSz");
            state.setStateCodeChar2("Y9XtULSSfpskIILYHe8De5z7UCSKzxXr");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "rxc9ML2jsz3XSgF3YHQ9bPnEIYyusWkxA5gOzWZrHLApOQPuJV5brEQmwqOUZqp9eOoFkwzAxEkddI2IkzR4T2iu7USR4YucSGs2Bj5bm7oWdnUiq47bXSF4oUqKnOBjyhO0eu1GjRslO2zahGXDEoIKFG3C4v2iRdCjRgjsjQkKDdckrz5rHuEmcd7IN4i3Pq4pGPbvHQHof4OqaixXDSKnqQ4DVuMCPeshs5Bno5Jvqo1kgEQ54qilRFixI8wDL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "o0aUV8GYqI6VXQU4KhYzgGzvAjByrKtXD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "FpwuB4MUsaYL0QUadSsd4XZ3pLbw6Z8vl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "9vQUzp2jheTiBtqc6JlHFd0E8zeiV4waJ1ro3QT5Z16sIENF5miMV2vLkN6TwkEJwPHCy20C78Su7hwjzO2cGQLRKvsVhAbNOj5NoYMyD4zQ1LZa7NuNqaxxXvF0gZtJxYkj6X2PPXwhEYC3xCBBwZNY4jn5aenbMv84pLs1o50JlL2BkJvqUnLiIPe8bRAk3ePsJ616M7R0ucgKxMvMc3OF493oTVwl7ROIN6YOGAzx4x6Jd2BqXWnTLOT3PzVmA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "tthyAfuucPItTNBjux7TZ7y6s6dbwcMVcEyqSshHC9hpGEaVAwYbZy3Izyt2HuiIiePUBOb1gxQEcJbXj8N1jOJgPSHWQqbEb4HYeYndFEqSOFD4KUIgYSE32EPlQOPAP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "ir8SjbOF2YpjaS4njZEeH79pePRPwUxO8TiqvqxTnVTvQ19NfZ94hGvWnzqvztc3tn290dzmr5wupTo6UTXl0Erpo2veOgYQq3YdlfJecJ6Q785Vsg67PU6UrbMin5yj1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 15));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 17));
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
