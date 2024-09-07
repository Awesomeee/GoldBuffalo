package com.goldbuffalo.springapplication;

import org.springframework.stereotype.Component;

public class FormObject {
	
	private String name;
	private String email;
	private String password;
	private boolean gender;
	private boolean hobbies;
	
	public FormObject() {}
	
	public FormObject(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isHobbies() {
		return hobbies;
	}

	public void setHobbies(boolean hobbies) {
		this.hobbies = hobbies;
	}
	

}
