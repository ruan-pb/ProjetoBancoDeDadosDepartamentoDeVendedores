package DAO;

import Entidade.DAO.Implementacao.VendedorDaoJDBC;

public class DaoFactory {
	
	public static VendedorDao criarVendedorDao(){
		return new VendedorDaoJDBC();
	}

}
