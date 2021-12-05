package br.unitins.topicos.a2.models;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Usuario {
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	@Email(message = "Email com formato inválido.")
	@NotBlank(message = "O email deve ser informado.")
	private String email;
	private String senha;
	private Perfil perfil;
	
	
	
	public Usuario(Integer id, String nome, String cpf, LocalDate dataNascimento, String email, String senha,
			Perfil perfil) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}
	public Usuario( String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	public Usuario() {
	}
	/*
	 * CREATE TABLE public.empresa ( idempresa serial unique NOT null, nome varchar
	 * NOT NULL, sedeempresa varchar NOT NULL, ceo varchar NOT NULL, datafundacao date
	 * NOT NULL);
	 * 
	 * create table public.jogo( idjogo serial unique not null, nome varchar
	 * NOT NULL, empresa int NOT NULL, plataforma varchar NOT NULL, genero varchar not
	 * null, datalancamento date not null, classificaoindicativa int not null, foreign key
	 * (empresa) references empresa(idempresa) );
	 * 
	 * create table public.usuario( idusuario serial unique , nome varchar
	 * , cpf varchar , email varchar NOT NULL, datanascimento date, senha varchar NOT NULL,
	 * perfil integer not null;
	 */
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", senha=" + senha + ", perfil=" + perfil + "]";
	}
	public boolean checkEmailPwd(Usuario user) {
		if(this.getEmail().equals(user.getEmail())&&this.getSenha().equals(user.getSenha())) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
