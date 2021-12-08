package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.CarrinhoDao;
import br.unitins.topicos.a2.models.Carrinho;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Session;

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
		System.out.println(listaVenda.size());
		return listaVenda;
	}
	public void setListaVenda(List<Carrinho> listaVenda) {
		this.listaVenda = listaVenda;
	}
	
	
	
}
