##prerequisite
install glassfish 5.0
install domain on glassfish (local.host)
create jms connection factory (jms/sampleConnectionFactory)
create jms queue (jms/sampleQueue)

##build & run
open command line
mvn clean package
appclient -client target\jms-sample-consumer.jar

##output
Nov 13, 2018 3:08:52 PM org.hibernate.validator.internal.util.Version <clinit>
INFO: HV000001: Hibernate Validator 6.0.2.Final
Nov 13, 2018 3:08:53 PM com.sun.messaging.jms.ra.ResourceAdapter start
INFO: MQJMSRA_RA1101: GlassFish MQ JMS Resource Adapter: Version:  5.1.1  (Build 6-a) Compile:  August 17 2017 1649
Nov 13, 2018 3:08:53 PM com.sun.messaging.jms.ra.ResourceAdapter start
INFO: MQJMSRA_RA1101: GlassFish MQ JMS Resource Adapter starting: broker is REMOTE, connection mode is TCP
Nov 13, 2018 3:08:53 PM com.sun.messaging.jms.ra.ResourceAdapter start
INFO: MQJMSRA_RA1101: GlassFish MQ JMS Resource Adapter Started:REMOTE
Waiting for messages...

####output (after run producer)
Received the following message: Testing, 1, 2, 3. Can you hear me?
Received the following message: Do you copy?
Received the following message: Good bye!