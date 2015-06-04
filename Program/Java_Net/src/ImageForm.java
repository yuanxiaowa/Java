import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;


public class ImageForm extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuBar menuBar;
	boolean drawImage;
	DataInputStream dataInputStream;
	int i;
	String line_str;
	boolean first = true;
	Font font;
	public ImageForm() {
		menuBar = new MenuBar();
		setMenuBar(menuBar);
		Menu display = new Menu("display");
		menuBar.add(display);
		
		MenuItem beauty_display = new MenuItem("display_beauty");
		MenuItem text_display = new MenuItem("display_text");
		display.add(beauty_display);
		display.add(text_display);
		beauty_display.addActionListener(this);
		text_display.addActionListener(this);
		setBackground(Color.white);
		font = new Font("ËÎÌå", Font.BOLD, 40);
		setTitle("sample: use URL get data");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
	
	
	@Override
	public void paint(Graphics g) {
		if (drawImage) {
			try {
				URL image_url = new URL("file:///C:/Users/Administrator/Desktop/Î¢Íù_µÇÂ¼_files/icon-ind-logo.png");
				Toolkit object_toolkit = Toolkit.getDefaultToolkit();
				Image image = object_toolkit.getImage(image_url);
				g.setColor(Color.white);
				g.fillRect(0, 0, 300, 400);
				g.drawImage(image, 40, 80, 160, 200, this);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (first) {
				first = false;
				g.setColor(Color.white);
				g.fillRect(0, 0, 400, 300);
				g.setFont(font);
			}
			if (line_str != null) {
				g.setColor(Color.green);
				g.drawString(line_str, 40, i++ * 80);
			}
		}
	}
	
	private void doDrawImage() {
		drawImage = true;
		repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if (msg.equals("display_beauty")) {
			drawImage = true;
			doDrawImage();
		} else {
			drawImage = false;
			first = true;
			if (msg.equals("display_text")) {
				doWrite("Hello world;!!!!!!!!!!!");
			}
		}
	}


	private void doWrite(String str) {
		// TODO Auto-generated method stub
		i = 1;
		line_str = str;
		repaint();
	}
}
