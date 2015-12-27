package br.com.formandoideias.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="Forum.recuperarTopicosPorForum",query="select forum.listaTopicos from Forum forum where forum.turma = :turma "),
	@NamedQuery(name="Forum.recuperarForumPorTurma",query="select forum from Forum forum where forum.turma = :turma ")
})
public class Forum {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_forum", insertable = false, columnDefinition = "serial") 
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_turma")
	private Turma turma;
	
	@OneToMany(mappedBy="forum")
	private List<TopicoForum> listaTopicos;
	
	

}
