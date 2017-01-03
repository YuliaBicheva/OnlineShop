package edu.bicheva.OnlineShop.dao.queries;

public interface SQL {
	
	String CREATE_GOODS = "INSERT INTO goods VALUES (default,?,?,?,?,?,?)";
	String UPDATE_GOODS = "UPDATE goods SET serialNo=?, name=?, description=?,availability=?,quantity=?,price=? WHERE id=?";
	String FIND_BY_ID_GOODS = "SELECT * FROM goods WHERE id=?";
}
