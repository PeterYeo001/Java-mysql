package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.wms.bean.User;
import net.wms.dao.LoginUseImp;

public class Userdelete extends IndexAdmin {
	//声明部分对象
	JLabel name;
	JLabel pwd;
	JLabel style;
	JTextField dname;
	//为User类初始化对象
	User user = new User();
	
	//构造函数
	public Userdelete(String name) {
		super(name);
		init();
	}
	
	public void init() {
		//初始化字体
		Font d = new Font("楷体", Font.BOLD, 24);
		Font f = new Font("楷体", Font.BOLD, 18);
		//初始化对象
		JLabel userdelete = new JLabel("用户删除");
		JLabel deletename = new JLabel("输入用户名：");
		dname = new JTextField();
		JLabel usertitle = new JLabel("删除的用户信息");
		JLabel username = new JLabel("用户名：");
		name = new JLabel();
		JLabel userpwd = new JLabel("密  码：");
		pwd = new JLabel();
		JLabel userstyle = new JLabel("类  型：");
		style = new JLabel();
		JButton submit = new JButton("确定");
		JButton delete = new JButton("删除");
		//设置对象
		userdelete.setBounds(130, 30, 100, 40);
		userdelete.setFont(d);
		deletename.setBounds(20, 90, 120, 30);
		deletename.setFont(f);
		dname.setBounds(130, 90, 150, 30);
		dname.setFont(f);
		usertitle.setBounds(100, 140, 200, 40);
		usertitle.setFont(d);
		username.setBounds(60, 200, 80, 30);
		username.setFont(f);
		name.setBounds(140, 200, 150, 30);
		name.setFont(f);
		userpwd.setBounds(60, 260, 80, 30);
		userpwd.setFont(f);
		pwd.setBounds(140, 260, 150, 30);
		pwd.setFont(f);
		userstyle.setBounds(60, 320, 80, 30);
		userstyle.setFont(f);
		style.setBounds(140, 320, 150, 30);
		style.setFont(f);
		submit.setBounds(290, 90, 80, 30);
		submit.setFont(f);
		delete.setBounds(150, 380, 80, 30);
		delete.setFont(f);
		//添加对象
		index.add(userdelete);
		index.add(deletename);
		index.add(dname);
		index.add(submit);
		index.add(usertitle);
		index.add(username);
		index.add(name);
		index.add(userpwd);
		index.add(pwd);
		index.add(style);
		index.add(userstyle);
		index.add(delete);
		
		//为确定按钮添加监听事件
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//从文本框中取得用户名设置进user对象中
				user.setusername(dname.getText());
				LoginUseImp l = new LoginUseImp();
				boolean b;
				try {
					//执行sql语句
					b = l.Query1(user, "select * from users where username= '"+dname.getText()+"'");
					if(b){
						//将数据库中的值设置进文本框
						name.setText(user.getusername());
						pwd.setText(user.getuserpwd());
						style.setText(user.getFlag());
					} else {
						//未查找到提示框
						JOptionPane.showMessageDialog(null,"未查到该用户");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//为删除按钮添加监听事件
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//将选中的名字添加进文本框
				user.setusername(dname.getText());
				LoginUseImp l = new LoginUseImp();
				try {
					//执行删除的sql语句
					l.Delete(user, "delete from users where username='"+dname.getText()+"'");
					JOptionPane.showMessageDialog(null, "删除成功");
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
	}
}