

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_3761234c7 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_f11c46c9d FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;