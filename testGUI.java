package datShat;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class testGUI extends JPanel {

	private Font font = new Font("Verdana", Font.BOLD, 20);
	
	private JPanel buttonPanel = new JPanel(new GridLayout(1,2));
	
	private JButton getMessage = new JButton("Hämta medelande");
	private JButton sendMessage = new JButton("Skicka medelande");
	
	private JLabel header = new JLabel("Test GUI Gruppuppgift 1");
	private JLabel pictureBody = new JLabel();
	
	private JTextArea body = new JTextArea();
	
	private JTextField znop = new JTextField();
	
	public testGUI() {
		setPreferredSize(new Dimension(800,350));
		
		body.setPreferredSize(new Dimension(800, 300));
		
		header.setFont(font);
		body.setFont(font);	
		
		buttonPanel.add(getMessage);
		buttonPanel.add(sendMessage);
		
		body.add(pictureBody);
		
		add(header);
		add(buttonPanel);
		add(body);
		
	}
	
	public void setText(String text) {
		body.append(text);
	}
	
	public void setImageIcon(ImageIcon icon){
		pictureBody.setIcon(icon);
	}
	
	public static void main (String[] args) {
		testGUI prog = new testGUI();
		
		JFrame frame1 = new JFrame( "Viewer" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add(prog);
		frame1.pack();
		frame1.setVisible( true );
		
	}
}
