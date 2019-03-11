package net.wms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.wms.dao.GoodsmanagementImp;
import net.wms.dao.StoragemanagementImp;

public class Storagedelete extends IndexAdmin{
	int id ;
	//声明表格
	private JTable table;
	
	public Storagedelete(String name) {
		super(name);
		init();
	}
	public void init() {
		Font t = new Font("楷体",Font.BOLD, 24);
		final Font f = new Font("楷体",Font.BOLD, 15);
		JLabel title = new JLabel("仓库信息");
		title.setFont(t);
		title.setBounds(130, 40, 100, 40);
		final Vector c = new Vector();
		//添加数据
		c.add("编号");
		c.add("仓库名称");
		c.add("仓库类型");
		c.add("仓库编号");
		final StoragemanagementImp s = new StoragemanagementImp();
		try {
			s.Query("select * from storage");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//创建表格
		table = new JTable(s.vec,c);
		table.setFont(f);
		//为表格添加鼠标单击事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取表格中的ID
				id = (int) table.getValueAt(
				table.getSelectedRow(), 0);
				System.out.println(id);
				super.mouseClicked(e);
			}
		});
		//创建Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(40, 120, 300, 200);
		//创建删除按钮
		final JButton delete = new JButton("删除");
		//为按钮创建监听事件
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//判断Id是否在列表内
				if(id == 0){
					JOptionPane.showMessageDialog(null, "删除失败请选择需要删除的记录！");
				}else{
				try {
					//给出提示
					//4个参数：1.null 2.提示内容 3.标题 4.按钮类型
					int mess = JOptionPane.showConfirmDialog(
							null,"确定删除记录？","友情提示：",
							JOptionPane.YES_NO_OPTION );
					//点击确定按钮之后的事件
					//0 == 确定 ，1 == 取消
					if(mess == 0){
						//调用删除方法
						s.Delete("delete from storage where id ="+id);
						//提示删除成功
						JOptionPane.showMessageDialog(null, "删除成功");
						s.Query("select * from storage");
						//创建表格
						JTable new_table = new JTable(s.vec,c);
						new_table.setFont(f);
						//创建Jscrollpane
						JScrollPane p = new JScrollPane(new_table);
						//设置新组建的大小
						p.setBounds(40, 120, 300, 200);
						//移除旧组件
						index.remove(js);
						//添加新组件
						index.add(p);
						//重绘组键
						index.repaint();
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}
			}
		});
		//设置位置及大小
		delete.setBounds(150, 350, 80,30);
		index.add(title);
		index.add(js);
		//添加按钮
		index.add(delete);
	}
}
