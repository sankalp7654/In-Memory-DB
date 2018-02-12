package embedded;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	public static String user_name, first_name, last_name, gender, password;
	public static int user_id, status, search; 
	private JTextField txt_fld_user_id;
	private JTextField txt_fld_username;
	private JTextField txt_fld_first_name;
	private JTextField txt_fld_last_name;
	private JTextField txt_fld_gender;
	private JTextField txt_fld_password;
	private JTextField txt_fld_status;
	private JButton btnNewButton;
	      
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InMemoryDemo.createDatabase();
					GUI frame = new GUI();
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
	public GUI() {
		
		
		setMinimumSize(new Dimension(500, 300));
		getContentPane().setBackground(new Color(245, 245, 220));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(66dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(88dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(74dlu;default):grow"),
				ColumnSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblImdbVsFilesystem = new JLabel("IMDB Vs Filesystem");
		lblImdbVsFilesystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImdbVsFilesystem.setBackground(new Color(0, 250, 154));
		lblImdbVsFilesystem.setFont(new Font("Euphemia UCAS", Font.BOLD, 24));
		lblImdbVsFilesystem.setForeground(new Color(0, 128, 128));
		getContentPane().add(lblImdbVsFilesystem, "2, 2, 7, 3, default, center");
		
		JLabel lblNewLabel = new JLabel("User Id :");
		getContentPane().add(lblNewLabel, "2, 6, right, default");
		
		txt_fld_user_id = new JTextField();
		getContentPane().add(txt_fld_user_id, "4, 6, 2, 1, left, default");
		txt_fld_user_id.setColumns(10);
		
			
			btnNewButton = new JButton("INSERT INTO IMDB");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						user_id = Integer.parseInt(txt_fld_user_id.getText());
						user_name = txt_fld_username.getText();
						first_name = txt_fld_first_name.getText();
						last_name = txt_fld_last_name.getText();
						gender = txt_fld_gender.getText();
						password = txt_fld_password.getText();
						status = Integer.parseInt(txt_fld_status.getText());
						InMemoryDemo.insertIntoIMDB();
					} catch (FileNotFoundException | ClassNotFoundException | SQLException  | NumberFormatException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Invalid Inputs");
				//		e1.printStackTrace();
					}
				}
			});
			getContentPane().add(btnNewButton, "6, 6");
		
		
		JLabel lblUserName = new JLabel("User Name :");
		getContentPane().add(lblUserName, "2, 8, right, default");
		
		
		JTextField txt_fld_user_name = new JTextField();
		getContentPane().add(txt_fld_user_name, "4, 8, left, default");
		txt_fld_user_name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("INSERT INTO FILESYSTEM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton_1, "6, 8");
		
		JLabel lblFirstName = new JLabel("First Name :");
		getContentPane().add(lblFirstName, "2, 10, right, default");
		
		txt_fld_first_name = new JTextField();
		getContentPane().add(txt_fld_first_name, "4, 10, left, default");
		txt_fld_first_name.setColumns(10);
		
		
		JLabel lblLastName = new JLabel("Last Name :");
		getContentPane().add(lblLastName, "2, 12, right, default");
		
		txt_fld_last_name = new JTextField();
		getContentPane().add(txt_fld_last_name, "4, 12, 2, 1, left, default");
		txt_fld_last_name.setColumns(10);
		
		
		JLabel lblGender = new JLabel("Gender :");
		getContentPane().add(lblGender, "2, 14, right, default");
		
		txt_fld_gender = new JTextField();
		getContentPane().add(txt_fld_gender, "4, 14, 2, 1, left, default");
		txt_fld_gender.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Password :");
		getContentPane().add(lblPassword, "2, 16, right, default");
		
		txt_fld_password = new JTextField();
		getContentPane().add(txt_fld_password, "4, 16, left, default");
		txt_fld_password.setColumns(10);
		
		
		JLabel lblStatus = new JLabel("Status :");
		getContentPane().add(lblStatus, "2, 18, right, default");
		
		txt_fld_status = new JTextField();
		getContentPane().add(txt_fld_status, "4, 18, 2, 1, left, default");
		txt_fld_status.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		

		setJMenuBar(menuBar);
	}
}
