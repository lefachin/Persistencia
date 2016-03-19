package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unoesc.br.MinhaEntidade;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString(of={"codigo","descricao"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="descricao")
@Entity
public class Formacao implements MinhaEntidade{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	@Column(nullable=false, unique=true)
	private String descricao;

}
