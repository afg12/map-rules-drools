package co.com.ceiba.drools.maprulesdrools.model.rule;

import java.lang.reflect.Array;

import com.google.gson.annotations.SerializedName;

import co.com.ceiba.drools.maprulesdrools.util.Constantes;

public class Condition{
	
	@SerializedName("obs_variable")
	private String obsVariable;
	
	@SerializedName("cod_variable")
	private String codVariable;
	
	@SerializedName("sis_variable")
    private String sisVariable;
	
	@SerializedName("operador_valor")
    private String operatorValue;
	
	@SerializedName("obs_valor")
    private String obsValue;
	
	@SerializedName("dat_valor")
    private Object datValue;
	
	@SerializedName("sis_valor")
    private String sisValue;
	
	@SerializedName("operador_fecha")
    private String operatorDate;
	
	@SerializedName("cantidad_dia")
    private String amountDay;
    
	public String getObsVariable() {
		return obsVariable;
	}
	public void setObsVariable(String obsVariable) {
		this.obsVariable = obsVariable;
	}
	public String getCodVariable() {
		return codVariable;
	}
	public void setCodVariable(String codVariable) {
		this.codVariable = codVariable;
	}
	public String getSisVariable() {
		return sisVariable;
	}
	public void setSisVariable(String sisVariable) {
		this.sisVariable = sisVariable;
	}
	public String getOperatorValue() {
		return operatorValue;
	}
	public void setOperatorValue(String operatorValue) {
		this.operatorValue = operatorValue;
	}
	public String getObsValue() {
		return obsValue;
	}
	public void setObsValue(String obsValue) {
		this.obsValue = obsValue;
	}
	public Object getDatValue() {
		return datValue;
	}
	public void setDatValue(Object datValue) {
		this.datValue = datValue;
	}
	public String getSisValue() {
		return sisValue;
	}
	public void setSisValue(String sisValue) {
		this.sisValue = sisValue;
	}
	public String getOperatorDate() {
		return operatorDate;
	}
	public void setOperatorDate(String operatorDate) {
		this.operatorDate = operatorDate;
	}
	public String getAmountDay() {
		return amountDay;
	}
	public void setAmountDay(String amountDay) {
		this.amountDay = amountDay;
	}
	
	@Override
	public String toString() {
		StringBuilder statementBuilder = new StringBuilder();
		//codigo_variable
		statementBuilder.append("codigo_variable").append(" == ");
		statementBuilder.append("'").append(codVariable).append("'").append(" && ");
		
		//sistema_variable
		statementBuilder.append("sistema_variable").append(" == ");
		statementBuilder.append("'").append(sisVariable).append("'").append(" && ");
		
		//dato_valor
		if (datValue instanceof Array) {
			statementBuilder.append(datValue).append(" ").append(getValue(operatorValue)).append(" ").append("dato_valor");
        } else {
        	statementBuilder.append("dato_valor").append(" ").append(getValue(operatorValue)).append(" ");
        	statementBuilder.append("'").append(datValue).append("'");
        }
		statementBuilder.append(" && ");
		//sistema_valor
		statementBuilder.append("sistema_valor").append(" == ");
		statementBuilder.append("'").append(sisValue).append("'");
		return statementBuilder.toString();
		
	}
	
	private String getValue(String operador) {
		switch (operador) {
		case Constantes.IGUAL:
			operador = "==";
			break;
		case Constantes.MAYOR:
			operador = ">";
			break;
		case Constantes.MAYOR_IGUAL:
			operador = ">=";
			break;
		case Constantes.MENOR:
			operador = "<";
			break;
		case Constantes.MENOR_IGUAL:
			operador = "<=";
			break;
		case Constantes.NO_TENGA_MENOR:
			operador = " <= ";
			break;
		case Constantes.NO_TENGA_MAYOR:
			operador = "<=";
			break;
		case Constantes.GRUPO:
			operador = "contains";
			break;
		default:
			break;
		}
		return operador;
	}
}
