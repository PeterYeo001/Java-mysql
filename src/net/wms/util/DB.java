package net.wms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	//锟斤拷锟捷匡拷锟街�
	private String Driver_name =
			"jdbc:mysql://localhost:3306/wms";
	//锟斤拷锟捷匡拷锟矫伙拷锟斤拷
	private String USER = "root";
	//锟斤拷锟捷匡拷锟斤拷锟斤拷
	private String PASS = "";
	//锟斤拷锟捷匡拷锟斤拷锟斤拷
	public static Connection con;
	//锟斤拷锟届方锟斤拷
	public DB(){
		try {
			//锟斤拷锟斤拷锟斤拷锟斤拷
			Class.forName("com.mysql.jdbc.Driver");
			//锟斤拷取锟斤拷锟斤拷
			con = 
			DriverManager.getConnection(
			Driver_name, USER, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//锟斤拷取锟斤拷锟斤拷
	public static Connection getConnection(){
		if(con == null){
			new DB();
		}
		return con;
	}
}
