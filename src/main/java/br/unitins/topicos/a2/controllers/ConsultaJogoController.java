package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.JogoDao;
import br.unitins.topicos.a2.models.Jogo;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class ConsultaJogoController implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Jogo> jogos;
	
	public List<Jogo> getJogos() {
		if(this.jogos==null) {
			JogoDao dao = new JogoDao();
			this.setJogos(dao.obterTodos());
		}
		return jogos;
	}
	
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	public void selectJogo(Jogo jogo) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("jogoFlash", jogo);
		Utils.redirect("/pages/admin/cadastrarJogo.xhtml");
	}
	
	public void irParaCadastro() {
		Utils.redirect("/pages/admin/cadastrarJogo.xhtml");
	}
	
}
