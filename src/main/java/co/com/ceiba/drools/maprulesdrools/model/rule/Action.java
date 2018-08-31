package co.com.ceiba.drools.maprulesdrools.model.rule;

public class Action {
	
	private String type;
    private String observation;
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public String toString() {
		StringBuilder statementBuilder = new StringBuilder();
		
		statementBuilder.append(type).append(observation);
		
		return statementBuilder.toString();
	}
}
