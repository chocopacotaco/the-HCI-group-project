
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

public class PartsScreen{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartsScreen window = new PartsScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PartsScreen() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backToMain = new JButton("Back");
		backToMain.setToolTipText("Back to Build Menu");
		backToMain.setBounds(10, 10, 80, 40);
		frame.getContentPane().add(backToMain);
		backToMain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {				
				MainScreen mainWindow = new MainScreen();
				String[] args = null;
				mainWindow.main(args);	
				frame.dispose();			
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 50, 578, 311);
		panel.setLayout(new GridLayout(10,1));
		JButton a = new JButton("placeholder");
		a.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(a);
		JButton b = new JButton("placeholder");
		b.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(b);
		JButton c = new JButton("placeholder");
		c.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(c);
		JButton d = new JButton("placeholder");
		d.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(d);
		JButton e = new JButton("placeholder");
		e.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(e);
		JButton f = new JButton("placeholder");
		f.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(f);
		JButton g = new JButton("placeholder");
		g.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(g);
		JButton h = new JButton("placeholder");
		h.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(h);
		JButton i = new JButton("placeholder");
		i.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(i);
		JButton j = new JButton("placeholder");
		j.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(j);
		frame.getContentPane().add(panel);
		
		JLabel PartsTitle = new JLabel("Parts");
		PartsTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PartsTitle.setBounds(110, 10, 160, 40);
		frame.getContentPane().add(PartsTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 50, 578, 311);
		frame.getContentPane().add(scrollPane);
	}
}
