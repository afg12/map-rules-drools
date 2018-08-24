package co.com.ceiba.drools.maprulesdrools.util;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import co.com.ceiba.drools.maprulesdrools.model.rule.Objeto;

public class JSONConverter {
	
	public static Objeto convertObject(String filename) throws IOException {
		// read json
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filename));
		return gson.fromJson(reader, Objeto.class);
		
	}

}
