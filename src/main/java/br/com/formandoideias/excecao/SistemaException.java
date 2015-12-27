package br.com.formandoideias.excecao;

import javax.ejb.ApplicationException;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 *
 */
@ApplicationException(rollback=true)
public class SistemaException extends Exception {

    private static final long serialVersionUID = 7932906037871518427L;

    public SistemaException() {
        super();
    }

    public SistemaException(String msg) {
        super(msg);
    }

    public SistemaException(Throwable cause) {
        super(cause);
    }

    public SistemaException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
