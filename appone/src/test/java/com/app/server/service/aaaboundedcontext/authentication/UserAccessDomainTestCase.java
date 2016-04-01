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
        useraccessdomain.setDomainDescription("2yzW0tOTpICbG8Ix7ZULxqKEN6VG8wzWpyuQjyNUCNI6fjhLus");
        useraccessdomain.setDomainName("ooAxxyTLeN4ozJuypPAGStEGTN2eryo0gix6FMfVLJg4eFszGY");
        useraccessdomain.setDomainIcon("WD8nYYA4G9y5xzHtT1jyPOt6YO6pPmyB7MIHo8rvKGOgQMBjZ7");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("REIxsuZssbKUdrq0R9FZCQPtavlS4YO07pwmQolb2zrYupnVkT");
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
            useraccessdomain.setDomainDescription("nyMrAlX47a907YIF9kxhOrU2VZGrTsj3YBW4uwJfgLlmhFZSzW");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("dkrGVbmjbY43qPaD2dg08JtedTnZkJCIAkKkARF1IDFVQu9xYr");
            useraccessdomain.setDomainIcon("ElqYrkJhXnpIeVHNFRvP0oy9vSw6HOTB5ZUTUFPHhsC3vYcE1T");
            useraccessdomain.setUserAccessDomain(1220);
            useraccessdomain.setDomainHelp("S6NeD7zVEZide3POVO5uWvYmc3xaIk7SMLeCNtWdCmGwnozH5F");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 162508));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "RWPgAkGG2Ysp2x4vJ5jV38aHVQNclg11Ifz9QBkqYpwRluwXQUbUhO3LxShKsFf0aCyLIT6oLSBxJhGlHKmVpgQYV1PzC6b2t5uDH1agj11THDXFI0xDqED29u5Uw3CLbia1frpQ1lqh1vf397agZmKYURSJID8lbSoDxCQwrfcvTFW7GPcPfYsN8LPVxGQP4qpEWFB7yh9diiDnL1Rha4bkmFkRQCoUWEeptLWKnwrBC2wjTgIKbqxOUsw3c3UwS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "YVHrSaaUy71ZiNc6JE1SCwYfDLe2nxtMk17dRuzm221Y8mOZV3189ozuYWN5BmDXpEhAEE1GatLxjfHpaVNrx9Vjw4GM5zmzgpOVh6uScyVrsoCEVVbe49eI0RehLObD9xd7wgzUD7rHpODt3mc6h5bnzSgGNm4Bw6OYxJNEvZNS87E3BCdMe8Q6yXesN7rB3wjfHKtMUci3abaggyqZ25idu0jV2Avfx0fc6T4mRbhr9V9bi95Wrl508icb6VCDj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "acPcpuVymjvFlV7u3aZInMpI33eMrup71aOsCSgasoUh4rY3h9ycddKuIgEQ7C8RItgtcewdf3aqT4vMsxjiR1FPbxB6ZyPH91UNxZqd4nHcgcn6L9ef1jQAVwI6XK5wJvC6Rjs2ezysbaGF6JQOd9aBCAvMQ877jKECCdP00f5LPBHAyBZTdS3sFiIP8RAC5vo3VxC64Me1hxTRO670U8BuzjX7NNBYWxGq4MJA961anhtv0CftjZBO2Q2XqbTZZ"));
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
