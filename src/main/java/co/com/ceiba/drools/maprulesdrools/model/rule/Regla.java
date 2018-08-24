package co.com.ceiba.drools.maprulesdrools.model.rule;

import java.util.ArrayList;
import java.util.List;

public class Regla {
	
	private Metadato metadatos;
	private List<ListaCondiciones> condiciones = new ArrayList<>();
	private List<Accion> acciones = new ArrayList<>();

	public Metadato getMetadatos() {
		return metadatos;
	}
	public void setMetadatos(Metadato metadatos) {
		this.metadatos = metadatos;
	}
	public List<Accion> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<Accion> acciones) {
		this.acciones = acciones;
	}

	public List<ListaCondiciones> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(List<ListaCondiciones> condiciones) {
		this.condiciones = condiciones;
	}

}
