package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.wms.bean.User;
import net.wms.dao.LoginUseImp;

public class Useradd extends IndexAdmin{
	//声明部分对象
	JTextField name;
	JTextField pwd;
	JTextField style;
	//为User类初始化对象user
	User user = new User();
	
	//构造函数
	public Useradd(String name) {
		super(name);
		init();
	}
	
	
	public void init() {
		//初始化字体
		Font d = new Font("楷体", Font.BOLD, 24);
		Font f = new Font("楷体", Font.BOLD, 18);
		//初始化对象
		JLabel usertitle = new JLabel("添加用户");
		JLabel username = new JLabel("用户名：");
		name = new JTextField();
		JLabel userpwd = new JLabel("密  码：");
		pwd = new JTextField();
		JLabel userstyle = new JLabel("类  型：");
		style = new JTextField();
		JButton submit = new JButton("提交");
		JButton reset = new JButton("重置");
		//设置对象的位置、大小和字体
		usertitle.setBounds(130, 60, 100, 40);
		usertitle.setFont(d);
		username.setBounds(60, 140, 80, 30);
		username.setFont(f);
		name.setBounds(140, 140, 150, 30);
		name.setFont(f);
		userpwd.setBounds(60, 200, 80, 30);
		userpwd.setFont(f);
		pwd.setBounds(140, 200, 150, 30);
		pwd.setFont(f);
		userstyle.setBounds(60, 260, 80, 30);
		userstyle.setFont(f);
		style.setBounds(140, 260, 150, 30);
		style.setFont(f);
		submit.setBounds(90, 320, 80, 30);
		submit.setFont(f);
		reset.setBounds(200, 320, 80, 30);
		reset.setFont(f);
		//将对象添加到对象中
		index.add(usertitle);
		index.add(username);
		index.add(name);
		index.add(userpwd);
		index.add(pwd);
		index.add(style);
		index.add(userstyle);
		index.add(submit);
		index.add(reset);
		
		//为重置按钮设置监听事件
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//清空用户名框、密码框、用户类型
				name.setText("");
				pwd.setText("");
				style.setText("");
			}
		});
		
		//未提交按钮设置监听事件
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//判断文本框是否为空
				if(name.getText().equals("") || pwd.getText().equals("") || style.getText().equals("")) {
					//为空，弹出提示框
					JOptionPane.showMessageDialog(null,"请输入内容");
				} else {
					//不为空
					//从文本框中提取数据并存放到user对象中
					user.setusername(name.getText());
					user.setuserpwd(pwd.getText());
					user.setFlag(style.getText());
					//为登陆接口实现类初始化对象
					LoginUseImp l = new LoginUseImp();
					try {
						//执行sql语句
						l.Add(user, "insert into users(username,userpwd,flag) values(?,?,?)");
						//清空文本框
						name.setText("");
						pwd.setText("");
						style.setText("");
						//添加成功提示框
						JOptionPane.showMessageDialog(null, "添加成功");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
