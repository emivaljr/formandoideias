package br.com.formandoideias.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Eduardo Monteiro
 * @since 15/03/2014
 *
 */
@Data
public  class EnderecoVO implements Serializable {

    private static final long serialVersionUID = -3046561560949012411L;

    private  String numero;
    private  String logradouro;
    private  String bairro;
    private  String localidade;
    private String uf;

   

}
