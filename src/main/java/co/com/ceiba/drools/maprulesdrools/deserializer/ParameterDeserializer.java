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

import co.com.ceiba.drools.maprulesdrools.model.rule.Action;
import co.com.ceiba.drools.maprulesdrools.model.rule.Condition;
import co.com.ceiba.drools.maprulesdrools.model.rule.Parameter;

public class ParameterDeserializer implements JsonDeserializer<List<Parameter>> {

	@Override
	public List<Parameter> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		List<Parameter> parameters = new ArrayList<>();
		Gson gson = new Gson();
		String ruleCode = "";
		String conditionType = "";
		String acciones = "";
		String lastRow = "false";
		String firstRow = "true";
		JsonObject root = json.getAsJsonObject();
		
		if (root.has("metadatos")) {
			JsonObject objectMetadato = root.get("metadatos").getAsJsonObject();
			ruleCode = objectMetadato.get("codigo").getAsString();

		}
		
		if (root.has("acciones")) {
			JsonArray arrayAcciones = root.get("acciones").getAsJsonArray();
			Type listAction = new TypeToken<List<Action>>() {
			}.getType();
			acciones = convertString(gson.fromJson(arrayAcciones, listAction), ",");

		}
		
		JsonArray array;
		if (root.has("condiciones")) {
			array = root.get("condiciones").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				JsonElement condition = array.get(i);
				JsonArray conditionsArray = condition.getAsJsonArray();
				
				if(i > 0) {
					firstRow = "false";
				}
				
				if (conditionsArray.size() > 1) {
					conditionType = "Grupo";
				} else {
					conditionType = "Condicion";
				}
				
				if(i == array.size() - 1) {
					lastRow = acciones;
				}
				
				Type listRuleType = new TypeToken<List<Condition>>() {
				}.getType();
				
				parameters.add(new Parameter(ruleCode, convertString(gson.fromJson(conditionsArray, listRuleType), " && "), conditionType, lastRow, firstRow));
			}

		}
		return parameters;
	}
	
	public <T> String convertString(List<T> elementList, String separator) {
		StringBuilder statementBuilder = new StringBuilder();
		 for (Iterator<T> iterator = elementList.iterator(); iterator.hasNext();) {
			T element = iterator.next();	

			if(element instanceof Condition) {
				statementBuilder.append("Dato").append("(");
				statementBuilder.append(element.toString());
				statementBuilder.append(")");
			} else if (element instanceof Action){
				statementBuilder.append("\"");
				statementBuilder.append(element.toString());
				statementBuilder.append("\"");
			}

			if(iterator.hasNext()) {
				statementBuilder.append(separator).append("\n");
			}
		}
		return statementBuilder.toString();
	}

}
