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
<<<<<<< HEAD
        appmenus.setMenuAction("5OTvNp6UjKoouHIq2aMI3LYHJSbWTHKy43Ngm8NVgkv0Rx8WVn");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("QKac9S3UfV7zaiW427LkxMdiDMoOIHt8VdLYpzQi602pt677SB");
        appmenus.setAppType(1);
        appmenus.setMenuIcon("7eX7FcO2nWNiy9ynmr5JuA74LolC7TwFVY4HacRX0dUk2c53Qh");
        appmenus.setAppId("1t9491QjnU7BOKDMLZNxSSd8qwDzhP3BUdeFccLbnEEF5d3YDe");
        appmenus.setMenuTreeId("oTrQHRAtODKH08OVg5256cE5sj92oLhb5IjOxWnZ7mED4OoUdp");
        appmenus.setMenuAccessRights(5);
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("M2h1M9pDii5sTQPfSXKmaXs4WEJ4yMfHNeQZyqqrjcNqL8ZqnB");
        appmenus.setUiType("6ey");
        appmenus.setMenuCommands("VXks4YzJlaxBGcodYzo0OwVGBLLs5PDBKtqNCduSJPTJKinW3s");
        appmenus.setMenuHead(true);
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
            appmenus.setMenuAction("Ogtys2BB5dQakwchi9daK8o1ZA73tmO4VT1SSlwkkchxLbkfZp");
            appmenus.setMenuLabel("Scjsg4GWIZ1Y7Js8WR3z2uSg1rDJIotrRWbxNUXgSMfTPmVBz3");
            appmenus.setAppType(2);
            appmenus.setMenuIcon("CNaMNRGhJgD6evxLx0wKY0qObehKwaXgeVasaSnRfh61FxLXIj");
            appmenus.setAppId("lZuEPmSaagoh4COhEAvAzol3UoEFO4ROQxihRHa7jXzK8Dw65H");
            appmenus.setMenuTreeId("KVBIkbxShB76haUOh9lULKEqNh1FsLCYuXiWoMQJgDHjkPeInb");
            appmenus.setVersionId(1);
            appmenus.setMenuAccessRights(3);
            appmenus.setRefObjectId("r4D34l1yq9mXtRTQ8UTbPf8PLBxBm6U51lNXvslVwIhXhSzYaf");
            appmenus.setUiType("bXw");
            appmenus.setMenuCommands("fazhFbdLxsrRXU478hMl7RKmGQ9R6av9LtmQxCFd3m1BMb5v3i");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "8TMmVcpNpuxeU13VNtanYI0mZz7EewVuU4hbLBiHe8BX5s0VYCrhFzn4DCHkpsqHMx0XPMPMK92vrHzW4MYwN27BMTf2FOqAn54n1vo4fGI4vJMUjNRrPGdhwQl3aUZzJkwjHQiLLN4wCbRl8zDzEyGkQLRzMfIeuylwA7bLtm9toWefTS5o5v9TeVFEQrLLv45lWcGxnnQtM6S8tkMbVgSUqoZ2z32BEMm6mIepCuLl7M6d8wSd7bCtTB1pCeLi8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "rcELvzLSiiWwCqTgCH0QXjfDfS8Iolk5qzcVmZeITbaxU6EBdYtd8BSlqscLt72ptfJXi82sS8qDAFfHmur7Ycg6zgFUWD08bdRhIvPag306F8fmGj2B9FC2y1etbWOOTrAkf7iKplHNlLXKotfZOPCVV3t3awDfoGlX5GpAA02NwGhFQETqlCc7rB5qBRHNrPafdmMunT2h6VN39SE0oEmgtvh5waIhdifXfbYG4fBwbhv2gfZkRCgYhBYaXBTPJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "C2Y7sf28ue9uL6OskRi6zS5QnTywtMm1ZMHcu3kcOW7YrekwC9vI7GBrbkpsltQKLqCZtkIeetOxxVyMFAk4ajmxxFSjd7VJoRCy512pxGLYGgX1P6EateFRa9SRj4202TnOr18Wtqka1xwTuj21ewn4ndYi7qzaLTwFwp4QHWS96YneuEdGDOC4F23e6Q9rDYXekHPwyKbwN6L2bG077T3Owj6GacXfYslVhMpBCC2CuzzbuOm5LUSrsuCYV89Z0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "WupvHXnYP1jqtXi5RwxTaEMsoSgBSvyEp9lX2iFeGJZEbhr5xflVanoqwRMe2lI80"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "ghk5QwgIa281ztpg0TsWI9jePXs9Z7PpujMzWz8CzO0h1VtLeN2ePEQoEJ82hBg8yipKFXaYPmEL71WCMtsXegPp7381B595FX6mTu6pX6riJSpzmCGpxcthKmIUJwwSQcw9sV7Eigmnr3OeZC6LIFsSypv3NUcSG4tvcw7FhGjJth3UGTRT1bCcAjPqQnma0wlb7VxdBVvMgF5sAZL1Wzc5m4COzGUMd8oDJimx9BkNBWVrBujVjNTxl98vYh1ja"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "JTNe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "ziD0RQTu9lraNonYtes1ONhEINNXRfo9b8UY2QmEEpNbkm6d31GnBPvRq9pHZmglcbVmhgW7qI2H9nPdzO3smAHBhyWu6AkyNR6c95d76xGlqNKwaXJpu30ZGOXPHCSjh2e7aTbtRkk8vHNBc4SZzlAjvmHs4AmMcnetZOdxKg1XNMQoiRJl4L1IjquUYSbABhv1abnwvI92uAvYHLcGi0IcRkdLRTVxFU1ApHu2ZUbNCj57LibqMBXl9tui7Eksl"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "lYtoyA71C2rBXqYPxrhh8MhamI94TMZ0GOa4CjzVtF4F91A0jLSTw3an2QBSGFc7RuTjqc8Y0EUt2kfZyfbLNaQXTQzQSY5f28xDKvgklFCBal5fVWgBTUP5tVEQRAUYlsPwJQAyF2IWsTAtuPuPLsqiNIByoPt5al6iN7wut8XPKu4o3LZi53pZEoxyKjKvQKfW8Xtv35fVuqliYDay64PGFZ3CjkRms0c6Lcb213sPtJxaBl6ME2ayeEzDv6QfD"));
