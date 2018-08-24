package co.com.ceiba.drools.maprulesdrools.model.rule;

import com.google.gson.annotations.SerializedName;

public class Metadato {
	
	private String codigo;
	private String tema;
	private String momento;
	private String informacion;
	
	@SerializedName("obs_interna")
	private String obsInterna;
	private String autores;
	private String fechaCreacion;
	private String referencia;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getMomento() {
		return momento;
	}
	public void setMomento(String momento) {
		this.momento = momento;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public String getObsInterna() {
		return obsInterna;
	}
	public void setObsInterna(String obsInterna) {
		this.obsInterna = obsInterna;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
