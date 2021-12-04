package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{
	/*
	 * CREATE TABLE public.empresa ( idempresa serial unique NOT null, nome varchar
	 * NOT NULL, sedeempresa varchar NOT NULL, ceo varchar NOT NULL, datafundacao date
	 * NOT NULL);
	 * 
	 * create table public.jogo( idjogo serial unique not null, nome varchar
	 * NOT NULL,preco decimal NOT NULL, empresa int NOT NULL, plataforma varchar NOT NULL, genero varchar not
	 * null, datalancamento date not null, classificaoindicativa int not null, foreign key
	 * (empresa) references empresa(idempresa) );
	 * 
	 * create table public.usuario( idusuario serial unique , nome varchar
	 * , cpf varchar , email varchar NOT NULL, datanascimento date, senha varchar NOT NULL,
	 * perfil integer not null);
	 */
	public boolean incluir(T obj);
	public boolean alterar(T obj);
	public boolean excluir(T obj);
	public List<T> obterTodos();
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Não encontrei o driver");
			e.printStackTrace();
			return null;
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/pingadb","topicos1","123456");
		}catch(SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();
		}
		return conn;
	}
}
