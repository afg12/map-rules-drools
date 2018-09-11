package co.com.ceiba.drools.maprulesdrools.object;

import com.google.gson.annotations.SerializedName;

public class Dato {
	
	@SerializedName("codigo_var")
	private String codigoVar;
	
	@SerializedName("sistema_var")
	private String sistemaVar;
	
	@SerializedName("codigo_val")
	private String codigoVal;
	
	@SerializedName("sistema_val")
	private String sistemaVal;
	private String grupo;
	private String contexto;
	private String fecha;
	private String dias;
	
	
	public Dato(String codigoVar, String sistemaVar, String codigoVal, String sistemaVal, String grupo, String contexto,
			String fecha, String dias) {
		super();
		this.codigoVar = codigoVar;
		this.sistemaVar = sistemaVar;
		this.codigoVal = codigoVal;
		this.sistemaVal = sistemaVal;
		this.grupo = grupo;
		this.contexto = contexto;
		this.fecha = fecha;
		this.dias = dias;
	}
	
	public String getCodigoVar() {
		return codigoVar;
	}
	public void setCodigoVar(String codigoVar) {
		this.codigoVar = codigoVar;
	}
	public String getSistemaVar() {
		return sistemaVar;
	}
	public void setSistemaVar(String sistemaVar) {
		this.sistemaVar = sistemaVar;
	}
	public String getCodigoVal() {
		return codigoVal;
	}
	public void setCodigoVal(String codigoVal) {
		this.codigoVal = codigoVal;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getContexto() {
		return contexto;
	}
	public void setContexto(String contexto) {
		this.contexto = contexto;
	}
	public String getSistemaVal() {
		return sistemaVal;
	}
	public void setSistemaVal(String sistemaVal) {
		this.sistemaVal = sistemaVal;
	}

}
