package com.goldbuffalo.springapplication;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

@RestController
public class CustomerController {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
    private Drive googleDrive;
	
	@GetMapping(path = "/hello")
	public String hello() {
		Employee savedEmployee = repository.findById(1);
		System.out.println("hello");
		System.out.println(savedEmployee.getId());
		System.out.println(savedEmployee.getName());
		
		return "hello";
	}
	
	@GetMapping(path = "/hello2")
	public String hello2() {
		FileList result = null;
		try {
			result = googleDrive.files().list()
			        .setFields("nextPageToken, files(id, name, parents, mimeType)")
			        .execute();
			System.out.println(googleDrive.files().get("1gBV8lZNOkpeegMn4odv935VuvO-jrY8I"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i < result.getFiles().size();i++) {
			System.out.println(result.getFiles().get(i).getName());
		}
        return result.getFiles().toString();
	}
	
	@GetMapping(path = "/hello3")
	public String CreateNewFolder() {
		File fileMetadata = new File();
        fileMetadata.setName("duyl test");
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        File file = null;
		try {
			file = googleDrive.files().create(fileMetadata).setFields("id").execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return file.getId();
	}
	
	@GetMapping(path = "/printAllBeans")
	public String PrintAllBeans() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {

            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
        }

        return "helloworld";
	}
	
	@PostMapping(path = "/handleSubmit")
	public String handleSubmit(@RequestParam("name") String name) {
		return name;
	}
	
	

}
