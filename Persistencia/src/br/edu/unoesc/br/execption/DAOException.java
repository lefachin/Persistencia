package br.edu.unoesc.br.execption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DAOException extends Exception {


	private static final long serialVersionUID = 11230120L;

	
	private String mensagem;
	private String mensagemTratada;
	private Throwable teta;


	public DAOException(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
	
	public DAOException(String mensagem, Throwable t) {
		super(mensagem, t);
		this.mensagem = mensagem;
		this.mensagemTratada = trataMensagem(t.getCause().getMessage());
		this.teta = t;
	}
	
public String trataMensagem(String mensagem){
		if (mensagem.contains("Column 'descricao' cannot be null")){
			return "Campo obrigatório deverá ser preenchido, DESCRICAO";
		}
		else{
			return "Erro";
		}
	}
	
	
	
	
	
}
