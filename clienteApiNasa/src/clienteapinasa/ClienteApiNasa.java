/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteapinasa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
/**
 *
 * @author jlbugarin
 */
public class ClienteApiNasa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
         String endpoint = "https://api.nasa.gov/planetary/apod?api_key=BNnOMpUYGOuT2y8VzMDYzeuqD7ZDmMlZclTCGO7T";
		
		
                String url = endpoint;
                
		System.out.println(url);
                HttpClientBuilder hcBuilder = HttpClients.custom();
		HttpClient client = hcBuilder.build() ;
		HttpGet request = new HttpGet(url); 
		//Setting header parameters
		request.addHeader("Content-Type", "application/json");
		request.addHeader("Accept", "application/json");
		
		//Executing the call
		HttpResponse response = client.execute(request);
		System.out.println("\nSending 'Get' to " + url);
		System.out.println("HTTP Response: " +  response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
 		//Reading the response
		StringBuilder result = new StringBuilder();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		} 
		System.out.println(result.toString()); 
    }
    
}
