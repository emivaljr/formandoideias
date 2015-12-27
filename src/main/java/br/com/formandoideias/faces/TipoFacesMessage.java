package br.com.formandoideias.faces;


/**
 * Enum criado para substituir os tipos das mensagens adicionados no
 * FacesContext.
 *
 * Essa substituição foi necessária, pois, ao executar o projeto no JBOSS o
 * módulo FRAMEWORK não reconhecia o tipo FacesMessage.Severity como parâmetro
 * no método da classe AbstractMB.
 *
 */
public enum TipoFacesMessage {

    INFO, AVISO, ERRO, FATAL;

}
