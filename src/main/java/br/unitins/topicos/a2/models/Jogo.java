package br.unitins.topicos.a2.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.PositiveOrZero;

import br.unitins.topicos.a2.util.Utils;

public class Jogo {
	private Integer id;
	private String nome;
	private Empresa empresa;
	private String plataforma;
	private String categoriaGenero;
	private LocalDate dataLancamento;
	private ClassificacaoIndicativa classificacaoIndicativa;
	private String descricaoJogo;
	@PositiveOrZero (message ="O preço deve ser maior ou igual a zero")
	private Double preco;
	private String imagem;
	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Jogo(Integer id, String nome, Empresa empresa, String plataforma, String categoriaGenero,
			LocalDate dataLancamento, int classificacaoIndicativa, String descricaoJogo, String imagem, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
		this.plataforma = plataforma;
		this.categoriaGenero = categoriaGenero;
		this.dataLancamento = dataLancamento;
		this.classificacaoIndicativa = ClassificacaoIndicativa.valueOf(classificacaoIndicativa);
		this.descricaoJogo = descricaoJogo;
		this.preco = preco;
		this.imagem = imagem;
	}
	
	public Jogo() {

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
	public String formatDate() {
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return this.dataLancamento.format(fomatter);
	}
	
	public String formatPrice() {
		return Utils.formatPrice(this.preco);
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", empresa=" + empresa + ", plataforma=" + plataforma
				+ ", categoriaGenero=" + categoriaGenero + ", dataLancamento=" + dataLancamento
				+ ", classificacaoIndicativa=" + classificacaoIndicativa + ", descricaoJogo=" + descricaoJogo
				+ ", preco=" + preco + ", imagem=" + imagem + "]";
	}
	
	

}
