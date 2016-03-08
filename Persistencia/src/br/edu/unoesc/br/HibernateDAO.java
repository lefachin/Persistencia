package br.edu.unoesc.br;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateDAO<T> implements GenericDAO<T>{
	
	public EntityManagerFactory factory;
	public EntityManager em;
	public EntityTransaction et;
	private static HibernateDAO hb;
	
public void conecta(){
	this.factory = Persistence.createEntityManagerFactory("Tarefa");
	this.em = this.factory.createEntityManager();
	this.et = this.em.getTransaction();
}

public static HibernateDAO getDAO(){
	if (hb == null){
		hb = new HibernateDAO();
	}
	return hb;
}

	
@Override
public void inserir(Object entidade) {
conecta();
	try{
		this.et.begin();
		this.em.persist(entidade);
		this.et.commit();
		System.out.println("SALVO");
		}
		catch(Exception E){
			this.et.rollback();
			System.out.println("ERRO");
		}
		finally {
			this.em.close();
			this.factory.close();
		}
}

@Override
public void alterar(Object entidade) {
	conecta();
	try{
		this.et.begin();
		this.em.merge(entidade);
		this.et.commit();
		System.out.println("SALVO");
		}
		catch(Exception E){
			this.et.rollback();
			System.out.println("ERRO");
		}
		finally {
			this.em.close();
			this.factory.close();
		}
	
}

@Override
public void excluir(Object entidade) {
	conecta();
	try{
		this.et.begin();
		
		this.em.remove(entidade);
		this.et.commit();
		System.out.println("SALVO");
		}
		catch(Exception E){
			this.et.rollback();
			System.out.println("ERRO");
		}
		finally {
			this.em.close();
			this.factory.close();
		}
	
}

@Override
public Object buscar(Object entidade, Long id) {	
	conecta();
	try{
		this.et.begin();
		Object ojb = this.em.find(entidade.getClass(), id);
		this.et.commit();
		return ojb;
		}
		catch(Exception E){
			this.et.rollback();
			System.out.println("ERRO BUSCAR");
			return null;
		}
		finally {
			this.em.close();
			this.factory.close();
		}
}

@Override
public List<Tarefa> todos() {
	this.conecta();
    return em.createQuery("FROM " + Tarefa.class.getName()).getResultList();	
}
}