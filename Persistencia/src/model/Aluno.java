package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.unoesc.br.MinhaEntidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aluno implements MinhaEntidade{
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long codigo;
private String nome;
@Temporal(TemporalType.TIMESTAMP)
private Date data;

@ManyToOne(optional = true, fetch = FetchType.EAGER)
private Formacao formacao;



@OneToMany(mappedBy="aluno",targetEntity=Endereco.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
private List<Endereco> enderecos = new ArrayList<>();

public void adicionar(Endereco endereco){
	endereco.setAluno(this);
	this.enderecos.add(endereco);
}

}
