package co.com.ceiba.drools.maprulesdrools.model.rule;

import com.google.gson.annotations.SerializedName;

public class Action {
	
	@SerializedName("tipo")
	private String type;
	
	@SerializedName("descripcion")
    private String description;
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder statementBuilder = new StringBuilder();
		
		statementBuilder.append(type).append(",").append(description);
		
		return statementBuilder.toString();
	}
}
