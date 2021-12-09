package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{
	/*
	 * CREATE TABLE public.empresa ( id_empresa serial unique NOT null, nome varchar
	 	NOT NULL, sede_empresa varchar NOT NULL, ceo varchar NOT NULL, data_fundacao date
	 	NOT NULL);
	 * 
	 * create table public.venda(id_venda serial not null unique, data timestamp not null, valor decimal not null , usuario int not null, foreign key (usuario) references usuario(id_usuario) );
	 * 
	 *  create table public.jogo( id_jogo serial unique not null, nome varchar
	  NOT NULL,preco decimal NOT NULL, empresa int NOT NULL, plataforma varchar NOT NULL, genero varchar not
	  null, data_lancamento date not null,descricao_jogo varchar not null ,classificacao_indicativa int not null,
	  imagem character varying COLLATE pg_catalog."default" NOT NULL DEFAULT 'https://i.imgur.com/rYpwYDK.jpg'::bpchar,  foreign key
	  (empresa) references empresa(id_empresa) );
	 * 
	 * create table public.item_venda(id_item_venda serial not null, valor decimal not null, 
		quantidade int not null, venda int not null, jogo int not null, foreign key
		(venda) references venda(id_venda), foreign key (jogo) references  jogo(id_jogo));
	 * 
	 * create table public.usuario( id_usuario serial unique , nome varchar
	  , cpf varchar , email varchar NOT NULL, data_nascimento date, senha varchar NOT NULL,
	  perfil integer not null);
	  
	  CREATE TABLE IF NOT EXISTS public.cupom(
    	id_cupom integer NOT NULL DEFAULT nextval('cupom_id_seq'::regclass),
    	codigo character varying COLLATE pg_catalog."default" NOT NULL,
    	porcentagem integer NOT NULL,
    	ativado boolean NOT NULL,
    	CONSTRAINT cupom_pkey PRIMARY KEY (id_cupom)
		)
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
