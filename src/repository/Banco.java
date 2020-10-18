package repository;
import java.util.ArrayList;
import java.util.List;
import entities.Livro;
import javax.persistence.*;

public class Banco {

	private static List<Livro> listaLivro= new ArrayList<>();
	//private static Integer codigo = 1;
	
	EntityManagerFactory factory;
	EntityManager manager;
	
	public Banco() {
		factory= Persistence.createEntityManagerFactory("c");
		manager = factory.createEntityManager();
	}

	public List<Livro> getListLivro() {
		try{
			manager.getTransaction().begin();
			Query consulta = manager.createQuery("SELECT livros FROM Livro");
			List<Livro> lista = consulta.getResultList();
			setListLivro(lista);
		}
		finally {
			emf.close();
		}
		return listLivro;
	}
	
	public static void setListLivro(List<Livro> listLivro) {
		Banco.listLivro = listLivro;
	}
	
	public void salvaLivro(Livro livros) {
		try {
			manager.getTransaction().begin();
			Livro response = manager.merge(livros);
			System.out.println(response.getId());;
			manager.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
	
	public void atualizaLivro(Livro livros) {
		try {
			manager.getTransaction().begin();
			Query delete = manager.createQuery("UPDATE livros FROM livros WHERE id = " +  livros.getId());
			delete.executeUpdate();
			manager.getTransaction().commit();
		}
		finally {
			manager.close();
		}
	}
	
	public Integer getTamanhoListaLivro() {
		return this.listLivro.size();
	}
	
	public Livro getLivroById(Integer id) {
		Livro localiza = new Livro();
		for(Livro livro : Banco.listLivro) {
			if(livro.getId() == id) {
				localiza = livro;
			}
		}
		return localiza;
	}
	
	public void deletaLivro(Integer id) {
		try {
			manager.getTransaction().begin();
			Query delete = manager.createNativeQuery("DELETE livros FROM livros WHERE id = " +  id);
			delete.executeUpdate();
			manager.getTransaction().commit();
		}
		finally {
			manager.close();
		}
	}
}
	
	
	
	
/*	
 public void salvaLivro(Livro obj) {
		if(obj.getId()>0) 
			atualizaLivro(obj);
		else {
			obj.setId(getProximoCodigo());
			listaLivro.add(obj);
		}
		
	}
	
	private void atualizaLivro(Livro obj) {
		
		for(int i = 0; i <Banco.listaLivro.size(); i++) {
			if(Banco.listaLivro.get(i).getId() == obj.getId()) {
				Banco.listaLivro.set(i, obj);
			}
		}		
	}
	
	private Integer getProximoCodigo() {
		return codigo++;
	}

	public List<Livro> getListaLivro(){
		return Banco.listaLivro;
	}
	
	public Integer getTamanhoListaLivro() {
		return Banco.listaLivro.size();
	}
	
	public Livro getLivrobyId(Integer id) {
		Livro localiza = new Livro();
		for(Livro livro: Banco.listaLivro) {
			if(livro.getId() == id) {
				localiza = livro;
			}
		}
		return localiza;
	}
	
	public void deletaLivro(Integer id) {
		for( int i = 0 ; i <= Banco.listaLivro.size(); i++) {
			if(Banco.listaLivro.get(i).getId() == id) {
				Banco.listaLivro.remove(i);
			}
		}
	}
}
*/
