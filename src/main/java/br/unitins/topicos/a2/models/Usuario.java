package br.unitins.topicos.a2.models;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

public class Usuario {
	private Integer id;
	private String nome;
	@CPF(message = "CPF inválido")
	private String cpf;
	@Past(message = "Data anterior ao dia de hoje")
	private LocalDate dataNascimento;
	@Email(message = "Email com formato inválido.")
	@NotBlank(message = "O email deve ser informado.")
	private String email;
	private String senha;
	private Perfil perfil;
	
	
	
	public Usuario(Integer id, String nome, String cpf,  String email, LocalDate dataNascimento, String senha,
			int perfil) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.perfil = Perfil.valueOf(perfil);
	}
	public Usuario( String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	public Usuario() {
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
