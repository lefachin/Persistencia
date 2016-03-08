package br.edu.unoesc.br;

import java.util.List;

//GenericDAO 
public interface GenericDAO<T> {

	void inserir(T entidade);
	
	void alterar(T entidade);
	
	void excluir(T entidade);
	
	T buscar(T entidade, Long id);
	
	List<Tarefa> todos();
	
}

