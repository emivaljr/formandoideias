package br.com.formandoideias.entidade;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("VIDEO")
@NamedQueries({
	@NamedQuery(name="Video.recuperarVideosPorCurso",query="select video from Video video where video.aula.curso = :curso ")
})
public class Video  extends ElementoAula{
	
	@Column(name="ds_caminho")
	private String caminhoVideo;

	public String getCaminhoVideo() {
		return caminhoVideo;
	}

	public void setCaminhoVideo(String caminhoVideo) {
		this.caminhoVideo = caminhoVideo;
	}

}
