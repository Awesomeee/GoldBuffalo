package com.goldbuffalo.springapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class BpmController {

	/*@GetMapping(path = "/getAssociatedEntities")
	public String getAssociatedEntities() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		ProcessAssociatedEntities processAssociatedEntities = restTemplate.getForObject("http://localhost:8080/kie-server/services/rest/server/containers/HR_Application_1.0.0-SNAPSHOT/processes/definitions/HR_Application.OnboardingProcess/entities?containerId=HR_Application_1.0.0-SNAPSHOT&processId=HR_Application.OnboardingProcess", ProcessAssociatedEntities.class);
		context.close();
		return processAssociatedEntities.toString();
	}*/
	
	public void aaa() {
		try {
			String API_URL = "http://localhost:8081/hello";
            // Create a URL object with the target URL
            URL url = new URL(API_URL);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to GET
            connection.setRequestMethod("GET");
            
            // Set request headers if necessary
            connection.setRequestProperty("Accept", "application/json");
            
            // Get the response code
            int responseCode = connection.getResponseCode();
            
            // Check if the response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the input stream
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                
                // Close the input stream
                in.close();
                
                // Print the response
                System.out.println(response.toString());
            } else {
                // Print an error message if the response code is not OK
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
            
            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        }
	}
	
	public void callRest() {
		try {
			String API_URL = "http://localhost:8081/hello";
            // Create a URL object with the target URL
            URL url = new URL(API_URL);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to GET
            connection.setRequestMethod("GET");
            
            // Set request headers if necessary
            connection.setRequestProperty("Accept", "application/json");
            
            // Get the response code
            int responseCode = connection.getResponseCode();
            
            // Check if the response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the input stream
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                
                // Close the input stream
                in.close();
                
                // Print the response
                System.out.println(response.toString());
            } else {
                // Print an error message if the response code is not OK
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
            
            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        }
	}
	
}
