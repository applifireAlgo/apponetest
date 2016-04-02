

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_1d861642b FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_431391237 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;