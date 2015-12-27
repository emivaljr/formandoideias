package br.com.formandoideias.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.formandoideias.entidade.Forum;
import br.com.formandoideias.entidade.MensagemForum;
import br.com.formandoideias.entidade.TopicoForum;
import br.com.formandoideias.entidade.Turma;

@Stateless
@SuppressWarnings("unchecked")
public class ForumService {
	
	   @PersistenceContext EntityManager em;

	
	public List<TopicoForum> listaTopicosPorTurma(Turma turmaSelecionada) {
		Query query = em.createNamedQuery("Forum.recuperarTopicosPorForum");
		query.setParameter("turma", turmaSelecionada);
		return query.getResultList();
	}
	
	public Forum consultaForumPorTurma(Turma turmaSelecionada) {
		Query query = em.createNamedQuery("Forum.recuperarForumPorTurma");
		query.setParameter("turma", turmaSelecionada);
		return (Forum) query.getSingleResult();
	}

	public List<MensagemForum> carregaListaMensagem(TopicoForum topico) {
		Query query = em.createNamedQuery("MensagemForum.recuperarMensagensPorTopico");
		query.setParameter("topico", topico);
		return query.getResultList();
	}
	public void salvarTopico(TopicoForum topicoForum){
		em.merge(topicoForum);
	}

	public void salvarMensagem(MensagemForum mensagemSelecionada) {
		em.merge(mensagemSelecionada);
		
	}

	public void excluirMensagem(MensagemForum mensagem) {
		em.remove(mensagem);
	}

}
