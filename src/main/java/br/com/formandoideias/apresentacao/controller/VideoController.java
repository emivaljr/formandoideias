package br.com.formandoideias.apresentacao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import br.com.formandoideias.componentes.SessaoUsuario;
import br.com.formandoideias.entidade.Video;
import br.com.formandoideias.negocio.VideoService;

@Named
@FlowScoped(value="videoAula")
public class VideoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Part file;

	private String caminhoVideo;
	private Boolean flag = Boolean.TRUE;
	
	private List<Video> listaVideos;
	
	@Inject
	private SessaoUsuario sessaoUsuario;
	
	@Inject
	private VideoService videoService;
	
	private Video videoSelecionado;
	
	private Integer idSelecionado;
	
	public void init(){
		listaVideos = videoService.listarVideosPorCurso(sessaoUsuario.getTurmaSelecionada().getCurso());
	}
	
	public void alterarVideo(){
		if(flag){
			setCaminhoVideo("/resources/videos/coração.mpg");
			flag = Boolean.FALSE;
		}
		else{
			setCaminhoVideo("/resources/videos/me_ama.mpg");
			flag = Boolean.TRUE;
		}
	}

	public String getCaminhoVideo() {
		return caminhoVideo;
	}

	public void setCaminhoVideo(String caminhoVideo) {
		this.caminhoVideo = caminhoVideo;
	}

	public List<Video> getListaVideos() {
		return listaVideos;
	}

	public void setListaVideos(List<Video> listaVideos) {
		this.listaVideos = listaVideos;
	}

	public Video getVideoSelecionado() {
		return videoSelecionado;
	}

	public void setVideoSelecionado(Video videoSelecionado) {
		this.videoSelecionado = videoSelecionado;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public Integer getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Integer idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

}
