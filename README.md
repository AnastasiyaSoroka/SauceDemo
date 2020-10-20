1. mvn versions:display-dependency-updates
 The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-6
[INFO]   org.seleniumhq.selenium:selenium-support ... 3.141.59 -> 4.0.0-alpha-6
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.3.0

2. mvn clean test
Tests run: 17, Failures: 3, Errors: 0, Skipped: 0
Tests run: 17, Failures: 0, Errors: 0, Skipped: 0

3. mvn clean test -DsuiteXmlFile=src/test/resources/smoketest.xml
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

mvn clean test -Dtest=LoginTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

mvn clean test -Dtest=LoginTest#checkErrorWithPasswordEmpty
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

mvn clean test -Dtest=LoginTest#checkErrorWithPasswordEmpty+checkErrorWithUsernamePasswordIncorrect
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

4. mvn clean test  -Dpassword=secret_sauce -Dusername=standard_user
Tests run: 17, Failures: 0, Errors: 0, Skipped: 0

