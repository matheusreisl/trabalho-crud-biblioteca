package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Livro;
import repository.Banco;

//Cria��o de classe para listar todos os livros na base de dados
@WebServlet("/livro/lista")
public class ListaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciando o banco
		Banco banco = new Banco();
		//Salvando na lista todos os livros dentro do banco
		List<Livro> lista = banco.getListaLivro();
		
		for (Livro livro: lista) {
			System.out.println(livro.getId() + " - " + livro.getTitulo());
		}
		
		request.setAttribute("livros", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/livro-lista.jsp");
		rd.forward(request, response);
	}

}
