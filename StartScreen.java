import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class StartScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 789, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		// elsewhere
		File file = new File("src/StartScreen.png");
		BufferedImage myImage;
		try {
			myImage = ImageIO.read(file);
			frame.setContentPane(new ImagePanel(myImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ImageIcon OpenImage = new ImageIcon("src/OpenStartScreen.png");
		
		JButton btnOpenBuild = new JButton(OpenImage);
		btnOpenBuild.setBounds(115, 220, 110, 25);
		frame.getContentPane().add(btnOpenBuild);
		btnOpenBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreenTest mainwindow = new MainScreenTest();
		    	ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/PCLogoNewC.png");
		    	String[] args = null;
		    	mainwindow.main(args);
		    	frame.dispose();
			}
		});
		
		
		
		ImageIcon NewImage = new ImageIcon("src/NewStartScreen.png");
		
		JButton btnNewBuild = new JButton(NewImage);
		btnNewBuild.setBounds(115, 263, 110, 25);
		frame.getContentPane().add(btnNewBuild);
		btnNewBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreenTest mainwindow = new MainScreenTest();
		    	ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/PCLogoNewC.png");
		    	String[] args = null;
		    	mainwindow.main(args);
		    	frame.dispose();
			}
		});
		
		ImageIcon CPUImage = new ImageIcon("src/CPUStartScreen.png");
		
		JButton btnGpu = new JButton(CPUImage);
		btnGpu.setBounds(505, 195, 110, 25);
		frame.getContentPane().add(btnGpu);
		btnGpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partGuideScreen partScreen = new partGuideScreen();
				String[] args = null;
				partScreen.main(args);
				frame.dispose();
			}
		});
		
		ImageIcon GPUImage = new ImageIcon("src/GPUStartScreen.png");
		
		JButton btnGpu_1 = new JButton(GPUImage);
		btnGpu_1.setBounds(505, 222, 110, 25);
		frame.getContentPane().add(btnGpu_1);
		btnGpu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partGuideScreen partScreen = new partGuideScreen();
				String[] args = null;
				partScreen.main(args);
				frame.dispose();
			}
		});
		
		
		ImageIcon MothImage = new ImageIcon("src/MothStartScreen.png");
		
		JButton btnMotherboard = new JButton(MothImage);
		btnMotherboard.setBounds(494, 248, 130, 25);
		frame.getContentPane().add(btnMotherboard);
		btnMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partGuideScreen partScreen = new partGuideScreen();
				String[] args = null;
				partScreen.main(args);
				frame.dispose();
			}
		});
		
		
		ImageIcon MemImage = new ImageIcon("src/MemStartScreen.png");
		
		JButton btnMemory = new JButton(MemImage);
		btnMemory.setBounds(505, 274, 110, 25);
		frame.getContentPane().add(btnMemory);
		btnMemory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partGuideScreen partScreen = new partGuideScreen();
				String[] args = null;
				partScreen.main(args);
				frame.dispose();
			}
		});
		
	}
}
