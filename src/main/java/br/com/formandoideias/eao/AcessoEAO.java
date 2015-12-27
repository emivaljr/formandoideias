package br.com.formandoideias.eao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.formandoideias.modelo.AbstractEntity;
import br.com.formandoideias.modelo.AbstractJPAEAO;

public abstract class AcessoEAO<T extends AbstractEntity> extends AbstractJPAEAO<T> {

	@PersistenceContext(unitName="widgets")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	};
	
}
