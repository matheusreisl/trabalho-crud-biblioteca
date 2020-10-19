package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Livro;
import repository.Banco;

//Criação da classe para editar um livro
@WebServlet("/livro/editar")
public class EditaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//Instanciando o banco
		Banco banco = new Banco();
		//Recebendo os dados do livro - identificado pelo id
		Livro livro = banco.getLivroById(Integer.valueOf(id));
		//Editando os atributos do livro
		request.setAttribute("id", livro.getId());
		request.setAttribute("titulo", livro.getTitulo());
		request.setAttribute("autor", livro.getAutor());
		request.setAttribute("isbn", livro.getIsbn());
		request.setAttribute("preco", livro.getPreco());
		
		RequestDispatcher rd = request.getRequestDispatcher("/livro-novo.jsp");
		rd.forward(request, response);
	}

}
