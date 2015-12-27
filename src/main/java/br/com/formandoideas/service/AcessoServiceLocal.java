package br.com.formandoideas.service;

import javax.ejb.Local;

import br.com.formandoideias.entidade.Usuario;
import br.com.formandoideias.excecao.NegocioException;

@Local
public interface AcessoServiceLocal {

	/**
	 * Método responsável por pesquisar o registro de
	 * usuário como parametro o usuário e a senha.
	 * @param usuario
	 * @param senha
	 * @return
	 * @throws NegocioException
	 */
	Usuario autenticar(String usuario, String senha)throws NegocioException;

	
}
