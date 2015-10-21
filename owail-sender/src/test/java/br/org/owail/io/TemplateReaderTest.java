package br.org.owail.io;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TemplateReaderTest {

    private static final String EXAMPLE_FILE = "templates/example.html";
    private TemplateReader templateReader;
    private HashMap<String, String> templateValues;

    @Before
    public void setUp() {
	templateReader = new TemplateReader();
	templateValues = new HashMap<String, String>();

	fillMapWithFakeData();
    }

    private void fillMapWithFakeData() {
	templateValues.put("world", "Java World");
    }

    @Test
    public void should_be_possible_open_an_archive() {
	String templateContent = templateReader.getFileToString(getClass().getClassLoader(), EXAMPLE_FILE);
	assertEquals(templateContent, "<h3>Hello {{world}}</h3>");
    }

    @Test
    public void should_be_possible_fill_the_template_with_map_values() {
	String template = templateReader.getFileToString(getClass().getClassLoader(), EXAMPLE_FILE);
	String mergeResult = templateReader.fillTemplate(templateValues, template);
	
	assertEquals(mergeResult, "<h3>Hello Java World</h3>");
    }
}
