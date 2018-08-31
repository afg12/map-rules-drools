package co.com.ceiba.drools.maprulesdrools.enumeration;

public enum Operator {
    EQUAL_TO("igual", "=="),
    GREATER_THAN("mayor", ">"),
    LESS_THAN("menor", "<"),
    GREATER_THAN_OR_EQUAL_TO("mayor_igual", ">="),
    LESS_THAN_OR_EQUAL_TO("menor_igual", "<=");
	
	private String name;
	private String value;
	
	private Operator(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String toString(Operator operator) {
		return operator.getValue();
	}

}