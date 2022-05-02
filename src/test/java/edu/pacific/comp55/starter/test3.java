package edu.pacific.comp55.starter;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

class test3 {

	@SuppressWarnings("unchecked")
	@Test
	void test() {
		String filePath = "src/main/java/edu/pacific/comp55/starter/tasks.json";
		JSONObject jo = new JSONObject();
		jo.put("firstName", "John");
		jo.put("lastName", "Doe");

		JSONArray ja = new JSONArray();
		ja.add(jo);

		JSONObject mainObj = new JSONObject();
		mainObj.put("employees", ja);
		mainObj.put("bannana", ja);
        try {
			FileWriter taskFile = new FileWriter(filePath);
			taskFile.write(mainObj.toString());//toJSONString
			taskFile.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        JSONParser jsonParser = new JSONParser();
        try 
        {
        	JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
        	System.out.print(jsonObject);
        	System.out.print(jsonObject.keySet());
        	System.out.print(jsonObject.get("employees"));
        	System.out.print(jsonObject.get("employees").getClass());
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
