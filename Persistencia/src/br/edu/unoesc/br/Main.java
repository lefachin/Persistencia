package br.edu.unoesc.br;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
List<Tarefa> lista = HibernateDAO.getDAO().todos();		
		
lista.forEach(tarefa->{
	System.out.println(tarefa.getDescricao());
});
		
}

}
