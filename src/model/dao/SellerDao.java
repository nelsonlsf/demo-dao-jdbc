package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	
	//operações do Department
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id); //recebe um inteiro e verifica se existe algum vendedor, se existir retorna um Seller
	List<Seller> findAll();//retorna uma lista de Seller
	List<Seller> findByDepartment(Department department);

}
