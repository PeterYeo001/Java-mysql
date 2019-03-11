package net.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import net.wms.bean.Goods;
import net.wms.util.DB;

public class GoodsmanagementImp implements Goodsmanagement{
			public static Vector vec = new Vector();
			//获取数据库连接
			Connection conn = DB.getConnection();
			//查询方法
			public void Query(String sql) throws SQLException {
				// TODO Auto-generated method stub
				//加载SQL语句
				PreparedStatement pra = conn.prepareStatement(sql);
				//放入结果集
				ResultSet rs = pra.executeQuery();
				vec.removeAllElements();
				while(rs.next()) {
					Vector v = new Vector();
					v.add(rs.getInt("id"));
					v.add(rs.getString("goodsname"));
					v.add(rs.getString("goodsstyle"));
					v.add(rs.getInt("goodsnumber"));
					v.add(rs.getInt("storageID"));
					vec.add(v);
				}
			}
			
			public boolean Query1(Goods goods, String sql) throws SQLException {
				// TODO Auto-generated method stub
				//加载SQL语句
				PreparedStatement pra = conn.prepareStatement(sql);
				//放入结果集
				ResultSet rs = pra.executeQuery();
				//遍历结果集
				return false;
			}
			
			public void Add(Goods goods, String sql) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pra = conn.prepareStatement(sql);
				pra.setString(1, goods.getGoodsname());
				pra.setString(2, goods.getGoodsstyle());
				pra.setInt(3, goods.getGoodsnumber());
				pra.setString(4, goods.getStorageID());
				pra.executeUpdate();
				pra.close();
			}

			public void Delete(String sql) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pra = conn.prepareStatement(sql);
				pra.executeUpdate();
				pra.close();
			}

			public void Update(Goods goods, String sql) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pra = conn.prepareStatement(sql);
				pra.setString(1, goods.getGoodsname());
				pra.setString(2, goods.getGoodsstyle());
				pra.setInt(3, goods.getGoodsnumber());
				pra.setString(4, goods.getStorageID());
				pra.executeUpdate();
				pra.close();
			}
			
			public void Out(String sql,int num) throws SQLException {
				
				PreparedStatement pra = conn.prepareStatement(sql);
	            pra.setInt(1, num);
				//pra.setString(1, goods.getGoodsname());
				//pra.setString(2, goods.getGoodsstyle());
				//pra.setInt(1, goods.getGoodsnumber());
				//pra.setString(4, goods.getStorageID());
				pra.executeUpdate();
				pra.close();
			}

			@Override
			public void Out(String sql) throws SQLException {
				// TODO Auto-generated method stub
				
			}
}
