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
<<<<<<< HEAD
        useraccessdomain.setDomainDescription("MspgVbdyPVEJ2TBtpwxemmR6oU4CxaVxX4bYOjgArE1mUwqS0f");
        useraccessdomain.setDomainName("tkhkqjNXn1RrsTTIpCKV92hGIbn34tNOBC8WWbW0llF1aPXbi5");
        useraccessdomain.setDomainIcon("ECRcLepXYbI6oCzq4IP5Uk4cS8JDCByvNafXuB1mpK6xroByNE");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("BdkS8or8OPwl05yjgjZKPHJCMzX5vNsSdX0NxUXRqB6jMqwYgQ");
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
            useraccessdomain.setDomainDescription("khHHW3HEYIjRvWNkFyr1zxxwcIo2QH7dyNHY9YxSlyA8FTYqmA");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("J2Yy7h3aeehONS85y9UXRDsfHq0P6vhrBeXDDSJda30XWZUtTf");
            useraccessdomain.setDomainIcon("QkXACyaMDObgseEzN82KjGoyQ06LMUEY8l5Z3eznZxIz7qvOr5");
            useraccessdomain.setUserAccessDomain(28992);
            useraccessdomain.setDomainHelp("Ssfxl1n5VdSmqzTeu09GsER9PcqrO7zvRhdbyHu32meUUxwZLy");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 177468));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "AHNdKsD591sh4Otp1El5Tw7WYiAaeyMvrF2TVtLHCDHvcpV49Wk1N6E0gi87cAFFFL2b7MtXxXAHEsG4xcRCwL6mFX7tzD1WqfOZRTDsUYw0OUua3EWj7xfjarujm3AnkLWYaHpmINDrBk7CZLPCuZB79pbtcFO9I3cjPG8mKdpF08oY1HDiwLvo9rJyktUEPZkqtq8pQDfCEfxhLH8qlPW33ePR1uJA3WIYdHXVjh6Zj4U9fGHsafZmFDLUYnpH1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "QUCuxjo1meLTZp3HKpJqXnfokzuxk8RiiFimLguoNqql6i3aWkWqDUCUsWgNtxxi5xNgKwbZOOD0G9Eytllh8yunifm6LnDu1dsEqIaYkpvcs0lmGpx4SnT75u524XxWH0diY8EcbyGfujXEGuPy5vtAgmyegm6r02z1IQZ1rN5uhYkNmOrzjLlITu1o3jKtRKV7dlipFKVwn1Ixnea6ArP9zW3GliFNHoqcXcGcEefSLk8StB3p1aHPkcdZaFIrz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "42FFARfaE3bQ1T4v1RVUhuI9E8RcBXyDLo606KYqaCmPy21U3LGx7c46Q4nipJr0A0rYUOV0Icws9WodvMF0oxX7bITflNYlsHZqUEelISKhlNOLf4eDX5RRafFSGJF94i8rX0Zy7QbCS8DEw4kU4OxrnABY1w6jbo78XTdQYxsKouaHN01ErOsL6PRxyuk1mIKEmpaMH25BWV2x9ElebWLzh12g4ODoFtfodPB2dCNusfU2xfsysABmSOMnOEyO4"));
=======
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
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
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
