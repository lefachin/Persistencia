package br.edu.unoesc.br;

import model.Aluno;

public class MainEscola {
	
	public static void main(String[] args) {
		
		Aluno alunoPegado = (Aluno) HibernateDAO.getDAO().buscar(Aluno.class, 8L);
		
		
		
		
		alunoPegado.getEnderecos().forEach(end->{
		
			System.out.println(end.getLogradouro());
		});
		
		
		
		
//		Endereco novoend = new Endereco();
//		novoend.setLogradouro("FSDAFDAS");
//		novoend.setNumero("12345");
//		novoend.setTipo(TipoEndereco.RESIDENCIAL);
//		alunoPegado.adicionar(novoend);
//		try{
//			HibernateDAO.getDAO().salvar(alunoPegado);
//		}
//		catch(DAOException e){
//			e.getMensagemTratada();
//			
//		}
		
		
		
		
	}
	

}
