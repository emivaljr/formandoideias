package br.com.formandoideias.modelo;

import java.io.Serializable;

/**
 * Classe abstrata de uma entidade
 */
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Retorna o <code>Id</code> da entidade
     * @return
     */
    public abstract Long getId();

    /**
     * Indicador se a entidade foi persistida.
     * @return <code>true</code> se a entidade foi persistida.
     */
    public boolean isPersisted() {
        return getId() != null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj == null || !getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        AbstractEntity other = (AbstractEntity) obj;
        if (getId() == null || other.getId() == null) {
            return false;
        } else if (!getId().equals(other.getId())) {
            return false;
        }

        return true;
    }

}
