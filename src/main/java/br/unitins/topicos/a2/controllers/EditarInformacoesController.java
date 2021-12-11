package br.unitins.topicos.a2.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Session;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class EditarInformacoesController implements Serializable{

	private Usuario usuario;

	
	public Usuario getUsuario() {
		if(usuario==null) {
			this.setUsuario((Usuario) Session.getInstance().get("usuarioLogado"));
			}
		return usuario;
	}

	public void atualizarInformacoes() {
		UsuarioDao dao = new UsuarioDao();
		if(dao.alterar(usuario)) {
			Utils.addInfoMessage("Alteração realizada com sucesso!!");
		}else{
			Utils.addWarnMessage("Houveram problemas para realizar a alteração");
		};
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	private static final long serialVersionUID = 1L;

}
