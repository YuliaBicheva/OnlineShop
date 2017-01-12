package edu.bicheva.OnlineShop.dao.queries;

public interface SQL {
	
	String CREATE_GOODS = "INSERT INTO goods VALUES (default,?,?,?,?,?,?)";
	String UPDATE_GOODS = "UPDATE goods SET serialNo=?, name=?, description=?,availability=?,quantity=?,price=? WHERE id=?";
	String FIND_GOODS_BY_ID = "SELECT * FROM goods WHERE id=?";
	String DELETE_BY_ID_GOODS = "DELETE FROM goods WHERE id=?";
	String FIND_GOODS_BY_SERIAL_NO = "SELECT * FROM goods WHERE serialNo=?";
}
