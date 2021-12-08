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
	
	public void red() {
		System.out.println(this.getQuantidade());
		if(this.getQuantidade()>1) {
			this.setQuantidade(this.quantidade -=1);
		}
	}
	
	public void add() {
		System.out.println(this.getQuantidade());
		this.setQuantidade(this.quantidade +=1);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		//Não sabia onde colocar
		this.setValor(quantidade*jogo.getPreco());
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



	public Jogo getJogo() {
		if(this.jogo==null) {
			this.setJogo(new Jogo());
		}
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
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
		return Objects.equals(jogo.getId(), other.jogo.getId());
	}

	@Override
	public String toString() {
		return "JogosVenda [id=" + id + ", valor=" + valor + ", quantidade=" + quantidade + ", jogo=" + jogo + "]";
	}
	
	
}
