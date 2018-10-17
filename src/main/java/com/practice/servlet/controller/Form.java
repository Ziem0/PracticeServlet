package com.practice.servlet.controller;

import com.practice.servlet.model.InputHandler;
import com.practice.servlet.view.WebDisplay;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/form")
public class Form extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getQueryString() != null) {
			dataHandler(resp, req.getQueryString());
		} else {
			resp.getWriter().write(WebDisplay.getForm());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletInputStream inputStream = req.getInputStream();
		String data = IOUtils.toString(inputStream);

		dataHandler(resp, data);
	}

	private void dataHandler(HttpServletResponse resp, String queryString) throws IOException {
		Map<String, String> kv = parseQuery(queryString);

		String name = kv.get("name");
		String last = kv.get("last");
		String date = kv.get("birthday");

		InputHandler ih = new InputHandler(name, last, date);

		resp.getWriter().write(WebDisplay.getResult(ih.calculateGuitaristData()));
	}

	private Map<String, String> parseQuery(String query) {
		Map<String, String> parsedQuery = new HashMap<>();
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			String value = URLDecoder.decode(kv[1]);
			parsedQuery.put(kv[0], value);
		}
		return parsedQuery;
	}
}
