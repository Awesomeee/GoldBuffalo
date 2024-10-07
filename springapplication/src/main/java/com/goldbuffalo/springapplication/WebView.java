package com.goldbuffalo.springapplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebView {
	
	@Autowired
	WebService webService;
	
	@GetMapping("/portalView")
	public String MainPortal() {
		//System.out.println("hello");
		return "portal";
	}
	
	@GetMapping("/layoutFlexbox")
	public String layoutFlexbox() {
		//System.out.println("hello");
		return "layout_flexbox.html";
	}
	
	@GetMapping("/basicHTMLStructure")
	public String basicHTMLStructure() {
		return "Exercise_basicHTMLStructure";
	}
	
	@GetMapping("/Contact")
	public String contact() {
		return "Exercise_HTMLForm";
	}
	
	/*@PostMapping(path = "/handleSubmit")
	public String handleSubmit(@ModelAttribute FormObject formObject, Model model) {
		model.addAttribute("name", formObject.getName());
		model.addAttribute("email", formObject.getEmail());
		model.addAttribute("password", formObject.getPassword());
		model.addAttribute("gender", formObject.isGender());
		model.addAttribute("hobbies", formObject.isHobbies());
		System.out.println(formObject.getName());
		System.out.println(formObject.getEmail());
		System.out.println(formObject.getPassword());
		System.out.println(formObject.isGender());
		System.out.println(formObject.isHobbies());
		return "formSuccess";
	}*/
	
	@PostMapping(path = "/handleSubmit2")
	public String handleSubmit2(@ModelAttribute FormObject formObject, Model model, @RequestParam("file") MultipartFile file) {
		model.addAttribute("name", formObject.getName());
		model.addAttribute("email", formObject.getEmail());
		model.addAttribute("password", formObject.getPassword());
		model.addAttribute("gender", formObject.isGender());
		model.addAttribute("hobbies", formObject.isHobbies());
		System.out.println(formObject.getName());
		System.out.println(formObject.getEmail());
		System.out.println(formObject.getPassword());
		System.out.println(formObject.isGender());
		System.out.println(formObject.isHobbies());
		System.out.println("file name: " + file.getName() + "file size: " + file.getSize());
		try {
			webService.WriteFile(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "formSuccess";
	}
	
	@GetMapping(path = "/exerciseListAndTable")
	public String exerciseListAndTable() {
		return "Exercise_HTMLListAndTable";
	}
	
	@GetMapping(path = "/exerciseSemanticHTML")
	public String exerciseSemanticHTML() {
		return "Exercise_semanticHTML";
	}
	
	@GetMapping(path = "/exerciseCssLayout")
	public String exerciseCssLayout() {
		return "Exercise_HTML_CSSLayout";
	}
	
	@GetMapping(path = "/exerciseCssSelector")
	public String exerciseCssSelector() {
		return "Exercise_CSSSelector";
	}
	
	@GetMapping("/Form1")
	public String getForm1() {
		return "Form1";
	}
	
	@GetMapping("/files/{fileName}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable String fileName) throws IOException {
        // Define the path to the file
		System.out.println("file Name " + fileName);
        Path filePath = Paths.get("/Users/duy/Data/2024/Working/File-Server/", fileName);

        // Read the file's content into a byte array
        byte[] fileContent = Files.readAllBytes(filePath);

        // Determine the file's content type (optional, you can hard-code it if you know it)
        MediaType contentType = getContentType(fileName);

        // Prepare the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + fileName);  // Inline for viewing in browser
        // headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName); // Attachment for download

        // Create a resource from the byte array
        ByteArrayResource resource = new ByteArrayResource(fileContent);

        // Return the file as a ResponseEntity
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileContent.length)
                .contentType(contentType)
                .body(resource);
    }

    // Helper method to determine the file's content type
    private MediaType getContentType(String fileName) {
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (fileName.endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else if (fileName.endsWith(".pdf")) {
            return MediaType.APPLICATION_PDF;
        }
        // Default content type for unknown file types
        return MediaType.APPLICATION_OCTET_STREAM;
    }
    
    @GetMapping("/files/banana.jpg")
    public ResponseEntity<ByteArrayResource> getFile2() throws IOException {
        // Define the path to the file
		
        Path filePath = Paths.get("/Users/duy/Data/2024/Working/File-Server/banana.jpg");

        // Read the file's content into a byte array
        byte[] fileContent = Files.readAllBytes(filePath);

        // Determine the file's content type (optional, you can hard-code it if you know it)
        MediaType contentType = getContentType("banana.jpg");

        // Prepare the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + "banana.jpg");  // Inline for viewing in browser
        // headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName); // Attachment for download

        // Create a resource from the byte array
        ByteArrayResource resource = new ByteArrayResource(fileContent);

        // Return the file as a ResponseEntity
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileContent.length)
                .contentType(contentType)
                .body(resource);
    }

}
