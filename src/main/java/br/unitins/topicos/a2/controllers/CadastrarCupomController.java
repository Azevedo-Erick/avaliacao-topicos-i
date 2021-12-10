package br.unitins.topicos.a2.controllers;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.CupomDao;
import br.unitins.topicos.a2.models.Cupom;

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
		dao.incluir(cupomForm);
		this.setCupomForm(null);
	}
	
	public void alterar() {
		CupomDao dao = new CupomDao();
		dao.alterar(cupomForm);
		this.setCupomForm(null);
	}
	public void excluir() {
		CupomDao dao = new CupomDao();
		dao.excluir(cupomForm);
		this.setCupomForm(null);
	}
	
	private static final long serialVersionUID = 1L;
	
	
}
