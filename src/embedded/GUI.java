package embedded;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	public static String name, email;
	public static int phone, id, createDb = 1, search; 
	InMemoryDemo object = new InMemoryDemo();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	      
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		getContentPane().setBackground(new Color(245, 245, 220));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(66dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(88dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(159dlu;default):grow"),
				ColumnSpec.decode("max(19dlu;default):grow"),
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
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				RowSpec.decode("max(8dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblImdbVsFilesystem = new JLabel("IMDB Vs Filesystem");
		lblImdbVsFilesystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImdbVsFilesystem.setBackground(new Color(0, 250, 154));
		lblImdbVsFilesystem.setFont(new Font("Euphemia UCAS", Font.BOLD, 24));
		lblImdbVsFilesystem.setForeground(new Color(0, 128, 128));
		getContentPane().add(lblImdbVsFilesystem, "2, 2, 11, 3, center, center");
		
		JLabel lblNewLabel = new JLabel("User Id :");
		getContentPane().add(lblNewLabel, "6, 6, right, default");
		
		textField = new JTextField();
		getContentPane().add(textField, "8, 6, 2, 1, left, default");
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name :");
		getContentPane().add(lblUserName, "6, 8, right, default");
		
		JTextField textField_1 = new JTextField();
		getContentPane().add(textField_1, "8, 8, left, default");
		textField_1.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name :");
		getContentPane().add(lblFirstName, "6, 10, right, default");
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2, "8, 10, left, default");
		textField_2.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		getContentPane().add(lblLastName, "6, 12, right, default");
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3, "8, 12, 2, 1, left, default");
		textField_3.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender :");
		getContentPane().add(lblGender, "6, 14, right, default");
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4, "8, 14, 2, 1, left, default");
		textField_4.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		getContentPane().add(lblPassword, "6, 16, right, default");
		
		textField_5 = new JTextField();
		getContentPane().add(textField_5, "8, 16, left, default");
		textField_5.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status :");
		getContentPane().add(lblStatus, "6, 18, right, default");
		
		textField_6 = new JTextField();
		getContentPane().add(textField_6, "8, 18, 2, 1, left, default");
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERT INTO IMDB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton, "6, 20, 1, 3, left, default");
		
		JButton btnNewButton_1 = new JButton("INSERT INTO FILESYSTEM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton_1, "8, 20, 1, 3, left, default");
		
		JMenuBar menuBar = new JMenuBar();
		

		setJMenuBar(menuBar);
	}
}
