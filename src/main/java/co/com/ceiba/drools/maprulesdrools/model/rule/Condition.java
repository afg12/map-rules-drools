package co.com.ceiba.drools.maprulesdrools.model.rule;

import com.google.gson.annotations.SerializedName;

import co.com.ceiba.drools.maprulesdrools.util.Constantes;

public class Condition{
	
	@SerializedName("obs_variable")
	private String obsVariable;
	
	@SerializedName("cod_variable")
	private String codVariable;
	
	@SerializedName("sis_variable")
    private Object sisVariable;
	
	@SerializedName("operador_valor")
    private String operatorValue;
	
	@SerializedName("obs_valor")
    private String obsValue;
	
	@SerializedName("dat_valor")
    private String datValue;
	
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
	public Object getSisVariable() {
		return sisVariable;
	}
	public void setSisVariable(Object sisVariable) {
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
	public String getDatValue() {
		return datValue;
	}
	public void setDatValue(String datValue) {
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
		statementBuilder.append(codVariable).append(" ").append(getValue(operatorValue)).append(" ");
		
		if (sisVariable instanceof String) {
            statementBuilder.append("'").append(sisVariable).append("'");
        } else {
            statementBuilder.append(sisVariable);
        }
		statementBuilder.append(" && ");
		statementBuilder.append(datValue).append(" ").append("==").append(" ").append(sisValue);
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
		default:
			break;
		}
		return operador;
	}
}
