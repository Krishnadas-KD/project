import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewadddelete extends JFrame {

	private static final TableModel DbUtils = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField textname;
	private JTextField textquntity;
	private JTextField textprice;
	private JTextField textdelete;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
					viewadddelete frame = new viewadddelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void refrsh() {
try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
		    Statement stm=con.createStatement();
		    String csql="select * from medic";
		    PreparedStatement pst=con.prepareStatement(csql);
		    ResultSet rs= pst.executeQuery();			
			table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
			
			con.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
			
			
		}
		
	}
	public viewadddelete() {
		setBounds(100, 100, 800, 600);
		setResizable(true);

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 440, 478);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] { },
			new String[] {
				"Name of medicin", "stock", "price"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		refrsh();
		
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Medicin name");
		lblNewLabel.setBounds(10, 35, 84, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edit");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(606, 73, 84, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(482, 122, 60, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quntity");
		lblNewLabel_1_1_1.setBounds(482, 160, 60, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price of one");
		lblNewLabel_1_1_1_1.setBounds(482, 197, 60, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("delete");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(606, 311, 84, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Name");
		lblNewLabel_1_2_1.setBounds(482, 390, 84, 26);
		contentPane.add(lblNewLabel_1_2_1);
		
		textname = new JTextField();
		textname.setBounds(552, 125, 211, 21);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textquntity = new JTextField();
		textquntity.setColumns(10);
		textquntity.setBounds(552, 163, 211, 21);
		contentPane.add(textquntity);
		
		textprice = new JTextField();
		textprice.setColumns(10);
		textprice.setBounds(552, 200, 211, 21);
		contentPane.add(textprice);
		
		textdelete = new JTextField();
		textdelete.setColumns(10);
		textdelete.setBounds(552, 393, 211, 21);
		contentPane.add(textdelete);
		
		JButton b_add = new JButton("add");
		b_add.setToolTipText("edith medicins value must fill name\r\nauthor 2 are optional\r\n");
		b_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
				//	Class.forName("com.mysql.jdbc.Driver");
				//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
				//    Statement stm=con.createStatement();
				//	ResultSet rs= stm.executeQuery("select name from empl");
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
					  Statement stm=con.createStatement();
					if (textname.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "specify the medicin name");
						refrsh();
					}
					else if (textprice.getText().trim().isEmpty()) {
						PreparedStatement ps= con.prepareStatement("UPDATE medic set Quantity="+textquntity.getText()+" where Medicin_Name='"+textname.getText()+"'");
						ps.execute();
						JOptionPane.showMessageDialog(null, "update "+textname.getText()+" quntity");
						refrsh();
					}
					else if (textquntity.getText().trim().isEmpty()) {
						PreparedStatement ps= con.prepareStatement("UPDATE medic set Price_of_One="+textprice.getText()+" where Medicin_Name='"+textname.getText()+"'");
						ps.execute();
						JOptionPane.showMessageDialog(null, "update "+textname.getText()+" price");
						refrsh();
					}
					else {
						PreparedStatement ps= con.prepareStatement("UPDATE medic set Price_of_One="+textprice.getText()+",Quantity="+textquntity.getText()+" where Medicin_Name='"+textname.getText()+"'");
						ps.execute();
						JOptionPane.showMessageDialog(null, "update "+textname.getText()+" price and quntity");
						refrsh();
					}
					
				con.close();	
				}
				catch (Exception e5) {
					System.out.println(e5);
					
				}
				textname.setText(null);
				textprice.setText(null);
				textquntity.setText(null);
				refrsh();
			}
				
				
			
		});
		b_add.setBounds(482, 264, 89, 23);
		contentPane.add(b_add);
		
		JButton B_addnew = new JButton("add new item");
		B_addnew.setToolTipText("To add new medicin \r\nmust fill all above textfield.");
		B_addnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if (textname.getText().trim().isEmpty() && textprice.getText().trim().isEmpty() && textquntity.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "specify medic name,quntity and price.");
				
				}
				else {
					
				
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
						PreparedStatement ps= con.prepareStatement("insert into medic values('"+textname.getText()+"',"+textquntity.getText()+","+textprice.getText()+");");
						int x=ps.executeUpdate();
						if(x>0) {
							JOptionPane.showMessageDialog(null, "Added new data");
						}
						else {
							JOptionPane.showMessageDialog(null, "error");
						}
						refrsh();
						con.close();
					}
					catch (Exception e2) {
						System.out.println(e2);
						
					}
				}
			textname.setText(null);
			textprice.setText(null);
			textquntity.setText(null);
			
			}
			
			
		});
		B_addnew.setBounds(633, 264, 130, 23);
		contentPane.add(B_addnew);
		
		JButton B_delete = new JButton("Delete");
		B_delete.setToolTipText("Delete all details specifyed medicins\r\n");
		B_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
					PreparedStatement ps= con.prepareStatement("DELETE from medic where Medicin_Name='"+textdelete.getText()+"'");
					int x=ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null, "delete succsfully");
					}
					else {
						System.out.println("error");
					}
					con.close();
				}
				catch (Exception e2) {
					System.out.println(e2);
					
				}
				textdelete.setText(null);
				refrsh();
				
			}
		});
		B_delete.setBounds(601, 470, 89, 23);
		contentPane.add(B_delete);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
				PreparedStatement ps= con.prepareStatement("select * from medic where Medicin_Name like'"+search.getText()+"%'");
				
				ResultSet rs=ps.executeQuery();
				
				table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
			
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
		});
		search.setBounds(104, 35, 323, 21);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton refresh = new JButton("");
		refresh.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-refresh-30.png"));
		refresh.setToolTipText("Refresh the Table");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrsh();
				search.setText(null);
			}
		});
		refresh.setBounds(437, 24, 39, 33);
		contentPane.add(refresh);
		
		
	}
}
