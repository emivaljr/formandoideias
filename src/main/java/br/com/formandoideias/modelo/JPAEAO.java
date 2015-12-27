package br.com.formandoideias.modelo;

import br.com.formandoideias.excecao.EAOException;


/**
 * Interface para a camada de serviços integar com Java Persistence API.
 */
public interface JPAEAO<T extends AbstractEntity> {

    /**
     * Método responsável por salvar uma entidade
     * @param entity Entidade
     * @throws EAOException
     */
    void salvar(T entity) throws EAOException;

    /**
     * Método responsável por salvar uma entidade
     * @param entity Entidade
     * @param flushed Indicador para utilizar o método <code>flush()</code> do <code>EntityManager</code>
     * @throws EAOException
     */
    void salvar(T entity, boolean flushed) throws EAOException;

    /**
     * Método responsável por excluir uma entidade
     * @param entity Entidade
     * @throws EAOException
     */
    void excluir(T entity) throws EAOException;

    /**
     * Método responsável por excluir uma entidade
     * @param entity Entidade
     * @param flushed Indicador para utilizar o método <code>flush()</code> do <code>EntityManager</code>
     * @throws EAOException
     */
    void excluir(T entity, boolean flushed) throws EAOException;

    /**
     * Método responsável por confirmar ação <code>flush()</code> do <code>EntityManager</code>
     * @throws EAOException
     */
    void flush() throws EAOException;


}
