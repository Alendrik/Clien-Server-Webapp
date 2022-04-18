# Clien-Server-Webapp
## Functionality
  Webapp provides functionality of View, Download, Upload, and Delete on a tomcat server.  

## Authentication
  Webapp uses LDAP to authenticate users. LDAP database stores user credentials, group, but NOT permissions.
  
## Authorization
  Webapp doesn't support authentication yet. As long as a user is authenticated, they have full access to the functionality.
  
  In the future, I plan to implement some sort of database (SQL, SQLite) OR a readOnly JSON file to track user permissions. 
  This method may get cumbersome, however, so I want to look into implementing RBAC instead.

## Security
  Webapp doesn't support security yet. LDAP and Tomcat are not under SSL or TLS and credentials are communicated through cleartext.
  
  I plan to use GnuTLS for both Apcahe Tomcat and LDAP communications.
  I also need to scrub inputs, prevent unwanted file uploads, and more. (refer to notebook)
  
## Logging
  Webapp doesn't support logging yet. There is no accounting for any given actions.
  
  I plan to implement a Java logging feature as well as leverage tomcat logging.
  
# Dependencies
- Java
- Eclipse (development wise)
- Tomcat
- LDAP
- Database or Read-only record (future)
- GnuTLS (future)
