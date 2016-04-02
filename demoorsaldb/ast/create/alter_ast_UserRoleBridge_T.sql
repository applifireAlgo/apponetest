

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_ec05a7d03 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_f401ab4a8 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;