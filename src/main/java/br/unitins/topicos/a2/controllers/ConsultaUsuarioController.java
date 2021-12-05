package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class ConsultaUsuarioController implements Serializable{
	private List<Usuario> listaUsuarios;
	public List<Usuario> getListaUsuarios() {
		if(this.listaUsuarios==null) {
			UsuarioDao dao = new UsuarioDao();
			this.setListaUsuarios(dao.obterTodos());
		}
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public void irParaCadastro() {
		Utils.redirect("cadastrarUsuario.xhtml");
	}

	public void selectUser(Usuario user) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("usuarioFlash", user);
		Utils.redirect("cadastrarUsuario.xhtml");
	}
	
	private static final long serialVersionUID = 6402525871778912190L;

}
