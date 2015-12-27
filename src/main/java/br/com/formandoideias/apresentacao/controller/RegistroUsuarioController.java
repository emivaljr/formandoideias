package br.com.formandoideias.apresentacao.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import br.com.formandoideias.componentes.Controller;
import br.com.formandoideias.entidade.Login;
import br.com.formandoideias.entidade.Usuario;
import br.com.formandoideias.negocio.UsuarioService;

@Controller
public class RegistroUsuarioController {
	
	@Inject
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	private Login login;
	
	private Boolean aceitarTermos;

	public Boolean getAceitarTermos() {
		return aceitarTermos;
	}

	public void setAceitarTermos(Boolean aceitarTermos) {
		this.aceitarTermos = aceitarTermos;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setLogin(getLogin());
		}
		return usuario;
	}
	
	public String salvar(){
		usuarioService.salvar(getUsuario());
		return "sucesso";
	}

	public Login getLogin() {
		if (login == null) {
			login = new Login();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void validateLoginExistente(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String login = (String) value;
		if(usuarioService.validaLoginExistente(login)){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login existente!", "Login existente!"));
		}
	}

}
