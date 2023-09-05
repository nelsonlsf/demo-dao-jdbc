package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	//classe para instanciar meus DAOs, utilizando operações estáticas
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(); //manobra para não precisar expor a implementação
	}
	

}
