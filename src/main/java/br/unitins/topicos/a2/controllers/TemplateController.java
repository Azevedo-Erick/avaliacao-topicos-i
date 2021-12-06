package br.unitins.topicos.a2.controllers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.models.Jogo;
import br.unitins.topicos.a2.models.JogosVenda;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.*;

@Named
@ViewScoped
public class TemplateController implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	
	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null)
			usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		return usuarioLogado;
	}
	
public Integer atualizarValorCarrinho() {
		
		@SuppressWarnings("unchecked")
		List<JogosVenda> carrinho =(List<JogosVenda>) Session.getInstance().get("carrinho");
		// caso nao exista o carrinho, retorna 0
		if (carrinho == null) {
			return 0;
		}
		// se existe no carrinho, retorna a qnt
			return carrinho.size();
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public void logar() {
		Utils.redirect("login.xhtml");
	}
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Utils.redirect("index.xhtml");
	}
	
	public void redirecionar(String pagina) {
		Utils.redirect(pagina);
	}
	
}
