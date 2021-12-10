package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos.a2.dao.JogoDao;
import br.unitins.topicos.a2.models.Jogo;
import br.unitins.topicos.a2.models.JogosVenda;
import br.unitins.topicos.a2.util.Session;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class JogoController implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Jogo> jogos;

	public List<Jogo> getJogos() {
		if(this.jogos==null) {
			JogoDao dao = new JogoDao();
			this.setJogos(dao.obterTodos());
			
		}
		return jogos;
	}

	
	public void detalhes(Jogo jogo) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("detalhesJogoFlash", jogo);
		Utils.redirect("/pages/detalhesJogo.xhtml");
		
	}
	
	
	public String formatPrice(Double price) {
		 return Utils.formatPrice(price);
	}
	
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	public void comprar(Jogo jogo) {
		
		@SuppressWarnings("unchecked")
		List<JogosVenda> carrinho =(List<JogosVenda>) Session.getInstance().get("carrinho");
		// caso nao exista o carrinho, criar um espaco de memoria
		if (carrinho == null) {
			carrinho = new ArrayList<JogosVenda>();
		}
		
		JogosVenda item = new JogosVenda();
		item.setJogo(jogo);
		item.setValor(jogo.getPreco());
		item.setQuantidade(1);
		
		// se existe no carrinho, atualizar a quantidade
		if (carrinho.contains(item)) {
			int index = carrinho.indexOf(item);
			int quantidade = carrinho.get(index).getQuantidade() + 1;
			carrinho.get(index).setQuantidade(quantidade);
			
		} else {
			// adicionando o novo item no carrinho
			carrinho.add(item);
		}
		
		// adicionando / atualizando o carrinho na sessao
		Session.getInstance().set("carrinho", carrinho);
		
		Utils.addInfoMessage("Produto adicionado no carrinho.");
		Utils.redirect("/pages/carrinho.xhtml");
		}

}
