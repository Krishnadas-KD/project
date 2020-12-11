import javafx.print.Printer;
import java.awt.print.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xpath.internal.functions.FuncStringLength;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class printpage extends JFrame {

	private JPanel contentPane;
	public static String	tabelname;
	public static String name;
	public static String age;
	public static String place;
	public static String time;
	public static String date;
	private static int c=0;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printpage frame = new printpage(name, age, place, time, date, tabelname);
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
	public printpage(final String name,final String age,final String place,final String time,final String date,final String tableName) {
		
		setBounds(300, 10, 800, 700);
		System.out.println(c);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 59, 734, 521);
		contentPane.add(scrollPane);
		
		 textArea = new JTextArea();
		 textArea.setFont(new Font("Elephant", Font.PLAIN, 11));
		scrollPane.setViewportView(textArea);
	
	
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-print-54.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				} catch (Exception e2) {
					
				}
				}
				
		});
		btnNewButton.setBounds(63, 591, 76, 59);
		contentPane.add(btnNewButton);
		
		JButton cancel = new JButton("cancel all order");
		cancel.setToolTipText("It cancel order and delete all present patient details.");
		cancel.setForeground(new Color(0, 0, 0));
		cancel.setBackground(new Color(0, 255, 255));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
					
					PreparedStatement ps= con.prepareStatement("drop table "+tableName);
					
					ps.executeUpdate();
					System.out.println("1");
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/persionmedicins","root","");
					PreparedStatement ps2= con2.prepareStatement("delete from persion where name='"+name+"' and timeofbuy='"+time+"'");
					ps2.executeUpdate();
					System.out.println("2");
					JOptionPane.showMessageDialog(null, "cancel the order susscfully");
					setVisible(false);
					con.close();
					con2.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
				
				
				
			
		});
		cancel.setBounds(574, 606, 152, 23);
		contentPane.add(cancel);
		
		JLabel lblNewLabel = new JLabel("Print Area");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(306, 16, 304, 32);
		contentPane.add(lblNewLabel);
		
		JButton create = new JButton("display");
		create.setFont(new Font("Consolas", Font.BOLD, 14));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea.append(
						"\n                Name:"+  name                     +             "\t\t        Age:"+age
					   +"\n                Place:"+place                       +            "\t\t       Time and Date:"+time+"  "+date+
						"\n              ===================================================\n"+
						"                      Medicin name                             quntity                                   Total price   \n\n"
			
								);
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
					PreparedStatement ps= con.prepareStatement("select * from "+tableName);
					ResultSet rsprint=ps.executeQuery();
					String sql="select count(*) from "+tableName;
					PreparedStatement ps2=con.prepareStatement(sql);
					String count=null,ssString="ascpirin23";
					int y=ssString.length();
					ResultSet rs=ps2.executeQuery();
					if(rs.next())
					{
						 count=rs.getString(1);
						
					}
					
					int c=Integer.parseInt(count);
					int i;
					for(i=0;i<c;i++) {
					if(rsprint.next())
					{
						System.out.println(c-1+"     "+i);
						if(i==c-1) {
							System.out.println(c-1+"     "+i);
							textArea.append("          ---------------------------------------------------------------------------------------------------------------------------------------------------------------------      \n"+
									"\tTotal Bill=                                                                                                "+rsprint.getDouble(3)+"Rs");
							break;
						}
						textArea.append("\t"+rsprint.getString(1));
						int ln=rsprint.getString(1).length();
						
						System.out.println(ln);
						for(int i1=ln-3;i1<58-ln;i1++)
						{
							textArea.append(" ");
						}
						textArea.append(""+rsprint.getInt(2)+"");
						
						
						for(int i2=0;i2<50-2;i2++)
						{
							textArea.append(" ");
						}
						textArea.append(""+rsprint.getDouble(3)+"          \n");
						
						}
					}
				
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		create.setBounds(609, 25, 123, 23);
		contentPane.add(create);
	}
	
		// TODO Auto-generated method stub
		
	
}
