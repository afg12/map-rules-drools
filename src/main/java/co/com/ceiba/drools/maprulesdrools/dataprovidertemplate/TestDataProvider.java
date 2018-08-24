package co.com.ceiba.drools.maprulesdrools.dataprovidertemplate;

import java.util.Iterator;
import java.util.List;

import org.drools.template.DataProvider;

import co.com.ceiba.drools.maprulesdrools.model.rule.Condicion;
import co.com.ceiba.drools.maprulesdrools.util.Constantes;

public class TestDataProvider implements DataProvider {

	private Iterator<Condicion> iterator;

	public TestDataProvider(List<Condicion> rows) {
		this.iterator = rows.iterator();
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public String[] next() {
		Condicion nextRule = iterator.next();
		return new String[] { nextRule.getObsVariable(), nextRule.getCodVariable(), nextRule.getSisVariable(),
				toString(nextRule.getOperadorValor()), nextRule.getObsValor(), nextRule.getDatValor(),
				nextRule.getSisValor(), toString(nextRule.getOperadorFecha()), nextRule.getCantidadDia() };
	}

	private String toString(String operador) {
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
			operador = "<=";
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
