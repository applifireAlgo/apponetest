load data infile '/tmp/applifire/db/JAFRTOITE3ZP7JPEHMWKIW/A5286AD3-CF74-4BD8-9EF5-F183A14868C4/ast/data/Language.csv' into table ast_Language_M FIELDS TERMINATED BY '#appfire#' (languageId,language,languageType CHAR(1000) "decode(:languageType, '\\N', null, :languageType)",languageDescription CHAR(1000) "decode(:languageDescription, '\\N', null, :languageDescription)",languageIcon CHAR(1000) "decode(:languageIcon, '\\N', null, :languageIcon)",alpha2 CHAR(1000) "decode(:alpha2, '\\N', null, :alpha2)",alpha3 CHAR(1000) "decode(:alpha3, '\\N', null, :alpha3)",alpha4 CHAR(1000) "decode(:alpha4, '\\N', null, :alpha4)",alpha4parentid CHAR(1000) "decode(:alpha4parentid, '\\N', null, :alpha4parentid)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")
