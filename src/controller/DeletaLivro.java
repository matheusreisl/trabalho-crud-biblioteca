package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.Banco;

//Cria��o da classe para deletar um livro
@WebServlet("/livro/deletar")
public class DeletaLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//Instanciando o banco
		Banco banco = new Banco();
		//Deletando o livro com o id puxado
		banco.deletaLivro(Integer.valueOf(id));
	}

}
