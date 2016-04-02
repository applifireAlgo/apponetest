load data infile '/tmp/applifire/db/JAFRTOITE3ZP7JPEHMWKIW/A5286AD3-CF74-4BD8-9EF5-F183A14868C4/art/data/art_password_policy.csv' into table art_password_policy FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription,minPwdLength,maxPwdLength,minCapitalLetters,minSmallLetters,minNumericValues,minSpecialLetters,allowedSpecialLetters
,version_id,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',created_by)

