package repository;
import java.util.ArrayList;
import java.util.List;
import entities.Livro;
import javax.persistence.*;

//Criação da classe Banco
public class Banco {

	private static List<Livro> listaLivro = new ArrayList<>();
	//private static Integer codigo = 1;
	
	//Instanciando o criador de entidade
	EntityManagerFactory emf;
	//Instanciando o editor de entidade
	EntityManager em;
	
	public Banco() {
		emf= Persistence.createEntityManagerFactory("livros");
		em = emf.createEntityManager();
	}
	
	//Puxando do banco todos os livros salvos
	public List<Livro> getListaLivro() {
		try{
			em.getTransaction().begin();
			Query consulta = em.createQuery("SELECT livro FROM Livro livro");
			List<Livro> lista = consulta.getResultList();
			setListaLivro(lista);
		}
		finally {
			emf.close();
		}
		return listaLivro;
	}
	
	//Definindo a lista de livros
	public static void setListaLivro(List<Livro> listaLivro) {
		Banco.listaLivro = listaLivro;
	}
	
	//Salvando o livro no banco
	public void salvaLivro(Livro livro) {
		try {
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
		}
		finally {
			emf.close();
		}
	}
	
	//Atualizando o livro no banco
	public void atualizaLivro(Livro livro) {
		try {
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	} 

	//Buscando livro no banco pelo id
	public Livro getLivroById(Integer id) {
		Livro localiza = new Livro();
		for(Livro livro : Banco.listaLivro) {
			if(livro.getId() == id) {
				localiza = livro;
			}
		}
		return localiza;
	}

	//Deletando livro no banco
	public void deletaLivro(Integer id) {
		try {	
			Livro livroEncontrado = em.find(Livro.class, id);  
			em.getTransaction().begin();
			em.remove(livroEncontrado);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}
	
	
}