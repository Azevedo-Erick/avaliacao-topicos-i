package br.unitins.topicos.a2.controllers;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.CarrinhoDao;
import br.unitins.topicos.a2.models.Carrinho;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Session;

@Named
@ViewScoped
public class DetalhesVendaController implements Serializable{
	private static final long serialVersionUID = 2836507612377649282L;
	private Carrinho carrinho;
	Usuario usuarioLogado;
	
	public DetalhesVendaController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("compraFlash");
		carrinho = (Carrinho) flash.get("compraFlash");
		usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
	}

	public Carrinho getCarrinho() {
		CarrinhoDao dao = new CarrinhoDao();
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

}
