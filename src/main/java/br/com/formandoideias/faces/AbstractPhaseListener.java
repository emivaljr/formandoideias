package br.com.formandoideias.faces;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.event.PhaseListener;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 *
 */
public abstract class AbstractPhaseListener implements PhaseListener {

    private static final long serialVersionUID = -489217588166739781L;
    private static final Logger LOGGER = Logger.getLogger(AbstractPhaseListener.class.getName());

    public BeanManager getBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        }  catch (NamingException e) {
            LOGGER.error("Couldn't get BeanManager through JNDI");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBeanByName(String name) {
        BeanManager bm = getBeanManager();
        Bean<?> bean = bm.getBeans(name).iterator().next();
        CreationalContext<?> ctx = bm.createCreationalContext(bean);
        return (T)bm.getReference(bean, bean.getBeanClass(), ctx);
    }

}
