package co.com.ceiba.drools.maprulesdrools.object;

import java.util.List;

public class Atributo {
	
	private Metadato metadatos;
	private List<Dato> datos;
	public Metadato getMetadatos() {
		return metadatos;
	}
	public void setMetadatos(Metadato metadatos) {
		this.metadatos = metadatos;
	}
	public List<Dato> getDatos() {
		return datos;
	}
	public void setDatos(List<Dato> datos) {
		this.datos = datos;
	}

}
