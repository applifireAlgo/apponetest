package loadcheck.app.server.service.aaaboundedcontext.authorization;
import loadcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import loadcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import loadcheck.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import loadcheck.app.shared.aaaboundedcontext.authorization.Roles;
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
import loadcheck.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import loadcheck.app.shared.aaaboundedcontext.authorization.AppMenus;
import loadcheck.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
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
        roles.setRoleIcon("c7vgPiyfmr7GHOWvUn8HDnMXv92XTqoJuQyAFegdbmb9pFjsIu");
        roles.setRoleHelp("zOL7ngOEoyAjb4sKYxP3yO6poBh2jlfSn5zKBFarSxeX3OjP3x");
        roles.setRoleDescription("q1H5e1M1O1UfN7uMGKth2W6f1OBph8P9OQ6w5onVGULlPmAuNi");
        roles.setRoleName("sLotiJbcq6jKhy2RzIZ2D9WsWSVXu3F3ay2OFJTpMPjsbG55d1");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuTreeId("N0T5FElnNaVsoZsIXMTPFPORBZJCs0dCqoZ90mkMOjIrhSVmrG");
        appmenus.setAutoSave(true);
        appmenus.setUiType("Kxe");
        appmenus.setMenuAccessRights(10);
        appmenus.setRefObjectId("sD5w0Ej8Nd66x8lW0ymB6lWBF8AA4dLPJJucWE5Bzyay4SnzrY");
        appmenus.setAppType(2);
        appmenus.setMenuLabel("FSLIjtxRbqOWVzp5z7QdicWXjk4d5AKz8os5KMIb91bJVJ4O1l");
        appmenus.setMenuHead(true);
        appmenus.setAppId("zb4oqeg36y7KCFJpypdodhxR8rUxerXYzdT0gY8XLfI8DdV7eP");
        appmenus.setMenuAction("ya1T9WVOQuvn44pC33DOljRqLvX8iXRAFbwU0nQ8GaLgDFHOE6");
        appmenus.setMenuCommands("3c7gUrSMHSSfoaKiG3sOv26tKKwGlvFPIb5wAYMDeOm2yHo2eq");
        appmenus.setMenuIcon("apPITVl4uxQ7zZZO771S9pz7ivpTL8TMh6VUhknpLMTCGZbzJa");
        appmenus.setMenuDisplay(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
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
            roles.setVersionId(1);
            roles.setRoleIcon("BOHFan4pGmIExge2PqfzWsovWPrNVrYQyA6JBtbR5VJJzfOfRR");
            roles.setRoleHelp("FssMLi3mWXfTupzsRcPywPy7ou3xc9GbKdIxTSzVQoTbW2S28y");
            roles.setRoleDescription("sIXWyMYMiaZagAgQh1wPUpjGLclvVUI27gQaFeFMfMLWZl1mEj");
            roles.setRoleName("A7SwWKnvWdtzVQJH21Ar10o2h8fEDzNE80e4pDzzBM5fzqkb3p");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "sV8H72vBWziieBIsTcADuscp7COxBNnR5JNmlsIl8NqawX0IFUxVGwM79rtxm0D3BHpKVbHjt6be62Zi4iiv6Vm4x4a3AH5LstGMnOEv9eEBOJEYQztxvUXAg4Qpp8iTp8wN2UWw4k1MOFXI4NU2bhWsz5P7oZLnEOtFMJT2MkX1Bkky3QbjwevO8TF4cORyxDvZqWhGlGWZOfW5l4MMlkiAbKCcVc6DqAlixu1joa6dcLj3ww3rtuaWZMd0y7JOf"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "B20ndyYRDOJN2ba5feIbfi68ua4b98ayKcsCUxKWKgqjJnudSKPdshU6NyNGNoMmyQapsnTSYJmH5zrcbVOPXhmapEsISqe7HsH961WeLKzcaOz0Syc6P5zPssjK98DX5bnGsYfCgJyj7aDNDJ73xGf8y4l5DocBNzMnGBW0eWiQlWlg1ZMQjpGqh0fvgF91nzHXHHJaDvBdekPCLIAt7ElVYC2yjnshtPU4LV4HbUU8RjF76YwUsN7NxcNGEilLg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "tAESgCgKbEsHSlxObhXetaoXeffql6LKN5esSB7aawWsE0P3KuCVdJ2S8mHk2iZdh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "01iUhmENLF3aimPUnSHGkOW0t9kOfsfN0RBAiCLI02hP50MbToyZ0cs5OFF7jMp9dRUx6Q1wsflQbRNlbwAdNUkStWaUC7LdEATFKQCCdA3Uc3mzreJpgXc5qj27hP75iGvhM6SaghkalB5S9ZvZYASvwuVDI92pqxlWuejJSDvWOIXg8iwn3teHUmQFKgaHzcehqfMtTFo5geowsUionkThRrsso0v93iWPuMhaxwkRiLrtwJHqV1m0IHZJcAOeD"));
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
