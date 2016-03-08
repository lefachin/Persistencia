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
	
	//Conecta com o Hibernate
public void conecta(){
	this.factory = Persistence.createEntityManagerFactory("Tarefa");
	this.em = this.factory.createEntityManager();
	this.et = this.em.getTransaction();
}

//Retorna a propria instancia
public static HibernateDAO getDAO(){
	if (hb == null){
		hb = new HibernateDAO();
	}
	return hb;
}

	//Insere qualquer unidade, tem que testar com outras unidades, com Tarefa funciona
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

//Altera qualquer unidade, tem que testar com outras unidades, com Tarefa funciona.
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

//Exclui a entidade, mas esse nao funciona, nao sei o por que.
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

//Retorna com base no ID o objeto do banco, funciona com Tarefa.
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

//Retorna todas as Tarefas.
@Override
public List<Tarefa> todos() {
	this.conecta();
    return em.createQuery("FROM " + Tarefa.class.getName()).getResultList();	
}
}