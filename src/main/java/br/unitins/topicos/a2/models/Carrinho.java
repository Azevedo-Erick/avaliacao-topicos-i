package br.unitins.topicos.a2.models;

import java.time.LocalDateTime;
import java.util.List;

public class Carrinho {
	private Integer id;
	private LocalDateTime data;
	private Double totalVenda;
	private Usuario usuario;
	private List<JogosVenda> listaJogoVenda;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<JogosVenda> getListaJogoVenda() {
		return listaJogoVenda;
	}

	public void setListaJogoVenda(List<JogosVenda> listaJogoVenda) {
		this.listaJogoVenda = listaJogoVenda;
	}
}
