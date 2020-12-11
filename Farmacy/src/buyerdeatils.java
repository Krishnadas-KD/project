import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;
import java.awt.Component;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.sun.beans.introspect.PropertyInfo.Name;

import jdk.jfr.internal.PrivateAccess;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AbstractAutoCompleteAdaptor;
import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.List;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class buyerdeatils extends JFrame {
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private static int i=0;
	private JLabel agep,namep,placep;
	private String sname,sage,splace;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buyerdeatils frame = new buyerdeatils();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refrsh() {
		try{
			
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persionmedicins","root","");
				    Statement stm=con.createStatement();
				    
				    String csql="select * from persion";
				    PreparedStatement pst=con.prepareStatement(csql);
				   
				    ResultSet rs= pst.executeQuery();
				    
				    
				    
					while(rs.next())
					{
						String  c1=rs.getString(1);
						String c2=rs.getString(2);
						String c3=String.valueOf((rs.getInt(3)));
						String c4=rs.getString(4);
						String c5=rs.getString(5);
						String c6=rs.getString(6);
						String data[]= {c1,c2,c3,c4,c5,c6};
						
						DefaultTableModel tModel=(DefaultTableModel)table.getModel();
						tModel.addRow(data);
					
					}
					
					con.close();
				}
				catch (Exception e2) {
					e2.printStackTrace();
					
					
				}
				
			}
	
	public void subrefrsh(String tname) {
		try{
			
			table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"medicin name", "quntity", "price", "date", "time"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
				    Statement stm=con.createStatement();
				    
				    String csql="select * from "+tname;
				    PreparedStatement pst=con.prepareStatement(csql);
				   
				    ResultSet rs= pst.executeQuery();
				  
				    
				    
					while(rs.next())
					{
						String  c1=rs.getString(1);
						String c2=String.valueOf(rs.getInt(2));
						String c3=String.valueOf(rs.getDouble(3));
						String c4=rs.getString(4);
						String c5=rs.getString(5);
						String data[]= {c1,c2,c3,c4,c5};
						
						DefaultTableModel tModel=(DefaultTableModel)table_1.getModel();
						tModel.addRow(data);
					
					}
					con.close();
				
				}
				catch (Exception e2) {
					e2.printStackTrace();
					
					
				}
				
			}
	public void clear() {
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "Place", "age", "time", "date", "T-able name"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
	}
	/**
	 * Create the frame.
	 */
	public buyerdeatils() {
		getContentPane().setBackground(new Color(204, 255, 255));
		
	

		setBounds(100, 100, 800, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Place", "age", "time", "date", "T-able name"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		refrsh();
		table.getColumnModel().getColumn(0).setPreferredWidth(166);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
		table.getColumnModel().getColumn(5).setPreferredWidth(83);
		scrollPane.setViewportView(table);
		JScrollPane scrollPane_1 = new JScrollPane();
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"medicin name", "quntity", "price", "date", "time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(203);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(89);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(94);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-arrow-40.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=table.getSelectedRow();
				System.out.println(i);
				TableModel model=table.getModel();
				String sdString=model.getValueAt(i, 5).toString();
				sname=model.getValueAt(i, 0).toString();
				sage=model.getValueAt(i, 2).toString();
				splace=model.getValueAt(i, 1).toString();
				subrefrsh(sdString);
				namep.setText(sname);
				agep.setText(sage);
				placep.setText(splace);
				
			}
		});
		
		 namep = new JLabel("Name");
		
		agep = new JLabel("age");
		
		placep = new JLabel("Place");
		
		JLabel lblNewLabel_1 = new JLabel("Name of person");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				
					
						try {
								clear();
								Class.forName("com.mysql.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persionmedicins","root","");
								PreparedStatement ps= con.prepareStatement("select * from persion where Name like'"+textField.getText()+"%'");
								ResultSet rs=ps.executeQuery();
								System.out.println("1");
								
								 while(rs.next())
									{
										String  c1=rs.getString(1);
										String c2=rs.getString(2);
										String c3=String.valueOf((rs.getInt(3)));
										String c4=rs.getString(4);
										String c5=rs.getString(5);
										String c6=rs.getString(6);
										String data[]= {c1,c2,c3,c4,c5,c6};
										
										DefaultTableModel tModel=(DefaultTableModel)table.getModel();
										tModel.addRow(data);
									
									}

								 
							
								
								ps.close();
								rs.close();
								
							
						} catch (Exception e4) {
							e4.printStackTrace();
						}
							
						}
				
			
		});
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(placep, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(namep, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
											.addGap(70)
											.addComponent(agep, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(10, Short.MAX_VALUE))
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(namep)
								.addComponent(agep))
							.addGap(28)
							.addComponent(placep)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);
		
	

		
	}


}
