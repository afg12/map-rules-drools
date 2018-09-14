package co.com.ceiba.drools.maprulesdrools.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import co.com.ceiba.drools.maprulesdrools.object.Atributo;
import co.com.ceiba.drools.maprulesdrools.object.Dato;
import co.com.ceiba.drools.maprulesdrools.object.Grupo;
import co.com.ceiba.drools.maprulesdrools.object.Recomendacion;

public class RulesExampleTest {

	public static final void main(String[] args) {
		
		Atributo atributo = null;
		try {
			atributo = JSONConverter.convertObject("src/main/resources/ruleEjemplo.json");
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			StatelessKieSession kSession = kContainer.newStatelessKieSession("ksession-rule");
			List<String> grupos = new ArrayList<>(
				      new HashSet<>(atributo.getDatos().stream().map(Dato::getGrupo).collect(Collectors.toList())));
			
			List<Grupo> grupoList= new ArrayList<>();
			for(String g: grupos ){
	            Grupo grupo = new Grupo(g);
	            grupoList.add(grupo);
	        }
			
			List<String> actions = new ArrayList<>();
			
			@SuppressWarnings("rawtypes")
			List<Command> cmds = new ArrayList<>();
			cmds.add(CommandFactory.newInsertElements(grupoList));
			cmds.add(CommandFactory.newInsertElements(atributo.getDatos()));
			cmds.add(CommandFactory.newInsert(new Recomendacion(actions), "recomendacion"));
			cmds.add(CommandFactory.newFireAllRules());
			ExecutionResults results = kSession.execute(CommandFactory.newBatchExecution(cmds));
			System.out.println(results.getIdentifiers());
			Recomendacion r = (Recomendacion) results.getValue("recomendacion");
			System.out.println(r.getActions().get(0));
			r.getActions().forEach(name -> System.out.println(name));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
