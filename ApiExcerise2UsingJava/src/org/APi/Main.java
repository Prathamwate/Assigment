package org.APi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		
		try {
			weatherApi();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	
	public static void weatherApi() throws URISyntaxException, IOException, InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter Location : ");
		String Location=sc.nextLine();
		sc.close();
		
		String url="https://api.weatherbit.io/v2.0/current?key=b025ca65e7114a52bbca5f30585931ab&city=Mumbai";
	    URIBuilder builder=new URIBuilder(url);
		
	    builder.setParameter("city", Location);
	
		//RequestBuild
		HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		//RequestObject
		HttpClient clients=HttpClient.newBuilder().build();
		
		//Get Response
		HttpResponse<String> httpResponse=clients.send(request,HttpResponse.BodyHandlers.ofString());
		
		JSONObject  responseObject=new JSONObject(httpResponse.body());
     	
		 JSONArray valueObject=responseObject.getJSONArray("data");
		 
		 System.out.println("Location \t Date \t Temp \t\t Latitude \t Country_Code");
		 for(int i=0;i<valueObject.length();i++) {
				
				JSONObject values= valueObject.getJSONObject(i);
				
				String date=values.getString("datetime");
		        double temp=values.getDouble("app_temp");
		        double latitude=values.getDouble("lat");
		        String country_code=values.getString("country_code");
		      
		        
		        System.out.printf("%s \t %s \t %f \t %f \t %s \n",Location , date , temp , latitude , country_code);
			}
	
		
	}

}
