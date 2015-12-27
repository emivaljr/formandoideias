package br.com.formandoideias.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.formandoideias.entidade.Curso;
import br.com.formandoideias.entidade.Video;

@Stateless
public class VideoService {
	
	   @PersistenceContext EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Video> listarVideosPorCurso(Curso curso) {
		Query query = em.createNamedQuery("Video.recuperarVideosPorCurso");
		query.setParameter("curso", curso);
		return query.getResultList();
	}

}
