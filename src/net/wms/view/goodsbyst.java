package net.wms.view;


	import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	import java.util.Vector;

	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
	import javax.swing.JTable;
import javax.swing.JTextField;

import net.wms.dao.GoodsmanagementImp;
import net.wms.util.DB;

	public class goodsbyst extends IndexAdmin{
		
		private JTable table;
		int id ;
		//String getType="";
		JTextField type;
		 Vector c;
		final GoodsmanagementImp g = new GoodsmanagementImp();
		public goodsbyst(String name) {
			super(name);
			init();
		}
		public void init() {
			Font t = new Font("楷体",Font.BOLD, 24);
			final Font f = new Font("楷体",Font.BOLD, 15);
			JLabel title = new JLabel("按仓库查询");
			type=new JTextField();
			type.setBounds(140, 90, 100, 20);
			type.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){
						int getType=Integer.parseInt(type.getText().trim());
						String stid = type.getText().trim();
						Connection conn = DB.getConnection();
						boolean flag = false;
					    String sql = "select  StorageID from storage";
					    try {
						PreparedStatement pra = conn.prepareStatement(sql);
						ResultSet rs = pra.executeQuery();
						//遍历结果集
						while(rs.next())
						{
							//获取数据库列字段
						   if(rs.getString("StorageID").equals(stid))
						   {
							   flag = true;
							   break;
						   }
							
						}
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					    if(flag == false)
					    {
					    	 JOptionPane.showMessageDialog(null, "无此库...请重新输入");
					    	 type.setText("");
					    	 init();
					    }
					    else
					    {
					    	try {							
							g.Query("select * from goods where storageID='"+getType+"'");
							//创建表格
							type.setText("");
							table = new JTable(g.vec,c);
							table.setFont(f);
							//创建Jscrollpane
							final JScrollPane js = new JScrollPane(table);
							js.setBounds(40, 120, 300, 200);
							index.add(js);
						  } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    }
					    
				
					}
				}

			});
			
			title.setFont(t);
			title.setBounds(130, 40, 200, 40);
			c = new Vector();
			//添加数据
			c.add("编号");
			c.add("商品名称");
			c.add("商品类型");
			c.add("商品数量");
			c.add("仓库编号");
			
			index.add(title);
			
			index.add(type);
		}
		
	}

