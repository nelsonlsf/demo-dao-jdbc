package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	//classe para instanciar meus DAOs, utilizando operações estáticas
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection()); //manobra para não precisar expor a implementação
	}
	

}
