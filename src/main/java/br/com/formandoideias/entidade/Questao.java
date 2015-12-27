package br.com.formandoideias.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.formandoideias.dominio.TipoQuestaoEnum;

/**
 * 
 * @author bruno
 * 
 */
@Entity
public class Questao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questao", insertable = false, columnDefinition = "serial")
	private Integer id;

	@Column(name = "enunciado", nullable = false)
	private String enunciado;

	@Enumerated(EnumType.ORDINAL)
	private TipoQuestaoEnum tipoQuestao;

	@Column(name = "pontuacao", nullable = false)
	private Double pontuacao;

	@OneToMany(mappedBy = "questao")
	private List<Item> listaItens;
	
	@Column(name = "explicacao", nullable = false)
	private String explicacao;
	
	@ManyToMany(mappedBy = "listaQuestoes")
	private List<Questionario> listaQuestionario;

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

	public TipoQuestaoEnum getTipoQuestao() {
		return tipoQuestao;
	}

	public void setTipoQuestao(TipoQuestaoEnum tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
	}

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Item> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public List<Questionario> getListaQuestionario() {
		return listaQuestionario;
	}

	public void setListaQuestionario(List<Questionario> listaQuestionario) {
		this.listaQuestionario = listaQuestionario;
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
		Questao other = (Questao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
