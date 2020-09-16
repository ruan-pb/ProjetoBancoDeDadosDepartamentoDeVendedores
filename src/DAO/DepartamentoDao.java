package DAO;

import java.util.List;

import Entidades.Departamento;

public interface DepartamentoDao {
	
	void inserir(Departamento departamento);
	void update (Departamento departamento);
	void deleteId(Integer id);
	Departamento findById(Integer id);
	List<Departamento>findAll();
	

}
