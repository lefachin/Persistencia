package br.edu.unoesc.br;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="descricao")

@NamedQueries({
	@NamedQuery(name=Tarefa.FILTRA_POR_DESCRICAO, 
			query="from Tarefa a where upper(a.descricao) like ?")
})

public class Tarefa implements MinhaEntidade{
	
	public static final String FILTRA_POR_DESCRICAO = "FILTRA_POR_DESCRICAO";


	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;

	@Override
	public Long getCodigo(){
		return id;
	}
}
