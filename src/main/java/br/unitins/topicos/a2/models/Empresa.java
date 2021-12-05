package br.unitins.topicos.a2.models;

import java.time.LocalDate;
import java.util.Objects;

public class Empresa {
	private Integer id;
	private String nome;
	private String sedeEmpresa;
	private String ceo;
	private LocalDate dataFundacao;
	
	
	public Empresa() {};
	public Empresa(Integer id, String nome, String sedeEmpresa, String ceo, LocalDate dataFundacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sedeEmpresa = sedeEmpresa;
		this.ceo = ceo;
		this.dataFundacao = dataFundacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSedeEmpresa() {
		return sedeEmpresa;
	}
	public void setSedeEmpresa(String sedeEmpresa) {
		this.sedeEmpresa = sedeEmpresa;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
