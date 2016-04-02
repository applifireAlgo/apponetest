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
import loadcheck.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import loadcheck.app.shared.aaaboundedcontext.authorization.AppMenus;
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
        appmenus.setMenuTreeId("i68O3XzWzS1vTPTzuxvB9OWNcDiQ7qRFqVRijseheZY6mdBjvk");
        appmenus.setAutoSave(true);
        appmenus.setUiType("a25");
        appmenus.setMenuAccessRights(6);
        appmenus.setRefObjectId("CRgU8R18iagO56Oy35iFZe0oXEqXJ3dLhnRIOWa4xW7FhEZLa6");
        appmenus.setAppType(2);
        appmenus.setMenuLabel("iWIjqWoxWbMzy1UZY4JlsyleUlZ5p864odYGT2jd9704owrQPP");
        appmenus.setMenuHead(true);
        appmenus.setAppId("ryLTuBo9phKJh9ysye2ek4KAsOC9WFu4zhEFWexZzVNZv8GxEV");
        appmenus.setMenuAction("OGMRhtu6gCLNT9nxCrbYENUXuDhzTC6gFYalFf0UbSGjDyjEKC");
        appmenus.setMenuCommands("G2QRAMCL1zLu4J4wrDjjGLlaD8GIY3T6ZnH2pCAzZtabUGDuPB");
        appmenus.setMenuIcon("AsIvLoFCyu8xIfIqbLyXM4zO8nlcOIqILLz4DlSVdOXGIa6MLE");
        appmenus.setMenuDisplay(true);
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
            appmenus.setMenuTreeId("B9RlCUhNWpI2gAwrBkLDMcxSKtlEmpNUuA4XLXrY9Q4fssIJED");
            appmenus.setUiType("wq0");
            appmenus.setMenuAccessRights(1);
            appmenus.setRefObjectId("mmLX9exkukr0OkWnoGQWraT6XR335GET8z5seS3nf51NPYkk6L");
            appmenus.setAppType(1);
            appmenus.setMenuLabel("3RmBLEKnqCFK9H6UGB2tf0hLfpL9NregOoFC0XeIzepURpV1Bm");
            appmenus.setVersionId(1);
            appmenus.setAppId("rUeiWhPXDm9Y1tRWU8S8qqRDskh40jJXVLM8ZfgrrDkEVxMcnY");
            appmenus.setMenuAction("V6zaKtyjeDu9AwqQKYsYlBct5KE4wcffOmFQoubnQSVfI8GFrQ");
            appmenus.setMenuCommands("R6cRYt0GDHk7AJgqF0ngmVhotAzeQyLvZDhAGPUwfGsGhDCW5Q");
            appmenus.setMenuIcon("H4zLO45UyH5w0YlJq0MaQcPlKUqAMTQ4dBZwGsiJgU7dr20U8n");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "l8uoj2tRXbK24NH7VBMd5tvK98FGp9TAIP4wwqh7bDb6afMAV880l7VQbqduluZX30b6itLsCme4am4KWkUkQbhbToxPTVUzYsQ1JSjzzHhk9wXnfKNXMjm2EHP8PGW6DBFioNDsHxiFbPkCU1UtKFyHkrMtvWdsmZf5xievInbiLGvVXgP5lLfI6B9NMVId3kP9wIt57yGDg3btVyrWeS9SSYeC4Ez7gHhMIzywReTH5arAV0MXVmZF2V3fYsqFt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "7dXGDbesqztXRZ61sIv97CwwbDBkBAImMKp5qrESXjlZu3Wp1r4gfEB6b3WTF1kG8dKgKkk9kPEKPx5nEhd54fa658iZPdRSFKXJVt23Exb5GEwefihySovAiUdTfybEIopeLg5TtMurGW0Ib2iCmva2JBBenCoPKKdwVpzQaT6oVUGUoNnWyKWtO0WLNzFp3uIJrlqS5HeNdjVw2hprYpWDtkbuP1etrU8HdaiQCoqCpa4j15y66MwpRpivnFcjh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "1xfpTwv9yH4BIM5RxpGuNodCEXUOSRuRcgLzrQhwgyRHW4ajcFslyGol8xVwHh64laQM0EN0rfmtqtqRrYHxxWO1VjHnd4xdZaXQW9T9592TegDiETu8m3ckhjf45mturBRhzRjUtJYb5mPF9jHUNHRVpe0yteSUlJaBesNadJ0hWFyXnyHzants25HREXAIjx8aNlFtDa2Mv5Y7hR8ngVdJsZHuWLJz8oslRAOGF5tAaxBZDJNXnrGLJoqVRavMV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "QfelDiZz5en5pLaoNoDnqw10Q3A4Om24XiDonIiz7QlXMw9zXMPZgj90RvL39r2Fw"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "QIv07cH9Kqr08VCmpdYtAgtaLdVYMIzP7Hh0DSF3CXR3CpHdqjonQXS534MDaTTK3dM4z8HqCW15spxQJK7CLzOHwyunDkdDlEGYXly5R3ie94vw9ellJJt4mtHeEPoyKmYAfWwvqOKNR4rot1PTE6Ljsx52hxF97llNpYUfaPhxxByIE1WoXkXzr9VktqwsaVttQ4dPddhydVnnNEy0AOC0aJyMDMMd400MKhDea20MPIEwTR5zeZ91uhNwhux6D"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "hU8q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "pAtA6MjrHhD5q0PtqUnhddI9jJRJ0wJWPtEWPnXAw97GNQVQIdVzVinvFcgfjbihe1hKpWfdCVzz2dgB5RjvjAZJ6ouZQTGt5whm1WNCUBU8fxHgkxizTCOXKHFDVqHkbveHfsOx0NQgDWArYJjDwCtPiqdiLf30612AnhEJFyJp6FvKoRqaeYaf5kVZ4JU1ZUrsB017wNcqQZM7tcgC3G5rXdG5Q2y1EwrQbBItK7F7duayT7QwUbyo0VYFJ6MI3"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "GuBzAEaU8Ctx6G5ZbGlBqQra2WRLFz20tqyyMCJF0zFMgVOHShSbnmiCEdc72ypF5xRwKTIGsWi8xjRp6K54FMkx9aaRkn5TdvmL8A8P5n641WYREbqQs65xUwcSfSAWNqyzQgHVomzOMIitj5kTGIOmEdrXDXB8DGnAL2a9BPSwgthCpdQcsO3Ld7S3Upcr3Fq1ttBIYYUdK0CGzx73BkFUhjP8dTeCx9DaQeldABVZbWjMcIc3JNI6DQx7RqRnV"));
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
