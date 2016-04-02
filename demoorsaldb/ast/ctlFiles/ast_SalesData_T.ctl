load data infile '/tmp/applifire/db/JAFRTOITE3ZP7JPEHMWKIW/A5286AD3-CF74-4BD8-9EF5-F183A14868C4/ast/data/SalesData.csv' into table ast_SalesData_T FIELDS TERMINATED BY '#appfire#' (autoid "ast_SalesData_T_seq.NEXTVAL",channelId,reatilercode,retailername CHAR(1000) "decode(:retailername, '\\N', null, :retailername)",salesdate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',salesmonth,salesyear,salesinvoicenbr,materialdesc CHAR(1000) "decode(:materialdesc, '\\N', null, :materialdesc)",branddesc CHAR(1000) "decode(:branddesc, '\\N', null, :branddesc)",salesqty,netsalesamt,grosssalesamt,materialcode,brandcode,category,createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")
