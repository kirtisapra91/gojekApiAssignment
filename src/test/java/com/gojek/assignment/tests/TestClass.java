package com.gojek.assignment.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gojek.assignment.lib.testlib;

public class TestClass {
	testlib obj = new testlib();	
	File file1 = new File(System.getProperty("user.dir")+File.separator+"src\\main\\java\\TestData\\file1.txt");
	File file2 = new File(System.getProperty("user.dir")+File.separator+"src\\main\\java\\TestData\\file2.txt");
	public static List<String> list1 = new ArrayList<String>();
	public static List<String> list2 = new ArrayList<String>();
	SoftAssert softAssertion = new SoftAssert();	

	
	@Test (priority = 1)
	public void verifyFile1IsNotBlank() throws IOException{
		list1 = obj.readFile(file1);
		softAssertion.assertEquals(list1.isEmpty(), false, "File1 is blank");
		softAssertion.assertAll();
	}
	
	@Test(priority = 2)
	public void verifyFile2IsNotBlank() throws IOException{
		list2 = obj.readFile(file2);
		softAssertion.assertEquals(list2.isEmpty(), false, "File2 is blank");
		softAssertion.assertAll();
	}
	
	@Test (priority = 3)
	public void verifyResponseOfFile1Urls(){
		for(String url: list1){
			Response result = (Response) obj.getResponse(url);
			softAssertion.assertEquals(result.asString().isEmpty(), false, url + " is returning blank response");
			softAssertion.assertAll();
		}
	}
	
	@Test (priority = 4)
	public void verifyResponseOfFile2Urls(){
		for(String url: list2){
			Response result = (Response) obj.getResponse(url);
			softAssertion.assertEquals(result.asString().isEmpty(), false, url + " is returning blank response");
			softAssertion.assertAll();
		}
	}
	
	@Test (priority = 5)
	public void compareFiles(){
		for(int i=0; i<list1.size(); i++){
			for(int j=0; j<list2.size(); j++){
				int result=0;
				result =  obj.compareTwoUrls(list1.get(i), list1.get(j));
				softAssertion.assertEquals(result, 0, list1.get(i) + " not equals " + list2.get(j) );
			}
		}
		softAssertion.assertAll();
	}
}
