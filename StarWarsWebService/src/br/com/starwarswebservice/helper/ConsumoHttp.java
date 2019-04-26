package br.com.starwarswebservice.helper;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.starwarswebservice.model.Result;
import io.restassured.RestAssured;

public class ConsumoHttp {
	

	private static int HTTP_COD_SUCESSO = 200;
	 private final String USER_AGENT = "Mozilla/5.0";	

	 public JsonObject Get(String surl) throws Exception {
		  
		 JsonObject resultado = null;
		  String readLine = null;
		  
			  
	         URL url = new URL(surl);
	         HttpURLConnection con = (HttpURLConnection) url.openConnection();
	         con.setRequestProperty("User-Agent", USER_AGENT);
	
	         if (con.getResponseCode() != HTTP_COD_SUCESSO) {
	             throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	         }    
	
	             BufferedReader in = new BufferedReader(
	                 new InputStreamReader(con.getInputStream()));
	             StringBuffer response = new StringBuffer();
	             while ((readLine = in .readLine()) != null) {
	                 response.append(readLine);
	             } in .close();
	             // print result
	             System.out.println("JSON String Result " + response.toString());
	             
	             JsonParser parser = new JsonParser(); 
	             resultado = (JsonObject) parser.parse(response.toString());

	             
	       
	    return resultado;
	  
	 }
    
   
	
}
