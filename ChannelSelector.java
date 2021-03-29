package myOwnIdeas;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.net.*;


public class ChannelSelector extends JFrame{
	
	JButton netflix, hulu, disney, prime;
	URI[] pageLink = new URI[4];
	
	public ChannelSelector() {
		super("Channel Selector"); //title of frame you can also use setTitle("title");
		setSize(350,150); //size in pixels
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(2,2);
		setLayout(layout);
		netflix = new JButton("Netflix");
		Color netflixRed = new Color(229,9,20);
		netflix.setBackground(netflixRed);
		add(netflix);
		hulu = new JButton("Hulu");
		Color huluGreen = new Color(28,231,131);
		hulu.setBackground(huluGreen);
		add(hulu);
		disney = new JButton("Disney+");
		Color disneyBlue = new Color(0,110,153);
		disney.setBackground(disneyBlue);
		add(disney);
		prime = new JButton("Amazon Prime");
		Color primeOrange = new Color(255,153,0);
		prime.setBackground(primeOrange);
		add(prime);
		
		pageLink[0] = getURI("https://www.netflix.com/browse");
		pageLink[1] = getURI("https://www.hulu.com/hub/home");
		pageLink[2] = getURI("https://www.disneyplus.com/home");
		pageLink[3] = getURI("https://www.amazon.com/Amazon-Video/b/?&node=2858778011&ref=dvm_MLP_ROWNA_US_1");
		
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Desktop desktop = Desktop.getDesktop();
				if(event.getSource() == netflix) {
					try {
						desktop.browse(pageLink[0]);
					}catch(IOException exc) {
						//do nothing
					}
				}
				if(event.getSource() == hulu) {
					try {
						desktop.browse(pageLink[1]);
					}catch(IOException exc) {
						//do nothing
					}
				}
				if(event.getSource() == disney) {
					try {
						desktop.browse(pageLink[2]);
					}catch(IOException exc) {
						//do nothing
					}
				}
				if(event.getSource() == prime) {
					try {
						desktop.browse(pageLink[3]);
					}catch(IOException exc) {
						//do nothing
					}
				}
			}
		};
		netflix.addActionListener(act);
		hulu.addActionListener(act);
		disney.addActionListener(act);
		prime.addActionListener(act);
		setVisible(true);
	}
	
	private URI getURI(String urlText) {
		URI pageURI = null;
		try {
			pageURI = new URI(urlText);
		}catch(URISyntaxException ex) {
			//do nothing
		}
		return pageURI;
	}
	
	public static void main(String[] arguments) {
		new ChannelSelector();
	}
}