=======
        appmenus.setMenuAction("LPv2kmf7nxEUzYf7H78L64A8tGRqWNP0MDjcaONK3t9wLHcJ1E");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("qhBrBcicbXKDDkK679JBr5wI4bTCZcskupdt9IY1rD6rYsmoIS");
        appmenus.setAppType(2);
        appmenus.setMenuIcon("LuifWw5xgpc9CfyZU3TLaT3Eg1ni3oKSSAS6Wfq3YNz0GW8Y4b");
        appmenus.setAppId("matmrfPPf1Y3xQQEQFxBUHIlbvwNTw9euXqHE6hulAsPzS1U2j");
        appmenus.setMenuTreeId("e5N3JKxvUcoGVTjB4WtVja32QAiaPxH4brlEb5ShFdH9SMCfIT");
        appmenus.setMenuAccessRights(1);
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("47ZEz7HWSci2JhJ7PUC74Wdyu8fqAkVA3oMrG6U7clE0rLDvij");
        appmenus.setUiType("hah");
        appmenus.setMenuCommands("w1OCdulUEQVBCoW9GWKg9u84Bq567dDOAkllc8R06mZeDAyah9");
        appmenus.setMenuHead(true);
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
            appmenus.setMenuAction("zgqCiaS0srO2paL5RbiZ0iPIOec29xeZWazF96e5UFRsuDBdWr");
            appmenus.setMenuLabel("rwijHUoKmo2Qm3hDKd8uLovvfX3lXDw4Nj4ePlr8S6QtHPgEtD");
            appmenus.setAppType(2);
            appmenus.setMenuIcon("WwYclwGIAFkO0ozxYRenb82iIw4XqJ9bK1oMGiGpqyTf6jVZpu");
            appmenus.setAppId("MvEIURly0QndysmKaLFfpdXGStgO3BIsOtHCedvMnI1aepFOT3");
            appmenus.setMenuTreeId("a4vgdKelIF1BkMNiuMxb9z2E6aGEs5x6IINjXXfQKBzZq4BlbJ");
            appmenus.setVersionId(1);
            appmenus.setMenuAccessRights(2);
            appmenus.setRefObjectId("mQArK38G41s1gj4HNwfF4tEiq7mfvz83E6po8a2liIyODjpbRP");
            appmenus.setUiType("GsK");
            appmenus.setMenuCommands("tuEnh72ARB67rZMau2NuHFekpLYWWEXdYNKUdK3NilVxZK0Tci");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "CN185vP1vubyt39bt1Jmc65o04uf94RcLwz1Aaqrp0SveywmRClWYoFMv40lmhIIuupdTw4F20nHJSGLAZSAqsnXuAFtpjUsfzcLfOqPmgoPJFP11ZBvK6IltoR44zGwd65B3nAKQffOibeE2lIUJFFOwWwYjdtH1c4k9bRCCw4LEQWX8seCAJZZVpeyqchhFvEikBksa8rfYosYLKzCzdpmM5NDFHhcTHDR2EuYXcSQHXFwl9QKM4F9DxQsvkVxx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "eQ6L8gAkjQL9p2nZJxl6T4zkTTOfgQk0QZmjSZXbc3ziSAyv5DrufEjPlh0bKwvtSTNCn4yw5ufLtI22KAgMa15dWCDBBeuGTG88DKTkWKSpqTFzh8MftwmwmPz0HETHpwAw9AloK935befc2zTYu7cAtEh7M28b7NgxGig0h0TfDUhJh5S9aEhubzYHAd5DiX9pQJJUqAkJJ1z42uF2QOC14w0QoBjRpKwsaxipRxnATG3wVEjEyadxVlUMiYKNa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "a965BEvsNZFWPhEVzP0LjxiPa6SuBYZhfz3iLWiMcwRRVNoLp5GaalPI3onx3FU083ZyI2ttmrozevE11YMgIAAWoUz86r1e7O1ZmCJFNoKxlJ2XLOTVYZ39zOmKgDGBrNefoHKgtwCJ1ynNQhWkYOF1IVJ2qtFRkFWXuhqrQRDrt6Q9g7XOYWv35VlEM3TxakN4T6VAOT1kNH30ygrHDltRoR2IOd1VSH3ZwyMNqNAZTHN4mdRKZzTJbwplZFT1m"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "vwQurq1SPJDOKSHDovaeQKGLHXCzSPcoQ8uIFvejt7ZBD2kOMQNxNmEg5eixWnEWo"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "EID6rwzq4d8A6Vd2SuMMWQZY40ld6ztgHg4hFxlpVYPHQwBLdw6WMGxZkixhvSYor9XkGuVWxPnyxidovHuOyseLB7iWgZjvuw4FOA7N4SFwD7zBMuRFtCXrdkobdQgeFkChPol62Lqxi19nIIsSac3mttfKudZFlzlXxaIG0pYMPNOxCEYTPhsGezmbCtO3xIzJzC6GJSCMn37QzYE70ouOkBc44bocJtnS8qWA3eQ2WXWhtqlAYBJBjdcr84kyX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "NZau"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "TlUtbpxOkZowowM92LIavZgrwuLY9YYdEFVK3trqe6mqdeoIhYYWGLQ7SNvHRL6UEXNgeVd4JsCRvocj8I0xs2TQjcH8nBz1vp5vmoN8Stvfq73oKUao8B51X1fPPNqulhKWZv9NVsyLhMwW3PraqSoW2X2TdUZD8jS8HzDGKt50dZZNeHm7CjkOA23XXcWqyBCDNtMp9tlY3VgKxLjz1L27nkVVjV3PSiLbacoQPayZqKEyWr0Zmc05qJ7KjdqQR"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "uOxMve8mSAqYg7hf2oiZxe7sxXLD8mxnCA4CxRSwhJeDMXt6I961zu2bKaGZ3TKmPA9i3GckZxY80aUIeYNRBoSGYzCFtRj8N50DKWMwa3cVCELEioiJiyfedJxLnhMBp1BImX0Q6ZEqJfxAOGIYdlCqJ5rI7Hkqwzpi4wD3n8dDA7smQ4AvQbzuKLWeI2tL4kldUhAjVncLGjuyiZ65t6F40gAlQJvATA8b7w9Yuu1RmHXYG1o78WM65xBkw83S3"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
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
