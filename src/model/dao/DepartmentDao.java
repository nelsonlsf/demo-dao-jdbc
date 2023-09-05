package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	//operações do Department
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id); //recebe um inteiro e verifica se existe algum departamento, se existir retorna um departamento
	List<Department> findAll();//retorna uma lista de departamento

}
