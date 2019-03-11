package net.wms.dao;

import java.sql.SQLException;

import net.wms.bean.Goods;


public interface Goodsmanagement {
			//查询
			public void Query(String sql) throws SQLException;
			//增加
			public void Add(Goods goods,String sql)throws SQLException;
			//删除
			public void Delete(String sql)throws SQLException;
			//修改
			public void Update(Goods goods,String sql)throws SQLException;
            public void Out(String sql) throws SQLException;
			public void Out(String sql,int number) throws SQLException;
			
}
