package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos.a2.models.ClassificacaoIndicativa;
import br.unitins.topicos.a2.models.Empresa;
import br.unitins.topicos.a2.models.Jogo;

public class JogoDao implements Dao<Jogo>{

	@Override
	public boolean incluir(Jogo obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if(conn==null) {
			return result;
		}
		String SQL = "insert into jogo(nome,preco,empresa,plataforma,genero,data_lancamento,classificao_indicativa) values (?,?,?,?,?,?,?)";
		PreparedStatement stat=null;
		
		try {
			stat = conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setDouble(2, obj.getPreco());
			stat.setInt(3,  obj.getEmpresa().getId());
			stat.setString(4, obj.getPlataforma());
			stat.setString(5, obj.getCategoriaGenero());
			stat.setDate(6, Date.valueOf(obj.getDataLancamento()));
			stat.setInt(7, obj.getClassificacaoIndicativa().getId());
			stat.execute();
			result = true;
		}catch (SQLException e) {
			System.out.println("Erro ao inserir o jogo");
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
	public boolean alterar(Jogo obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if(conn==null) {
			return result;
		}
		String SQL = "UPDATE jogo set nome=?,preco=?,empresa=?,plataforma=?,genero=?,data_lancamento=?,classificao_indicativa=? where id_jogo = ?";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(SQL);
			stat.setString(1, obj.getNome());
			stat.setDouble(2, obj.getPreco());
			stat.setInt(3,  obj.getEmpresa().getId());
			stat.setString(4, obj.getPlataforma());
			stat.setString(5, obj.getCategoriaGenero());
			stat.setDate(6, Date.valueOf(obj.getDataLancamento()));
			stat.setInt(7, obj.getClassificacaoIndicativa().getId());
			stat.setInt(8, obj.getId());
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
	public boolean excluir(Jogo obj) {
		Connection conn = Dao.getConnection();
		boolean resultado = false;
		if(conn==null) {
			return resultado;
		}
		PreparedStatement del = null;
		
		String SQL = "DELETE FROM jogo WHERE jogo.id_jogo = ?";
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
	public List<Jogo> obterTodos() {
		Connection conn = Dao.getConnection();
		if(conn==null) {
			return null;
		}
		List<Jogo> listaJogos = new ArrayList<Jogo>();
		String SQL = "SELECT * from jogo";
		ResultSet rs=null;
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(SQL);
			rs = stat.executeQuery();
			EmpresaDao empresaDao = new EmpresaDao();
			while(rs.next()) {
				listaJogos.add(new Jogo(
						rs.getInt(1),
						rs.getString(2),
						empresaDao.buscaPorId(rs.getInt(3)),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(5).toLocalDate(),
						rs.getInt(6),
						rs.getString(7),
						rs.getDouble(8)
						));
			}
		}catch (SQLException e) {
			
		}finally {
			try {
				conn.close();
			}catch(SQLException e){}
			try {
				rs.close();
			}catch(SQLException e){}
			try {
				stat.close();
			}catch(SQLException e){}
		}
		return listaJogos;
	}

}
