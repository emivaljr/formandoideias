package br.com.formandoideias.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Questionario.listaQuestionariosPorCurso", query="select quest from Questionario quest where quest.curso = :curso"),
	@NamedQuery(name="Questionario.listaQuestionariosDisponiveisPorCurso", query="select quest from Questionario quest where quest.curso = :curso and :dataAtual between quest.dataInicio and quest.dataFim")
})
@DiscriminatorValue("QUESTIONARIO")
public class Questionario extends ElementoAula implements Serializable {

	private static final long serialVersionUID = 1L;
	


	@ManyToMany
	private List<Questao> listaQuestoes;
	
	@Column(name = "qtde_max_questoes", nullable = false)
	private Integer qtdeMaxQuestoes;
	
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio")
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim")
	private Date dataFim;



	public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public Integer getQtdeMaxQuestoes() {
		return qtdeMaxQuestoes;
	}

	public void setQtdeMaxQuestoes(Integer qtdeMaxQuestoes) {
		this.qtdeMaxQuestoes = qtdeMaxQuestoes;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
