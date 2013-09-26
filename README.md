Example of remote EJB invocation between JBoss 7 instances.

*Mini-How-To*

1. Unzip JBoss into MASTER and SLAVE instances and build movie-manager:
    milad@linux-pc-0018:~$ cd zips
    milad@linux-pc-0018:~/zips$ unzip jboss-eap-6.1.0.Alpha.zip
    ...
    milad@linux-pc-0018:~/zips$ mv jboss-eap-6.1 ~
    milad@linux-pc-0018:~/zips$ cd
    milad@linux-pc-0018:~$ cp -r jboss-eap-6.1 jboss-eap-6.1-slave
    milad@linux-pc-0018:~$ cd projects/movie-manager
    milad@linux-pc-0018:~/projects/movie-manager$ mvn clean install
    ...
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 9.534s
    [INFO] Finished at: Thu Sep 26 09:45:46 CEST 2013
    [INFO] Final Memory: 19M/490M
    [INFO] ------------------------------------------------------------------------
    milad@linux-pc-0018:~/projects/movie-manager$ cd movie-manager-dist/target/
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ unzip movie-manager-dist-1.0.0-SNAPSHOT-distribution.zip
    ...
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ cp movie-manager-ear-slave-1.0.0-SNAPSHOT.ear ~/jboss-eap-6.1-slave/standalone/deployments/
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ cp movie-manager-ear-master-1.0.0-SNAPSHOT.ear ~/jboss-eap-6.1/standalone/deployments/
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ cp -r modules/com/ ~/jboss-eap-6.1/modules/
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ cp -r modules/com/ ~/jboss-eap-6.1-slave/modules/
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ cp standalone-full-master.xml ~/jboss-eap-6.1/standalone/configuration/
    milad@linux-pc-0018:~/projects/movie-manager/movie-manager-dist/target$ cp standalone-full-slave.xml ~/jboss-eap-6.1-slave/standalone/configuration/

2. Add the "ejb" application user to the SLAVE instance and start it up:
    milad@linux-pc-0018:~/jboss-eap-6.1-slave$ export JBOSS_HOME=/home/local/SPSSIT/milad/jboss-eap-6.1-slave
    milad@linux-pc-0018:~/jboss-eap-6.1-slave$ bin/add-user.sh

    What type of user do you wish to add? 
     a) Management User (mgmt-users.properties) 
     b) Application User (application-users.properties)
    (a): b

    Enter the details of the new user to add.
    Realm (ApplicationRealm) : 
    Username : ejb
    Password : 
    Re-enter Password : 
    What roles do you want this user to belong to? (Please enter a comma separated list, or leave blank for none)[  ]: 
    About to add user 'ejb' for realm 'ApplicationRealm'
    Is this correct yes/no? yes
    Added user 'ejb' to file '/home/local/SPSSIT/milad/jboss-eap-6.1-slave/standalone/configuration/application-users.properties'
    Added user 'ejb' to file '/home/local/SPSSIT/milad/jboss-eap-6.1-slave/domain/configuration/application-users.properties'
    Added user 'ejb' with roles  to file '/home/local/SPSSIT/milad/jboss-eap-6.1-slave/standalone/configuration/application-roles.properties'
    Added user 'ejb' with roles  to file '/home/local/SPSSIT/milad/jboss-eap-6.1-slave/domain/configuration/application-roles.properties'
    Is this new user going to be used for one AS process to connect to another AS process? 
    e.g. for a slave host controller connecting to the master or for a Remoting connection for server to server EJB calls.
    yes/no? no
    milad@linux-pc-0018:~/jboss-eap-6.1-slave$ bin/standalone.sh -server-config=standalone-full-slave.xml -Djboss.socket.binding.port-offset=100 -Djboss.node.name=slave

3. Start up MASTER:
    milad@linux-pc-0018:~/jboss-eap-6.1$ export JBOSS_HOME=/home/local/SPSSIT/milad/jboss-eap-6.1
    milad@linux-pc-0018:~/jboss-eap-6.1$ bin/standalone.sh -server-config=standalone-full-master.xml -Djboss.node.name=master

If now I navigate to URL http://localhost:8080/movie/ (points at the MASTER instance) and enter "a scanner darkly" in the input text, the movie is correctly found, and I see the Hibernate query run on the SLAVE.

The two descriptors {{standalone-full-master.xml}} and {{standalone-full-slave.xml}} have been produced from the original {{standalone-full.xml}}, and:
- adding the MySql datasource to both,
- adding the securiry/remoting information (following server-to-server guide) to the MASTER's only.
