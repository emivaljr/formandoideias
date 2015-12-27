package br.com.formandoideias.apresentacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.formandoideias.apresentacao.decorator.QuestaoDecorator;
import br.com.formandoideias.componentes.SessaoUsuario;
import br.com.formandoideias.entidade.Questao;
import br.com.formandoideias.entidade.Questionario;
import br.com.formandoideias.negocio.ExercicioAulaService;

@Named
@FlowScoped(value="exercicioAula")
public class ExercicioAulaController implements Serializable {

	private static final long serialVersionUID = -559063014719603388L;

	@Inject
	private ExercicioAulaService exercicioAulaService;
	
	@Inject
	private SessaoUsuario sessaoUsuario;
	
	private List<Questionario> listaQuestionarios;
	
	private Questionario questionarioSelecionado;
	
	private List<QuestaoDecorator> listaQuestoesDecorator;
	
	public void init() { 
		listaQuestionarios = exercicioAulaService.listaQuestionariosDisponiveisPorCurso(sessaoUsuario.getTurmaSelecionada().getCurso());
	}
	
	public List<QuestaoDecorator> obtemListaQuestoes() {
		if (listaQuestoesDecorator == null) {
			Integer contador = 0;
			listaQuestoesDecorator = new ArrayList<QuestaoDecorator>();
			List<Questao> listaQuestoes = exercicioAulaService.obtemListaQuestoes(questionarioSelecionado);
			
			for (Questao questao : listaQuestoes) {
				QuestaoDecorator questaoDecorator = new QuestaoDecorator();
				questaoDecorator.setQuestao(questao);
				questaoDecorator.setNumeroQuestao(++contador);
				listaQuestoesDecorator.add(questaoDecorator);
			}		
		}
		
		return listaQuestoesDecorator;
	}
	
	public String salvar() {
		return "sucesso";
	}

	public List<Questionario> getListaQuestionarios() {
		return listaQuestionarios;
	}

	public void setListaQuestionarios(List<Questionario> listaQuestionarios) {
		this.listaQuestionarios = listaQuestionarios;
	}

	public Questionario getQuestionarioSelecionado() {
		return questionarioSelecionado;
	}

	public void setQuestionarioSelecionado(Questionario questionarioSelecionado) {
		this.questionarioSelecionado = questionarioSelecionado;
	}
}
