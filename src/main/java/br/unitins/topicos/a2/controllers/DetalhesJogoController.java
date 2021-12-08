package br.unitins.topicos.a2.controllers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos.a2.models.Jogo;
import br.unitins.topicos.a2.util.Utils;

@Named
@ViewScoped
public class DetalhesJogoController implements Serializable{

	private Jogo jogo;
	
	DetalhesJogoController(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("detalhesJogoFlash");
		jogo = (Jogo) flash.get("detalhesJogoFlash");
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public String formatPrice(Double price) {
		return Utils.formatPrice(price);
	}

	public String formatDate(LocalDate date) {
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return date.format(fomatter);
	}
	
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}



	private static final long serialVersionUID = 1L;

}
