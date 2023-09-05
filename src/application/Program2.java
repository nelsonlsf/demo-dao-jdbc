package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== TESTE 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 3: department Insert ===");
		Department newDepartment = new Department(null, "TI");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId()); //para verificar se trouxe o Id criado de volta
		
		System.out.println("=== TESTE 4: department Update ===");
		dep = departmentDao.findById(1);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("=== TESTE 5: seller Delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed");
		
		sc.close();

	}

}
