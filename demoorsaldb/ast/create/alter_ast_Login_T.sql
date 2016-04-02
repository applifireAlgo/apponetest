

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_17ca8a2ce FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_e14014095 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;