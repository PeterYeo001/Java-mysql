package net.wms.dao;

import java.sql.SQLException;

import net.wms.bean.Storage;

public interface Storagemanagement {
			//查询
			public void Query(String sql) throws SQLException;
			//增加
			public void Add(Storage storage,String sql)throws SQLException;
			//删除
			public void Delete(String sql)throws SQLException;
			//修改
			public void 
			Update(Storage storage,String sql)throws SQLException;
}
