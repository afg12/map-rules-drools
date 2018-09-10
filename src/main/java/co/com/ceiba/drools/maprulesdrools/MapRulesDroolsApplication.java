package co.com.ceiba.drools.maprulesdrools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.assertj.core.util.Files;
import org.drools.template.ObjectDataCompiler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import co.com.ceiba.drools.maprulesdrools.model.rule.Parameter;
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
				List<Parameter> parameters = JSONConverter.run("src/main/resources/rule.json");
				ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
				String drl = objectDataCompiler.compile(parameters, getTemplate());
				System.out.println(drl);
				
				// se crea el archivo drl
				createDrlFile(drl);

			} catch (Exception e) {
				System.out.println("An error ocurred while generating the DRL");
			}
		};
	}

	private static void createDrlFile(String drl) throws IOException {
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
				System.out.println("File created");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private static InputStream getTemplate() {
		return MapRulesDroolsApplication.class.getResourceAsStream("rule-template.drt");
	}

}
