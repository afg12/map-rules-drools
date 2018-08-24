package co.com.ceiba.drools.maprulesdrools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.assertj.core.util.Files;
import org.drools.compiler.lang.DrlDumper;
import org.drools.compiler.lang.api.DescrFactory;
import org.drools.compiler.lang.descr.PackageDescr;
import org.drools.template.DataProviderCompiler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import co.com.ceiba.drools.maprulesdrools.dataprovidertemplate.TestDataProvider;
import co.com.ceiba.drools.maprulesdrools.model.rule.Condicion;
import co.com.ceiba.drools.maprulesdrools.model.rule.Objeto;
import co.com.ceiba.drools.maprulesdrools.util.JSONConverter;

@SpringBootApplication
public class MapRulesDroolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapRulesDroolsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			try {
				Objeto objeto = JSONConverter.convertObject("src/main/resources/rule.json");

				List<Condicion> listCondicion = objeto.getRegla().getCondiciones().get(0).getGrupoCondiciones().get(0)
						.getCondicion();

				//generar drl con template
				String drl = testCompiler(listCondicion);
				
				//generar drl con DrlDumper
				String drlDumper = dumperCompiler(listCondicion);
			
				// se crea el archivo drl
				crearDrl(drlDumper);

			} catch (Exception e) {
				System.out.println("Error ar generar drl");
			}
		};
	}

	private String dumperCompiler(List<Condicion> listCondicion) {
		
		StringBuilder condicion = new StringBuilder();
		condicion.append(listCondicion.get(0).getObsVariable()).append(listCondicion.get(0).getOperadorValor()).append(listCondicion.get(0).getObsValor());
		PackageDescr pkg = DescrFactory.newPackage()
                .name("org.drools.example")
                .newRule().name("Xyz")
                    .attribute("ruleflow-grou","bla")
                .lhs()
                    .and()
                        .pattern("Pattern").id( "$p", false ).constraint(condicion.toString()).constraint("x>y").end()
                        .not().pattern("Bar").constraint("a+b==c").end().end()
                    .end()
                .end()
                .rhs( "System.out.println();" ).end()
                .getDescr();
		DrlDumper dumper=new DrlDumper();
		String drl=dumper.dump(pkg);
		System.out.print(drl);
		return drl;
	}

	private String testCompiler(List<Condicion> listCondicion) {
		TestDataProvider tdp = new TestDataProvider(listCondicion);
		final DataProviderCompiler converter = new DataProviderCompiler();
		InputStream template = getTemplate();
		final String drl = converter.compile(tdp, template);
		System.out.println(drl);
		return drl;
	}

	private static void crearDrl(String drl) throws IOException {
		// create new file
		File file = new File("src/main/resources/test.drl");

		if (file.exists()) {
			Files.delete(file);
		}

		if (file.createNewFile()) {
			try (FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
				bufferedWriter.write(drl);
				// close connection
				System.out.println("Archivo creado");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private static InputStream getTemplate() {
		return MapRulesDroolsApplication.class.getResourceAsStream("rule-template.drt");
	}

}
