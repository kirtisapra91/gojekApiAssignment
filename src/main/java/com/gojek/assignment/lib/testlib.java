package com.gojek.assignment.lib;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class testlib {	
	public testlib() {
		
	}
	
	public List<String> readFile(File file1) throws IOException{
		List<String> list = new ArrayList<String>();		
		BufferedReader bufferedReader = null;
		try{
			Reader reader = new FileReader(file1);
			bufferedReader = new BufferedReader(reader);
			String line = null;
	        while((line = bufferedReader.readLine()) != null){
	        	list.add(line);
	        }
		}catch(IOException e){
			e.printStackTrace();
		}   
		return list;        
	}
	
	
	public Response getResponse(String url){
        RestAssured.baseURI = url; 
        Response response = null;
        try {
        	   response = RestAssured.given()
        	    .when()
        	    .get();
    	  } catch (Exception e) {
    		  e.printStackTrace();
         }

        return response;
	}
	
	public int compareTwoUrls(String url1, String url2){
		Response response1 = getResponse(url1);
		Response response2 = getResponse(url2);
		return response1.asString().compareTo(response2.asString());
	}

}


