package br.com.formandoideias.eao;

import javax.persistence.NoResultException;

import br.com.formandoideias.entidade.Usuario;
import br.com.formandoideias.excecao.EAOException;

public class UsuarioEAO extends AcessoEAO<Usuario>{

	
	@SuppressWarnings("unchecked")
	public Usuario perquisarUsuario(String login, String senha)throws EAOException{
		try {
			Usuario usuario = getSingleResult("usuario.pesquisaAutenticacao",
					new Parameter("login", login),
					new Parameter("senha", senha));
			return usuario;
		} catch (NoResultException e) {
			return null;
		}catch (RuntimeException ex) {
			throw new EAOException(EAOException.ERR_PROBLEMA_INESPERADO, ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Usuario pesquisarUsuario(String email)throws EAOException{
		try {
			Usuario usuario = getSingleResult("usuario.pesquisaUsuarioPorEmail", new Parameter("email", email));
			return usuario;
		} catch (NoResultException e) {
			return null;
		} catch (RuntimeException ex) {
			throw new RuntimeException(EAOException.ERR_PROBLEMA_INESPERADO, ex);
		}
	}
}
