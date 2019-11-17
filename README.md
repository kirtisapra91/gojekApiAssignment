#GoJek-API

#Dependencies:
Rest-Assured, testng

#TestData:
Under this folder there are 02 files placed which have multiple url. There are only 4 urls in each file for now to test the scenarios

# Library folder
Library : com.gojek.assignment.lib
Under this package, there is a testlib.java file which has the functions to test below cases:
=> Read file
=> Get Response from urls present in files
=> Comparison of response returned from above urls for 02 files

# Test folder
Test: com.gojek.assignment.tests
Under this package, there is a testng test class which consists of 05 test methods

# Testng file
This file is placed under root directory with name: testng.xml
=> This file has the test class name which has 05 test methods as described above

# How to run:
1. install maven on your machine
2. Set apache maven bin path
3. use below command to run the project from command line:
=> mvn clean test -Dsuite=testng.xml

# Output - surefire reports
=> There is a folder "target" which gets created once you run above mvn command
Out of 5 test points, 1 test will fail because all urls don't give same response
Results can be seen in index.html file under target folder 

# Test Cases:
1. Verify file1 is not blank
2. Verify file2 is not blank
3. Verify response of urls present in file1 is not empty
4. Verify response of urls present in file2 is not empty
5. Compare output of urls present in both files

# Drawback of current approach
=> comparing json strings gets failed sometimes because of the data positioning in json response which gets changed

# Things yet to be done:
Need to convert json response into map & validate the response using each key in nested maps


