

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_2f4f81896 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;