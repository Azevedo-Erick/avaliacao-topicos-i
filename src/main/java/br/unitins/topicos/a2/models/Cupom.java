package br.unitins.topicos.a2.models;

public class Cupom {
	private Integer id;
	private String codigo;
	private Integer porcentagem;
	private boolean ativo;
	public Cupom(Integer id, String codigo, Integer porcentagem, boolean ativo) {
		this.id = id;
		this.codigo = codigo;
		this.porcentagem = porcentagem;
		this.ativo = ativo;
	}
	public Cupom() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return "Cupom [id=" + id + ", codigo=" + codigo + ", porcentagem=" + porcentagem + ", ativo=" + ativo + "]";
	}
	
	

}
