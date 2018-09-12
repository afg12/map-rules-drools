package co.com.ceiba.drools.maprulesdrools.model.rule;

import java.lang.reflect.Array;

import com.google.gson.annotations.SerializedName;

import co.com.ceiba.drools.maprulesdrools.util.Constantes;

public class Condition{
	
	@SerializedName("cod_var")
	private String codVar;
	
	@SerializedName("des_var")
	private String desVar;
	
	@SerializedName("sis_var")
    private String sisVar;
	
	@SerializedName("ope_val")
    private String opeVal;
	
	@SerializedName("cod_val")
    private Object codVal;
	
	@SerializedName("des_val")
    private String desVal;
	
	@SerializedName("sis_val")
    private String sisVal;
	
	@SerializedName("ope_fec")
    private String opeFec;
	
	@SerializedName("dias")
    private String days;
	
	private String contexto;
	
	@SerializedName("des_ctx")
	private String desCtx;
	
	public String getCodVar() {
		return codVar;
	}

	public void setCodVar(String codVar) {
		this.codVar = codVar;
	}

	public String getDesVar() {
		return desVar;
	}

	public void setDesVar(String desVar) {
		this.desVar = desVar;
	}

	public String getSisVar() {
		return sisVar;
	}

	public void setSisVar(String sisVar) {
		this.sisVar = sisVar;
	}

	public String getOpeVal() {
		return opeVal;
	}

	public void setOpeVal(String opeVal) {
		this.opeVal = opeVal;
	}

	public Object getCodVal() {
		return codVal;
	}

	public void setCodVal(Object codVal) {
		this.codVal = codVal;
	}

	public String getDesVal() {
		return desVal;
	}

	public void setDesVal(String desVal) {
		this.desVal = desVal;
	}

	public String getSisVal() {
		return sisVal;
	}

	public void setSisVal(String sisVal) {
		this.sisVal = sisVal;
	}

	public String getOpeFec() {
		return opeFec;
	}

	public void setOpeFec(String opeFec) {
		this.opeFec = opeFec;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getDesCtx() {
		return desCtx;
	}

	public void setDesCtx(String desCtx) {
		this.desCtx = desCtx;
	}

	@Override
	public String toString() {
		StringBuilder statementBuilder = new StringBuilder();
		//codigo_variable
		statementBuilder.append("codigoVar").append(" == ");
		statementBuilder.append("'").append(codVar).append("'").append(",");
		
		//sistema_variable
		statementBuilder.append("sistemaVar").append(" == ");
		statementBuilder.append("'").append(sisVar).append("'").append(",");
		
		//dato_valor
		if (codVal instanceof Array) {
			statementBuilder.append("codigoVal").append(" ").append(getValue(opeVal)).append(" (").append(codVal).append(") ").append(",");
        } else {
        	statementBuilder.append("codigoVal").append(" ").append(getValue(opeVal)).append(" ");
        	statementBuilder.append("'").append(codVal).append("'").append(",");
        }
		//sistema_valor
		statementBuilder.append("sistemaVal").append(" == ");
		statementBuilder.append("'").append(sisVal).append("'").append(",");
		
		//contexto
		statementBuilder.append("contexto").append(" contains ");
		statementBuilder.append("'").append(contexto).append("'");
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
			operador = "in";
			break;
		default:
			break;
		}
		return operador;
	}
}
