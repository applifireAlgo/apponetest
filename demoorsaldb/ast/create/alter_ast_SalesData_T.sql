

ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_5ea98d581 FOREIGN KEY (reatilercode) REFERENCES ast_Retailer_M(retailercode);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_dd6479826 FOREIGN KEY (materialcode) REFERENCES ast_Material_M(materialcode);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_72677bbcc FOREIGN KEY (category) REFERENCES ast_Category_M(categoryId);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_870e25407 FOREIGN KEY (channelId) REFERENCES ast_Channel_M(channelId);



ALTER TABLE ast_SalesData_T ADD CONSTRAINT fk_fba24026a FOREIGN KEY (brandcode) REFERENCES ast_Brand_M(brandcode);



exit;