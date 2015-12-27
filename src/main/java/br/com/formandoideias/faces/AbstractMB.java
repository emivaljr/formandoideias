package br.com.formandoideias.faces;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Eduardo Monteiro
 * @since 05/03/2014
 * Managed Bean Generico com a definiçãoo de operações básicas.
 */
public abstract class AbstractMB implements Serializable {

    private static final long serialVersionUID = 2628117946616807375L;

    protected void redirect(String pagina) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            String url = ec.encodeActionURL(fc.getApplication().getViewHandler().getActionURL(fc, pagina));
            ec.redirect(url);
        } catch(IOException ex) {
            adicionaMensagemErro(Mensagens.SIS.get("sistema.erro.problemaredirecionamento"));
        }
    }

    protected void download(String nomeArquivo, byte[] dados, String mimeType) throws IOException {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletResponse response = (HttpServletResponse)facesContext.getExternalContext().getResponse();
        response.resetBuffer();
        response.reset();

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");

        response.setContentLength(dados.length);
        response.getOutputStream().write(dados);
        response.getOutputStream().flush();
        facesContext.responseComplete();
    }

    protected void download(String nomeArquivo, byte[] dados) throws IOException {
        download(nomeArquivo, dados, "application/octet-stream");
    }

    protected void downloadAsPDF(String nomeArquivo, byte[] dados) throws IOException {
        download(nomeArquivo, dados, "application/pdf");
    }

    private static void adicionaMensagem(TipoFacesMessage tipo, String componente, String mensagem, String detalhe) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(mensagem, detalhe);

        switch (tipo) {
        case FATAL:
            fm.setSeverity(FacesMessage.SEVERITY_FATAL);
            break;
        case ERRO:
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            break;
        case AVISO:
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
            break;
        default:
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
        }

        fc.addMessage(componente, fm);
    }

    public static void adicionaMensagemErro(String componente, String mensagem) {
        adicionaMensagem(TipoFacesMessage.ERRO, componente, mensagem, null);
    }

    public static void adicionaMensagemErro(String mensagem) {
        adicionaMensagemErro(null, mensagem);
    }

    public static void adicionaMensagemInfo(String componente, String mensagem) {
        adicionaMensagem(TipoFacesMessage.INFO, componente, mensagem, null);
    }

    public static void adicionaMensagemInfo(String mensagem) {
        adicionaMensagemInfo(null, mensagem);
    }

    public static void adicionaMensagemAviso(String componente, String mensagem) {
        adicionaMensagem(TipoFacesMessage.AVISO, componente, mensagem, null);
    }

    public static void adicionaMensagemAviso(String mensagem) {
        adicionaMensagemAviso(null, mensagem);
    }

    public static void adicionaMensagemFatal(String componente, String mensagem) {
        adicionaMensagem(TipoFacesMessage.FATAL, componente, mensagem, null);
    }

    public static void adicionaMensagemFatal(String mensagem) {
        adicionaMensagemFatal(null, mensagem);
    }

    public String getJSFVersion() {
        return FacesContext.class.getPackage().getImplementationVersion();
    }

    public String getJAVAVersion() {
        return System.getProperty("java.version");
    }

    public String getOSArchitecture() {
        return System.getProperty("os.arch");
    }

    public String getOSName() {
        return System.getProperty("os.name");
    }

    public String getOSVersion() {
        return System.getProperty("os.version");
    }

}
