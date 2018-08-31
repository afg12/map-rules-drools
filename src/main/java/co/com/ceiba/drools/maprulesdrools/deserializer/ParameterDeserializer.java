package co.com.ceiba.drools.maprulesdrools.deserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import co.com.ceiba.drools.maprulesdrools.model.rule.Condition;
import co.com.ceiba.drools.maprulesdrools.model.rule.Group;
import co.com.ceiba.drools.maprulesdrools.model.rule.Parameter;

public class ParameterDeserializer implements JsonDeserializer<List<Parameter>> {

	@Override
	public List<Parameter> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		List<Parameter> parameters = new ArrayList<>();
		Gson gson = new Gson();
		String ruleCode = "";
		String conditionType = "";
		JsonObject root = json.getAsJsonObject();
		JsonObject ruleObject = root.get("regla").getAsJsonObject();
		
		if (ruleObject.has("metadatos")) {
			JsonObject objectMetadato = ruleObject.get("metadatos").getAsJsonObject();
			ruleCode = objectMetadato.get("codigo").getAsString();

		}
		
		JsonObject object;
		JsonArray array;
		List<Class<?>> conditionsList = new ArrayList<>();
		if (ruleObject.has("condiciones")) {
			array = ruleObject.get("condiciones").getAsJsonArray();
			for (JsonElement elementCondicion : array) {
				object = elementCondicion.getAsJsonObject();
				if (object.has("grupo")) {
					array = object.get("grupo").getAsJsonArray();
					Type listRuleType = new TypeToken<List<Group>>() {
					}.getType();
					conditionsList = gson.fromJson(array, listRuleType);
					conditionType = "Grupo";
				} else if (object.has("condicion")) {
					array = object.get("condicion").getAsJsonArray();
					Type listRuleType = new TypeToken<List<Condition>>() {
					}.getType();
					conditionsList = gson.fromJson(array, listRuleType);
					conditionType = "Condicion";
				}

				parameters.add(new Parameter(ruleCode, conditionsList, conditionType));
			}

		}
		return parameters;
	}

}
