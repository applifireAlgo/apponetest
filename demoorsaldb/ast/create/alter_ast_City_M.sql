

ALTER TABLE ast_City_M ADD CONSTRAINT fk_84c045f74 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_eec78ac42 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;