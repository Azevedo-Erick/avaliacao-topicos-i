package br.unitins.topicos.a2.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Session;

@Named
@ViewScoped
public class EditarInformacoesController implements Serializable{

	private Usuario usuario;
	
	EditarInformacoesController(){
		
		if(usuario==null) {
		this.setUsuario((Usuario) Session.getInstance().get("usuarioLogado"));
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void atualizarInformacoes() {
		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	private static final long serialVersionUID = 1L;

}
