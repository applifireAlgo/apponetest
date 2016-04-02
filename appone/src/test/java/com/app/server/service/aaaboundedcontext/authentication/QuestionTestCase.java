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
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.Question;
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
public class QuestionTestCase extends EntityTestCriteria {

    @Autowired
    private QuestionRepository<Question> questionRepository;

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

    private Question createQuestion(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Question question = new Question();
<<<<<<< HEAD
        question.setQuestionDetails("vW2TnJ1IPT");
        question.setQuestion("aGLKcyma8lUFIrktLDVsW0slEnQGFSEtj1PzdkwKyfunJ7kCoX");
        question.setLevelid(6);
        question.setQuestionIcon("9SLzuuMsENxSyJKbhoQgcfu3LEq6fEmMH7IE2EkXu7yYKH6kqL");
        question.setEntityValidator(entityValidator);
        return question;
    }

    @Test
    public void test1Save() {
        try {
            Question question = createQuestion(true);
            question.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            question.isValid();
            questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            Question question = questionRepository.findById((java.lang.String) map.get("QuestionPrimaryKey"));
            question.setQuestionDetails("2ywigIqQ1s");
            question.setQuestion("TYed8oKoLcHSyWEItUdNHzfaEJMJmiqwMk237VPWFtGEYXvvFZ");
            question.setVersionId(1);
            question.setLevelid(2);
            question.setQuestionIcon("PsNPpOafKnAP3gUhzDAtZ9EKt6FDgUwQfH57Iw4Pm3xOJvEcwf");
            question.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            questionRepository.update(question);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            questionRepository.findById((java.lang.String) map.get("QuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateQuestion(EntityTestCriteria contraints, Question question) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            question.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            question.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            question.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            questionRepository.save(question);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "levelid", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "levelid", 13));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "question", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "question", "6nzDuetZnKfOkwQCWZdpqS9rkQnns2f76Msq1bYUFxXX1dQojdHlqLiNslV0NcinfbyMOkZ7kpdtJBEKrH0JKfS4eQJB5UqsBiF0gqdWtEqajPCjHqU5GY5F7xuZ5nAwgyIEla06Tonbpurn5Q0tEX597SB5Zi8NDDNGObMS55VzUycZapvKJT7JJGhSISBIh1kFEHmJ4XeVzQN8EjnwXdFR5LLtNqK2vJMLzfVk7nClqfRYaTyJLywrKaQbe6L0Q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "questionDetails", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "questionIcon", "vowGurbP7R7Rc0OOjsTSaRGiAe6CxwfWIsXX4fzL1jj6kCR74yBsWy2E8kSUxgRdD"));
=======
        question.setQuestionDetails("awX5iJdpLG");
        question.setQuestion("xpT3YmqGGp1Ox204yLs0KbC9D1ldTBgd6g6HdMRey160ZaESdb");
        question.setLevelid(6);
        question.setQuestionIcon("oG15FFtqzM5UylFZ7aTU5kR0qMBAs11GGFi6nj5JqYv31TBgbp");
        question.setEntityValidator(entityValidator);
        return question;
    }

    @Test
    public void test1Save() {
        try {
            Question question = createQuestion(true);
            question.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            question.isValid();
            questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            Question question = questionRepository.findById((java.lang.String) map.get("QuestionPrimaryKey"));
            question.setQuestionDetails("geCJZ1yQUc");
            question.setQuestion("uwcVdj926xbRpQqaJol0gI2L8wMCdLmQUEvFgqtRIOfaS05jsl");
            question.setVersionId(1);
            question.setLevelid(1);
            question.setQuestionIcon("EIp1R8CKXtQM0YIaj0g56Nhp4b8mOPM7wbHNF9q9lYaoAhKRap");
            question.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            questionRepository.update(question);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            questionRepository.findById((java.lang.String) map.get("QuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("QuestionPrimaryKey"));
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateQuestion(EntityTestCriteria contraints, Question question) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            question.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            question.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            question.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            questionRepository.save(question);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "levelid", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "levelid", 17));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "question", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "question", "UPClZB1ztTl6x4RILkAQ5SReHYOW4GbB8sQCjRTPMwBAN5C51lK5zXtK9gdDgs4kW3bRHxpqBLAgk7HedHKwGYNp7p0tQ9fFxYLG8ylEn33efR3wC8EmzNGv6VVZgiO98H6FCdRvz8LeBoXASeQlSVzxV2cmmqtNOxv6s15KUYntky5bPofxKsayyuGsXg0zVc4JylcmDkCVBmW0EOwfYmPQQ8btRPMhKnvZsgh6zEHQjXWlCML7k1zsMW49tp2WK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "questionDetails", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "questionIcon", "3DFC6BjZDJd2ykfdeudYpjXzhZTvvgJwOPKt0aV7QVa5Qtms2PWCxdV1wYxiiMDYM"));
>>>>>>> branch 'master' of https://github.com/applifireAlgo/apponetest.git
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Question question = createQuestion(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = question.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(question, null);
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 2:
                        question.setLevelid(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(question, null);
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 4:
                        question.setQuestion(contraints.getNegativeValue().toString());
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 5:
                        question.setQuestionDetails(contraints.getNegativeValue().toString());
                        validateQuestion(contraints, question);
                        failureCount++;
                        break;
                    case 6:
                        question.setQuestionIcon(contraints.getNegativeValue().toString());
                        validateQuestion(contraints, question);
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
