package co.com.ceiba.drools.maprulesdrools.model.rule;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListaCondiciones {
	
	@SerializedName("grupo")
	private List<Grupo> grupoCondiciones = new ArrayList<>();
	
	private List<Condicion> condicion = new ArrayList<>();
	
	public List<Grupo> getGrupoCondiciones() {
		return grupoCondiciones;
	}
	public void setGrupoCondiciones(List<Grupo> grupoCondiciones) {
		this.grupoCondiciones = grupoCondiciones;
	}
	public List<Condicion> getCondicion() {
		return condicion;
	}
	public void setCondicion(List<Condicion> condicion) {
		this.condicion = condicion;
	}
	
}
