package br.unitins.topicos.a2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos.a2.models.Carrinho;
import br.unitins.topicos.a2.models.JogosVenda;
import br.unitins.topicos.a2.models.Usuario;

public class CarrinhoDao implements Dao<Carrinho> {

	@Override
	public boolean incluir(Carrinho obj) {
		Connection conn = Dao.getConnection();
		boolean result = false;
		if (conn == null) {
			return result;
		}

		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQL = "INSERT INTO venda(data,valor, usuario) VALUES (?,?,?)";
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(SQL, stat.RETURN_GENERATED_KEYS);
			stat.setTimestamp(1, Timestamp.valueOf(obj.getData()));
			stat.setDouble(2, obj.getTotalVenda());
			stat.setInt(3, obj.getUsuario().getId());
			stat.execute();

			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				obj.setId(rs.getInt("id_venda"));
			}

			salvarItensVenda(obj, conn);
			conn.commit();
			result = true;
		} catch (SQLException e) {
			System.out.println("Erro ao concluir venda");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException err) {
				err.printStackTrace();
			}
			result = false;
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}

	private void salvarItensVenda(Carrinho carrinho, Connection conn) throws SQLException {
		String SQL = "INSERT INTO item_venda(valor,quantidade,venda,jogo) values (?,?,?,?)";
		PreparedStatement stat = null;
		for (JogosVenda jogo : carrinho.getListaJogoVenda()) {
			stat = conn.prepareStatement(SQL);
			stat.setDouble(1, jogo.getValor());
			stat.setInt(2, jogo.getQuantidade());
			stat.setInt(3, carrinho.getId());
			stat.setInt(4, jogo.getJogo().getId());
			stat.execute();
		}

	}
	@Override
	public boolean alterar(Carrinho obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Carrinho obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Carrinho> obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Carrinho> obterTodos(Usuario obj) {
		Connection conn = Dao.getConnection();
		List<Carrinho> listaDeCompras = new ArrayList<Carrinho>();
		if (conn == null) {
			return null;
		}
		String SQL = "SELECT id_venda, data, valor FROM venda WHERE venda.usuario = ? ORDER BY venda.id_venda DESC";
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			
			stat = conn.prepareStatement(SQL);
			stat.setInt(1, obj.getId());
			rs = stat.executeQuery();
			while(rs.next()) {
				listaDeCompras.add(
						new Carrinho(rs.getInt("id_venda"),
						rs.getTimestamp("data").toLocalDateTime(),
						rs.getDouble("valor"))
						);
			}
		} catch (SQLException e) {
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}

			try {
				rs.close();
			} catch (SQLException e) {

			}

			try {
				stat.close();
			} catch (SQLException e) {

			}
		}
		return listaDeCompras;
	}
	
}
