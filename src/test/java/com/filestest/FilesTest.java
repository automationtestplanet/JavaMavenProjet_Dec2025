package com.filestest;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.csv.CsvUtils;
import com.automation.excel.ExcelUtils;
import com.automation.json.JsonUtils;
import com.automation.models.Credentials;
import com.automation.models.LoginDetails;
import com.automation.xml.XmlUtils;

public class FilesTest {
	@Test
	public void readDataFromExcelTest() {
		ExcelUtils excelUtils = new ExcelUtils();

		String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Test.xlsx";
		List<Map<String, String>> data = excelUtils.readDataFromExcel(excelFilePath, "Languages");

//		List<Map<String,String>> filteredist = data.stream().filter(eachMapObj-> eachMapObj.get("Language").equals("Java")).collect(Collectors.toList());
//		System.out.println(filteredist);

		Map<String, String> filteredMap = data.stream().filter(eachMapObj -> eachMapObj.get("Language").equals("Java"))
				.findFirst().orElse(null);
		System.out.println(filteredMap);

		Assert.assertNotNull(filteredMap, "Filtered Object is Null");
		Assert.assertEquals("Object Oriendted Programming", filteredMap.get("TypeOfLanguage"),
				"Filtered Object Type Of language showing wrong");
		Assert.assertTrue(filteredMap.get("TypeOfLanguage").equals("Object Oriendted Programming"),
				"Filtered Object Type Of language showing wrong");
	}

	@Test
	public void readDataFromJsonTest() {
		JsonUtils jsonUtils = new JsonUtils();
		String filePath = System.getProperty("user.dir") + "//src//test//resources//LoginDetails.json";
		JSONObject jsonDataObject = jsonUtils.readDataFromJson(filePath);
		System.out.println(jsonDataObject);
		Assert.assertNotNull(jsonDataObject, "Json Object is Null");
		Assert.assertEquals(jsonDataObject.get("userName"), "Admin");
		Assert.assertTrue(jsonDataObject.get("password").equals("Admin123"));
	}
	
	@Test
	public void readDataFromJsonAsModelTest() {
		JsonUtils jsonUtils = new JsonUtils();
		String filePath = System.getProperty("user.dir") + "//src//test//resources//LoginDetails.json";
		LoginDetails loginDetails = jsonUtils.readDataFromJsonAsModelClass(filePath);
		
		Assert.assertNotNull(loginDetails, "Json Object is Null");
		Assert.assertEquals(loginDetails.getUserName(),"Admin");
		Assert.assertTrue(loginDetails.getPassword().equals("Admin123"));
	}
	
	@Test
	public void readDataFromXmlTest() {
		XmlUtils xmlUtils = new XmlUtils();
		String filePath = System.getProperty("user.dir") + "//src//test//resources//Credentials.xml";
		Credentials credentials = xmlUtils.readDataFromXml(filePath);
		Assert.assertNotNull(credentials, "Json Object is Null");
		Assert.assertEquals(credentials.getUserName(),"ABC123");
		Assert.assertTrue(credentials.getPassword().equals("ABC@123"));
	}
	
	@Test
	public void ReadDataFromCsvTest() {
		CsvUtils csvUtils = new CsvUtils();
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\CreateUser.csv";
		List<Map<String, String>> data = csvUtils.readDataFromCsv2(filePath);

		Map<String, String> filteredMap = data.stream().filter(eachMapObj -> eachMapObj.get("Name").equals("Tester1"))
				.findFirst().orElse(null);
		System.out.println(filteredMap);

		Assert.assertNotNull(filteredMap, "Filtered Object is Null");
		Assert.assertEquals( filteredMap.get("Job"),"QA Engieer","Filtered Object Type Of language showing wrong");
	}
}
