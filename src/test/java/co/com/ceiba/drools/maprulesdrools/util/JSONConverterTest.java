package co.com.ceiba.drools.maprulesdrools.util;

import java.io.IOException;

import org.junit.Test;

import co.com.ceiba.drools.maprulesdrools.model.rule.Objeto;

public class JSONConverterTest {

	@Test
	public void testconJsonGrupos() throws IOException {
		Objeto regla = JSONConverter.convertObject("src/main/resources/rule.json");
		System.out.println("regla-->>"+regla.getRegla().getMetadatos().getCodigo());
		
	}
	
	@Test
	public void testconJsonSinGrupos() throws IOException {
		Objeto regla = JSONConverter.convertObject("src/main/resources/ruleSimple.json");
		System.out.println("regla-->>"+regla.getRegla().getMetadatos().getCodigo());
		
	}

}
