package br.edu.unoesc.br;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.edu.unoesc.br.execption.DAOException;

public class HibernateDAO<T extends MinhaEntidade> implements GenericDAO<T>{
	
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


public void finaliza(){
	this.em.close();
	this.factory.close();
}


public void salvar (T entidade) throws DAOException{
	conecta();
	try{
		this.et.begin();
		
		if (entidade.getCodigo() == null){
			this.em.persist(entidade);
		}
		else {
			this.em.merge(entidade);	
		}
		this.et.commit();
		}
		catch(PersistenceException E){
			if (et.isActive()){
				et.rollback();
			}
			throw new DAOException("Erro ao Salvar", E.getCause());
		}
		finally {
			this.em.close();
			this.factory.close();
		}
	
}


//Exclui a entidade, mas esse nao funciona, nao sei o por que.
@Override
public void excluir(T entidade) throws DAOException{
	conecta();
	try{
		this.et.begin();
		
		Object opa = em.find(entidade.getClass(), entidade.getCodigo());
		em.remove(opa);
	}

		catch(PersistenceException E){
			if (et.isActive()){
				et.rollback();
			}
			throw new DAOException("Erro ao Salvar", E.getCause());
		}
		finally {
			this.em.close();
			this.factory.close();
		}
}

//Retorna com base no ID o objeto do banco, funciona com Tarefa.
@Override
public T buscar(Class<T> classe, Long id) {	
	conecta();
	try{
		return em.find(classe, id);
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
    try{
    	return em.createQuery("FROM " + Tarefa.class.getName()).getResultList();	
    }
    finally{
    	this.finaliza();
    }
	
    
}

@Override
public List<T> buscar(Class<T> classe, String str) {
	conecta();
	try{
		String hql = "from "+classe.getName()+" a where upper(a.descricao) like ?";
		TypedQuery<T> query = em.createQuery(hql, classe);
		query.setParameter(1, "%"+str.toUpperCase()+"%");
		return query.getResultList();	
	}
	finally{
		this.finaliza();
	}
}





}





