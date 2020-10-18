package controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Livro;
import repository.Banco;

/**
 * Servlet implementation class ListaCliente
 */
@WebServlet("/livro/lista")
public class ListaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Livro> lista = banco.getListaLivro();
		
		for (Livro livro: lista) {
			System.out.println(livro.getId() + " - " + livro.getTitulo());
		}
		
		request.setAttribute("livros", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/livro-lista.jsp");
		rd.forward(request, response);
	}

}
