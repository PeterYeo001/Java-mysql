package net.wms.view;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.wms.dao.LoginUseImp;

public class Userselect extends IndexAdmin{
	//声明对象
	int id;
	private JTable table;
	
	//构造函数
	public Userselect(String name) {
		super(name);
		init();
	}
	
	public void init() {
		//初始化字体
		Font t = new Font("楷体",Font.BOLD, 24);
		final Font f = new Font("楷体",Font.BOLD, 15);
		//初始化对象
		JLabel title = new JLabel("用户信息");
		title.setFont(t);
		title.setBounds(130, 40, 100, 40);
		//初始化Vector集合
		Vector v = new Vector();
		//为集合添加字段
		v.add("编号");
		v.add("用户名");
		v.add("用户类型");
		LoginUseImp l = new LoginUseImp();
		//初始化表格
		table = new JTable(l.vec,v);
		table.setFont(f);
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(40, 120, 300, 200);
		try {
			l.Select("select * from users");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		index.add(title);
		index.add(jp);
	}
}
