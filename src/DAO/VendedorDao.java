package DAO;

import java.util.List;

import Entidades.Vendedor;

public interface VendedorDao {
	void inserir(Vendedor departamento);
	void update (Vendedor departamento);
	void deleteId(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor>findAll();

}
