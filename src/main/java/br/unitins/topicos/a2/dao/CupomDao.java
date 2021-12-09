package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.unitins.topicos.a2.models.Cupom;
import br.unitins.topicos.a2.models.Perfil;
import br.unitins.topicos.a2.models.Usuario;

public class CupomDao implements Dao<Cupom> {

	@Override
	public boolean incluir(Cupom obj) {
		boolean result = true;
		String SQL = "INSERT INTO cupom(codigo, porcentagem, ativado) VALUES (?,?,?);";
		PreparedStatement stat = null;
		Connection conn=null;
		try {
			conn = Dao.getConnection();
			if(conn==null) {
				result= false;
			}
			stat= conn.prepareStatement(SQL);
			stat.setString(1, obj.getCodigo());
			stat.setInt(2, obj.getPorcentagem());
			stat.setBoolean(3, obj.isAtivo());
			
			stat.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao inserir cupom");
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

	@Override
	public boolean alterar(Cupom obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if(conn==null) {
			return result;
		}
		String SQL = "UPDATE cupom SET codigo=?,porcentagem=?,ativado=? WHERE id_cupom= ?;";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(SQL);
			stat.setString(1, obj.getCodigo());
			stat.setInt(2, obj.getPorcentagem());
			stat.setBoolean(3, obj.isAtivo());
			stat.setInt(4, obj.getId());
			stat.execute();
			result = true;
		}catch(SQLException e){
			System.out.println("Erro ao atualizar o cupom");
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
	public boolean excluir(Cupom obj) {
		Connection conn = Dao.getConnection();
		boolean resultado = false;
		if(conn==null) {
			return resultado;
		}
		PreparedStatement del = null;
		
		String SQL = "DELETE FROM cupom WHERE id_cupom = ?";
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
	public List<Cupom> obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Cupom verificarCupom(String codigo) {
		Connection conn = Dao.getConnection();
		String sql = "SELECT id_cupom, codigo, porcentagem, ativado FROM cupom WHERE codigo = ? AND ativado = true";
		if (conn == null) 
			return null;
			
		PreparedStatement stat = null;
		ResultSet rs = null;
		Cupom cupom = null;
		
		try {	
			stat = conn.prepareStatement(sql);
			stat.setString(1, codigo);
			rs = stat.executeQuery();
			
			if(rs.next()) {
				cupom = new Cupom();
				cupom.setId(rs.getInt("id_cupom"));
				cupom.setCodigo(rs.getString("codigo"));
				cupom.setPorcentagem(rs.getInt("porcentagem"));
				cupom.setAtivo(rs.getBoolean("ativado"));
				
			}
			
		} catch (SQLException e) {
			cupom = null;
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
		return cupom;		
	}

}
