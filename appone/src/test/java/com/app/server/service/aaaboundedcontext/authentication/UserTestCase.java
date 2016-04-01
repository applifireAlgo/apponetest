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
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.User;
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
public class UserTestCase extends EntityTestCriteria {

    @Autowired
    private UserRepository<User> userRepository;

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

    private User createUser(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("PZAuDktRVLq6JI2wY7M0pEfgD4HlkEKjDzG0hawVXXAzinq70x");
        useraccessdomain.setDomainName("QSA9a3UY8q8Rqp7mmV7pPWiEUm3doKXqkUp7gopI5y8Uks1UNW");
        useraccessdomain.setDomainIcon("jzFIuTNt5ZeywaDIEu9GGJ4TmrY5zeP1dIIjc6ZyytRm3cfKCo");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("K9l6wtgTV96lug3CnwZK2hKf7cKL2YkDOCNFCsSTrfNBbLbDyV");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("HOTGCzC5mWrqnhDA0pMjZmA2FFBs72XVQpVm18AWYMc5EfSnrp");
        useraccesslevel.setLevelHelp("9KQZ4RuAzAdGNXBRQ9f2eOqVeJ4svOLVhVTFjOgY63nMqeLsOv");
        useraccesslevel.setLevelDescription("6R4gnnyOTABnGmM8kN7GaK8Rn4ZAh8MkZMvIBxZ46VWYbZHLaO");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("8OLXxeTCzYnYWaCHlTf0VHR1xHBrBdQusPhHaeZoiw9i4e1iqP");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        User user = new User();
        user.setSessionTimeout(1580);
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("2BaZctjs4dh7SREUAfgJ7noccImxkxScvOgEePuWexaotx5ttW");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459520623373l));
        user.setUserAccessCode(45817);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459520623373l));
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("KhcrK3iy08");
        question.setQuestion("L84xTkubfbooQ00m5CbQJc6L3iQfpqoN2Zq2tba09S0y9H3rLw");
        question.setLevelid(9);
        question.setQuestionIcon("1rurLAPBz5036HJZOfqDb5yhVG1oHk9CNfgVOlTyQKlkqIvXH5");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("ABrMLw2ZkZMoVkj9zS6xuDRy2ClffA8INSd9KB81OZSz4jYV5p");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459520623781l));
        userdata.setOneTimePassword("X2G3g5PIYO4wpQDLiIAURQjTM8Mhmfgn");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459520623805l));
        userdata.setOneTimePassword("eN7h0LSvJITo25VuWcZYn9zSxUm5tTtP");
        userdata.setUser(user);
        userdata.setPassword("r5UPUDflBl3qgPbonV7VMgRTPL5o6Sge1SCKsCtB4pkUC7G6HV");
        userdata.setOneTimePasswordExpiry(1);
        userdata.setLast5Passwords("BjLBsNU6a5S8QDrNyaaX2CberPMiTlqHQwtnQeN4aepvSg9FsG");
        user.setUserData(userdata);
        user.setEntityValidator(entityValidator);
        return user;
    }

    @Test
    public void test1Save() {
        try {
            User user = createUser(true);
            user.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            user.isValid();
            userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2findByuserAccessDomainId() {
        try {
            java.util.List<User> listofuserAccessDomainId = userRepository.findByUserAccessDomainId((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            if (listofuserAccessDomainId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2findByuserAccessLevelId() {
        try {
            java.util.List<User> listofuserAccessLevelId = userRepository.findByUserAccessLevelId((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            if (listofuserAccessLevelId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserPrimaryKey"));
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUser(EntityTestCriteria contraints, User user) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            user.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            user.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            user.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            userRepository.save(user);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "userAccessCode", 89708));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "multiFactorAuthEnabled", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "genTempOneTimePassword", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "allowMultipleLogin", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "isLocked", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isDeleted", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "changePasswordNextLogin", 2));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "passwordAlgo", "RkzvBhexoIGAuIZEOy2VlEou1KkaF2te7QkjC9UXSPK06ldM4Y4doGzhZl3SA5pph"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "sessionTimeout", 6815));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                User user = createUser(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = user.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        user.setUserAccessCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 2:
                        user.setMultiFactorAuthEnabled(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 3:
                        user.setGenTempOneTimePassword(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 4:
                        user.setAllowMultipleLogin(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 5:
                        user.setIsLocked(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 6:
                        user.setIsDeleted(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 7:
                        user.setChangePasswordNextLogin(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 8:
                        user.setPasswordAlgo(contraints.getNegativeValue().toString());
                        validateUser(contraints, user);
                        failureCount++;
                        break;
                    case 9:
                        user.setSessionTimeout(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUser(contraints, user);
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
