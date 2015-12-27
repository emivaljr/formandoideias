package br.com.formandoideias.faces;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 *
 */
public class FaceletsFunctions {

    private FaceletsFunctions() {}

    /**
     * Retorna um valor padrão caso o valor informado seja nulo.
     *
     * @param valueToTest  valor a ser informado
     * @param defaultValue  valor padrão
     * @return retorna o valor padrão se o valor informado for nulo
     */
    public static Object getValorPadrao(Object valor, Object padrao) {
        return valor == null ? padrao : valor;
    }

    /**
     * Retorna se existe mensagens para um id específico
     * @param clientId
     * @return <code>true</code> se existe mensagens ou <code>false</code> se não existe.
     */
    public static Boolean possuiMensagens(String idComponente) {

        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            return context.getMessageList(idComponente).size() > 0;
        }
        return false;
    }

    public static String getClasseDestaqueMensagem(String idComponente) {

        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {

            boolean erro = false;
            boolean info = false;
            boolean warn = false;
            boolean fatal = false;

            List<FacesMessage> messages = context.getMessageList(idComponente);
            for(FacesMessage m : messages) {

                if(m.getSeverity() == FacesMessage.SEVERITY_ERROR && !erro) {
                    erro = true;
                } else if(m.getSeverity() == FacesMessage.SEVERITY_WARN && !warn) {
                    warn = true;
                } else if(m.getSeverity() == FacesMessage.SEVERITY_INFO && !info) {
                    info = true;
                } else if(m.getSeverity() == FacesMessage.SEVERITY_FATAL && !fatal) {
                    fatal = true;
                }
            }

            if(erro) {
                return "error";
            } else if(warn) {
                return "warning";
            } else if(info) {
                return "info";
            } else if(fatal) {
                return "error";
            }
        }

        return "";
    }

}
