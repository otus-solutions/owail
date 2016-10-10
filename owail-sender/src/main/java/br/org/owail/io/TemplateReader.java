package br.org.owail.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

public class TemplateReader {

    public TemplateReader() {
	super();
    }

    public String getFileToString(ClassLoader classLoader, String fileName) {
	return openfile(classLoader.getResourceAsStream(fileName));
    }

    private String openfile(InputStream fileStream) {
	try {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
	    String line = null;
	    StringBuffer content = new StringBuffer();

	    while ((line = reader.readLine()) != null) {
		content.append(line);
	    }

	    reader.close();
	    return content.toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public String fillTemplate(Map<String, String> values, String template) {
	for (Entry<String, String> entry : values.entrySet()) {
	    template = template.replaceAll("\\{\\{" + entry.getKey() + "\\}\\}", entry.getValue());
	}
	return template;
    }

}
