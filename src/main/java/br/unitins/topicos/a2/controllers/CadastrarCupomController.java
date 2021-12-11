package br.unitins.topicos.a2.controllers;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.CupomDao;
import br.unitins.topicos.a2.models.Cupom;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class CadastrarCupomController implements Serializable{
	
	private Cupom cupomForm;
	CadastrarCupomController(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("cupomFlash");
		cupomForm = (Cupom) flash.get("cupomFlash");
	}
	public Cupom getCupomForm() {
		if(this.cupomForm==null) {
			this.setCupomForm(new Cupom());
		}
		return cupomForm;
	}

	public void setCupomForm(Cupom cupomForm) {
		this.cupomForm = cupomForm;
	}
	
	public void incluir() {
		CupomDao dao = new CupomDao();
		if(dao.verificarCupom(cupomForm.getCodigo()) != null) {
			Utils.addErrorMessage("Já existe um cupom com esse nome no sistema");
		}
		else if(dao.incluir(cupomForm)) {
			Utils.addInfoMessage("Cupom cadastrado com sucesso");
		}else{
			Utils.addWarnMessage("Houveram problemas para cadastrar o cupom");
		}
		
		this.setCupomForm(null);
	}
	
	public void alterar() {
		CupomDao dao = new CupomDao();
		if(dao.alterar(cupomForm)) {
			Utils.addInfoMessage("Cupom alterado com sucesso");
		}else {
			Utils.addWarnMessage("Houveram problemas para alterar o cupom");
		}
		this.setCupomForm(null);
	}
	public void excluir() {
		CupomDao dao = new CupomDao();
		if(dao.excluir(cupomForm)) {
			Utils.addInfoMessage("Cupom excluid com sucesso");
		}else{
			Utils.addWarnMessage("Houveram problemas para excluir o cupom");
		};
		this.setCupomForm(null);
	}
	
	private static final long serialVersionUID = 1L;
	
	
}
