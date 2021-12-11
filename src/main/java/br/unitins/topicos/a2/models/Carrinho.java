package br.unitins.topicos.a2.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos.a2.util.Utils;

public class Carrinho {
	private Integer id;
	private LocalDateTime data;
	private Double totalVenda;
	private Usuario usuario;
	private List<JogosVenda> listaJogoVenda;

	
	public Carrinho() {}
	public Carrinho(Integer id, LocalDateTime data, Double totalVenda) {
		super();
		this.id = id;
		this.data = data;
		this.totalVenda = totalVenda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(Double totalVenda) {
		this.totalVenda = totalVenda;
	}

	private Double calculaTotal() {
		Double total = 0.0;
			for(JogosVenda jogo : listaJogoVenda) {
			total+=jogo.getValor();
		}
		return total;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<JogosVenda> getListaJogoVenda() {
		//Não sabia onde colocar
		this.setTotalVenda(calculaTotal());
		return listaJogoVenda;
	}

	public void setListaJogoVenda(List<JogosVenda> listaJogoVenda) {
		this.listaJogoVenda = listaJogoVenda;
	}
	
	public String formatDate() {
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return this.data.format(fomatter);
	}
	
	public String formatTime() {
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("hh:mm");
		
		return this.data.format(fomatter);
	}
	
	public String formatPrice() {
		return Utils.formatPrice(this.totalVenda);
	}
}
