package br.com.formandoideias.negocio;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.formandoideas.service.AcessoServiceLocal;
import br.com.formandoideias.eao.UsuarioEAO;
import br.com.formandoideias.entidade.Usuario;
import br.com.formandoideias.excecao.EAOException;
import br.com.formandoideias.excecao.NegocioException;
import br.com.formandoideias.util.SHA;

@Named
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AcessoService implements AcessoServiceLocal{

	@Inject
	private UsuarioEAO usuarioEAO;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario autenticar(String usuario, String senha)throws NegocioException {
		try {
			String senhaC = criptografarSenha(senha);
			return usuarioEAO.perquisarUsuario(usuario, senhaC);
		} catch (EAOException eao) {
			throw new NegocioException(eao.getMessage(), eao);
		}
	}

    private String criptografarSenha(String senha) {
        return senha != null ? SHA.valueSHA512(senha) : null;
    }

}
