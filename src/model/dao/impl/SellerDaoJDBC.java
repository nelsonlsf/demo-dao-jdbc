package model.dao.impl; //pacote onde está a implementação do DAO

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{ //implementa a interface SellerDao

	//criado o objeto conn, para que seja possível utilizar em todas as operações a fim de conectar com o banco
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		
		
	}

	@Override
	public void update(Seller obj) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"); //criando o SELECT
			st.setInt(1, id);//o id que foi passado por parâmetro
			rs = st.executeQuery();
			//após executar a query, o resultSet está apontando para a posição 0 (que não possui dados)
			if(rs.next()) { //testar se veio algum resultado, se a consulta não teve nenhum registro de retorno, passa direto por essa condição
				//é necessário navegar entre os registros retornados para instanciar os objetos (Vendedor com o Departamento pendurado nele)
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));//para buscar o ID do departmento 
				dep.setName(rs.getString("DepName"));//para buscar o nome do departamento
				//após os comandos acima, foi instanciado um Departamento e setamos seus valores
				
				//agora é necessário instanciar um vendedor
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				//agora preciso verificar quem será o Departamento associado com o Seller, será associado o objeto Departamento criado dep
				obj.setDepartment(dep);
				return obj;//retornar o objeto Seller (pois na declaração do método diz que retorna um Seller
				
			}
			return null;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
