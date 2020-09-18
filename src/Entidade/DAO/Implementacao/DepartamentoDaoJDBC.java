package Entidade.DAO.Implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import DAO.DepartamentoDao;
import Entidades.Departamento;
import db.DB;
import db.DbIntegridadeException;

public class DepartamentoDaoJDBC implements DepartamentoDao {

	private Connection conn;

	public DepartamentoDaoJDBC(Connection con) {
		this.conn = con;
	}

	@Override
	public void inserir(Departamento departamento) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, departamento.getNome());

			int linhasAlteradas = ps.executeUpdate();

			if (linhasAlteradas > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					departamento.setId(id);
				} else {
					throw new DbIntegridadeException("Não houve mudanças no banco de dados");
				}
				DB.fecharResultSet(rs);
			}

		} catch (SQLException e) {
			throw new DbIntegridadeException(e.getMessage());
		} finally {
			DB.fecharStatement(ps);
		}

	}

	@Override
	public void update(Departamento departamento) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("UPDATE department SET (Name) VALUES (?) WHERE Id = ?");

			ps.setString(1, departamento.getNome());
			ps.setInt(2, departamento.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegridadeException(e.getMessage());
		} finally {
			DB.fecharStatement(ps);
		}

	}

	@Override
	public void deleteId(Integer id) {
		PreparedStatement ps =null;
		try {
			ps =conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			
			ps.setInt(1, id);
				
			
		}
		catch(SQLException e) {
			throw new DbIntegridadeException(e.getMessage());
		}
		finally {
			DB.fecharStatement(ps);
		}

	}

	@Override
	public Departamento findById(Integer id) {
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			ps =conn.prepareStatement("Select * From department WHERE Id = ?");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Name"));
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbIntegridadeException(e.getMessage());
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(ps);
		}
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement ps =null;
		ResultSet rs =null;
		
		List<Departamento> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement("Select * From department");
			
			rs =ps.executeQuery();
			
			while(rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("Id"));
				dep.setNome(rs.getString("name"));
				lista.add(dep);
				
			}
			return lista;
		}
		
		catch(SQLException e) {
			throw new DbIntegridadeException(e.getMessage());
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(ps);
		}
	}

}
