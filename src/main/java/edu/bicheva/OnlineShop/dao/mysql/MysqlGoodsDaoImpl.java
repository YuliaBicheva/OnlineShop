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
			LOG.error("Cannot save Goods => {}", goods, e);
			throw new DbException("Cannot save Goods => " + goods, e);
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
			insertGoods(pst, goods);
			pst.executeUpdate();
		}catch(SQLException e){
			LOG.error("Cannot update Goods -> {}", goods, e);
			throw new DbException("Cannot update Goods --> " + goods,e);
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
            pst = con.prepareStatement(SQL.FIND_GOODS_BY_ID);
			pst.setLong(1, id);
            rs = pst.executeQuery();
            if(rs != null){
                if(rs.next()) {
                    goods = extractGoods(rs);
                }
            }
        }catch(SQLException e){
			LOG.error("Cannot find Goods by id {}", id, e);
			throw new DbException("Cannot find Goods by id " + id, e);
        }finally{
            DatabaseManager.close(rs,pst);
        }

        return goods;
	}


    @Override
	public Goods findBySerialNo(Long serialNo) throws DbException {
		Goods goods = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL.FIND_GOODS_BY_SERIAL_NO);
			pst.setLong(1, serialNo);
			rs = pst.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					goods = extractGoods(rs);
				}
			}
		} catch (SQLException e) {
			LOG.error("Cannot find Goods by serialNo {}", serialNo, e);
			throw new DbException("Cannot find Goods by serialNo " + serialNo, e);
		} finally {
			DatabaseManager.close(rs, pst);
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
	public List<Goods> findAll(int start, int step) throws DbException {
		List<Goods> goodsList = new ArrayList<Goods>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM goods LIMIT ? OFFSET ?");
			st.setInt(1, step);
			st.setInt(2, start);
			rs = st.executeQuery();
			while (rs.next()) {
				goodsList.add(extractGoods(rs));
			}
		} catch (SQLException e) {
			LOG.error("Cannot find all goods from database");
			throw new DbException("Cannot find find all goods", e);
		} finally {
			DatabaseManager.close(rs, st);
		}
		return goodsList;
	}

	@Override
	public void delete(Long id) throws DbException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL.DELETE_BY_ID_GOODS);
			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			LOG.error("Cannot delete Goods by id {}", id, e);
			throw new DbException("Cannot delete Goods by id " + id, e);
		} finally {
			DatabaseManager.close(rs, pst);
		}
	}

    @Override
	public int count() throws DbException {
		int quantity = 0;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT count(*) FROM goods");
			if (rs.next()) {
				quantity = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOG.error("Cannot find all goods from database");
			throw new DbException("Cannot find find all goods", e);
		} finally {
			DatabaseManager.close(rs, st);
		}
		return quantity;
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
		if(goods.getId() != null){
			pst.setLong(++i, goods.getId());
		}
	}
}
