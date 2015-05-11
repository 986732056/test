package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import socket.Client;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JFlashPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JFrame implements ActionListener{
   
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField userpwd;
    private JButton login;
    public static String user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		
		int with=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((with-378)/2,(height-293)/2, 378, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel bottom = new JLabel("");
		bottom.setIcon(new ImageIcon("D:\\oracle\\QQ_client_mysql\\src\\img\\bottom.gif"));
		bottom.setBounds(0, 0, 378, 293);
		contentPane.add(bottom);
		
		username = new JTextField();
		username.setBounds(111, 105, 188, 23);
		bottom.add(username);
		username.setColumns(10);
		
		userpwd = new JPasswordField();
		userpwd.setBounds(111, 138, 188, 23);
		bottom.add(userpwd);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(107, 167, 81, 23);
		bottom.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
		chckbxNewCheckBox_1.setOpaque(false);
		chckbxNewCheckBox_1.setBounds(190, 167, 81, 23);
		bottom.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u8D26\u53F7");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(308, 109, 54, 15);
		bottom.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u627E\u56DE\u5BC6\u7801");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(309, 142, 54, 15);
		bottom.add(lblNewLabel_1);
		
		 login = new JButton("\u767B           \u5F55");
		login.setBounds(122, 216, 149, 32);
		login.addActionListener(this);
		bottom.add(login);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\oracle\\QQ_client_mysql\\src\\img\\QQ.png"));
		lblNewLabel_2.setBounds(20, 105, 81, 81);
		bottom.add(lblNewLabel_2);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login){
			new Client();
			user=username.getText();
			 isLogin();
		}
	}
	public void isLogin(){
		String flag=null; 
		Client.outs.println("islogin");
		Client.outs.println(username.getText());
		Client.outs.println(userpwd.getText());
		try {
			flag=Client.ins.readLine();
			if(flag.equals("true")){
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException el) {
					// TODO Auto-generated catch block
					el.printStackTrace();
				}
				this.setVisible(false);
				//new FriendThread().start();
				MainJF mainjf = new MainJF();
			
			}else{
				username.setText("");
				userpwd.setText("");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
