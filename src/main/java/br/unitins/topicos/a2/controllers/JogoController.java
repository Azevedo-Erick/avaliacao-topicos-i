package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.models.Jogo;

@Named
@ViewScoped
public class JogoController implements Serializable{
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	private void load() {
		this.getJogos().add(new Jogo("Hollow Knight", "Desktop",3,"Um ótimo jogo de plataforma"));
		this.getJogos().add(new Jogo("GTA 5", "PS4",4,"Um ótimo jogo de mundo aberto"));
		this.getJogos().add(new Jogo("Terraria", "Mobile",1,"Um ótimo jogo de mundo aberto e plataforma"));
	}
	
	
	public List<Jogo> getJogos() {
		return jogos;
	}


	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
