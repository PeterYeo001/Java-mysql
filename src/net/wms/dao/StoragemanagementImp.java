package net.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import net.wms.bean.Storage;
import net.wms.util.DB;

public class StoragemanagementImp implements Storagemanagement{
			public static Vector vec = new Vector();
			public static Vector vr = new Vector();
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
					v.add(rs.getString("storagename"));
					v.add(rs.getString("storagestyle"));
					v.add(rs.getInt("storageID"));
					vec.add(v);
				}
			}
			
			public void Query1(String sql) throws SQLException {
				// TODO Auto-generated method stub
				//加载SQL语句
				PreparedStatement pra = conn.prepareStatement(sql);
				//放入结果集
				ResultSet rs = pra.executeQuery();
				vr.removeAllElements();
				while(rs.next()) {
					vr.add(rs.getInt("storageID"));
				}
			}
			
			public void Add(Storage storage, String sql) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pra = conn.prepareStatement(sql);
				pra.setString(1, storage.getStoragename());
				pra.setString(2, storage.getStoragestyle());
				pra.setInt(3, storage.getStorageID());
				pra.executeUpdate();
				pra.close();
			}

			public void Delete(String sql) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pra = conn.prepareStatement(sql);
				pra.executeUpdate();
				pra.close();
			}

			public void Update(Storage storage, String sql) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pra = conn.prepareStatement(sql);
				pra.setString(1, storage.getStoragename());
				pra.setString(2, storage.getStoragestyle());
				pra.setInt(3, storage.getStorageID());
				pra.executeUpdate();
				pra.close();
			}
}
