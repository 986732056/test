package GUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import socket.Client;

public class MainJF extends JFrame implements MouseListener {
	public static Map<String, TalkJF> talkjfs=null;
	private JPanel contentPane;
	private JTextField textField;
	JLabel add,cancel,A,B,C;
	private JPanel panel;
    public static JLabel[] jfriends;
    private int size;     
    public static JLabel gril;
    
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainJF() {
		talkjfs=new HashMap<String,TalkJF>();
		int with=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				offLine();
				super.windowClosing(e);
			}
		});
		
		
		setTitle("QQ");
		setBounds((with-279), 0, 279, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gril = new JLabel("");
		gril.setIcon(new ImageIcon("D:\\oracle\\QQ_client_mysql\\src\\img\\girl.jpg"));
		gril.setBounds(0, 0, 263, 612);
		contentPane.add(gril);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\oracle\\QQ_client_mysql\\src\\img\\QQ_01.png"));
		lblNewLabel.setBounds(2, 2, 62, 64);
		gril.add(lblNewLabel);
		
		JLabel label = new JLabel(Login.user);
		label.setFont(new Font("华文新魏", Font.PLAIN, 14));
		gril.add(label);
		label.setBounds(80, 4, 80, 15);
		
		textField = new JTextField();
		textField.setText("搜索：联系人、讨论组、群、企业");
		textField.setOpaque(false);
		textField.setBounds(0, 72, 279, 30);
		gril.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("知我者为我心忧，不知我者为我何求");
		lblNewLabel_1.setOpaque(false);
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(67, 29, 160, 15);
		gril.add(lblNewLabel_1);
	
	    add = new JLabel("  add  ");
	    add.addMouseListener(this);
		add.setBounds(0, 102, 54, 37);
		gril.add(add);
		
		cancel = new JLabel("cancel");
		cancel.addMouseListener(this);
		cancel.setBounds(54, 102, 54, 37);
		gril.add(cancel);
		
		A = new JLabel("  A ");
		A.addMouseListener(this);
		A.setBounds(108, 102, 54, 37);
		gril.add(A);
		
		B = new JLabel("  B  ");
		B.addMouseListener(this);
		B.setBounds(162, 102, 54, 37);
		gril.add(B);
		
		C = new JLabel("  C   ");
		C.addMouseListener(this);
		C.setBounds(216, 102, 54, 37);
		gril.add(C);
		//give my friends from server
//		getFriends();
		new FriendThread().getMyFriends();;
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add){
			add.setOpaque(true);
			add.setBackground(Color.getHSBColor(100, 50, 20));
		}
		if(e.getSource()==cancel){
			cancel.setOpaque(true);
			cancel.setBackground(Color.getHSBColor(100, 50, 20));
		}
		if(e.getSource()==A){
			A.setOpaque(true);
			A.setBackground(Color.getHSBColor(100, 50, 20));
		}
		if(e.getSource()==B){
			B.setOpaque(true);
			B.setBackground(Color.getHSBColor(100, 50, 20));
		}
		if(e.getSource()==C){
			C.setOpaque(true);
			C.setBackground(Color.getHSBColor(100, 50, 20));
		}	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add){
			add.setOpaque(false);
			add.setBackground(Color.LIGHT_GRAY);
		}
		if(e.getSource()==cancel){
			cancel.setOpaque(false);
			cancel.setBackground(Color.LIGHT_GRAY);
		}
		if(e.getSource()==A){
			A.setOpaque(false);
			A.setBackground(Color.LIGHT_GRAY);
		}
		if(e.getSource()==B){
			B.setOpaque(false);
			B.setBackground(Color.LIGHT_GRAY);
		}
		if(e.getSource()==C){
			C.setOpaque(false);
			C.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void offLine(){
		Client.outs.println("offline");
		Client.outs.println(Login.user);
	}	
}
