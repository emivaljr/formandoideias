package br.com.formandoideias.apresentacao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.formandoideias.componentes.SessaoUsuario;
import br.com.formandoideias.entidade.Aula;
import br.com.formandoideias.negocio.AulaService;

@Named
@FlowScoped(value="visaoGeralAula")
public class VisaoGeralController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AulaService aulaService;
	
	@Inject
	private SessaoUsuario sessaoUsuario;
	
	private List<Aula> listaAulas;
	
	public void init(){
		listaAulas = aulaService.consultarAulas(sessaoUsuario.getTurmaSelecionada().getCurso());
	}

	public List<Aula> getListaAulas() {
		return listaAulas;
	}

	public void setListaAulas(List<Aula> listaAulas) {
		this.listaAulas = listaAulas;
	}

}
