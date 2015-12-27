package br.com.formandoideias.entidade;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name="tp_tipoelementoaula",
        discriminatorType=DiscriminatorType.STRING)
public abstract class ElementoAula {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_elementoaula", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "tp_tipoelementoaula", nullable = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="id_aula",columnDefinition="integer")
	private Aula aula;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
