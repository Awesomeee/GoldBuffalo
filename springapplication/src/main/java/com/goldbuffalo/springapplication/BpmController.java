package com.goldbuffalo.springapplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BpmController {

	@GetMapping(path = "/getAssociatedEntities")
	public String getAssociatedEntities() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		ProcessAssociatedEntities processAssociatedEntities = restTemplate.getForObject("http://localhost:8080/kie-server/services/rest/server/containers/HR_Application_1.0.0-SNAPSHOT/processes/definitions/HR_Application.OnboardingProcess/entities?containerId=HR_Application_1.0.0-SNAPSHOT&processId=HR_Application.OnboardingProcess", ProcessAssociatedEntities.class);
		context.close();
		return processAssociatedEntities.toString();
	}
}
