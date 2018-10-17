package com.practice.servlet.controller;

import com.practice.servlet.helpers.MimeTypeResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

@WebServlet("/static/*")   // potrzebuje /static/*
public class Static extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = "." + req.getRequestURI();

		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(uri);

		if (url == null) {
			send404(req,resp);
		} else {
			sendFile(req, resp, url);
		}
	}

	private void send404(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write("File not found(404)");
	}

	private void sendFile(HttpServletRequest req, HttpServletResponse resp, URL url) throws IOException {
		File file = new File(url.getFile());
		MimeTypeResolver resolver = new MimeTypeResolver(file);
		String mime = resolver.getMimeType();

		resp.setContentType(mime);

		OutputStream os = resp.getOutputStream();

		FileInputStream fileInputStream = new FileInputStream(file);
		int value;
		while ((value = fileInputStream.read()) != -1) {
			os.write(value);
		}
		fileInputStream.close();
	}

}
