package br.com.formandoideias.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Aula.listaAulasPorCurso", query=" from Aula aula where aula.curso = :curso")
})
public class Aula {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_aula", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@Column(name = "ds_nome", nullable = false)
	private String nome;
	
	@Column(name = "ds_descricao", nullable = false,columnDefinition="text")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_curso",columnDefinition="integer")
	private Curso curso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
