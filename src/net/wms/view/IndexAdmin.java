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

public class IndexAdmin {
	//声明对象
	public  JFrame index;
	private JMenuBar management;
	private JMenu user;
	private JMenu goods;
	private JMenu storage;
	private JMenuItem exit;
	private JMenuItem useradd;
	private JMenuItem userdelete;
	private JMenuItem userupdate;
	private JMenuItem userselect;
	private JMenuItem goodout;
	private JMenuItem goodsadd;
	private JMenuItem goodsdelete;
	private JMenuItem goodsupdate;
	private JMenuItem goodselect;
	private JMenuItem goodsbyst;
	private JMenuItem storageadd;
	private JMenuItem storagedelete;
	private JMenuItem storageupdate;
	Font f = new Font("楷体", Font.BOLD, 15);
	
	//构造函数
	public IndexAdmin(String name) {
		indexadmin();
		//菜单的添加
		//给用户菜单添加条目
		user.add(useradd);
		user.add(userselect);
		user.add(userdelete);
		user.add(userupdate);
		user.add(exit);
		//给商品菜单添加条目
		goods.add(goodout);
		goods.add(goodsadd);
		goods.add(goodsdelete);
		goods.add(goodsupdate);
		goods.add(goodselect);
		goods.add(goodsbyst);
		//给仓库菜单添加条目
		storage.add(storageadd);
		storage.add(storagedelete);
		storage.add(storageupdate);
		//将菜单添加到菜单栏里
		management.add(user);
		management.add(goods);
		management.add(storage);
		init(name);
		action(name);
	}
	
	private void init(String name) {
		//初始化框架
		index = new JFrame("欢迎管理员"+name+"使用本系统");
		//设置框架大小及位置
		index.setBounds(500, 100, 400, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将菜单栏设置进框架
		index.setJMenuBar(management);
		//清空框架格式
		index.setLayout(null);
		//将框架转换为容器
		((JComponent) index.getContentPane()).setOpaque(false);
		//声明图片对象
		ImageIcon img = null;
		//产生随机数
		Random r = new Random();
		int i = r.nextInt(5);
		//用随机数的值获取不同的图片
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
		//初始化标签
		JLabel background = new JLabel(img);
		//将标签添加进框架index（添加进容器中）
		index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		//设置标签大小
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		//设置可视化
		index.setVisible(true);
	}

	public void indexadmin() {
		//对象初始化以及设置字体
		management = new JMenuBar();
		//菜单初始化
		user = new JMenu(" 用户管理");
		user.setFont(f);
		goods = new JMenu(" 商品管理");
		goods.setFont(f);
		storage = new JMenu(" 仓库管理");
		storage.setFont(f);
		//菜单条目初始化
		exit = new JMenuItem("更换用户");
		exit.setFont(f);
		useradd = new JMenuItem("添加用户");
		useradd.setFont(f);
		userdelete = new JMenuItem("删除用户");
		userdelete.setFont(f);
		userupdate = new JMenuItem("密码修改");
		userupdate.setFont(f);
		userselect = new JMenuItem("查询用户");
		userselect.setFont(f);
		goodsadd = new JMenuItem("商品添加");
		goodsadd.setFont(f);
		goodsdelete = new JMenuItem("商品删除");
		goodsdelete.setFont(f);
		goodsupdate = new JMenuItem("商品更新");
		goodsupdate.setFont(f);
		goodout=new JMenuItem("商品出库");
		goodout.setFont(f);
		goodselect=new JMenuItem("商品查看");
		goodselect.setFont(f);
		goodsbyst=new JMenuItem("按库查看");
		goodsbyst.setFont(f);
		storageadd = new JMenuItem("仓库添加");
		storageadd.setFont(f);
		storagedelete = new JMenuItem("仓库删除");
		storagedelete.setFont(f);
		storageupdate = new JMenuItem("仓库更新");
		storageupdate.setFont(f);
	}
	
	//给所有的菜单条目设置监听事件
	private void action(final String name) {
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				//将原来页面设置为不可见
				index.setVisible(false);
				//调用函数转到登陆页面
				Login.main(null);
			}
		});
		useradd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				//将原来页面设置为不可见
				index.setVisible(false);
				//用构造函数获取新页面
				new Useradd(name); 
			}
		});
		userselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Userselect(name);
			}
		});
		userdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Userdelete(name);
			}
		});
		userupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Adminupdate(name);
			}
		});
		goodsadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Goodsadd(name);
			}
		});
		goodsdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Goodsdelete(name);
			}
		});
		goodsupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new GoodsUpdate(name);
			}
		});
		goodsbyst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new goodsbyst(name);
				//new Storageadd(name);
			}
		});
		goodout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Goodsout(name);
				//new Storageadd(name);
			}
		});
      goodselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new GoodsSelect(name);
				//new Storageadd(name);
			}
		});
		storageadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storageadd(name);
			}
		});
		storagedelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storagedelete(name);
			}
		});
		storageupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//界面转换
				index.setVisible(false);
				new Storageupdate(name);
			}
		});
	}
}