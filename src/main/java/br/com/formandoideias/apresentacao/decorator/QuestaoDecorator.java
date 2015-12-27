package br.com.formandoideias.apresentacao.decorator;

import br.com.formandoideias.entidade.Item;
import br.com.formandoideias.entidade.Questao;

public class QuestaoDecorator {
	
	private Integer numeroQuestao;
	private Questao questao;
	private Item respostaQuestao;
	private Item[] respostasQuestoesArray;
	private String respostaDescritiva;
	
	public Integer getNumeroQuestao() {
		return numeroQuestao;
	}

	public void setNumeroQuestao(Integer numeroQuestao) {
		this.numeroQuestao = numeroQuestao;
	}

	public Questao getQuestao() {
		return questao;
	}
	
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
	public Item getRespostaQuestao() {
		return respostaQuestao;
	}
	
	public void setRespostaQuestao(Item respostaQuestao) {
		this.respostaQuestao = respostaQuestao;
	}

	public Item[] getRespostasQuestoesArray() {
		return respostasQuestoesArray;
	}

	public void setRespostasQuestoesArray(Item[] respostasQuestoesArray) {
		this.respostasQuestoesArray = respostasQuestoesArray;
	}

	public String getRespostaDescritiva() {
		return respostaDescritiva;
	}

	public void setRespostaDescritiva(String respostaDescritiva) {
		this.respostaDescritiva = respostaDescritiva;
	}
	
}
