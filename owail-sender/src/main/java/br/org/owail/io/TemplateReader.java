package br.org.owail.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class TemplateReader {

	private static String TEMPLATE_PATH = "src/main/resources/templates/";
	private StringBuilder stringFile;

	public TemplateReader() {
		super();
		stringFile = new StringBuilder();
	}

	public String getFileToString(String fileName) {
		Stream<String> lines = openfile(fileName);
		lines.forEach(line -> stringFile.append(line));
		return stringFile.toString();
	}

	private Stream<String> openfile(String fileName) {
		try {
			Stream<String> lines = Files.lines(Paths.get(TEMPLATE_PATH + fileName));
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String fillTemplate(HashMap<String,String> values, String template) {
		String aux = "";
		for (String key : values.keySet()) {
			aux = template.replace(key, values.get(key));
			template = aux;
		}
		return template;
	}

}
