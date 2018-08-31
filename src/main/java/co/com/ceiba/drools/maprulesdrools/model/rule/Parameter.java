package co.com.ceiba.drools.maprulesdrools.model.rule;

import java.util.List;

public class Parameter {
	
	private String codeRule;
	private List<Class<?>> conditionsList;
	private String conditionType;
	
	public Parameter(String codeRule, List<Class<?>> conditionsList, String conditionType) {
		super();
		this.codeRule = codeRule;
		this.conditionsList = conditionsList;
		this.conditionType = conditionType;
	}
	
	public String getCodeRule() {
		return codeRule;
	}
	public void setCodeRule(String codeRule) {
		this.codeRule = codeRule;
	}
	public List<Class<?>> getConditionsList() {
		return conditionsList;
	}
	public void setConditionsList(List<Class<?>> conditionsList) {
		this.conditionsList = conditionsList;
	}
	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	
}
