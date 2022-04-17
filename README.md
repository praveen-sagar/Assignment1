# Assignement1

**Prerqusite:**
1. JDK 8, [Follow JDK 8 installation](https://www.codejava.net/java-se/download-and-install-java-8-on-windows)
2. Eclipse IDE for Java Developers with Plugin "TestNG for Eclipse" [Download Eclipse](https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-java-developers), [Install TestNG in Eclipse](https://www.guru99.com/install-testng-in-eclipse.html)
3. Maven should be installed & path set, for download & installation follow: [Download Maven](https://maven.apache.org/download.cgi), [Install Maven & set environment variable](https://maven.apache.org/install.html)
4. Chrome Browser

**Clone & Test Execution instruction:**  

_Run using Eclipse_
1. Clone the project using url https://github.com/praveen-sagar/Assignment1.git  
2. Import maven project: `File > Import > Maven > Existing Maven Projects > Next > Browse & select cloned project > Finish`
3. Run TestSuite1.xml file: `test-suites > TestSuite1.xml > Right Click > Run as > TestNG Suite`
4. After successful test execution open mentioned file in any Browser: `test-output > index.html`
5. Now we can check the TestNG report for the TestSuite1


_Run using Powershell or Terminal_
1. Clone the project `git clone https://github.com/praveen-sagar/Assignment1.git`
2. Go to Project root location `cd Application1`
3. Run maven clean install `mvn clean install`
4. Run Test Suite `mvn clean test -DsuiteXmlFile=test_suite/TestSuite1`
5. After successful test execution open mentioned file in any Browser: `target\surefire-reports\index.html`
5. Now we can check the TestNG report for the TestSuite1
