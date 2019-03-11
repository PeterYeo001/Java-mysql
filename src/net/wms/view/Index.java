package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Index {
	//声明对象
	public  JFrame index;
	private JMenuBar management;
	private JMenu user;
	private JMenu goods;
	private JMenu storage;
	private JMenuItem exit;
	private JMenuItem usernews;
	private JMenuItem userupdate;
	private JMenuItem goodsselect;
	private JMenuItem storageselect;
	
	//创建构造函数
	public Index(String name) {
		indexadmin();
		//添加对象
		user.add(usernews);
		user.add(userupdate);
		user.add(exit);
		goods.add(goodsselect);
		storage.add(storageselect);
		management.add(user);
		management.add(goods);
		management.add(storage);
		init(name);
		action(name);
	}
	
	
	private void init(String name) {
		//初始化矿建index
		index = new JFrame("欢迎用户"+name+"使用本系统");
		//设置框架大小和位置
		index.setBounds(500, 100, 400, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将菜单栏设置进框架
		index.setJMenuBar(management);
		index.setLayout(null);
		//设置随机背景
		((JComponent) index.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		Random r = new Random();
		int i = r.nextInt(5);
		switch (i) {
		case 0:
			img = new ImageIcon("Images//主背景.jpg");
			break;
		case 1:
			img = new ImageIcon("Images//主背景1.jpg");
			break;
		case 2:
			img = new ImageIcon("Images//主背景2.jpg");
			break;
		case 3:
			img = new ImageIcon("Images//主背景3.jpg");
			break;
		case 4:
			img = new ImageIcon("Images//主背景4.jpg");
			break;
		default:
			break;
		}
		JLabel background = new JLabel(img);
		index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		index.setVisible(true);
	}
	
	public void indexadmin() {
		//初始化对象
		Font f = new Font("楷体", Font.BOLD, 15);
		management = new JMenuBar();
		user = new JMenu(" 用户管理");
		user.setFont(f);
		goods = new JMenu(" 商品管理");
		goods.setFont(f);
		storage = new JMenu(" 仓库管理");
		storage.setFont(f);
		exit = new JMenuItem("更换用户");
		exit.setFont(f);
		usernews = new JMenuItem("个人信息");
		usernews.setFont(f);
		userupdate = new JMenuItem("密码修改");
		userupdate.setFont(f);
		goodsselect = new JMenuItem("商品浏览");
		goodsselect.setFont(f);
		storageselect = new JMenuItem("仓库浏览");
		storageselect.setFont(f);
	}
	
	//为所有的菜单条目设置监听事件
	private void action(final String name) {
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				Login.main(null);
			}
		});
		usernews.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Usernews(name);
			}
		});
		userupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Userupdate(name);
			}
		});
		goodsselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new UserIndex(name);
			}
		});
		storageselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storageselect(name);
			}
		});
	}
}
