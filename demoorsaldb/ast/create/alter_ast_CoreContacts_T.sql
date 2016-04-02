

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_678fca320 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_de9b6eb16 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_fb9d8ba2a FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_e133d4452 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;