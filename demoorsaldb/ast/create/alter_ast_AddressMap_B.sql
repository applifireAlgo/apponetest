

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_2445fc0c0 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_a93d654e5 FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;