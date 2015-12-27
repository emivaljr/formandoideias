package br.com.formandoideias.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RespostaQuestaoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resposta", insertable = false, columnDefinition = "serial")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_questao_usuario")
	private QuestaoUsuario questaoUsuario;
	
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestaoUsuario getQuestaoUsuario() {
		return questaoUsuario;
	}

	public void setQuestaoUsuario(QuestaoUsuario questaoUsuario) {
		this.questaoUsuario = questaoUsuario;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
