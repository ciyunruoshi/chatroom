package com.TestClientwindow.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class Clientwindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField address;
	private JTextField sendtxt;
	private JTextArea txtmain;
	private JLabel lblIp;
	private String name,password;
	private JLabel label;

	
	public void appendtxt(String str){
		txtmain.append("\n"+str);
	}
	 public String getinfo(){
		 return name+"\n"+password;
	 }
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Clientwindow(String name,String password) {
		
		this.name = name;
		this.password= password;
		
		label = new JLabel(name);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		address = new JTextField();
		address.setText("127.0.0.1");
		address.setColumns(10);
		
		JButton connectionbutton = new JButton("\u9023\u63A5\u670D\u52D9\u5668");
		
		
		sendtxt = new JTextField();
		sendtxt.setText("hello");
		sendtxt.setColumns(10);
		
		JButton sendbutton = new JButton("send");
		sendbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendtxt("Œ“£∫"+sendtxt.getText());
				ClientManager.init().send(sendtxt.getText());
			}
		});
		
		txtmain = new JTextArea();
		txtmain.setText("\u6B22\u8FCE\u8FDB\u5165\u804A\u5929\u5BA4");
		
		JLabel lblName = new JLabel("Name");
		
		lblIp = new JLabel("ip");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtmain, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(sendtxt, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(sendbutton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(address, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(connectionbutton, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
								.addComponent(label))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(connectionbutton)
						.addComponent(lblIp))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(label))
					.addGap(18)
					.addComponent(txtmain, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(sendbutton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(sendtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
