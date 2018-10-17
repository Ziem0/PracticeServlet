package com.practice.servlet.view;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.util.Map;

public class WebDisplay {

	public static String getHome() {
		JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/main.twig");
		JtwigModel model = JtwigModel.newModel();
		return template.render(model);
	}

	public static String getForm() {
		JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/form.twig");
		JtwigModel model = JtwigModel.newModel();
		return template.render(model);
	}

	public static String getResult(Map<String, String> data) {
		JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/result.twig");
		JtwigModel model = JtwigModel.newModel();
		String name = data.get("name");
		String pic = data.get("path");
		model.with("value", name);
		model.with("guitarist", pic);
		return template.render(model);
	}
}
