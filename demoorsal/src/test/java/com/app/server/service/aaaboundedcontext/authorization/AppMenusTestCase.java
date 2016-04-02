package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuTreeId("8L1wpV2TyGruP0WYsnfGVWklmH9enNP2NQshYPz74gGKftBfRa");
        appmenus.setAppId("XlZUl9GxwYSIjFfYlu6zv4D7yS2RvdIVqvxO2hoOdvj28PabOe");
        appmenus.setMenuAction("waUMWtIHxdoSyl46kWhMTiH0ccer087Ph1EZKySibOy0v2irh8");
        appmenus.setAppType(1);
        appmenus.setMenuIcon("2Dlzd4efpDZiXmjxmeCydFgbvsTTH61z17EHAtuAtRpB4AvWOU");
        appmenus.setRefObjectId("5HJgtNvrXgZFXEnnxAVeMZ3cL17RhbULS3QsRQp3tHDiPIsjea");
        appmenus.setMenuAccessRights(11);
        appmenus.setMenuDisplay(true);
        appmenus.setUiType("ud9");
        appmenus.setMenuLabel("LdkViZU8koTUu0U6uLMLMvH5keYrzYBFEozlzxbdeSX30JoKzZ");
        appmenus.setMenuCommands("tAXb06fldQxKgdVnM0FWsBzKFJ1aY89toU44s34LlKHt3I8veW");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuTreeId("rWTTAsWTaHvoBPfD5H8z1RBb78TVu9pJS0gnGpDOLtGQiMZdYS");
            appmenus.setAppId("9ScJsnwVMyW3XsKvFHqVEajNAGnOnVvoztsnrPUVfKbsE7pt3Q");
            appmenus.setMenuAction("F29cQwPugr1yRwkT4XxpUNKUccR2f3HhI7GRBh3QnR9BQjTSVN");
            appmenus.setAppType(2);
            appmenus.setMenuIcon("ZR88P6oFZUDf2Lmj8cYWN6zQmEBMjvXSz0j3pJwCwVxsEbOGjb");
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("8q6GmAGBcUk5fkOCAB7EHb41oE5rFxlISQLgzmEEkRWrN1ortO");
            appmenus.setMenuAccessRights(7);
            appmenus.setUiType("0x0");
            appmenus.setMenuLabel("9UtYDmAyGkBSPu2VY02ny6BzNPiIdM5AXxJ8YlvQnW1gIX4AKA");
            appmenus.setMenuCommands("OCm7OsC2LbXXz6Pfn0hNqoN1qwpwb2WJNISNZAfrSsCzX1HCKi");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "vjtXCgoqJETSMmjjNfoTgLFdKoIYWe4ykJpfTVMkRE6rhXAhFiLCJVTkqQn3Y0NKokYX36oSmd5Gl6yq5Ct2k36bWQZ157FQ92shXiqPjabIocj2BDgmjL2u9ckVRlDQwHRaUP3k4xUEc92nVWcTWnGmqx78CIPObgxMqrHj2qJFnkfVtIFz2O6tgi5acLLkX8QugWQzu3H1DzYO3hvfDZ0Ym7qSQEqYn0kv6UpCHZpAjGCCmvcRv0JnQFDUiJa8u"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "SPqWRyhg7CLTUuoQFvO81PrtwPVoCbJMEf2yRzO1mm8RdaFeGvJ40CEwYsUIlwtCkS4pzMYDYFMIeDv3D6sEyrqNJ1ECqj5PYwrliY1n7cTt2y9FaxwaYgxHXTWPDgxOU2ClFdBeL4AY5wlzt2JW8Nwqmuats4oChGuYv3gjCgFSjVJWQKb0yb5SRN0ChliglcWHjDQnMldnoP65HGhW7g7AXRPKUFkvZznHrJTI8VRb9QyXk0IAqkY70at9HGlxA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "MBAS5dJAnWl5geFQHvhtyGrqVeP1nT3UfbDISKNTTvhmiEEtu9XS6WI1ddjiMCY0JByXQWd46luov06K4BexW6YLleZel8eOb6v8pveBZ3NjvOmG4moN8Leof4XIJxIoYIbdCzo7g2zsUIllWVDRx1l3ipYLG5yUnYybZf6DTLf82Y5RoBkRZolHtxP9vOyssUlFKNhpIfHxpo3jPlltMPuEUVAQeVT0FaNy56qhtNkFsTRa8U6mLMtuCzsW1JWNP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "HqdjiQiCXgXJ1gpSU1e06Sp99JqUUvI7I0H3KAG7yzIaZS8YO3LjfkN0CrZJzAQsm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "4Qyi4MiWP8Kf3xgYyN3EYoGdS7BNv3dkIWMztnrgq9TLOd1RfOkhY1SHhFfeBVgNuD0OcXG6ZfkSvX3Vzmc2n9fz6LhHN3ocIrf7ytPXMZx2cjDziZ2bgqnVJN28LHaXYi5Q8pOzNIcSaRIaIaCG6gNAgaPfVms2uIydGSjuvOnBEpyvmoSJ0gyabGZiRPVeta5YFFcVHVuLEn1kcu2a5V0EVFSf4eMxHQLjWaLf1Qo4APz9UzfxvYZ4IEyKzoPcc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "SuCm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "7VZY6uUZc688i5KTXApOy37c96DiZIqqVumMvUjHBvl8NCsWMrljVyuN1q9ZxPUiZMT3tKNYkBPeY1av8CftnNFNdtcS8vYDBOtPA6oyxR9NaQcliLVGbQ6w0FhJHCNOgfkBLEPg7hw3eXJ2GJSN8QHvroVA1e2GdOEvFrFmJubOiHRPGFFWUx4r2sN5rw32QHyJWlq1Snfq6yrZjk91lEfSJa7Ak8TIzj2tKfNQs1qBnYlbuSDGRtmZmoNpQziFX"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "RR7QPvGfuXITwoupO8BBLEHLExJDF0oRDdeufI3UgCxKOEDdhPHqHJ1uLPa1wPApIPQSJV8E5AQTepwrKzoyecMm4Q4EYbqflXMPPQfBShBFnf4DrReTCSvdHZ9bfCTWdAJ6zbk69YY2x0yQAOdx7JCmllT2wctTm1W75NnbqgT2iWlafZ3tOgCo1Hpdmj15mxGu8OsWaKvYBHyb2AumDQ9rqEvBR70QadzC33ad8Ju88VJ7Wod28NvySijBnkJ6o"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
