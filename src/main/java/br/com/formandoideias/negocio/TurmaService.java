package br.com.formandoideias.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.formandoideias.entidade.Turma;

@Stateless
public class TurmaService {
	
	   @PersistenceContext EntityManager em;

	public Turma recuperarTurma(Integer id) {
		return em.find(Turma.class, id);
	}

}
