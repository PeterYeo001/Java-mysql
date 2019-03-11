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

public class Userupdate extends Index{
	
	JLabel uname;
	JTextField pwd;
	JTextField pass;
	User user = new User();
	
	public Userupdate(String name) {
		super(name);
		init(name);
	}
	
	public void init(String name) {
		user.setusername(name);
		Font d = new Font("楷体", Font.BOLD, 24);
		Font f = new Font("楷体", Font.BOLD, 18);
		JLabel usertitle = new JLabel("修改密码");
		JLabel username = new JLabel("用  户  名：");
		uname = new JLabel();
		JLabel userpwd = new JLabel("新  密  码：");
		pwd = new JTextField();
		JLabel userpass = new JLabel("再输次密码：");
		pass = new JTextField();
		JButton submit = new JButton("修改");
		JButton reset = new JButton("重置");
		usertitle.setBounds(130, 60, 100, 40);
		usertitle.setFont(d);
		username.setBounds(50, 140, 140, 30);
		username.setFont(f);
		uname.setBounds(170, 140, 150, 30);
		uname.setFont(f);
		uname.setText(name);
		userpwd.setBounds(50, 200, 140, 30);
		userpwd.setFont(f);
		pwd.setBounds(170, 200, 150, 30);
		pwd.setFont(f);
		userpass.setBounds(50, 260, 140, 30);
		userpass.setFont(f);
		pass.setBounds(170, 260, 150, 30);
		pass.setFont(f);
		submit.setBounds(90, 320, 80, 30);
		submit.setFont(f);
		reset.setBounds(200, 320, 80, 30);
		reset.setFont(f);
		index.add(usertitle);
		index.add(username);
		index.add(uname);
		index.add(userpwd);
		index.add(pwd);
		index.add(pass);
		index.add(userpass);
		index.add(submit);
		index.add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				pwd.setText("");
				pass.setText("");
			}
		});
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				LoginUseImp l = new LoginUseImp();
				try {
					l.Delete(user, "update users set userpwd='"+pass.getText()+"' where username='"+user.getusername()+"'");
					JOptionPane.showMessageDialog(null, "修改成功");
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
	}

}
