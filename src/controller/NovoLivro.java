package controller;

import java.io.IOException;
import java.util.ArrayList;
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


@WebServlet("/livro/novo")
public class NovoLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/livro-novo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		/*String id = request.getParameter("id");
		if (id.isEmpty()) {
			id = "0";
		}*/
		
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String isbn = request.getParameter("isbn");
		String preco = request.getParameter("preco");
		boolean novoCadastro = true;
		
		List<String> mensagens  = new ArrayList<String>();
		
		if (titulo.isEmpty()) 
			mensagens.add("Campo titulo é obrigatório!");
		if (autor.isEmpty()) 
			mensagens.add("Campo autor é obrigatório!");
		if (isbn.isEmpty()) 
			mensagens.add("Campo isbn é obrigatório!");
		if (preco.isEmpty()) 
			mensagens.add("Campo preco é obrigatório!");
		
		if( mensagens.size() > 0 ) {
			request.setAttribute("mensagens", mensagens);
			request.setAttribute("id", id);
			request.setAttribute("titulo", titulo);
			request.setAttribute("autor", autor);
			request.setAttribute("isbn", isbn);
			request.setAttribute("preco", preco);
		
		} else {					
			Banco banco = new Banco();
			Livro livro = new Livro();
			
			//livro.setId(Integer.valueOf(id));
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setIsbn(isbn);
			livro.setPreco(Double.valueOf(preco));
			
			if(!id.isEmpty()) {
				livro.setId(Integer.parseInt(id));
				novoCadastro = false;
				banco.atualizaLivro(livro);
			}else {
				banco.salvaLivro(livro);
			}
			
			request.setAttribute("sucess", novoCadastro ? "Cadastro realizado com sucesso!":"Atualização realizada com sucesso!" );
		}
	
		doGet(request, response);
	}

}
