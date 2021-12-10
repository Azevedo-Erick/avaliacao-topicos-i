package br.unitins.topicos.a2.controllers;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos.a2.models.JogosVenda;
import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.*;

@Named
@ViewScoped
public class TemplateController implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	private Integer carrinhoQtd;
	
	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null)
			usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		return usuarioLogado;
	}
	
	public Integer getCarrinhoQtd() {
		// caso nao exista o carrinho ou esteja vazio, retorna 0
			@SuppressWarnings("unchecked")
			List<JogosVenda> carrinhoL =(List<JogosVenda>) Session.getInstance().get("carrinho");
			if (carrinhoL == null || carrinhoL.isEmpty() ) {
				carrinhoQtd = 0;
				return carrinhoQtd;
			} else {
			// se existe carrinho, retorna a qtd
			carrinhoQtd = carrinhoL.size();
			
			return carrinhoQtd;
			}
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public void logar() {
		Utils.redirect("/pages/login.xhtml");
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Utils.redirect("/pages/index.xhtml");
	}
	
	public void redirecionar(String pagina) {
		Utils.redirect(pagina);
	}
	
}
