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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelIcon("L87MwRp3j872LFDYuCJSmIQQJ0okkWKKGfWbO05fvOUxJZtRML");
        useraccesslevel.setLevelDescription("Z1sPtBFBdaxJs3n0KGq5AiZtgfBZYKTsXunETNrDP4c4fF2Sga");
        useraccesslevel.setLevelName("2R2YZZIhBj0KjvyfCnhSB4bc0Ps75y3rlH5oW08U220MH2XCVa");
        useraccesslevel.setLevelHelp("y1wyIF3BNirEL56DYNic6qelLohNgL13Fftvir2TIT3dSDHISD");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelIcon("qH2jKCpAkRMT3B6jO9LI125KsvRp7lAzUHsvqhkZkCRqR054Z3");
            useraccesslevel.setLevelDescription("IDLBoWDpKTPOKcFnc5Ha3H2UvarZHIjrwu617KUyiILMeXSHZp");
            useraccesslevel.setLevelName("TsJMxYdYzrFRWZ9HnGP2j8tQBZissrdxZIwm0965FhDW28T5UJ");
            useraccesslevel.setLevelHelp("TK1SLj5gtRhOkqoQjAK1Y597YL8R6mpqXZOFbGxXJYZaN0a4Rr");
            useraccesslevel.setUserAccessLevel(36369);
            useraccesslevel.setVersionId(1);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 180837));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "WBBVjsUCEerm0jrTNrytWMgc3x4jthIUtJoyJOClRejrlcN6Cg8uL8Yh8LByfLCzmuRj5t55XTaGYfFeKjvgO32pqoeBwCY1WgMoUwOhfwStLlL1xvoDCu65Dsvcevf1Go6ZQGEULRsEqQW3WCb3WdYYU7sODgvRhBAUglXG2fuKNc1KIP3f0rJGC4x3qeVkUhMwc0li7b4V9jSyEmGRzZMkmhI1kVubaQopRsS37hH3y49tbGMDNZCTGu5IxG2cN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "xwpjUP9hrKrZdrruXuBqWsA5hwJqAxiSTpPSjsTwxNnYhvEiuMUpPN63WDwZjMed8cn7WMCr1U9QLyXcYVC8Z0rt6nXDAYBC3PVg3IYpsUqdkgUL7w1yLYAFbaLejLlYf8hQhOqxqKYkgJxoLP619nfkzSg1IJKFseUXny3EHivSkUTE9AxfQyFV4wkMHz817KfvCr8zgyFVYQfPqDKEc5NHbHAZcWSfYaPMTCdqTXZ0sR71Onyc9TJdyRwIq78cC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "wv5NjrDP0Hc3RLMIaPG42adbgXilQuMdvRzKsRUAODWTA348YmOkrnfOkguksuzQpxfuF4Rx3MBYP5IvAZ1itfVgRnjsUKj5su02V6T9V4DNtO8zydoBuB9SC6SoL9LYuI9DPeZ4sONWrSLUIKmAbaOPCWTNFod7qbgDlSVaWPGXUSVpCaml5hosMLY5TEfd1k2m4zWCAjOd9DG8r8Lz2sDwOgdQUB5WSdKmgGoSHcsjAC2NqWGlluJCGZYoDwXGW"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
