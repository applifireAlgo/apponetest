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
import loadcheck.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import loadcheck.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("syZfwNsj4yozAucWsjOI16fDRuyL2ux2pdFMBruMed1BSVtv5g");
        useraccessdomain.setDomainHelp("Kuo3RmlcOlSfpexhgvcTvwnsIMJYESj0xckOCjl8CX6Fe0m6ma");
        useraccessdomain.setDomainIcon("u9ah0NUglxar6KA37mcaRqHyOdWq0Ycqj41FAZ4EtJZiayg7n7");
        useraccessdomain.setDomainDescription("NjzBunAQdm5zrtg97Iupng9AZCSKoJcK79JKv4ibnPevCS8yA4");
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
            useraccessdomain.setUserAccessDomain(99124);
            useraccessdomain.setDomainName("WNutJj0WWm6YSrl74XlnVSIAKA4I35vByQcyx4aSs5vWHTnB93");
            useraccessdomain.setDomainHelp("XghzBcdmPdjTLdWhgXXo0MPJu3Tu9WlYKooHmW1Uq2TLg23SSQ");
            useraccessdomain.setDomainIcon("74AN1FPaCj3u8RHch0c8yhasPS849cRUR9GLFLwASF55WiyTpG");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainDescription("ogKtIZzSqNEdUkxKIU51IlZVrelAqn9ihwux5hemh77V9t9M43");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 185278));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "WkrAfAOSahMkyYuWouiDFi3RW4btRGJx5Ie1rlELCtdSKvdzQ280mrndD7OEvdjk3wWgtjLRQKqXbcfJH0pOctvvGGz3PKI42ZxtfmlpWYofkgCytOs28ZSwWoEjBjcQop6UYvs5IlQ3GPXnGWassAC8MXToH5NIkZb5B8Xbsnc1IXwFxMp61DUhr6ZCcw2WGiCUAWy06GhiFPkIao8agP1N7hgZ4JTBOgf3O2Dh1gMdPou2bKNA41ToqDjxxknel"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "ZC82pY6atFMPDCqrW6KmYOi6i08KcHBsD0ANzR33X5ISBA2gKhtwfpugG3PU5WiEatv85N3ebFPM288oAy0CT6iN9xhbCTu2wSUnEMmHBy1WUyxbak03APUiUy2Cdk3FzYIIVFwyO9cdqf2Q0ptaqidnF306p4UCCSnkBbykKZiFrxj2goZku7FibIt0ZnDCyzXbRbrzArpJSeyO7QR2QsoveGhb4NC3vjblWLfRMhFCvoaGXqzg8lL0fiuHFFVd4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "GgXmAEVAGePqH9LfNcE5Sg1p77UDkkwAeRSitOOPeEtnBJyUWPIxPqIkMuIQBtvI8lJ0YETZkxiGJhyUZSIobFX7UeyVeKe05Tow4R0jXH8fTFgpf858D92t0uTSLbvE5HPUZb1trPNwQ77mc2sAvSrJSND3sb0J2UvSpOoi0c6B1WLIpkHQoGmyGHTjdYcxn1BNJV7B3gE7ps258miqtkvdBPCIGuvs7S27YuyZJocaTlKSQLuGIbcmaqGxgFmZ0"));
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
