package br.com.formandoideias.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class TopicoForum {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_topicoforum", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@Column(name="ds_assunto")
	private String assunto;
	
	@Column(name="ds_topicoforum")
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criacao")
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="id_forum")
	private Forum forum;
	
	@ManyToOne
	@JoinColumn(name="id_autor")
	private Usuario autor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
}
