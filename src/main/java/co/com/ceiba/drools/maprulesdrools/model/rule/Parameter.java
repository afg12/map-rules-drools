package co.com.ceiba.drools.maprulesdrools.model.rule;

public class Parameter {
	
	private String codeRule;
	private String conditionsList;
	private String conditionType;
	private String actions;
	private String firstRow;
	
	public Parameter(String codeRule, String conditionsList, String conditionType, String actions, String firstRow) {
		super();
		this.codeRule = codeRule;
		this.conditionsList = conditionsList;
		this.conditionType = conditionType;
		this.actions = actions;
		this.firstRow = firstRow;
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

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(String firstRow) {
		this.firstRow = firstRow;
	}
	
}
