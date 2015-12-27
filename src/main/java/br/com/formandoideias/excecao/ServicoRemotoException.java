package br.com.formandoideias.excecao;

import javax.ejb.ApplicationException;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 *
 */
@ApplicationException(rollback=true)
public class ServicoRemotoException extends SistemaException {

    private static final long serialVersionUID = 5267898127782217041L;

    public ServicoRemotoException() {
        super();
    }

    public ServicoRemotoException(String msg) {
        super(msg);
    }

    public ServicoRemotoException(Throwable cause) {
        super(cause);
    }

    public ServicoRemotoException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
