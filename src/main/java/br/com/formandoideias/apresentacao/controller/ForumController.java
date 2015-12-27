package br.com.formandoideias.apresentacao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.formandoideias.componentes.SessaoUsuario;
import br.com.formandoideias.entidade.MensagemForum;
import br.com.formandoideias.entidade.TopicoForum;
import br.com.formandoideias.negocio.ForumService;

@Named
@FlowScoped(value="forum")
public class ForumController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6294643719980521371L;

	@Inject
	private ForumService forumService;
	
	@Inject
	private SessaoUsuario sessaoUsuario;
	
	private List<TopicoForum> listaTopicos;
	
	private List<MensagemForum> listaMensagem;
	
	private TopicoForum topicoSelecionado;
	
	private MensagemForum mensagemSelecionada;
	
	public void init(){
		listaTopicos = forumService.listaTopicosPorTurma(sessaoUsuario.getTurmaSelecionada());
		
	}
	
	public void carregaMensagens(TopicoForum topico){
		setTopicoSelecionado(topico);
		listaMensagem = forumService.carregaListaMensagem(topico);
		
	}
	public void responderMensagem(MensagemForum mensagemForum){
		mensagemSelecionada = new MensagemForum();
		mensagemSelecionada.setMensagemPai(mensagemForum);
		mensagemSelecionada.setTopicoForum(topicoSelecionado);
		mensagemSelecionada.setAutor(sessaoUsuario.getUsuario());
	}
	public void salvarMensagem(){
		forumService.salvarMensagem(mensagemSelecionada);
	}
	public void salvarTopico(){
		forumService.salvarTopico(getTopicoSelecionado());
	}
	
	public void carregaMensagemSelecionada(MensagemForum mensagem){
		setMensagemSelecionada(mensagem);
	}
	public void excluirMensagem(MensagemForum mensagem){
		forumService.excluirMensagem(mensagem);
	}

	public List<TopicoForum> getListaTopicos() {
		return listaTopicos;
	}

	public void setListaTopicos(List<TopicoForum> listaTopicos) {
		this.listaTopicos = listaTopicos;
	}

	public TopicoForum getTopicoSelecionado() {
		if(topicoSelecionado == null){
			topicoSelecionado = new TopicoForum();
			topicoSelecionado.setAutor(sessaoUsuario.getUsuario());
			topicoSelecionado.setForum(forumService.consultaForumPorTurma(sessaoUsuario.getTurmaSelecionada()));
		}
		return topicoSelecionado;
	}

	public void setTopicoSelecionado(TopicoForum topicoSelecionado) {
		this.topicoSelecionado = topicoSelecionado;
	}

	public List<MensagemForum> getListaMensagem() {
		return listaMensagem;
	}

	public void setListaMensagem(List<MensagemForum> listaMensagem) {
		this.listaMensagem = listaMensagem;
	}

	public MensagemForum getMensagemSelecionada() {
		return mensagemSelecionada;
	}

	public void setMensagemSelecionada(MensagemForum mensagemSelecionada) {
		this.mensagemSelecionada = mensagemSelecionada;
	}

}
