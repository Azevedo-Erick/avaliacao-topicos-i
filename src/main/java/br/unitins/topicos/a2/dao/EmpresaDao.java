package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos.a2.models.Empresa;
public class EmpresaDao implements Dao<Empresa>{

	@Override
	public boolean incluir(Empresa obj) {
		boolean result = true;
		String SQL = "insert into public.empresa( nome,sede_empresa,ceo,data_fundacao) values (?,?,?,?);";
		PreparedStatement stat = null;
		Connection conn=null;
		try {
			conn = Dao.getConnection();
			if(conn==null) {
				result= false;
			}
			stat= conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getSedeEmpresa());
			stat.setString(3, obj.getCeo());
			stat.setDate(4, Date.valueOf(obj.getDataFundacao()));
			
			stat.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao inserir empresa");
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
	public boolean alterar(Empresa obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if(conn==null) {
			return result;
		}
		String SQL = "UPDATE empresa SET nome=?,sede_empresa=?,ceo=?,data_fundacao=? WHERE id_empresa= ?;";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setString(2, obj.getSedeEmpresa());
			stat.setString(3, obj.getCeo());
			stat.setDate(4, Date.valueOf(obj.getDataFundacao()));
			stat.setInt(5, obj.getId());
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
	public boolean excluir(Empresa obj) {
		Connection conn = Dao.getConnection();
		boolean resultado = false;
		if(conn==null) {
			return resultado;
		}
		PreparedStatement del = null;
		
		String SQL = "DELETE FROM empresa WHERE empresa.id_empresa = ?";
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
	public List<Empresa> obterTodos() {
		Connection conn = Dao.getConnection();
		if(conn==null) {
			return null;
		}
		List<Empresa> empresas=new ArrayList<Empresa>();
		String sql = "SELECT * FROM empresa;";
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				empresas.add(new Empresa(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDate(5)!=null?rs.getDate(5).toLocalDate():null));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao solicitar a lista de empresas");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				
			}catch(SQLException e) {}
			try {
				rs.close();
			}catch(SQLException e) {}
		}
		return empresas;
	}


}
