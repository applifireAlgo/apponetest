CREATE TABLE art_loginSession (
  sessionid varchar2(45) NOT NULL,
  loginTime timestamp(0) DEFAULT NULL NULL,
  logoutTime timestamp(0) DEFAULT NULL NULL,
  clientIPAddress varchar2(45) DEFAULT NULL,
  clientIPAddressInt number(10) DEFAULT NULL,
  clientNetworkAddress number(10) DEFAULT NULL,
  clientBrowser varchar2(1000) DEFAULT NULL,
  userId number(10) DEFAULT NULL,
  version_id number(10) DEFAULT NULL,
  PRIMARY KEY (sessionid)
) ;

exit

