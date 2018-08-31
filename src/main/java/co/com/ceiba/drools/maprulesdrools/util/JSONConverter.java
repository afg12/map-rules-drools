package co.com.ceiba.drools.maprulesdrools.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import co.com.ceiba.drools.maprulesdrools.deserializer.ParameterDeserializer;
import co.com.ceiba.drools.maprulesdrools.model.rule.Parameter;

public final class JSONConverter {
	
	
	public static Map<String, Object> convertMap(String filename) throws IOException {
		// read json
		Gson gson = new Gson();
		Type listRuleTypeO = new TypeToken<Map<String, Object>>(){}.getType();
		JsonReader reader = new JsonReader(new FileReader(filename));
		return gson.fromJson(reader, listRuleTypeO);
		
	}
	
	public static List<Parameter> run(String filename) throws FileNotFoundException {
	    GsonBuilder builder = new GsonBuilder();
	    JsonReader reader = new JsonReader(new FileReader(filename));
	    Type type = new TypeToken<List<Parameter>>(){}.getType();
	    builder.registerTypeAdapter(type, new ParameterDeserializer());

	    Gson gson = builder.create();
	    return gson.fromJson(reader, type);
	  }

}
