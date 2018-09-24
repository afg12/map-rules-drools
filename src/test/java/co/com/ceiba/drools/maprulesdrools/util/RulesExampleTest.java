package co.com.ceiba.drools.maprulesdrools.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import co.com.ceiba.drools.maprulesdrools.object.Recomendation;

public class RulesExampleTest {

	@SuppressWarnings("unchecked")
	public static final void main(String[] args) {
		
		Atributo atributo = null;
		try {
			atributo = JSONConverter.convertObject("src/main/resources/ruleEjemplo.json");
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			StatelessKieSession kSession = kContainer.newStatelessKieSession("ksession-rule");
			System.out.println("Buscando grupos");
			List<String> grupos = atributo.getDatos().stream().filter(dato -> !dato.getGrupo().isEmpty()).map(Dato::getGrupo).distinct().collect(Collectors.toList());
			System.out.println("Encontró grupos");
			List<Grupo> grupoList= new ArrayList<>();
			for(String g: grupos ){
	            Grupo grupo = new Grupo(g);
	            grupoList.add(grupo);
	        }

			List<Recomendation> listRecomendation = Arrays.asList(new Recomendation("", new ArrayList<>(), ""));
			@SuppressWarnings("rawtypes")
			List<Command> cmds = new ArrayList<>();
			cmds.add(CommandFactory.newInsertElements(grupoList));
			cmds.add(CommandFactory.newInsertElements(atributo.getDatos()));
			cmds.add(CommandFactory.newInsert(listRecomendation, "recomendaciones"));
			cmds.add(CommandFactory.newFireAllRules());
			ExecutionResults results = kSession.execute(CommandFactory.newBatchExecution(cmds));
			System.out.println(results.getIdentifiers());
			List<Recomendation> r =  (List<Recomendation>) results.getValue("recomendaciones");
			//System.out.println(r.getActions());
			//r.getConditionRule().forEach(name -> System.out.println("conditions"+name));
			r.forEach(recomendation -> System.out.println("acciones"+recomendation.getActions()+"conditions"+recomendation.getConditionRule()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
