package br.com.formandoideias.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class QuestaoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questao_usuario", insertable = false, columnDefinition = "serial")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_questao")
	private Questao questao;
	
	@ManyToOne
	@JoinColumn(name="id_formulario")
	private FormularioUsuario formulario;
	
	@Column(name = "nota", nullable = true)
	private String respostaDescritiva;
	
	@OneToMany(mappedBy="questaoUsuario")
	private List<RespostaQuestaoUsuario> respostaQuestaoUsuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public FormularioUsuario getFormulario() {
		return formulario;
	}

	public void setFormulario(FormularioUsuario formulario) {
		this.formulario = formulario;
	}

	public String getRespostaDescritiva() {
		return respostaDescritiva;
	}

	public void setRespostaDescritiva(String respostaDescritiva) {
		this.respostaDescritiva = respostaDescritiva;
	}

	public List<RespostaQuestaoUsuario> getRespostaQuestaoUsuarios() {
		return respostaQuestaoUsuarios;
	}

	public void setRespostaQuestaoUsuarios(
			List<RespostaQuestaoUsuario> respostaQuestaoUsuarios) {
		this.respostaQuestaoUsuarios = respostaQuestaoUsuarios;
	}

}
