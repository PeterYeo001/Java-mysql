package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.wms.bean.Goods;
import net.wms.dao.GoodsmanagementImp;
import net.wms.dao.StoragemanagementImp;
import net.wms.util.DB;

public class Goodsout extends IndexAdmin{
	JTextField name;
	JTextField style;
	JTextField number;
	JComboBox id;
	Goods goods = new Goods();
	
	public Goodsout(String name) {
		super(name);
		init();
	}
	public void init() {
		Font d = new Font("楷体", Font.BOLD, 24);
		Font f = new Font("楷体", Font.BOLD, 18);
		JLabel goodstitle = new JLabel("出库商品");
		JLabel goodsname = new JLabel("商品名：");
		name = new JTextField();
		JLabel goodsstyle = new JLabel("类  型：");
		style = new JTextField();
		JLabel goodsnumber = new JLabel("出库数量：");
		number = new JTextField();
		JLabel storageid = new JLabel("仓库号：");
		StoragemanagementImp s = new StoragemanagementImp();
		try {
			s.Query1("select storageID from storage");
			id = new JComboBox(StoragemanagementImp.vr);
		} catch (SQLException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}
		JButton submit = new JButton("提交");
		JButton reset = new JButton("重置");
		goodstitle.setBounds(130, 40, 100, 40);
		goodstitle.setFont(d);
		goodsname.setBounds(60, 120, 80, 30);
		goodsname.setFont(f);
		name.setBounds(140, 120, 150, 30);
		name.setFont(f);
		goodsstyle.setBounds(60, 180, 80, 30);
		goodsstyle.setFont(f);
		style.setBounds(140, 180, 150, 30);
		style.setFont(f);
		goodsnumber.setBounds(60, 240, 80, 30);
		goodsnumber.setFont(f);
		number.setBounds(140, 240, 150, 30);
		number.setFont(f);
		storageid.setBounds(60, 300, 80, 30);
		storageid.setFont(f);
		id.setBounds(140, 300, 150, 30);
		id.setFont(f);
		submit.setBounds(90, 360, 80, 30);
		submit.setFont(f);
		reset.setBounds(200, 360, 80, 30);
		reset.setFont(f);
		index.add(goodstitle);
		index.add(goodsname);
		index.add(name);
		index.add(goodsstyle);
		index.add(style);
		index.add(goodsnumber);
		index.add(number);
		index.add(storageid);
		index.add(id);
		index.add(submit);
		index.add(reset);
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				name.setText("");
				style.setText("");
				number.setText("");
			}
		});
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(name.getText().equals("") || style.getText().equals("") || number.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入内容");
				} else {
				  final StoragemanagementImp s = new StoragemanagementImp();
					goods.setGoodsname(name.getText());
					goods.setGoodsstyle(style.getText());
					goods.setGoodsnumber(Integer.parseInt(number.getText()));
					goods.setStorageID(id.getSelectedItem().toString());
					String gname = goods.getGoodsname();
			        int num = goods.getGoodsnumber();
					int Stge = Integer.parseInt(goods.getStorageID());
					String stid = goods.getStorageID();
					boolean flag = false,flag1 = false;
					
				   Connection conn = DB.getConnection();
					int number1 = -1;
				    String sql = "select goodsname,goodsnumber from goods where storageID = "+Stge;
				    try {
					PreparedStatement pra = conn.prepareStatement(sql);
					ResultSet rs = pra.executeQuery();
					//遍历结果集
					while(rs.next())
					{
						flag1=true;
						//获取数据库列字段
					   if(rs.getString("goodsname").equals(gname))
					   {
						   number1 = rs.getInt("goodsnumber");
						   flag = true;
						   break;
					   }
						
					}
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}   
				 if(flag1){
				  if(flag == false)
				  {
					  JOptionPane.showMessageDialog(null, "无此商品...请重新输入");
					  init();
				  }
				  else if (number1 < num)
				  {
					  JOptionPane.showMessageDialog(null, "库存没这么大...请重新输入");
					  init();
				  }
				  else
				  {
					  number1 -= num;
					 // System.out.println("dfgvfgbf" + number1);
					  GoodsmanagementImp g = new GoodsmanagementImp();
					
					  
						  try {
							g.Out("update goods set goodsnumber = ? where  goodsname = '"+gname+"' and storageID = '"+Stge+"'" ,number1);
							name.setText("");
							style.setText("");
							number.setText("");
						
							
							JOptionPane.showMessageDialog(null, "出库成功");
							
					    	} 
					   catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						   
						 e1.printStackTrace();
					}
				  }
					
				
			}
				 else{
					  JOptionPane.showMessageDialog(null, "不存在");
				  }}
				
				 }
		});
	}
}

