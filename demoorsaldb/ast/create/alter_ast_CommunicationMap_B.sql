

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_718f58f89 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_cc4567158 FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;