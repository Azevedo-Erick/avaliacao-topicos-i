package br.unitins.topicos.a2.controllers;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class CarrinhoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<JogosVenda> listaJogoVenda = null;
	
	public String formatPrice(Double price) {
		 return Utils.formatPrice(price);
	}
	
	public String valorTotal() {
		double valor = 0;
		if(listaJogoVenda!=null)
		for(JogosVenda jogo : listaJogoVenda) {
			valor += jogo.getValor();
		}
		return formatPrice(valor);
	}
	
	public void print() {
		System.out.println("Compra finalizada");
		}
	
	@SuppressWarnings("unchecked")
	public List<JogosVenda> getListaJogoVenda() {
		listaJogoVenda = (List<JogosVenda>) Session.getInstance().get("carrinho");
		return listaJogoVenda;
	}
	public void setListaJogoVenda(List<JogosVenda> listaJogoVenda) {
		this.listaJogoVenda = listaJogoVenda;
	}

	public void finalizar() {
		// verificar se existe um usuario logado no sistema
		Usuario usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		if (usuarioLogado == null) {
			Utils.addErrorMessage("Faça o Login para concluir a venda.");
			return;
		}

		// verificar se existe algum produto no carrinho (sessao)
		@SuppressWarnings("unchecked")
		List<JogosVenda> carrinho = (List<JogosVenda>) Session.getInstance().get("carrinho");
		if (carrinho == null || carrinho.isEmpty() ) {
			Utils.addErrorMessage("Não existem produtos no carrinho");
			return;
		}

		Carrinho venda = new Carrinho();
		venda.setData(LocalDateTime.now());
		venda.setUsuario(usuarioLogado);
		venda.setListaJogoVenda(carrinho);

		// salvando no banco de dados
		CarrinhoDao dao = new CarrinhoDao();
		dao.incluir(venda);

		Utils.addInfoMessage("Venda realizada com sucesso.");
		
	}
	

}
