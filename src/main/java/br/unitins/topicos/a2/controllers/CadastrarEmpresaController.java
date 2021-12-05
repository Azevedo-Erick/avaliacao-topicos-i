package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.EmpresaDao;
import br.unitins.topicos.a2.models.Empresa;

@Named
@ViewScoped
public class CadastrarEmpresaController implements Serializable{

	private Empresa empresaForm;
	private List<Empresa> empresas;
	private static final long serialVersionUID = 1L;
	public Empresa getEmpresaForm() {
		if(this.empresaForm==null) {
			this.setEmpresaForm(new Empresa());
		}
		return empresaForm;
	}
	public void setEmpresaForm(Empresa empresaForm) {
		this.empresaForm = empresaForm;
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
	public void selectEmpresa(Empresa empresa) {
		this.setEmpresaForm(empresa);
	}
	public void incluir() {
		EmpresaDao dao = new EmpresaDao();
		dao.incluir(empresaForm);
		this.setEmpresaForm(null);
		this.setEmpresas(null);
	}
	
	public void atualizar() {
		EmpresaDao dao = new EmpresaDao();
		dao.alterar(empresaForm);
		this.setEmpresaForm(null);
	}
	
	public void excluir(Empresa obj) {
		EmpresaDao dao = new EmpresaDao();
		dao.excluir(obj);
		this.setEmpresaForm(null);
		this.setEmpresas(null);
	}

}
