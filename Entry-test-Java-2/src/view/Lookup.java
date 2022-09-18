package view;

import controller.JDBCConnection;
import model.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lookup extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtColor;
	private JTextField txtStyte;
	private JTextField txtSize;
	private JTextField txtProperty;
	private JTextField txtPrice;
	private JTextField txtAmount;
	private JTextField txtDuration;
	private JTable table;
	JComboBox comboBox = new JComboBox();

	
	Vector Vtitle = new Vector();//Contains columnName
	Vector Vcontent = new Vector();//Contains data display
	Vector Vline;//Contains content 
	DefaultTableModel dtm = new DefaultTableModel();
	private JTextField txtSearchById;
	
	//column name
	void Title() {
		Vtitle.add("Description");
	}
	
	//Display content video on table
	void EnterVideo(Video video) {
		Vline = new Vector();
		Vline.add(video.getDescription());
		Vcontent.add(Vline);
	}
	
	void EnterBOT(BookOnTape bot) {
		Vline = new Vector();
		Vline.add(bot.getDescription());
		Vcontent.add(Vline);
	}
	
	void EnterFurniture(Furniture furniture) {
		Vline = new Vector();
		Vline.add(furniture.getDescription());
		Vcontent.add(Vline);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lookup frame = new Lookup();
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
	public Lookup() {
		Title();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 473);
		contentPane = new JPanel();
		contentPane.setToolTipText("sss");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RUDY'S RENTAL SYSTEM");
		lblNewLabel.setBounds(303, 11, 141, 14);
		contentPane.add(lblNewLabel);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Video", "BookOnTape", "Furniture"}));
		comboBox.setBounds(107, 144, 105, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 42, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(66, 39, 105, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Styte");
		lblNewLabel_1_1.setBounds(10, 92, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setBounds(10, 67, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(66, 62, 105, 20);
		contentPane.add(txtName);
		
		txtColor = new JTextField();
		txtColor.setBounds(546, 86, 105, 20);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		txtStyte = new JTextField();
		txtStyte.setBounds(66, 86, 105, 20);
		contentPane.add(txtStyte);
		txtStyte.setColumns(10);
		
		txtSize = new JTextField();
		txtSize.setColumns(10);
		txtSize.setBounds(303, 39, 112, 20);
		contentPane.add(txtSize);
		
		txtProperty = new JTextField();
		txtProperty.setBounds(303, 62, 112, 20);
		contentPane.add(txtProperty);
		txtProperty.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(303, 86, 112, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(546, 62, 105, 20);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtDuration = new JTextField();
		txtDuration.setColumns(10);
		txtDuration.setBounds(546, 39, 105, 20);
		contentPane.add(txtDuration);
		
		JLabel lblNewLabel_1_3 = new JLabel("Size");
		lblNewLabel_1_3.setBounds(247, 42, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Duration");
		lblNewLabel_2.setBounds(470, 42, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Property");
		lblNewLabel_3.setBounds(247, 65, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(247, 92, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setBounds(470, 67, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Color/Author");
		lblNewLabel_6.setBounds(470, 92, 62, 14);
		contentPane.add(lblNewLabel_6);
		
		//Addion input data to database and display on table
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String styte = txtStyte.getText();
				String size = txtSize.getText();
				String property = txtProperty.getText();
				float price = Float.parseFloat(txtPrice.getText());
				String duration = txtDuration.getText();
				float amount = Float.parseFloat(txtAmount.getText());
				String color = txtColor.getText();
				
				if(comboBox.getSelectedIndex()==0) {
					Video video = new Video(id,name,styte,size,property,price,duration,amount);
					EnterVideo(video);
					dtm.setDataVector(Vcontent, Vtitle);
					table.setModel(dtm);
					new JDBCConnection().addVideo(video);
				}
				if(comboBox.getSelectedIndex()==1) {
					BookOnTape bot = new BookOnTape(id,name,styte,size,property,price,duration,amount,color);
					EnterBOT(bot);
					dtm.setDataVector(Vcontent, Vtitle);
					table.setModel(dtm);
					new JDBCConnection().addBOT(bot);

				} 
				if(comboBox.getSelectedIndex()==2) {
					Furniture fur = new Furniture(id,name,styte,size,property,price,duration,amount,color);
					EnterFurniture(fur);
					dtm.setDataVector(Vcontent, Vtitle);
					table.setModel(dtm);
					new JDBCConnection().addFurniture(fur);

				}
			}
		});
		btnAdd.setBounds(313, 117, 89, 23);
		contentPane.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 764, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		scrollPane.setViewportView(table);
		
		txtSearchById = new JTextField();
		txtSearchById.setToolTipText("");
		txtSearchById.setBounds(615, 144, 121, 22);
		contentPane.add(txtSearchById);
		txtSearchById.setColumns(10);
		
		//Search by ID
		JButton btnSearch = new JButton("Search by serial number");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String byId = txtSearchById.getText();
				if(comboBox.getSelectedIndex()==0) {
					JDBCConnection ccon = new JDBCConnection();
					Video seekvideo = ccon.seekVideo(byId);
					EnterVideo(seekvideo);
					dtm.setDataVector(Vcontent, Vtitle);
					table.setModel(dtm);
				}
				if(comboBox.getSelectedIndex()==1) {
					JDBCConnection ccon = new JDBCConnection();
					BookOnTape seekbot = ccon.seekBOT(byId);
					EnterBOT(seekbot);
					dtm.setDataVector(Vcontent, Vtitle);
					table.setModel(dtm);

				} 
				if(comboBox.getSelectedIndex()==2) {
					JDBCConnection ccon = new JDBCConnection();
					Furniture seekfurniture = ccon.seekFurniture(byId);
					EnterFurniture(seekfurniture);
					dtm.setDataVector(Vcontent, Vtitle);
					table.setModel(dtm);

				}
			}
		});
		btnSearch.setBounds(425, 144, 189, 23);
		contentPane.add(btnSearch);
	}
}
