package co.com.ceiba.drools.maprulesdrools.object;

import java.util.List;

import co.com.ceiba.drools.maprulesdrools.model.rule.Action;
import co.com.ceiba.drools.maprulesdrools.model.rule.Condition;


public class Recomendacion {
	
//	private Metadata metadata;
//	private List<Condition> conditionRule;
	private List<String> actions;
	
	public Recomendacion(List<String> actions) {
		super();
//		this.metadata = metadata;
//		this.conditionRule = conditionRule;
		this.actions = actions;
	}
	
//	public Metadata getMetadata() {
//		return metadata;
//	}
//	public void setMetadata(Metadata metadata) {
//		this.metadata = metadata;
//	}
//	public List<Condition> getConditionRule() {
//		return conditionRule;
//	}
//	public void setConditionRule(List<Condition> conditionRule) {
//		this.conditionRule = conditionRule;
//	}
	public List<String> getActions() {
		return actions;
	}
	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	
}
