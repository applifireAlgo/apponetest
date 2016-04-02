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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("M9tgMXS37fmRD2CnYVPr1EmpS7OJuhvkpiAxF47d0xElKEuc3m");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("0E4gjaIMZMu7qYDetC7bAwZCg1NPsohkQyMRq4nVZPPSOGBI8r");
        useraccessdomain.setDomainName("IARVLbtcao7C71QlPK1ENIVu1FrkUyIrGYVJ5sJbhUWmIC6c7r");
        useraccessdomain.setDomainDescription("cjvmMxw5CHGUEQlClSuO2USDxEfatliflVJk1feb5Qqe4ebwti");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainIcon("fecJfuSHHGhVbBD7IW2Pjwe0LQMEqF5uXWMH6waqNnyYyuvO86");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setUserAccessDomain(33566);
            useraccessdomain.setDomainHelp("V8lUNimrrC1ug8b6PLHrySO7HWeTaDHfWD8AaQXhfeQW7krpBF");
            useraccessdomain.setDomainName("g2zI8H4rLWpCqpVXw9F0lmqSk8uKG3a85ndQFRYl9cKWF6mHo0");
            useraccessdomain.setDomainDescription("HHyCRBXrgC2ud7JMQ0EVsdlTZyagDob818R5Jc2k0IGYz14Om5");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 186199));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "P0UebTQow5d0dlcy1Iuu1Nm8OjgCDECweqmgigczy3GD5S6Ale07mvxK7rsm4oksx4qNtokGsSeFHmbym5WGNZxQfHldGGgElddhAqTVoTs2EWTJwTC6h8aqj3UwR8UGEC4Ydgxv3gAdkb1Cx8L15HYcBnOLeRX38kjnqPifxTyUCpg1C9RzbCFtSTxui6R8kPQILIfF6OuHQhR6tKqTxCZ7dpJcrTFbX4AoipR2JjszWCnY04LK0GbaDmNTp6rTU"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "HRF3Vz3W7YYyDCHkpl0pla5XqYRsSneSgNHf7ZjUK8dGHeNVLa7k8g5018hQJlNGnZ5JIvgz8d6ys3EIdOtTlz6p15vfdmzZjkPfTkb8NMla1YS6iQsKlNVbydrTJ6Icow7IzVJPoqMSPmZM6y8qpSfZDLooZZKi9jTrVQq3jqBcn27QszN1EmLTsyg2m1YfNgPwrrdlxHyo2AuAmPuMjcQAJUZeOpUs99I4AzbALl9NNqaVpUjPeJ2wOF3LGeyNu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "Rmyjj6nr8s0eEXOH4FKQd48NAuB8i8wf4qshSoDYzOJcr00QxERRoIPpbXuBp0O5vOsmuCmPEjes7xpW3iD4ajqZH3Aa6P03UuCtD9IyAfwNPJN7m5ugwMs84fFOYNEa5hZm0QZnpLyH7okH69Q5pid3iboEU3bGPXWTYB5EfEUpc07CacqRLrvWDtUHTAhhIaiHlBGX8YxaTskaJG8MUVhtxPJN4VhMukmpI8AD9LHGh0xBxzts9DXOJ1gErDIVw"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
