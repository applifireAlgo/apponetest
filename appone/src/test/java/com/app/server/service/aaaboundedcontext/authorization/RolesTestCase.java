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
import com.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
<<<<<<< HEAD
        roles.setRoleHelp("HvFOxYMovGNMCqdtF05MYBhUj40EIH7mq6wkut7gQiNjRKKzJ8");
        roles.setRoleIcon("REReylp6cqvfp46jLLN1rKkn3a7H87GcARALI5fxO7qKA1etfp");
        roles.setRoleDescription("zGZOyHheLg4Xw09pBiL7P9uSiHWtIBsYxuNngC1Bk5KnPMcuf8");
        roles.setRoleName("TN0YOAd2O54lmaHkT2UzIKBCT19VWQVwhUPt7gufxxQjoPylTL");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAction("MzkXZiMHeCxwmFyw8WMxGwdciKShgfWmiItGBYsRF78SKcZ4Sk");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("keRn5Blq5dGNzvdg7V9BBntzaJfQP1cDBEQrSAi4fvtuG9sOlm");
        appmenus.setAppType(1);
        appmenus.setMenuIcon("tmBqKBxk6rGJ4rpQ9DN8waKCTwFOs4qumm2RmXh6bDKNDkpHsd");
        appmenus.setAppId("iKO5hkoM03bkAP032ysVPqFjwfaIa4RPE6FS3wzQaoyyc8hOHD");
        appmenus.setMenuTreeId("aAZDTAslvYBYuW5ieRH4J0WOErBOjN8ubx9VvCoQSD69JOruXz");
        appmenus.setMenuAccessRights(1);
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("b1H7rtcd040CZnqENMrlZuhiuFkpk4RpFWPO3535VW3xzgTfax");
        appmenus.setUiType("87B");
        appmenus.setMenuCommands("wbEWfSoiqHzrMkjEMHF7KI56F5P3Iwx2wFLMrdXqqSVkqa0OKn");
        appmenus.setMenuHead(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsWrite(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleHelp("gS1f3FLxw4kFeauTfDWvOiIkKS6MvuyIVziTOF5idvZM8boi2P");
            roles.setRoleIcon("CsrxMXHPiktAfwfYzHnTHOXivTDuywrjmccuS3txSIdLB0OQ3V");
            roles.setRoleDescription("soijKBUNiw4ueVqVepatNJRot4dvEpQGjCq02vLupspKbXOmbD");
            roles.setVersionId(1);
            roles.setRoleName("qMDRIU8t3k8OnLVj0EANO6Y7nbZRfXnVu3pAM6R4ekTg307Zt6");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "1vtFIc9PhbzcTz57lpaUYumDZmVqK3SuFewREGXvPkh3VP6OqUClfxaaM3wJB5PyqcRWTyyshg3W44i9dmtcNiwEHMrB8BWtAr6BG3GhPySjB0rMCOMhE8g05aqewBdcd0CmbhlZLFscU3VUKfgC9x4fIE7bI4dCC41XKYZchlqQmGiTtnfnBrOoQhpWWHqwCG23UaCDDtUPe9R9fxJpereYCe5TIvsYTo3oHTohZCUKsLkLWQd2m1Yt7L02riytp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "1XmuIzjKMHkwW2EMMUWE9zixgCB4lUcYIPFNawsBUB4YMQcbQlD1gNMlecOHzxgaDIZ83AoXdu8zYCSuHeN3YZEcJiDcMcQjtPIIFrgoWUpbYPBq140GdtbszjVN5no6DRA4wS9mH750mqImBW4PrQTPIX6lBU917LIuw1iVqG1gWbmOmjUYgYpyBjmhFRfHCHcK4uaqsPU7vOwsExBjnsywtv05fQ4DJ9Crb3lslae9zRmRo2kjl5rrvT0ztDmhw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "SnbGjkMt6qDuyxNJzHCuTxevaNL0UvwCgepPsg5s6nbdTK1KYhNSQyMaT1Ykb8rQ7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "3Ppdkvdb1lYIscH9SNbGtdJ9rndCJSD2Rfbw5EfBME9CWIaiOGrFD5AHouNrzpFRCyj1FYh1t6KK6EH3BQb7HfUdO8aSZBN9v6xppuPm1te0BcpHBvcQqgaNgdmOOGoNeQukoLOpmpGnCpWEIwjcoKOKpTdrazEm6Fqv10NCTqKcSLkSZS0v663x7dOskT8j4HjyLVazQc6HGRE68vZwkdS1QVqBGG9VK4VR2oGP0dGb1ev55rou8LpOBKC5ktbLs"));
=======
        roles.setRoleHelp("oe7KIuXIlvDLH3Z91Pd7HOHDEu3vWsvwHlOpG45qHAySxuf1MA");
        roles.setRoleIcon("qLmN7auBQjVK1A6tyC9yplDSADXdOyjJgmNxTmavHRRqbyUPZT");
        roles.setRoleDescription("R6pvInHz4M3atdVz0yQ9m3PrGjekrZxLYczRXQL8Qm8vUexxNs");
        roles.setRoleName("nmR665QalZuS6hfSvcCO3emYKjl0yHom76s73WwLZI8yg35WMG");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAction("iMJ5jEia7Qw931KDLbDflxRjrdOZ8gl3CCn5ctrKjDIWPrtgtw");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("okNBXMqWeOCEgwo474116CawWeeTqC1t0dq78ActCKJiBMXxn1");
        appmenus.setAppType(1);
        appmenus.setMenuIcon("ugtHk7KBh6LlFqwAmWBoF2yq9PvB80lw7j1nBDTxgg6douTU7E");
        appmenus.setAppId("J0qmwUHDi3BCsXp05acsmJzQFp3f3gQPwRQEFM27F1Xi8gnquP");
        appmenus.setMenuTreeId("2LL2ZwzM7sVeEP1Ub8HbY7RcjwP6wdxdAqb2BNy2K9vE32ctWV");
        appmenus.setMenuAccessRights(5);
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("wNFaGXsi3okb5TjUEGE3LBW2GT72D00r0ptKjIafSUiUnnXEke");
        appmenus.setUiType("x5H");
        appmenus.setMenuCommands("cXEU6y5wsPrdFszipxSr7veDXLvGEtTWcYfsRk9aKoC1Jltb5J");
        appmenus.setMenuHead(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsWrite(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleHelp("MOJR1YOlcuPFFHQH5DAGCPVSFvzge9FPdZiyXzNaE77SDwQMhH");
            roles.setRoleIcon("jqIUJiyjtZ2vER6aJGFMcX8qD5RXwIcgb41Rsu8DIBTvi3nL0x");
            roles.setRoleDescription("t6zE5c7eZnl24V1zTJRIMeRSx8XKZJYkY0zRIY3hplIfHCnRFn");
            roles.setVersionId(1);
            roles.setRoleName("C651RyadSTy0KRKNJuqy5ulLLmc3TuJn2nZEvKQFODzB7HBkw7");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "w9jdtIgJx6SDqCm7qStI9V1lxtei2Eivopo6o95iKbq0g5WaHpzyqwlnPJm4jMZtNYLNWL2iCsx509Ther0tcCJdK4TEPS8aRyrpsfXQXrLFSNsdjFsbXySoxWDGvXubpoGCQsnxon4Eg5LRojr26zEaDe0K7yAax0LcZCJSbo48IUQ8V6IZJsk1dqKEhO6nENxyfQ8pQgoqtrW0D7T40sBfwHbMzGgkBObsnr0LkAE463ykSquB7lFH87lLbE2l5"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "kqeUeDRXxeA6FU0Wp7ntC6y8HfshbNuWk5Xk2pR5xIsQkzhgfeACcj52Gld5iINaWHjTDxwr1hdcnPgSMDKjQbwxSL4Pow9UJjGxsMXATaiGe8H12mtKfk6LBE9dCAsHJ45kHtKbgdGk6g6Bf6KB9RWnhuWcK2I1kK2mGWKLYxxxABjd1iLGz1Erc9Ad9umaKylhh7wG4MQk61e7WBCMTGnpR6OMAyVP8IZLoqKnpyeVrsA4PWobVEaSSwpc4VQlu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "acmwxjgZGlFhaUzuQlcPOfCbsNfeMJXMhIDFusWa0z4yDp1ZHJp3DDx9d64aSNBSU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "XVwK5AFbEseGd1i25miB1MkROHj3rqQTYi4EdpXnEcdBj6vzvSu8NibamvkjNgbYNxJgp7M8qykPuXhITX2JuSFIFUMOEGNs0UE8Bl7Ff7nJ9FMYegHDnD250uSMJMad2B2JOU5vz35nSZit021b9HEolPHdBnKFD1U2d7oWrU9r1fJCB9RJgxCnkbYqcSvJUAvSJ5fcakoiK3D8vmwrD93spMljEgd0dpW1APy4PNX1lycrLsfC5i1agAb5oYG8c"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
