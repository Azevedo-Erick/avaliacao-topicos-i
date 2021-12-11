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
import br.unitins.topicos.a2.util.Session;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class CadastrarUsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Perfil> perfis;

	private Usuario usuarioForm;
	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null)
			usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		return usuarioLogado;
	}
	
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
		Utils.redirect("/pages/admin/consultaUsuario.xhtml");
	}
	
	public void cadastrar() {
		UsuarioDao dao = new UsuarioDao();
		if(dao.verificarUsuario(usuarioForm.getEmail(), Utils.hash(usuarioForm)) != null) {
			Utils.addErrorMessage("Já existe um usuário cadastrado com esse email");
		}
		else if(dao.cadastar(usuarioForm)) {
			Utils.addInfoMessage("Cadastro realizado com sucesso!");
			
		}else {
			Utils.addWarnMessage("Houveram problemas para realizar o cadastro");
		}
		
		this.setUsuarioForm(null);
	}


	public void remover() {
		UsuarioDao dao = new UsuarioDao();
		if(dao.excluir(usuarioForm)) {
			Utils.addInfoMessage("Remoção realizada com sucesso!");
		}else{
			Utils.addWarnMessage("Houveram problemas para fazer a remoção");
		}
	}

	public void atualizar() {
		UsuarioDao dao = new UsuarioDao();
		if(dao.alterar(usuarioForm)) {
			Utils.addInfoMessage("Alteracao realizada com sucesso");
		}else{
			Utils.addWarnMessage("Houveram problemas para realizar a alteração");
		};
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
}
