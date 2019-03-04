package br.com.eric.maven.webstore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.eric.maven.Product;

@WebServlet(urlPatterns={"/contato"})
public class ContactServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product("", 0);
		PrintWriter writer = resp.getWriter();
		writer.print("<html><h2> Fale conosco! </h2></html>");
		writer.close();
	}
	
}
