

ALTER TABLE ast_UserAccess_M ADD CONSTRAINT fk_d25c7727c FOREIGN KEY (region) REFERENCES ast_SalesRegion_M(regioncode);



ALTER TABLE ast_UserAccess_M ADD CONSTRAINT fk_a81a68571 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;