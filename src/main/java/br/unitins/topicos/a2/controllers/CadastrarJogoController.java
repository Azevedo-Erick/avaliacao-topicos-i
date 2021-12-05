package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.EmpresaDao;
import br.unitins.topicos.a2.dao.JogoDao;
import br.unitins.topicos.a2.models.ClassificacaoIndicativa;
import br.unitins.topicos.a2.models.Empresa;
import br.unitins.topicos.a2.models.Jogo;

@Named
@ViewScoped
public class CadastrarJogoController implements Serializable{

	private Jogo jogoForm;
	private List<Jogo> jogos;
	private List<ClassificacaoIndicativa> classificacaoIndicativa;
	private List<Empresa> empresas;

	public List<Empresa> getEmpresas() {
		if(this.empresas==null) {
			EmpresaDao dao = new EmpresaDao();
			this.setEmpresas(dao.obterTodos());
		}
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	
	
	
	public List<ClassificacaoIndicativa> getClassificacaoIndicativa() {
		if(this.classificacaoIndicativa==null) {
			this.setClassificacaoIndicativa(new ArrayList<ClassificacaoIndicativa>());
			for(ClassificacaoIndicativa cI: ClassificacaoIndicativa.values()) {
				classificacaoIndicativa.add(cI);
			}
		}
		return classificacaoIndicativa;
	}




	public void setClassificacaoIndicativa(List<ClassificacaoIndicativa> classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}




	public Jogo getJogoForm() {
		if(this.jogoForm==null) {
			this.setJogoForm(new Jogo());
		}
		return jogoForm;
	}




	public void setJogoForm(Jogo jogoForm) {
		this.jogoForm = jogoForm;
	}

	public void selectJogo(Jogo jogo) {
		this.setJogoForm(jogo);
	}
	public void cadastrar() {
		JogoDao dao = new JogoDao();
		dao.incluir(jogoForm);
		this.setJogoForm(null);
	}
	public void remover(Jogo jogo) {
		JogoDao dao = new JogoDao();
		dao.excluir(jogo);
		this.setJogos(null);
	}
	public void atualizar() {
		JogoDao dao = new JogoDao();
		dao.alterar(jogoForm);
		this.setJogos(null);
		this.setJogoForm(null);
	}


	public List<Jogo> getJogos() {
		if(this.jogos==null) {
			JogoDao dao = new JogoDao();
			this.setJogos(dao.obterTodos());
		}
		return jogos;
	}




	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}




	private static final long serialVersionUID = 1L;
	
}
