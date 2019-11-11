import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class StartScreen {

	public static JFrame frame;
	
	public static StartScreen window;
	private JTextField txtWhatDoYou;
	MainScreen main= new MainScreen();
	/**
	 * Launch the application.
	 */
	partBuilder pc;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new StartScreen();
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
		frame.setBounds(100, 100, 452, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtWhatDoYou = new JTextField();
		txtWhatDoYou.setEditable(false);
		txtWhatDoYou.setText("What do you want to do?");
		txtWhatDoYou.setHorizontalAlignment(SwingConstants.CENTER);
		txtWhatDoYou.setBounds(116, 32, 172, 22);
		frame.getContentPane().add(txtWhatDoYou);
		txtWhatDoYou.setColumns(10);
		
		JButton btnPhotoEditing = new JButton("Photo Editing");
		btnPhotoEditing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				
				main.initialize();
				main.frame.setVisible(true);
				
			}
		});
		btnPhotoEditing.setBounds(22, 133, 110, 25);
		frame.getContentPane().add(btnPhotoEditing);
		
		JButton btnGaming = new JButton("Gaming");
		btnGaming.setBounds(22, 203, 110, 25);
		frame.getContentPane().add(btnGaming);
		
		JButton btnVideoEditing = new JButton("Video Editing");
		btnVideoEditing.setBounds(22, 168, 110, 25);
		frame.getContentPane().add(btnVideoEditing);
		
		JButton btnOpenBuild = new JButton("Open Build");
		btnOpenBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				main.initialize();
				main.frame.setVisible(true);
			}
		});
		btnOpenBuild.setBounds(165, 133, 110, 25);
		frame.getContentPane().add(btnOpenBuild);
		
		JButton btnNewBuild = new JButton("New Build");
		btnNewBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.initialize();
				frame.setVisible(false);
				main.frame.setVisible(true);
			}
		});
		btnNewBuild.setBounds(166, 168, 110, 25);
		frame.getContentPane().add(btnNewBuild);
		
		JButton btnGpu = new JButton("CPU");
		btnGpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "https://www.digitaltrends.com/computing/what-is-a-cpu/";
		         try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnGpu.setBounds(299, 133, 110, 25);
		frame.getContentPane().add(btnGpu);
		
		JButton btnGpu_1 = new JButton("GPU");
		btnGpu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "https://searchvirtualdesktop.techtarget.com/definition/GPU-graphics-processing-unit";
		         try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnGpu_1.setBounds(299, 168, 110, 25);
		frame.getContentPane().add(btnGpu_1);
		
		JButton btnMotherboard = new JButton("Motherboard");
		btnMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "https://www.computerhope.com/jargon/m/mothboar.htm";
		         try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException ex) {
					
					ex.printStackTrace();
				}
			}
		});
		btnMotherboard.setBounds(299, 203, 110, 25);
		frame.getContentPane().add(btnMotherboard);
		
		JButton btnGeneralUse = new JButton("General Use");
		btnGeneralUse.setBounds(22, 238, 110, 25);
		frame.getContentPane().add(btnGeneralUse);
		
		JButton btnMemory = new JButton("Memory");
		btnMemory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "https://www.computerhope.com/jargon/m/memory.htm";
		         try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException ex) {
					
					ex.printStackTrace();
				}
			}
		});
		btnMemory.setBounds(299, 238, 110, 25);
		frame.getContentPane().add(btnMemory);
		
		JLabel lblNewLabel = new JLabel("PC BUILDER NOW");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(83, 0, 232, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPremadePc = new JLabel("PREMADE PC");
		lblPremadePc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremadePc.setBounds(22, 90, 104, 30);
		frame.getContentPane().add(lblPremadePc);
		
		JLabel lblPcEditor = new JLabel("PC EDITOR");
		lblPcEditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcEditor.setBounds(165, 94, 90, 23);
		frame.getContentPane().add(lblPcEditor);
		
		JLabel lblPartGuide = new JLabel("PART GUIDE");
		lblPartGuide.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartGuide.setBounds(303, 94, 90, 23);
		frame.getContentPane().add(lblPartGuide);
	}
}
