package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.EmpresaDao;
import br.unitins.topicos.a2.dao.JogoDao;
import br.unitins.topicos.a2.models.ClassificacaoIndicativa;
import br.unitins.topicos.a2.models.Empresa;
import br.unitins.topicos.a2.models.Jogo;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class CadastrarJogoController implements Serializable{

	private Jogo jogoForm;
	
	private List<ClassificacaoIndicativa> classificacaoIndicativa;
	private List<Empresa> empresas;
	
	CadastrarJogoController(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("jogoFlash");
		jogoForm = (Jogo) flash.get("jogoFlash");
	}
	
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
	
	public void irParaConsulta() {
		Utils.redirect("/pages/admin/consultaJogo.xhtml");
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

	
	public void cadastrar() {
		JogoDao dao = new JogoDao();
		if(dao.verificarJogo(jogoForm.getNome()) == null) {
		if(dao.incluir(jogoForm)) {
			Utils.addInfoMessage("Jogo cadastrado com sucesso");
		}else {
			Utils.addWarnMessage("Houveram problemas para cadastrar o jogo");
		}
		}Utils.addErrorMessage("Já existe um jogo com esse nome");
		this.setJogoForm(null);
	}
	public void remover() {
		JogoDao dao = new JogoDao();
		if(dao.excluir(jogoForm)) {
			Utils.addInfoMessage("Remoção realizada com sucesso");
		}else {
			Utils.addWarnMessage("Houveram problemas para excluir");
		}
	}
	public void atualizar() {
		JogoDao dao = new JogoDao();
		if(dao.alterar(jogoForm)) {
			Utils.addInfoMessage("Alteração realizada com sucesso");
		}else {
			Utils.addWarnMessage("Houveram problemas para alterar");
		}
		this.setJogoForm(null);
	}





	private static final long serialVersionUID = 1L;
	
}
