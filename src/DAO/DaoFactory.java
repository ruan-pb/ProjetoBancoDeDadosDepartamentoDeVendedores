package DAO;

import Entidade.DAO.Implementacao.VendedorDaoJDBC;
import db.DB;

public class DaoFactory {
	
	public static VendedorDao criarVendedorDao(){
		return new VendedorDaoJDBC(DB.getConexao());
	}

}
