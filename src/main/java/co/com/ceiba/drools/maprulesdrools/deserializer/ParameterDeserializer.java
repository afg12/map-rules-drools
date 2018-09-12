package co.com.ceiba.drools.maprulesdrools.deserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import co.com.ceiba.drools.maprulesdrools.model.rule.Condition;
import co.com.ceiba.drools.maprulesdrools.model.rule.Parameter;

public class ParameterDeserializer implements JsonDeserializer<List<Parameter>> {

	@Override
	public List<Parameter> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		List<Parameter> parameters = new ArrayList<>();
		Gson gson = new Gson();
		String ruleCode = "";
		String conditionType = "";
		JsonObject root = json.getAsJsonObject();
		
		if (root.has("metadatos")) {
			JsonObject objectMetadato = root.get("metadatos").getAsJsonObject();
			ruleCode = objectMetadato.get("codigo").getAsString();

		}
		
		JsonArray array;
		List<Condition> conditionsList;
		if (root.has("condiciones")) {
			array = root.get("condiciones").getAsJsonArray();
			for (JsonElement elementCondicion : array) {
				JsonArray conditionsArray = elementCondicion.getAsJsonArray();
				if (conditionsArray.size() > 1) {
					conditionType = "Grupo";
				} else {
					conditionType = "Condicion";
				}
				Type listRuleType = new TypeToken<List<Condition>>() {
				}.getType();
				
				conditionsList = gson.fromJson(conditionsArray, listRuleType);
				parameters.add(new Parameter(ruleCode, convertString(conditionsList), conditionType));
			}

		}
		return parameters;
	}
	
	public String convertString(List<Condition> conditionsList) {
		StringBuilder statementBuilder = new StringBuilder();
		 for (Iterator<Condition> iterator = conditionsList.iterator(); iterator.hasNext();) {
			Condition conditionElement = iterator.next();	
			statementBuilder.append("Dato").append("(");
			statementBuilder.append(conditionElement.toString());
			statementBuilder.append(")");
			if(iterator.hasNext()) {
				statementBuilder.append(" && ");
			}
		}
		return statementBuilder.toString();
	}

}
