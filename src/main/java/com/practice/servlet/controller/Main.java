package com.practice.servlet.controller;

import com.practice.servlet.view.WebDisplay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/home"})
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(WebDisplay.getHome());
	}
}


/**
 * What type of guitarist are you?
 * main page with welcome screen and description about application
 * form page with inputs {name, lastName, birthday} -> it must give first possible number from 1 to 9.
 * result page
 *
 *check redirect -> ownAnnotation
 * maybe only 2 servlets: main and static. Main could have many webDisplay based on url
 * rather one servlet for one page and figure out how to redirect -> check if /* works
 */