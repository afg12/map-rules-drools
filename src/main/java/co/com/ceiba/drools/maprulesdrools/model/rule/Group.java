package co.com.ceiba.drools.maprulesdrools.model.rule;

import java.util.Iterator;
import java.util.List;

public class Group {
	
	private List<Condition> condition;

	public List<Condition> getCondition() {
		return condition;
	}

	public void setCondition(List<Condition> condition) {
		this.condition = condition;
	}
	
	@Override
	public String toString() {
		 StringBuilder statementBuilder = new StringBuilder();
		 for (Iterator<Condition> iterator = condition.iterator(); iterator.hasNext();) {
			Condition conditionElement = iterator.next();	
			statementBuilder.append(conditionElement.toString());
			if(iterator.hasNext()) {
				statementBuilder.append(" && ");
			}
		}
		 
		 return statementBuilder.toString();
		
	}

}
