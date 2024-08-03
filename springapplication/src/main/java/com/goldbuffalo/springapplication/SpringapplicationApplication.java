package com.goldbuffalo.springapplication;

import java.net.URI;
import java.util.Base64;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@SpringBootApplication
public class SpringapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringapplicationApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthentication("wbadmin", "wbadmin").build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String authorization = "wbadmin:wbadmin";
			byte[] authorizationByte = authorization.getBytes();
			byte[] base64Authorization = Base64.getEncoder().encode(authorizationByte);
			String base64String = new String(base64Authorization);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64String);
			
			// create request
		    HttpEntity<String> request = new HttpEntity<String>(headers);
		    ResponseEntity<String> response = new RestTemplate().exchange(new URI("http://localhost:8080/kie-server/services/rest/server/containers/HR_Application_1.0.0-SNAPSHOT/processes/definitions/HR_Application.OnboardingProcess/entities?containerId=HR_Application_1.0.0-SNAPSHOT&processId=HR_Application.OnboardingProcess"), HttpMethod.GET, request, String.class);
			//ProcessAssociatedEntities processAssociatedEntities = restTemplate.getForObject(
			//		"http://localhost:8080/kie-server/services/rest/server/containers/HR_Application_1.0.0-SNAPSHOT/processes/definitions/HR_Application.OnboardingProcess/entities?containerId=HR_Application_1.0.0-SNAPSHOT&processId=HR_Application.OnboardingProcess", ProcessAssociatedEntities.class);
			System.out.println(response.toString());
		};
	}

}
