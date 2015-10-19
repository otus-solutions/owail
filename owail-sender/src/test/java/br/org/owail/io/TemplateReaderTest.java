package br.org.owail.io;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TemplateReaderTest {
	
	private static final String EXAMPLE_FILE = "example.html";
	private TemplateReader templateReader;
	private HashMap<String, String> templateValues;
	

	@Before
	public void setUp(){
		templateReader = new TemplateReader();
		templateValues = new HashMap<>();
		
		fillMapWithFakeData();
	}

	private void fillMapWithFakeData() {
		templateValues.put("{{world}}", "Java World");
	}

	@Test
	public void should_be_possible_open_an_archive(){
		assertEquals(templateReader.getFileToString(EXAMPLE_FILE), "<h3>Hello + {{world}}</h3>");
	}
	
	@Test
	public void should_be_possible_fill_the_template_with_map_values(){
		assertEquals(templateReader.fillTemplate(templateValues, templateReader.getFileToString(EXAMPLE_FILE)), "<h3>Hello + Java World</h3>");
	}

}
