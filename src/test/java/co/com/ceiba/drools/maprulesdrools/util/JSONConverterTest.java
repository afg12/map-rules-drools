package co.com.ceiba.drools.maprulesdrools.util;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class JSONConverterTest {

	
	@Test
	public void testJsonToMap() throws IOException {
		Map<String, Object> jsonToMap = JSONConverter.convertMap("src/main/resources/rule.json");
		//System.out.println("regla-->>"+jsonToMap.get("regla").toString());
		jsonToMap.forEach((k, v) -> System.out.println("/n"+k + "=" + v.toString()));
		
	}

}
