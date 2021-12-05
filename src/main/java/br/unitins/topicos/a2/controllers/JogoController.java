package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.dao.EmpresaDao;
import br.unitins.topicos.a2.dao.JogoDao;
import br.unitins.topicos.a2.models.Empresa;
import br.unitins.topicos.a2.models.Jogo;

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

	
	public String formatPrice(Double price) {
		 DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
		 return formatter.format(price);
	}
	
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

}
