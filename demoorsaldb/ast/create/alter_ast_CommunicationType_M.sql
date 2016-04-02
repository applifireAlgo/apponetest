

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_d8a43effc FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;