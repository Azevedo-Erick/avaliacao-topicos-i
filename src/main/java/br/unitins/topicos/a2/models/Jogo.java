package br.unitins.topicos.a2.models;

import java.time.LocalDate;

public class Jogo {
	private Integer id;
	private String nome;
	private Empresa empresa;
	private String plataforma;
	private String categoriaGenero;
	private LocalDate dataLancamento;
	private ClassificacaoIndicativa classificacaoIndicativa;
	private String descricaoJogo;
	
	
	
	public Jogo(Integer id, String nome, Empresa empresa, String plataforma, String categoriaGenero,
			LocalDate dataLancamento, ClassificacaoIndicativa classificacaoIndicativa, String descricaoJogo) {
		super();
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
		this.plataforma = plataforma;
		this.categoriaGenero = categoriaGenero;
		this.dataLancamento = dataLancamento;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.descricaoJogo = descricaoJogo;
	}
	
	public Jogo( String nome,  String plataforma, int classificacaoIndicativa, String descricaoJogo) {

		this.id = id;
		this.plataforma = plataforma;
		this.classificacaoIndicativa = ClassificacaoIndicativa.valueOf(classificacaoIndicativa);
		this.descricaoJogo = descricaoJogo;
	}
	public String getDescricaoJogo() {
		return descricaoJogo;
	}
	public void setDescricaoJogo(String descricaoJogo) {
		this.descricaoJogo = descricaoJogo;
	}
	public ClassificacaoIndicativa getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}
	public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getCategoriaGenero() {
		return categoriaGenero;
	}
	public void setCategoriaGenero(String categoriaGenero) {
		this.categoriaGenero = categoriaGenero;
	}
	

}
