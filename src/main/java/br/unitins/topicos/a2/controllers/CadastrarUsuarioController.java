package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Perfil;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class CadastrarUsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Perfil> perfis;

	private Usuario usuarioForm;

	CadastrarUsuarioController(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("usuarioFlash");
		usuarioForm = (Usuario) flash.get("usuarioFlash");
	}
	
	public List<Perfil> getPerfis() {
		if (this.perfis == null) {
			perfis = new ArrayList<Perfil>();
			for (Perfil perfil : Perfil.values()) {
				perfis.add(perfil);
			}
		}
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public void irParaConsulta() {
		Utils.redirect("consultaUsuario.xhtml");
	}
	
	public void cadastrar() {
		UsuarioDao dao = new UsuarioDao();
		dao.cadastar(usuarioForm);
		this.setUsuarioForm(null);
	}

	public Usuario getUsuarioForm() {
		if (this.usuarioForm == null) {
			this.usuarioForm = new Usuario();
		}
		return usuarioForm;
	}

	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}

	public void remover() {
		UsuarioDao dao = new UsuarioDao();
		dao.excluir(usuarioForm);
		this.setUsuarioForm(null);
	}

	public void atualizar() {
		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuarioForm);
		this.setUsuarioForm(null);
	}

}
