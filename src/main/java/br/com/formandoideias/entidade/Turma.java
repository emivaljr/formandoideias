package br.com.formandoideias.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_turma", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicioinscricao")
	private Date dataInicioInscricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fiminscricao")
	private Date dataFimInscricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicioduracao")
	private Date dataInicioDuracao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fimduracao")
	private Date dataFimDuracao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}

	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}

	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}

	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}

	public Date getDataInicioDuracao() {
		return dataInicioDuracao;
	}

	public void setDataInicioDuracao(Date dataInicioDuracao) {
		this.dataInicioDuracao = dataInicioDuracao;
	}

	public Date getDataFimDuracao() {
		return dataFimDuracao;
	}

	public void setDataFimDuracao(Date dataFimDuracao) {
		this.dataFimDuracao = dataFimDuracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
