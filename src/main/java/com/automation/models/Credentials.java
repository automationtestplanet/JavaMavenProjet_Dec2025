package com.automation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties
public class Credentials {
	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("Password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
