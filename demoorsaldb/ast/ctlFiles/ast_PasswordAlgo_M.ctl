load data infile '/tmp/applifire/db/JAFRTOITE3ZP7JPEHMWKIW/A5286AD3-CF74-4BD8-9EF5-F183A14868C4/ast/data/ast_PasswordAlgo_M.csv' APPEND into table ast_PasswordAlgo_M FIELDS TERMINATED BY '#appfire#' (algoId,algorithm,algoName,algoDescription CHAR(1000) "decode(:algoDescription, '\\N', null, :algoDescription)",algoIcon CHAR(1000) "decode(:algoIcon, '\\N', null, :algoIcon)",algoHelp CHAR(1000) "decode(:algoHelp, '\\N', null, :algoHelp)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")

