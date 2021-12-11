package br.unitins.topicos.a2.controllers;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class CadastroController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Usuario usuarioForm;
	
	public Usuario getUsuarioForm() {
		if(this.usuarioForm==null) {
			this.usuarioForm= new Usuario();
		}
		return usuarioForm;
	}
	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
	public void cadastrar() {
		UsuarioDao dao = new UsuarioDao();
		if(dao.verificarUsuario(usuarioForm.getEmail(), Utils.hash(usuarioForm)) != null) {
			Utils.addErrorMessage("Já existe um usuário cadastrado com esse email");
		}
		if(dao.incluir(usuarioForm)) {
			Utils.addInfoMessage("Cadastro realizado com sucesso");
			Utils.redirect("/pages/index.xhtml");
		}else {
			Utils.addWarnMessage("Houveram problemas para realizar o cadastro");
		}
		this.setUsuarioForm(null);
	}
	public void redirecionar(String pagina) {
		Utils.redirect(pagina);
	}
	
}
