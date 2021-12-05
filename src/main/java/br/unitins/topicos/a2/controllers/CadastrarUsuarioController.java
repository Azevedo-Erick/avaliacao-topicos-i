package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.UsuarioDao;
import br.unitins.topicos.a2.models.Perfil;
import br.unitins.topicos.a2.models.Usuario;

@Named
@ViewScoped
public class CadastrarUsuarioController implements Serializable{
	private Usuario usuarioForm;
	private List<Perfil> perfis;
	
	
	
	public List<Perfil> getPerfis() {
		if(this.perfis==null) {
			perfis = new ArrayList<Perfil>();
			for(Perfil perfil : Perfil.values()) {
				perfis.add(perfil);
			}
		}
		return perfis;
	}

	
	public void cadastrar() {
		UsuarioDao dao = new UsuarioDao();
		dao.cadastar(usuarioForm);
		this.setUsuarioForm(null);
	}


	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}



	public Usuario getUsuarioForm() {
		if(this.usuarioForm==null) {
			this.usuarioForm = new Usuario();
		}
		return usuarioForm;
	}



	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}



	private static final long serialVersionUID = 1L;

}
