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

System.out.println("Busca pela classe e codigo:");
Tarefa tar = (Tarefa) HibernateDAO.getDAO().buscar(Tarefa.class, 5L);
System.out.println(tar.getDescricao());	

System.out.println("Lista buscando a descricao '123'");
List<Tarefa> lista2 = HibernateDAO.getDAO().buscar(Tarefa.class,  "123");
lista2.forEach(tarefa->{
System.out.println(tarefa.getDescricao());
});

List<Tarefa> lista3 = HibernateDAO.getDAO().listar(Tarefa.class);
lista3.forEach(tarefa->{
	System.out.println("ID: "+tarefa.getCodigo()+
			" descricao: "+tarefa.getDescricao());
});
	
	
	
	
	

}
	
}
