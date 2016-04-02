

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_8d97721b9 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_8baefc794 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;