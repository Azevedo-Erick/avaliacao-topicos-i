package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.unitins.topicos.a2.models.Usuario;
import br.unitins.topicos.a2.util.Utils;


public class UsuarioDao implements Dao<Usuario>{

	@Override
	public boolean incluir(Usuario obj) {
		boolean result = true;
		String SQL = "insert into public.usuario(email,cpf,senha,perfil) values (?,?,?,1);";
		PreparedStatement stat = null;
		Connection conn=null;
		try {
			conn = Dao.getConnection();
			if(conn==null) {
				result= false;
			}
			stat= conn.prepareStatement(SQL);
			stat.setString(1, obj.getEmail());
			stat.setString(2, obj.getCpf());
			stat.setString(3, Utils.hash(obj));
			
			stat.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao inserir cliente");
			e.printStackTrace();
			result =false;
		}finally{
			try {
				conn.close();
			}catch(SQLException e){}
			try {
				stat.close();
			}catch(SQLException e){}
		}
		return result;
	}
//TODO: Método de login
	public boolean login(Usuario obj) {
		String sql = "select * from usuario where usuario.email = ? and usuario.senha=?";
		
		Usuario user=new Usuario();
		boolean result = true;
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement stat=null;
		try {
			conn = Dao.getConnection();
			if(conn==null) {
				result = false;
			}
			stat = conn.prepareStatement(sql);
			stat.setString(1, obj.getEmail());
			stat.setString(2, Utils.hash(obj));
			rs=stat.executeQuery();
			
			if(rs.next()) {
				user.setEmail(rs.getString("email")); 
				user.setSenha(rs.getString("senha"));
			}else {
				System.out.println("Sem dados");
			}
			obj.setSenha(Utils.hash(obj));
			if(obj.checkEmailPwd(user)) {
				Utils.redirect("index.xhtml");
				System.out.println("Login feito com sucesso");
			}else {
				System.out.println("Usuário não encontrado");
				System.out.println(obj);
				System.out.println(user);
			}
			
		}catch(SQLException e) {
			System.out.println("Erro ao fazer o login");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {}
			try {
				stat.close();
			}catch(SQLException e) {}
			try {
				rs.close();
			}catch(SQLException e) {}

		}
		return result;
	}
	
	@Override
	public boolean alterar(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
