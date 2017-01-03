package edu.bicheva.OnlineShop.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.bicheva.OnlineShop.dao.DatabaseManager;
import edu.bicheva.OnlineShop.dao.GoodsDao;
import edu.bicheva.OnlineShop.dao.queries.SQL;
import edu.bicheva.OnlineShop.entity.Goods;
import edu.bicheva.OnlineShop.entity.Money;
import edu.bicheva.OnlineShop.exception.DbException;

public class MysqlGoodsDaoImpl implements GoodsDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(MysqlGoodsDaoImpl.class);
	
	private Connection con;
	
	public MysqlGoodsDaoImpl() {
		
	}
	
	public MysqlGoodsDaoImpl(Connection connection) {
		this.con = connection;
	}

    @Override
    public void setConnection(Connection connection) {
        this.con = connection;
    }

    @Override
	public Goods save(Goods goods) throws DbException{
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			pst = con.prepareStatement(SQL.CREATE_GOODS, PreparedStatement.RETURN_GENERATED_KEYS);
			
			insertGoods(pst,goods);
			
			if(pst.executeUpdate() > 0){
				rs = pst.getGeneratedKeys();
				if(rs.next()){
					goods.setId(rs.getInt(1));
				}
			}
		}catch(SQLException e){
			String msg = "Cannot save Goods";
			LOG.error(msg,e);
			throw new DbException(msg,e);
		}finally{
			DatabaseManager.close(rs,pst);
		}
		
		return goods;
	}

	@Override
	public Goods update(Goods goods) throws DbException{
		PreparedStatement pst = null;
		try{
			pst = con.prepareStatement(SQL.UPDATE_GOODS);
			pst.executeUpdate();
		}catch(SQLException e){
			String msg = "Cannot update Goods";
			LOG.error(msg,e);
			throw new DbException(msg,e);
		}finally{
			DatabaseManager.close(pst);
		}
		
		return goods;
	}

	@Override
	public Goods findById(Long id) throws DbException {
        Goods goods = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareStatement(SQL.FIND_BY_ID_GOODS);
            rs = pst.executeQuery();
            if(rs != null){
                if(rs.next()) {
                    goods = extractGoods(rs);
                }
            }
        }catch(SQLException e){
            String msg = "Cannot find Goods by id {}";
            LOG.error(msg, id,e);
        }finally{
            DatabaseManager.close(rs,pst);
        }

        return goods;
	}


    @Override
	public List<Goods> findAll() throws DbException {
    	List<Goods> goodsList = new ArrayList<Goods>();
		Statement st = null;
		ResultSet rs = null;
		try{
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM goods");
			while(rs.next()){
				goodsList.add(extractGoods(rs));
			}
		}catch(SQLException e){
			LOG.error("Cannot find all goods from database");
			throw new DbException("Cannot find find all goods",e);
		}finally{
			DatabaseManager.close(rs, st);
		}
		return goodsList;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

    private Goods extractGoods(ResultSet rs) throws SQLException {
        Goods goods = new Goods();
        goods.setId(rs.getInt("id"));
        goods.setSerialNo(rs.getLong("serialNo"));
        goods.setName(rs.getString("name"));
        goods.setDescription(rs.getString("description"));
        goods.setAvailability(rs.getBoolean("availability"));
        goods.setQuantity(rs.getInt("quantity"));
        goods.setPrice(Money.valueOf(rs.getDouble("price")));
        return goods;
    }

	private void insertGoods(PreparedStatement pst, Goods goods) throws SQLException {
		int i = 0;
		pst.setLong(++i, goods.getSerialNo());
		pst.setString(++i, goods.getName());
		pst.setString(++i, goods.getDescription());
		pst.setBoolean(++i, goods.isAvailability());
		pst.setInt(++i, goods.getQuantity());
		pst.setDouble(++i, goods.getPrice().doubleValue());
	}
}
