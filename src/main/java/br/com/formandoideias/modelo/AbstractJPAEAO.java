package br.com.formandoideias.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.formandoideias.excecao.EAOException;

public abstract class AbstractJPAEAO<T extends AbstractEntity> implements JPAEAO<T> {

    public abstract EntityManager getEntityManager();

    public List<T> getResultList(String namedQuery, Parameter... params) {
        Query query = getEntityManager().createNamedQuery(namedQuery);
        return getResultList(query, params);
    }

    public List<T> getResultList(String namedQuery, int inicio, int numRegistros, Parameter... params) {
        Query query = getEntityManager().createNamedQuery(namedQuery);
        return getResultList(query, inicio, numRegistros, params);
    }

    @SuppressWarnings("unchecked")
    public List<T> getResultList(Query query, Parameter... params) {
        defineParameters(query, params);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> getResultList(Query query, int inicio, int numRegistros, Parameter... params) {
        defineParameters(query, params);
        query.setFirstResult(inicio);
        query.setMaxResults(numRegistros);

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public T getSingleResult(String namedQuery, Parameter... params) {
        Query query = getEntityManager().createNamedQuery(namedQuery);
        try {
            defineParameters(query, params);
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    protected void defineParameters(Query query, Parameter... params) {
        if (params != null && params.length > 0) {
            for (Parameter parameter : params) {
                query.setParameter(parameter.getName(), parameter.getParam());
            }
        }
    }

    @Override
    public void salvar(T entity) throws EAOException{
        salvar(entity, true);
    }

    @Override
    public void salvar(T entity, boolean flushed) throws EAOException {

        if (entity.isPersisted()) {
            getEntityManager().merge(entity);
        } else {
            getEntityManager().persist(entity);
        }
        flush(flushed);
    }

    @Override
    public void excluir(T entity) throws EAOException {
        excluir(entity, true);
    }

    @Override
    public void excluir(T entity, boolean flushed) throws EAOException {
        if (entity != null) {
            getEntityManager().remove(getEntityManager().find(entity.getClass(), entity.getId()));
            flush(flushed);
        }
    }

    @Override
    public void flush() throws EAOException {
        getEntityManager().flush();
    }

    protected void flush(boolean flushed) throws EAOException {
        if (flushed) {
            flush();
        }
    }

    /**
     * Classe para encapuslar o parametro a passar para a <code>Query</code> do <code>EntityManager</code>
     */
    public class Parameter implements Serializable {

        private static final long serialVersionUID = 324176362422969108L;

        private final String name;
        private final Object param;

        public Parameter(final String name, Object param) {
            this.name = name;
            this.param = param;
        }

        public String getName() {
            return name;
        }

        public Object getParam() {
            return param;
        }
    }
}
