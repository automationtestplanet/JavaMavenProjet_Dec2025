package com.automation.xml;

import java.nio.file.Paths;

import com.automation.models.Credentials;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtils {

	public Credentials readDataFromXml(String filePath) {
		try {
			return new XmlMapper().readValue(Paths.get(filePath).toFile(), Credentials.class);
		} catch (Exception e) {
			System.out.println("Exception occurred while reading the data form XML: " + e.getCause());
			return null;
		}
	}
}
