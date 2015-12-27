package br.com.formandoideias.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Emival
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Login.validaLoginExistente",query="select count(login) from Login login where login.login = :login")
})
public class Login implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_login") 
	private String login;
	
	@Column(name = "ds_senha")
	private String senha;

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
	
	

}
