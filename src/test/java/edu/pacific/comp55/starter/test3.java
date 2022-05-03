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
        JSONParser jsonParser = new JSONParser();
        try 
        {
        	JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
        	System.out.print(jsonObject);
        	System.out.print(jsonObject.keySet());
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
