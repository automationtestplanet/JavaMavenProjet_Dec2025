package com.automation.json;

import java.nio.file.Paths;

import org.json.simple.JSONObject;

import com.automation.models.LoginDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public JSONObject readDataFromJson(String jsonFilePath) {

		JSONObject jObject = null;
		try {
			jObject = new ObjectMapper().readValue(Paths.get(jsonFilePath).toFile(), JSONObject.class);
		} catch (Exception e) {
			System.out.println("Exception Occurred while reading the data from JSON file: " + e.getMessage());
		}
		return jObject;
	}

	public LoginDetails readDataFromJsonAsModelClass(String jsonFilePath) {
		LoginDetails loginDetails = null;
		try {
			loginDetails = new ObjectMapper().readValue(Paths.get(jsonFilePath).toFile(), LoginDetails.class);
		} catch (Exception e) {
			System.out.println("Exception Occurred while reading the data from JSON file: " + e.getMessage());
		}
		return loginDetails;
	}
}
