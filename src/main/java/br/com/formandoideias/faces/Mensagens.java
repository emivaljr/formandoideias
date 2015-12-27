package br.com.formandoideias.faces;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 * Classe que encapsula o comportamento de recuperação de strings nos arquivos de propriedades do sistema.
 *
 */
public class Mensagens {

    public static Mensagens SIS = new Mensagens("sis");
    public static Mensagens COMPONENTES = new Mensagens("comps");

    private final String bundle;

    private Mensagens(String bundleName) {
        this.bundle = bundleName;
    }

    /**
     * Recupera uma mensagem dos arquivos de properties do sistema.
     * @param bundleName nome do pacote de mensagens
     * @param key identificação da mensagen
     * @param params valores para substituicao na mensagem
     * @return String contendo o texto da mensagem desejada
     */
    public String get(String key, Object ... params) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle rb = fc.getApplication().getResourceBundle(fc, bundle);

        if(rb == null) {
            return "";
        }

        String saida = rb.getString(key);

        if(saida == null) {
            return "";
        }

        if(params != null) {
            saida = MessageFormat.format(saida, params);
        }
        return saida;
    }

}

