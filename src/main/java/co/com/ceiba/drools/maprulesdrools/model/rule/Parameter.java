package co.com.ceiba.drools.maprulesdrools.model.rule;

public class Parameter {
	
	private String codeRule;
	private String conditionsList;
	private String conditionType;
	
	public Parameter(String codeRule, String conditionsList, String conditionType) {
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
	public String getConditionsList() {
		return conditionsList;
	}
	public void setConditionsList(String conditionsList) {
		this.conditionsList = conditionsList;
	}
	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	
}
