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
        useraccesslevel.setLevelName("0TtcBwPtF37yaseFPobQrwMa82jhPXMHqT6IXbUxKFVaMBoxQF");
        useraccesslevel.setLevelHelp("j9SaM1pSe5ACNVMdKIS2NbbmUfL9EEMURV1JLaH09pBnwHqohZ");
        useraccesslevel.setLevelDescription("5cuRYFVGsSNuNPf8fJLNmJ1gZ8jJbedr1DkgQTRnlyZbH0eBRS");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("mnjTKiSrgtnZrzrjJOPXF2SnGmIQ84qeIwITtF1QMkGY0GK0WV");
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
            useraccesslevel.setLevelName("YDXUExRPYr5ojnQCjEOLlLFDwWCtjUvj843sWzx0DYpWLvpwWK");
            useraccesslevel.setLevelHelp("4t3FVlRxHWqTkRHjy0xvuO9uiGOw7KPWyv0CYiRrxrCqjJXjFb");
            useraccesslevel.setLevelDescription("zTmdAegHcLASkcLPnaY4ggUE7dC7Wppc7ZkxErjc9sEFFOwm1S");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setUserAccessLevel(63396);
            useraccesslevel.setLevelIcon("HvJLecg0D0MSYOZjtnqJPmbpSrmzjbfRwugNgFh1YCR4USlSRb");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 117519));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "OjmJhPBGZ0clAvjyOk1lXmX4pWe8ooq1xzdqgzbReJRH15wUncptxScQ5pmgUMxcrfeSbpMSRT5TP70WqWE0qn1eexFJrFGEfJmVlMHBgvcRUz5UN4MxzDweeDeqwcdl32COZcDDgmtGXoT0hXDSjYskCdH0wBlQ6y0KT228dLvP6afyd8NOPMXVTclcs1xdNnCZwoamG7svaQI3lJJQ00vInwGGriFGUVRotNxd1ucd5RUMSZh6ZCv1nLxn0bHlP"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "yyS7KQVv7EFeqNChLGxf61NTI1YkRHEGfbBAtC5C5pUcosfqWjmjIXXNX2Fv44Y3Sl6sWT2rr5DkXUjPpGaE2DyldebAXniSaH8ooDmtmtKxAtGLtsJ5N72bKsaBDwq5EhYHCXr2fus8llvfMSwgxhfv7dTHY7cMnCGuMk5ikOwgCxXfduH8sdZhFjZoahI5YqmEjm4HIROoB3X1JYBC4WpJINkd6z6bvZKeaTpTiu1Z2bvrlvdLJJtLtnIsdbXRT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "x5FISdzh5NUthHZj8YFEkEN6ICiSQNKFnVoEFqi6SL51J01qhF2txCu3OLAt9AGmiwDNvMXF6BZ4ArCCuIlefEPISwtuYzP9NBcPqwFsGijiElCFQr2siVWEZa7AJ4ZL9srmq0l0iquhJWHDfKHyeVEriUbrhe1sD02RcN0Aj0mbqK1ggtE04LfH5pZTIP73r7CfpDr4cEmldDnkGgvQnH8dh4ogkJ02sAd7yNFGt3uNKNZzsSPjA2aOLI2yCGLHh"));
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
