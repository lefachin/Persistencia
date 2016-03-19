package br.edu.unoesc.br;

import java.util.List;

import br.edu.unoesc.br.execption.DAOException;

//GenericDAO 
public interface GenericDAO<T extends MinhaEntidade> {
	
	void salvar (T entidade) throws DAOException;
	
	void excluir(T entidade) throws DAOException;
	
	T buscar(Class<T> classe, Long id);
	
	List<T> buscar (Class<T> classe, String str);
	
	List<Tarefa> todos();
	
	List<T> listar(Class<T> classe);
}

