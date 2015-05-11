package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import socket.Client;

public class TalkJF extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextArea textArea,textArea_1;
	private JButton send,close,record;
    private String reuser;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TalkJF(String name) {
		char at[]=new char[name.length()-17];
		for(int k=17;k<name.length();k++){
		      	at[k-17]=name.charAt(k);
		}
		reuser=String.valueOf(at);
		MainJF.talkjfs.put(reuser, this);
		
		setTitle(name);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				close(reuser);
				super.windowClosing(e);
			}
		});
		setBounds(100, 100, 552, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    textArea = new JTextArea();
		textArea.setBounds(10, 79, 378, 263);
		contentPane.add(textArea);
		
		
		
		 record = new JButton("\u804A\u5929\u8BB0\u5F55");
		record.setBounds(295, 345, 93, 23);
		record.addActionListener(this);
		contentPane.add(record);
		
		 close = new JButton("关闭");
		close.setBounds(217, 472, 80, 23);
		close.addActionListener(this);
		contentPane.add(close);
		
		 send = new JButton("发送");
		send.setBounds(307, 472, 80, 23);
		send.addActionListener(this);
		contentPane.add(send);
		
		 textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 370, 378, 98);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\oracle\\QQ_client_mysql\\src\\img\\qq_04.png"));
		lblNewLabel.setBounds(390, 345, 146, 150);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==record){
			   
		}
		if(e.getSource()==close){
			this.dispose();
			MainJF.talkjfs.remove(this);
		}
		if(e.getSource()==send){
			if(textArea_1.getText()!=null){
		      	   Client.outs.println("send");//让服务器选择发送事件处理方法
		      	   Client.outs.println(reuser);
		      	   textArea.append("I said:"+textArea_1.getText()+'\n');
		      	   Client.outs.println(textArea_1.getText());
		      	   Client.outs.println(Login.user);
		      	   textArea_1.setText("");
		         }     
		}
	}
	public void showMsg(String user){
		try {
			String msg=Client.ins.readLine();
			textArea.append(user+":"+msg+'\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(String reuser){
		MainJF.talkjfs.remove(this);
	}
}
