package br.com.formandoideias.componentes;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.formandoideias.entidade.Turma;
import br.com.formandoideias.entidade.Usuario;
import br.com.formandoideias.negocio.TurmaService;
import br.com.formandoideias.negocio.UsuarioService;

@Named
@SessionScoped
public class SessaoUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Turma turmaSelecionada;
	
	private Usuario usuario;
		
	@Inject
	private TurmaService turmaService;
	
	@Inject
	private UsuarioService usuarioService;

	public Turma getTurmaSelecionada() {
		if (turmaSelecionada == null) {
			turmaSelecionada = turmaService.recuperarTurma(1);
		}
		return turmaSelecionada;
	}

	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = usuarioService.recuperarUsuarioPorId(1L);	
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
