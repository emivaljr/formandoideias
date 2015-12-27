package br.com.formandoideias.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.formandoideias.entidade.Aula;
import br.com.formandoideias.entidade.Curso;

@Named
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AulaService {
	
	@PersistenceContext EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Aula> consultarAulas(Curso curso){
		Query query = em.createNamedQuery("Aula.listaAulasPorCurso");
		query.setParameter("curso", curso);
		return query.getResultList();
	}

}
