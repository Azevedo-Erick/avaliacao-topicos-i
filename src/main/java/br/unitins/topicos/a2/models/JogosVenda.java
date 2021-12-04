package br.unitins.topicos.a2.models;

import java.util.Objects;

public class JogosVenda {
	private Integer id;
	private Double valor;
	private Integer quantidade;
	private Jogo jogo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Jogo getProduto() {
		return jogo;
	}

	public void setProduto(Jogo produto) {
		this.jogo = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(jogo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogosVenda other = (JogosVenda) obj;
		return Objects.equals(jogo, other.jogo);
	}
}
