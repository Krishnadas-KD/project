import java.awt.Dimension;

import java.awt.EventQueue;



import javax.swing.JFrame;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.org.apache.bcel.internal.generic.GOTO;

//import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;
import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import jdk.javadoc.internal.doclets.toolkit.util.VisibleMemberCache;

//import sun.jvm.hotspot.runtime.StaticBaseConstructor;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JDesktopPane;
import java.sql.*;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class mainpage {

	private JFrame frame;
	private JTextField Textname;
	private JTextField textage;
	private JButton P_entername;
	private JLabel M_name;
	private JTextField textmedicname;
	private JLabel M_quntity;
	private JTextField textitemquntity;
	private JButton medicin_enter;
	private JButton total_bill;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel Lb_name,Lb_age,Lb_date;
	private static double billprice=0;
	private JLabel billamount;
	private JList list ;
	private int ct=0;
	private static int counter=1;
	private double total=0;
	private String tablename,Vdate,Vtime;
	private int day,mont,year,sec,min,hou;
	private JTextField placename;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage window = new mainpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 255));
		frame.getContentPane().setEnabled(true);
	
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setAlignmentY(0.0f);
		
		
			Calendar calendar=new GregorianCalendar();
			 day=calendar.get(Calendar.DAY_OF_MONTH);
			 mont=calendar.get(Calendar.MONTH)+1;
			 year=calendar.get(Calendar.YEAR);
		 sec=calendar.get(Calendar.SECOND);
		 min=calendar.get(Calendar.MINUTE);
		 hou=calendar.get(Calendar.HOUR);
		Vtime=hou+":"+min+":"+sec;
		Vdate=day+"/"+mont+"/"+year;
		Textname = new JTextField();
		Textname.setColumns(10);
		
		JLabel P_age = new JLabel("Age");
		
		textage = new JTextField();
		textage.setColumns(10);
		

		Lb_name = new JLabel("");
		Lb_age = new JLabel("");
		Lb_date = new JLabel("");
		
		
		P_entername = new JButton("create");
		P_entername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar=new GregorianCalendar();
				
				Lb_name.setText(Textname.getText());
				Lb_age.setText(textage.getText());
				
				Lb_date.setText(Vdate);
				try {                     //dbms connection start
					tablename="patient0"+counter;
					
				Class.forName("com.mysql.jdbc.Driver");
				Connection conT=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
				DatabaseMetaData dbm = conT.getMetaData();
				ResultSet tables;
				int i=0;
				
				while (i==0) {
					tables = dbm.getTables(null, null, tablename, null);
		            if (tables.next()) {
		            	counter=counter+1;
		            	tablename="patient0"+counter;

		            }
		            else {
		            	
		            	break;
		            }
				}
					PreparedStatement ps= conT.prepareStatement("Create table "+tablename+"(medcin_name varchar(20),qunatity int(5),totalprice double,Mdateofbuy varchar(11),Mtimeofbuy varchar(11))");
					ps.executeUpdate();
				}
				
		
				catch (Exception e4) {
					// TODO: handle exception
				}
				
			}
		});
			
		JScrollPane listscroll=new JScrollPane();
		listscroll.setViewportView(list);
		listscroll.setVisible(true);
		
		M_name = new JLabel("Medicin name");
		
		textmedicname = new JTextField();
		textmedicname.setAlignmentY(Component.TOP_ALIGNMENT);
		textmedicname.setColumns(10);
	textmedicname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
			
				try {
					list.setVisible(true);
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
						PreparedStatement ps= con.prepareStatement("select Medicin_Name from medic where Medicin_Name like'"+textmedicname.getText()+"%'");
						ResultSet rs=ps.executeQuery();
						 DefaultListModel value= new DefaultListModel();
						 while (rs.next()) {
							value.addElement(rs.getString("Medicin_Name"));
						}
						 
						list.setModel(value);
						
						ps.close();
						rs.close();
						
					
				} catch (Exception e4) {
					e4.printStackTrace();
				}
					
				}
		});
		
		M_quntity = new JLabel("Quntity");
		
		textitemquntity = new JTextField();
		textitemquntity.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				list.setVisible(false);
			}
		});
		textitemquntity.setColumns(10);
		
		medicin_enter = new JButton("Enter");
		medicin_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textmedicname.getText().trim().isEmpty() || textitemquntity.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Specify all details");
					
				}
				else {
					try {
						
						
					
					
						String sqlQ1="Select * from medic where Medicin_Name='"+textmedicname.getText()+"'";
					double pric = 0;
					String medname = null;
					int stock,qun = 0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
					
					PreparedStatement ps= con.prepareStatement(sqlQ1);
					ResultSet rs=ps.executeQuery();
					while (rs.next()) {
						medname=rs.getString(1);
						qun=rs.getInt(2);
						pric=rs.getDouble(3);
						
					}
					
					if (medname==null) {
						throw new Exception();
						
					}
					if(qun==0)
					{
						
						throw new ExceptionInInitializerError();
						
					}
					ct=1;
					stock=qun-Integer.parseInt(textitemquntity.getText());
					
					String sqlQ2="Update medic set Quantity="+String.valueOf(stock)+" Where Medicin_Name='"+textmedicname.getText()+"'";
					
					PreparedStatement ps2= con.prepareStatement(sqlQ2);
					
					ps2.execute();
					total=Integer.parseInt(textitemquntity.getText())*pric;
				
					billprice=billprice+total;

					Object rowdata[]= {textmedicname.getText(),textitemquntity.getText(),String.valueOf(pric),String.valueOf(total),String.valueOf(stock)};
					//Create table "+tablename+"(medcin_name varchar(20),qunatity int(5),totalprice double,dateofbuy varchar(11),timeofbuy varchar(11))
					PreparedStatement ps4=con1.prepareStatement("insert into "+tablename+"(medcin_name,qunatity,totalprice) values('"+textmedicname.getText()+"',"+textitemquntity.getText()+","+total+")");
					ps4.execute();
					
					
					DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
					tableModel.addRow(rowdata);
					textmedicname.setText(null);
					textitemquntity.setText(null);
					con.close();
					con1.close();
					
				
					} catch (Exception e2) {
						
							JOptionPane.showMessageDialog(null, "medicin not here.");
					
							
						
					}catch (ExceptionInInitializerError e3) {
						JOptionPane.showMessageDialog(null, "outofstock");
					}
			
					
				}
			}
		});
		
		total_bill = new JButton("total Bill");
		total_bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billamount.setText(String.valueOf(billprice+"Rs"));
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("Bill amount:");
		
		 billamount = new JLabel("0Rs");
		
		JButton btnNewButton = new JButton("Print bill");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setToolTipText("To show Printing page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				if(textage.getText().trim().isEmpty() || Textname.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Specify person name and age");
					if(ct==0) {
						JOptionPane.showMessageDialog(null, "specify the medicins");
					}
				}
				else {

					try {
						
							Class.forName("com.mysql.jdbc.Driver");
							Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
							//Mdateofbuy varchar(11),Mtimeofbuy varchar(11))");
							PreparedStatement ps4=con1.prepareStatement("insert into "+tablename+" (medcin_name,totalprice,Mdateofbuy,Mtimeofbuy) values('Total bill=',"+billprice+",'"+Vdate+"','"+Vtime+"')");
							ps4.execute();
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persionmedicins","root","");
							PreparedStatement ps= con.prepareStatement("insert into persion values('"+Textname.getText()+"','"+placename.getText()+"',"+textage.getText()+",'"+day+"/"+mont+"/"+year+"','"+hou+":"+min+":"+sec+"','"+tablename+"')");
							ps.execute();
							
						
					} catch (Exception e4) {
						e4.printStackTrace();
					}
				//	printpage senddata=new printpage();
					int i=1;
					//senddata.recivedata(Textname.getText(),textage.getText(),placename.getText(),Vtime,Vdate,tablename,i);
					printpage newwindowAdd= new printpage(Textname.getText(),textage.getText(),placename.getText(),Vtime,Vdate,tablename);
					newwindowAdd.setVisible(true);
				
				}
				
				
			}
		});
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setToolTipText("Button\r\n:View the patient details.");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-view-6424.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyerdeatils newwindowAdd= new buyerdeatils();
				newwindowAdd.setVisible(true);
			}
		});
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Button:\r\nAdd,Edit and Remove Medicins details\r\n");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-add-column-6411.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				viewadddelete newwindowAdd= new viewadddelete();
				newwindowAdd.setVisible(true);
			}
		});
		
		 list = new JList();
		 list.addMouseListener(new MouseAdapter() {
		 	public void mouseClicked(MouseEvent e) {
		 		textmedicname.setText(String .valueOf((list.getSelectedValue())));
		 	}
		 });
		
		JLabel lblNewLabel_1 = new JLabel("Place");
		
		placename = new JTextField();
		placename.setColumns(10);
		
	
		list.setVisible(false);

		table = new JTable();
		table.setDragEnabled(false);
		table.setCellSelectionEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "quntity", "price of one", "total price", "stock"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(238);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_2 = new JLabel("Age");
		
		lblNewLabel_5 = new JLabel("Name");
		
		lblNewLabel_6 = new JLabel("Date");
		
		
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Lb_date, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(Lb_name, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Lb_age, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(Lb_age)
						.addComponent(lblNewLabel_5)
						.addComponent(Lb_name))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Lb_date)
						.addComponent(lblNewLabel_6))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_desktopPane);
		
		lblNewLabel_4 = new JLabel("PHARMEASY ASSIST");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Garamond", Font.BOLD, 34));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\26358.jpg"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
					.addGap(45))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(M_name, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addGap(201))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(564)
					.addComponent(textage, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(textmedicname, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addGap(201))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(M_quntity, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(placename, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
					.addGap(272))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(530)
					.addComponent(P_entername, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(165))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(732)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addComponent(billamount, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(Textname, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
					.addGap(272))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(530)
					.addComponent(P_age, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(224))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(medicin_enter, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(714)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(494)
					.addComponent(total_bill, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(201))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(textitemquntity, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
					.addGap(202))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
					.addGap(165))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(486)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(63))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(418)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(247)
					.addComponent(M_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(270)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(textage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(248)
					.addComponent(textmedicname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(337)
					.addComponent(M_quntity, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(196)
					.addComponent(placename, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(196)
					.addComponent(P_entername))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(247)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(554)
					.addComponent(billamount)
					.addGap(43))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(Textname, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(576)
					.addComponent(btnNewButton)
					.addGap(14))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(P_age, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(554)
					.addComponent(lblNewLabel_2)
					.addGap(43))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(377)
					.addComponent(medicin_enter))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(377)
					.addComponent(total_bill))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(337)
					.addComponent(textitemquntity, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(198)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 611, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 800, 670);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mntmNewMenuItem = new JMenuItem("Clear");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textage.setText(null);
				textitemquntity.setText(null);
				textmedicname.setText(null);
				Textname.setText(null);
				placename.setText(null);
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Name", "quntity", "price of one", "total price", "stock"
						}
					) {
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItem_1);

		
		
		
		
	}

	private Dimension Dimension() {
		// TODO Auto-generated method stub
		return null;
	}
}
