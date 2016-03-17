package br.edu.unoesc.br;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
List<Tarefa> lista = HibernateDAO.getDAO().todos();		

//Mostra a lista de Tarefas no Banco.
lista.forEach(tarefa->{
	System.out.println(tarefa.getDescricao());
});
		
Tarefa opa = new Tarefa();
opa.setDescricao("VAMO");
opa.setId(0L);

Tarefa tar = (Tarefa) HibernateDAO.getDAO().buscar(Tarefa.class, 5L);
System.out.println(tar.getDescricao());	

List<Tarefa> lista2 = HibernateDAO.getDAO().buscar(Tarefa.class,  "teste");
lista2.forEach(tarefa->{
System.out.println(tarefa.getDescricao());
});
	
	
	
	
	

}
	
}
