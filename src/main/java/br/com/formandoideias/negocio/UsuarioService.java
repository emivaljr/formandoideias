package br.com.formandoideias.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.formandoideias.entidade.Usuario;

@Stateless
public class UsuarioService {
	
	   @PersistenceContext EntityManager em;
	   
	   public void salvar(Usuario usuario){
		   em.merge(usuario);
	   }

	public boolean validaLoginExistente(String login) {
		Query query = em.createNamedQuery("Login.validaLoginExistente");
		query.setParameter("login", login);
		return ((Number)query.getSingleResult()).intValue()>0;
	}
	
	public Usuario recuperarUsuarioPorId(Long id){
		return em.find(Usuario.class, id);
	}

}
