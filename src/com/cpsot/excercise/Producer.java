package com.cpsot.excercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
 
import org.json.JSONObject;
  
public class Producer {
	
	public static void main(String[] args) {
	
		try {
 
			//Read JSON file 
			InputStream jsonInputStream =Producer.class.getResourceAsStream("JSONSource.txt"); 
			InputStreamReader jsonReader = new InputStreamReader(jsonInputStream);
			BufferedReader br = new BufferedReader(jsonReader);
			String line;
			while ((line = br.readLine()) != null) {
		 	System.out.println("\nRead" + line);
			
		 	//Create a JSONObject
			JSONObject jsonObject = new JSONObject(line);
			System.out.println("JSON Object"+ jsonObject);
						
			//Get IP for Consumer from cmd line
			String ip=args[0];
			System.out.println("IP is "+ip);
 
			// Pass JSON Object to Consumer REST Service
			try {
					URL url = new URL("http://"+ip+":8080/Consumer/api/consumerService");
					URLConnection connection = url.openConnection();
					connection.setDoOutput(true);
					connection.setRequestProperty("Content-Type", "application/json");
					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
					out.write(jsonObject.toString());
					out.close();
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 					while (in.readLine() != null) {
 				}
				System.out.println("Consumer REST Service Invoked Successfully.. for"+ jsonObject.toString());
				in.close();
			} catch (Exception e) {
				System.out.println("Error while calling Consumer REST Service");
				System.out.println(e);
			}
 		
		 	}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}