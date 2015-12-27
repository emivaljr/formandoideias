package br.com.formandoideias.apresentacao.controller;

import br.com.formandoideias.apresentacao.helper.FacebookAuthHelper;
import br.com.formandoideias.apresentacao.helper.GoogleAuthHelper;
import br.com.formandoideias.componentes.Controller;
import br.com.formandoideias.vo.UsuarioFBVO;

@Controller
public class LoginController {

	private String login;
	private String senha;
	private UsuarioFBVO usuarioFBVO;
	
	public String conectarComFacebook() {
		return FacebookAuthHelper.getLoginRedirectURL();
	}
	
	public String conectarComGooglePlus() {
		return  GoogleAuthHelper.buildLoginUrl();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioFBVO getUsuarioFB() {
		return usuarioFBVO;
	}
	public void setUsuarioFB(UsuarioFBVO usuarioFB) {
		this.usuarioFBVO = usuarioFB;
	}
}
