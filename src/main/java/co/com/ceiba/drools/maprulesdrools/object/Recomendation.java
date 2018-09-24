package co.com.ceiba.drools.maprulesdrools.object;

import java.util.List;


public class Recomendation {
	
	private String metadata;
	private List<String> conditionRule;
	private String actions;
	
	public Recomendation(String metadata, List<String> conditionRule, String actions) {
		super();
		this.metadata = metadata;
		this.conditionRule = conditionRule;
		this.actions = actions;
	}
	
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public List<String> getConditionRule() {
		return conditionRule;
	}
	public void setConditionRule(List<String> conditionRule) {
		this.conditionRule = conditionRule;
	}
	public String getActions() {
		return actions;
	}
	public void setActions(String actions) {
		this.actions = actions;
	}

	
}
