package br.com.formandoideias.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.formandoideias.entidade.Curso;
import br.com.formandoideias.entidade.Questao;
import br.com.formandoideias.entidade.Questionario;

@Stateless
public class ExercicioAulaService {

	@PersistenceContext EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Questionario> listaQuestionariosPorCurso(Curso cursoSelecionado) {
		Query query = em.createNamedQuery("Questionario.listaQuestionariosPorCurso");
		query.setParameter("curso", cursoSelecionado);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Questionario> listaQuestionariosDisponiveisPorCurso(Curso cursoSelecionado) {
		Query query = em.createNamedQuery("Questionario.listaQuestionariosDisponiveisPorCurso");
		query.setParameter("curso", cursoSelecionado);
		query.setParameter("dataAtual", new Date());
		
		List<Questionario> listaQuestionario = query.getResultList();
		
		for (Questionario questionario : listaQuestionario) {
			questionario.getListaQuestoes().size();
			
			for (Questao questao : questionario.getListaQuestoes()) {
				questao.getListaItens().size();
			}
		}
				
		return listaQuestionario;
	}
	
	public List<Questao> obtemListaQuestoes(Questionario questionario) {
		List<Questao> listaQuestoes = new ArrayList<Questao>();
		
		while (listaQuestoes.size() < questionario.getQtdeMaxQuestoes()) { 
			Integer numeroRandomico = (int)  (Math.random() * questionario.getQtdeMaxQuestoes());
			
			Questao questao = questionario.getListaQuestoes().get(numeroRandomico);
			
			if (!listaQuestoes.contains(questao)) {
				listaQuestoes.add(questao);
			}
		}
		
		return listaQuestoes;
	}
	
}
