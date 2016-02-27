package br.edu.unoesc.br;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Tarefa {

	@Id
	private Long id;
	private String descricao;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tarefa");
		System.out.println("FOI");
}
	
}
