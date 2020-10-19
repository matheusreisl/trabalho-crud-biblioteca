package repository;
import java.util.ArrayList;
import java.util.List;
import entities.Livro;
import javax.persistence.*;

public class Banco {

	private static List<Livro> listaLivro = new ArrayList<>();
	//private static Integer codigo = 1;
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public Banco() {
		emf= Persistence.createEntityManagerFactory("livros");
		em = emf.createEntityManager();
	}

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

	public static void setListaLivro(List<Livro> listaLivro) {
		Banco.listaLivro = listaLivro;
	}

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

	
	public Livro getLivroById(Integer id) {
		Livro localiza = new Livro();
		for(Livro livro : Banco.listaLivro) {
			if(livro.getId() == id) {
				localiza = livro;
			}
		}
		return localiza;
	}

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