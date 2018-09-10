package co.com.ceiba.drools.maprulesdrools.util;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import co.com.ceiba.drools.maprulesdrools.object.Atributo;

public class RulesExampleTest {

	public static final void main(String[] args) {
		
		Atributo atributo = null;
		try {
			atributo = JSONConverter.convertObject("src/main/resources/ruleEjemplo.json");
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			StatelessKieSession kSession = kContainer.newStatelessKieSession("ksession-rule");
			kSession.execute(atributo.getDatos());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
