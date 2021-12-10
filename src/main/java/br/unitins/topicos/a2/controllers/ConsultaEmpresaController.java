package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.EmpresaDao;
import br.unitins.topicos.a2.models.Empresa;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class ConsultaEmpresaController implements Serializable{
	

	
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
	public void selectEmpresa(Empresa empresa) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("empresaFlash", empresa);
		Utils.redirect("/pages/admin/cadastrarEmpresa.xhtml");
	}
	
	private static final long serialVersionUID = 1L;

}
