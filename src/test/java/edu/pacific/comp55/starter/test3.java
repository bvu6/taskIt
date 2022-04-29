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
//		File f = new File(filePath);
//		assertEquals(true, f.isFile());
		JSONObject taskDetails = new JSONObject();
        taskDetails.put("title: ", "0");   
        taskDetails.put("category: ", "1");
        taskDetails.put("due date: ", "2");
        taskDetails.put("priority: ", "3");
        
        JSONObject task = new JSONObject();
        task.put("task", taskDetails);
        MainApplication.jArray.put(task);
        System.out.println(MainApplication.jArray);
        
        try {
			FileWriter taskFile = new FileWriter(filePath);
			taskFile.write(MainApplication.jArray.toString());//toJSONString
			taskFile.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        JSONParser jsonParser = new JSONParser();
        try 
        {
        	JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));
        	JSONObject taskTest = (JSONObject) jsonArray.get(0);
    
        	System.out.println("TTest: " + taskTest);
        	
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
