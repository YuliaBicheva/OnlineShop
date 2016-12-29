package edu.bicheva.OnlineShop.dao.queries;

public interface SQL {
	
	String CREATE_GOODS = "INSERT INTO goods VALUES ()";
	String UPDATE_GOODS = "UPDATE goods SET ";
	String FIND_BY_ID_GOODS = "SELECT * FROM goods WHERE id=?";
}
