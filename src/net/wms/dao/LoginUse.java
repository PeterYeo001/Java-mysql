package net.wms.dao;

import java.sql.SQLException;

import net.wms.bean.User;

public interface LoginUse {
		//查询
		public boolean 
		Query(User user,String sql) throws SQLException;
		//增加
		public void 
		Add(User user,String sql)throws SQLException;
		//删除
		public void Delete(User user,String sql)throws SQLException;
		//修改
		public void 
		Update(User user,String sql)throws SQLException;
}
