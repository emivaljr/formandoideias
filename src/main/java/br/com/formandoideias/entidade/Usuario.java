package br.com.formandoideias.entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.formandoideias.modelo.AbstractEntity;

@NamedQueries({
	@NamedQuery(name="usuario.pesquisaAutenticacao",
				query="SELECT u FROM Usuario u WHERE (u.id = :usuario OR u.email = :usuario) AND u.senha = :senha"),
	
	@NamedQuery(name="usuario.pesquisaUsuarioPorEmail",
				query="SELECT u FROM Usuario u WHERE u.email = :email")
})

@Entity
@Table(name="USUARIO")
public class Usuario extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_usuario", insertable = false, columnDefinition = "serial") 
	private Long id;
	
	@Column(name = "ds_primeironome")
	private String primeiroNome;
	
	@Column(name = "ds_sobrenome")
	private String sobrenome;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_login")
	private Login login;
	
	@Column(name = "ds_email")
	private String email;

	@Column(name = "ds_estado")
	private String estado;
	
	@Column(name = "ds_pais")
	private String pais;

	@Column(name="ds_senha")
	private String senha;
	
	@Column(name="ds_usuarioativo")
	private  Boolean ativo;
	
	@Column(name="ds_dataultimologin")
	private Date dataUltimoLogin;
	
	@Column(name="ds_dataexpiracao")
	private Date dataExpiracao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataUltimoLogin() {
		return dataUltimoLogin;
	}

	public void setDataUltimoLogin(Date dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

}
