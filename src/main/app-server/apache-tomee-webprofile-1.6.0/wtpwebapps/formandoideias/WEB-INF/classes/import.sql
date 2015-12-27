-- Curso
INSERT INTO curso(id_curso, ds_curso) VALUES (1, 'Curso Java Básico');

-- Turma
INSERT INTO turma(id_turma, id_curso, dt_fimduracao, dt_fiminscricao, dt_inicioduracao, dt_inicioinscricao) VALUES (1, 1, current_date, current_date, current_date,current_date);

-- Forum
INSERT INTO forum(id_forum, id_turma)VALUES (1, 1);

-- TopicoForum
INSERT INTO topicoforum(id_topicoforum, ds_topicoforum, id_forum) VALUES (1, 'Descricao do tópico', 1);

-- Item
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item um', FALSE, 0.2, 1);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item dois', TRUE, 0.2, 1);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item tres', FALSE, 0.2, 1);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item quatro', FALSE, 0.2, 1);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item cinco', FALSE, 0.4, 2);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item seis', FALSE, 0.4, 2);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item sete', FALSE, 0.4, 2);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item oito', TRUE, 0.4, 2);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item nove', FALSE, 0.4, 3);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item dez', FALSE, 0.4, 3);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item onze', TRUE, 0.4, 3);
INSERT INTO item(enunciado, item_correto, pontuacao, id_questao) VALUES ('Item doze', TRUE, 0.4, 3); 
-- Questao
INSERT INTO questao(enunciado, explicacao, pontuacao, tipoquestao) VALUES ('Marque verdadeiro ou false', 'Esta questao esta correta porque eu quero', 0.8, 1);
INSERT INTO questao(enunciado, explicacao, pontuacao, tipoquestao) VALUES ('Marque verdadeiro ou falso novamente', 'Nao tem explicacao', 1.6, 1);
INSERT INTO questao(enunciado, explicacao, pontuacao, tipoquestao) VALUES ('Julgue os itens', 'Os dois itens sao verdadeiros porque sim!', 1.6, 0);

-- ElementoAula
INSERT INTO elementoaula(id_elementoaula) VALUES (1);

-- Questionario
INSERT INTO questionario(nome, qtde_max_questoes, dt_inicio, dt_fim, id_elementoaula, id_curso) VALUES ('Questionario 1' , 2, '2014/01/01', '2014/12/31', 1, 1);

-- Questionario_Questao
INSERT INTO questionario_questao(listaquestionario_id_elementoaula, listaquestoes_id_questao) VALUES (1, 1);
INSERT INTO questionario_questao(listaquestionario_id_elementoaula, listaquestoes_id_questao) VALUES (1, 2);
INSERT INTO questionario_questao(listaquestionario_id_elementoaula, listaquestoes_id_questao) VALUES (1, 3);



