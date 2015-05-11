package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.Person;
import socket.Client;
public class FriendThread extends Thread implements MouseListener{
	private ArrayList friends;
	private int size;
public void run(){
	while(true){
		System.out.println("getFriends start!");
		getMyFriends();
	}
}
public void getMyFriends(){
	friends=new ArrayList();
	try {
		size = Integer.parseInt(Client.ins.readLine());
	} catch (NumberFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	for(int k=0;k<size;k++){
		Person person=new Person();
	try {
		int n=Integer.parseInt(Client.ins.readLine());
		person.setId(n);
		String name=Client.ins.readLine();
		person.setName(name);
		String state=Client.ins.readLine();
		person.setState(state);
		friends.add(person);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//add myfriends main jframe
    MainJF.jfriends=new JLabel[size];
	int h=140;
	for(int i=0;i<size;i++){
		Person p=(Person) friends.get(i);
		MainJF.jfriends[i]=new JLabel();
		MainJF.jfriends[i].setBounds(0, h, 279, 25);
		MainJF.jfriends[i].setFont(new Font("»ªÎÄÐÂÎº", Font.PLAIN, 14));
		MainJF.jfriends[i].setText(String.valueOf("   "+p.getId())+"             "+p.getName());
		if(p.getState().equals("online")){
			MainJF.jfriends[i].setForeground(Color.red);
		}
		MainJF.jfriends[i].addMouseListener(this);
		MainJF.gril.add(MainJF.jfriends[i]);
		h=h+25;
}
}
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	for(int k=0;k<size;k++){
		if(e.getSource()==MainJF.jfriends[k]){
			MainJF.jfriends[k].setOpaque(true);
			MainJF.jfriends[k].setBackground(Color.getHSBColor(100, 50, 20));
		}
	}
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	for(int k=0;k<size;k++){
		if(e.getSource()==MainJF.jfriends[k]){
			MainJF.jfriends[k].setOpaque(false);
			MainJF.jfriends[k].setBackground(Color.LIGHT_GRAY);
		}
	}
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	for(int k=0;k<size;k++){
		if(e.getSource()==MainJF.jfriends[k]){
			new TalkJF(MainJF.jfriends[k].getText());
			new TalkThread().start();
		}
	}
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}