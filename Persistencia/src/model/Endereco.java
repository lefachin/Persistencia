package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.unoesc.br.MinhaEntidade;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of={"logradouro","numero"})
@EqualsAndHashCode(of={"codigo"})
@Entity
public class Endereco implements MinhaEntidade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable=true)
	private String logradouro;
	@Column(nullable=true)
	private String numero;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipo;
	
	//Associacao
	@ManyToOne(optional = false, targetEntity=Aluno.class)
	private Aluno aluno;

}
