package br.com.formandoideias.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author bruno
 *
 */
@Entity
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_item", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@Column(name = "enunciado", nullable = false)
	private String enunciado;
	
	@Column(name = "item_correto", nullable = false)
	private Boolean itemCorreta;
	
	@Column(name = "pontuacao", nullable = false)
	private Double pontuacao;
	
	@ManyToOne
	@JoinColumn(name="id_questao")
	private Questao questao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Boolean getItemCorreta() {
		return itemCorreta;
	}

	public void setItemCorreta(Boolean itemCorreta) {
		this.itemCorreta = itemCorreta;
	}

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
