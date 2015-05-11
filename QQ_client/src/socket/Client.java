package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static BufferedReader ins;
	public static PrintWriter outs;
	Socket s=null;
public Client(){
	try {
		InetAddress address = InetAddress.getByName("yangchun-PC");
		 s=new Socket(address.getHostAddress(),1088);
		// 输入流
        ins = new BufferedReader(new InputStreamReader(
							s.getInputStream()));
		// 输出流
		outs = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
							s.getOutputStream())), true);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//public static void main(String[] sad){
//	new Client();
//}
}
