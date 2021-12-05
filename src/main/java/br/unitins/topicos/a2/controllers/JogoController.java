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
	private static final long serialVersionUID = 1L;
	private List<Jogo> jogos;
	
	public List<Jogo> getJogos() {
		if(this.jogos==null) {
			this.setJogos(new ArrayList<Jogo>());
			this.getJogos().add(new Jogo("Hollow Knight", "Desktop",3,"Um ótimo jogo de plataforma", "Metroidvania",150.0));
			this.getJogos().add(new Jogo("GTA 5", "PS4",4,"Um ótimo jogo de mundo aberto", "Ação",90.0));
			this.getJogos().add(new Jogo("Terraria", "Mobile",1,"Um ótimo jogo de mundo aberto e plataforma", "Sandbox", 20.0));
		}
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

}
