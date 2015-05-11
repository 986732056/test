package GUI;

import java.io.IOException;

import socket.Client;

public class TalkThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				String msg=Client.ins.readLine();
				if(msg!=null){
				TalkJF tjf=MainJF.talkjfs.get(msg);
				tjf.showMsg(msg);
				}else{
					System.out.println("msg is null");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
