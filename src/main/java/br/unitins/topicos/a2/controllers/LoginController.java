package br.unitins.topicos.a2.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Usuario;

@Named
@ViewScoped
public class LoginController implements Serializable{
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	public Usuario getUsuario() {
		if(usuario==null) {
			usuario = new Usuario();
		}
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void insertUser() {
		UsuarioDao dao = new UsuarioDao();
		dao.incluir(usuario);
		this.setUsuario(null);
	}
	public void login() {
		UsuarioDao dao = new UsuarioDao();
		dao.login(usuario);
	}
}
