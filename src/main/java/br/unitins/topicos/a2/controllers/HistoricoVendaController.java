package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.CarrinhoDao;
import br.unitins.topicos.a2.models.Carrinho;
import br.unitins.topicos.a2.models.JogosVenda;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Session;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class HistoricoVendaController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Carrinho> listaVenda;
	public List<Carrinho> getListaVenda() {
		if(listaVenda==null) {
			Usuario usuario = (Usuario) Session.getInstance().get("usuarioLogado");
			CarrinhoDao dao = new CarrinhoDao();
			listaVenda = dao.obterTodos(usuario);
		}
		return listaVenda;
	}
	public void setListaVenda(List<Carrinho> listaVenda) {
		this.listaVenda = listaVenda;
	}
	
	public void selectVenda(Carrinho obj) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("compraFlash", obj);
		Utils.redirect("/pages/admin/detalhesVenda.xhtml");
	}
	
	
}
