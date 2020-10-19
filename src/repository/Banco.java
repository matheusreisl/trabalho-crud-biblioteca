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
			Livro response = em.merge(livro);
			System.out.println(response.getId());;
			em.getTransaction().commit();
		}
		finally {
			emf.close();
		}
	}
	
	public void atualizaLivro(Livro livro) {
		try {
			em.getTransaction().begin();
			Query delete = em.createQuery("UPDATE livro FROM livro WHERE id = " +  livro.getId());
			delete.executeUpdate();
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	} 
	
	public Integer getTamanhoListaLivro() {
		return this.listaLivro.size();
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
			em.getTransaction().begin();
			Query delete = em.createNativeQuery("DELETE livro FROM livro WHERE id = " +  id);
			delete.executeUpdate();
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}
	
	
}