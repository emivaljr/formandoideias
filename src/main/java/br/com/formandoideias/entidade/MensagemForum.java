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
	@NamedQuery(name="MensagemForum.recuperarMensagensPorTopico",query="select mensagem from MensagemForum mensagem where mensagem.topicoForum = :topico ")
})
public class MensagemForum {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_mensagemforum", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@Column(name="ds_mensagemforum")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_mensagempai",columnDefinition="integer")
	private MensagemForum mensagemPai;
	
	@ManyToOne
	@JoinColumn(name="id_topicoforum",columnDefinition="integer")
	private TopicoForum topicoForum;
	
	@ManyToOne
	@JoinColumn(name="id_autor")
	private Usuario autor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public MensagemForum getMensagemPai() {
		return mensagemPai;
	}

	public void setMensagemPai(MensagemForum mensagemPai) {
		this.mensagemPai = mensagemPai;
	}

	public TopicoForum getTopicoForum() {
		return topicoForum;
	}

	public void setTopicoForum(TopicoForum topicoForum) {
		this.topicoForum = topicoForum;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

}
