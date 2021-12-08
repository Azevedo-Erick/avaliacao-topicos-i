package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos.a2.models.Perfil;
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
//Método de login
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
	
	//Método de cadastro de usuário do administrador
	public boolean cadastar(Usuario obj) {
		boolean result = true;
		String SQL = "insert into public.usuario(nome, cpf, email,senha,data_nascimento,perfil) values (?,?,?,?,?,?);";
		PreparedStatement stat = null;
		Connection conn=null;
		try {
			conn = Dao.getConnection();
			if(conn==null) {
				result= false;
			}
			stat= conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getCpf());
			stat.setString(3, obj.getEmail());
			stat.setString(4, Utils.hash(obj));
			stat.setDate(5, Date.valueOf(obj.getDataNascimento()));
			stat.setInt(6, obj.getPerfil().getId());
			
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
	
	//Método para verificar se existe um usuário no sistema
		public Usuario verificarUsuario(String email, String senha) {
			Connection conn = Dao.getConnection();
			String sql = "SELECT id_usuario, nome, cpf, email, data_nascimento, senha, perfil FROM usuario WHERE email = ? AND senha = ? ORDER BY nome";
			if (conn == null) 
				return null;
				
			PreparedStatement stat = null;
			ResultSet rs = null;
			Usuario usuario = null;
			
			try {	
				stat = conn.prepareStatement(sql);
				stat.setString(1, email);
				stat.setString(2, senha);
				
				rs = stat.executeQuery();
				
				if(rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id_usuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setEmail(rs.getString("email"));
					
					Date data = rs.getDate("data_nascimento");
					if (data == null) {
						usuario.setDataNascimento(null);
					} else {
						usuario.setDataNascimento(data.toLocalDate());
						}
					usuario.setSenha(rs.getString("senha"));
					usuario.setPerfil(Perfil.valueOf(rs.getInt("perfil")));
				}
				
			} catch (SQLException e) {
				usuario = null;
				e.printStackTrace();
			} finally {
				try {
					stat.close();
				} catch (SQLException e) {}
				try {
					rs.close();
				} catch (SQLException e) {}
				try {
					conn.close();
				} catch (SQLException e) {}
			}		
			return usuario;		
		}
	
	@Override
	public boolean alterar(Usuario obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if(conn==null) {
			return result;
		}
		String SQL = "UPDATE usuario SET nome=?,cpf=?,data_nascimento=?,email=?, senha=?,perfil=? WHERE id_usuario = ?;";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getCpf());
			stat.setDate(3, Date.valueOf(obj.getDataNascimento()));
			stat.setString(4, obj.getEmail());
			stat.setString(5, Utils.hash(obj));
			stat.setInt(6, obj.getPerfil().getId());
			stat.setInt(7, obj.getId());
			
			stat.execute();
			result = true;
		}catch(SQLException e){
			System.out.println("Erro ao atualizar os dados");
			e.printStackTrace();
			return result;
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				
			}
			try {
				stat.close();
			}catch (SQLException e) {
				
			}
		}
		return result;
	}

	
	public boolean editarInformacoes(Usuario obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if(conn==null) {
			return result;
		}
		String SQL = "UPDATE usuario SET nome=?,cpf=?,data_nascimento=?,email=?, senha=? WHERE id_usuario = ?;";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getCpf());
			stat.setDate(3, Date.valueOf(obj.getDataNascimento()));
			stat.setString(4, obj.getEmail());
			stat.setString(5, Utils.hash(obj));
			stat.setInt(6, obj.getId());
			
			stat.execute();
			result = true;
		}catch(SQLException e){
			System.out.println("Erro ao atualizar os dados");
			e.printStackTrace();
			return result;
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				
			}
			try {
				stat.close();
			}catch (SQLException e) {
				
			}
		}
		return result;
	}
	
	
	@Override
	public boolean excluir(Usuario obj) {
		Connection conn = Dao.getConnection();
		boolean resultado = false;
		if(conn==null) {
			return resultado;
		}
		PreparedStatement del = null;
		
		String SQL = "DELETE FROM usuario WHERE usuario.id_usuario = ?";
		try {
			del = conn.prepareStatement(SQL);
			del.setInt(1, obj.getId());
			del.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return resultado;
		}finally {
			try {
				conn.close();
			}catch(SQLException e){
				
			}
			try {
				del.close();
			}catch(SQLException e) {
				
			}
		}
		return !resultado;
	
	}

	@Override
	public List<Usuario> obterTodos() {
		Connection conn = Dao.getConnection();
		if(conn==null) {
			return null;
		}
		List<Usuario> usuarios=new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuario ORDER BY id_usuario;";
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				usuarios.add(new Usuario(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDate(5)!=null?rs.getDate(5).toLocalDate():null,
						rs.getString(6),
						rs.getInt(7)));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao solicitar a lista de usuários");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				
			}catch(SQLException e) {}
			try {
				rs.close();
			}catch(SQLException e) {}
		}
		return usuarios;
	}

}
