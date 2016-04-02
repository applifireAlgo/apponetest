package loadcheck.app.server.service.aaaboundedcontext.authentication;
import loadcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import loadcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import loadcheck.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
        useraccesslevel.setLevelHelp("7ctJhHTl1mRDoHaXUgakhnETWGOHaFR3WEnTD3QZLaJToaGsOF");
        useraccesslevel.setLevelIcon("xB9y1VjWvWSrwtEti28hOYlmB1lzxOGrfws1XeAQ2nzgBW4gHw");
        useraccesslevel.setLevelDescription("N4n9vsim1gbM59n5l9aG9xuZIzJOEXMl5Br7LWK6Y63CmLrPp7");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("D8anU6XFypyJI201RbOv6PQ1dHlA65DimtUukHfzKqNpvOHjly");
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
            useraccesslevel.setLevelHelp("c9LmZSj9W63JapuV745jdSNZdVKU5cRYfjFKmwr4DdsfOE8yqG");
            useraccesslevel.setLevelIcon("w6v6tVQGdSe8XwMrLbvoYBMoEwD4t9bKeKoqXHfmCgplbeP360");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("GFAANfefg3oOy3QMlK9cMH4jVl6wKQ5l0k36N1VqGPBnwRQfUi");
            useraccesslevel.setUserAccessLevel(18197);
            useraccesslevel.setLevelName("RBxZpWG6kPs2VGGcvIfAOe4FDxH3DJQPPHpQV3r5zFjcDpqHU2");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 115374));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "d4JDJzGJbz8qgr79wYD8Fxldlj2ufq9ER77RdJeH4Z8bLcxk8fYc6lwqcPkd0pTChhokDccdgzOvJpUxCDocxVX0bOEsGh2LCC42wb2sETcre3ccY83MvyQ9yo5XdgPosibV2z0yxJ9XI9LyAUp55wUfxVvSKXbxPYvhxXGcldFRG44WYt5SKkmvZTnigSWGCsfEaGSLGxkuM1IlKrArsQtXOU5zhupV3lV8zZQ94RqlE5nEj5WSF1IVRM3yYpmdC"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "1YeA26QFvqDt4Q4YTLC0mvLMTUYiUm77MTOHuXy0hUawX7QTGeIuIj1PQ3lniWPNfpROBZCB5ssqWqFSglmmacTKAw3s87UaERSJiQKWhLc42SMP2qjs74M1vw58PhKUSjxgOOcESccKVffKu89piGSJIueLUt5YMIOjjumVUzPXusTa0x1EWGtUxnIwC9iQKFaIaygdYyA6l8SIOUYjq3GfzuAyUV9V4mobr5gfXjThxwCMmVoprohCioRYBLnDY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "hw6ba9lfwI5pXCLmpav9fnmfBWy3YHCfkBOEYpMsdY03xEMWj0ocbvFeYT8p43M468m93S4qUy6bmgzi014yUg4yRmB1akcLEr9fEqB39vMdAbPhXS7DzKL4nB26WZmMdZIwbvvqLIxbxBHLK7sQ5KuLYHXgXrAttowAORmmVB6HCYPez8ToSuP31FrfMqxnBUYHDT0MX5wikjSRl3jMWKm7xtWWtj08LyXteMdd0f2QNiPRJMu9aHEigotzePZXY"));
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
