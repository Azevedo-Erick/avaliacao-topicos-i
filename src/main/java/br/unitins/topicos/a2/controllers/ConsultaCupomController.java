package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.CupomDao;
import br.unitins.topicos.a2.models.Cupom;
import br.unitins.topicos.a2.models.Empresa;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class ConsultaCupomController implements Serializable{
	
	private List<Cupom> listaCupom;
	
	
	
	public List<Cupom> getListaCupom() {
		if(this.listaCupom==null) {
			CupomDao dao = new CupomDao();
			this.setListaCupom(dao.obterTodos());
		}
		return listaCupom;
	}

	public void selectCupom(Cupom cupom) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("cupomFlash", cupom);
		Utils.redirect("/pages/admin/cadastrarCupom.xhtml");
	}

	public void setListaCupom(List<Cupom> listaCupom) {
		this.listaCupom = listaCupom;
	}



	private static final long serialVersionUID = 1L;
	
	
}
