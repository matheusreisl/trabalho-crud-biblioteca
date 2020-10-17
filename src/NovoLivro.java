

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovoCliente
 */
@WebServlet("/livro/novo")
public class NovoLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/livro-novo.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if (id.isEmpty()) {
			id = "0";
		}
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String isbn = request.getParameter("isbn");
		String preco = request.getParameter("preco");
		
		
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
		
		}
		else {
	
			Livro livro = new Livro();
			livro.setId(Integer.valueOf(id));
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setIsbn(isbn);
			livro.setPreco(Double.valueOf(preco));
			
			
			
			Banco banco = new Banco();		
			//livro.setId(banco.getTamanhoListaLivro() + 1);
			banco.salvaLivro(livro);			
			
			System.out.println("Cadastro realizado com sucesso!!!");
			request.setAttribute("sucess", "Cadastro realizado com sucesso!");
		}
	
		doGet(request, response);
	}

}
