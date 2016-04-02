

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_16afa914a FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_ef3d628e1 FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_43158f8f8 FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_69d965f81 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;