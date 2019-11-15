import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class StartScreen {

	private JFrame frame;
	private JTextField txtWhatDoYou;

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
		btnOpenBuild.setBounds(165, 133, 110, 25);
		frame.getContentPane().add(btnOpenBuild);
		
		JButton btnNewBuild = new JButton("New Build");
		btnNewBuild.setBounds(166, 168, 110, 25);
		frame.getContentPane().add(btnNewBuild);
		
		JButton btnGpu = new JButton("CPU");
		btnGpu.setBounds(299, 133, 110, 25);
		frame.getContentPane().add(btnGpu);
		
		JButton btnGpu_1 = new JButton("GPU");
		btnGpu_1.setBounds(299, 168, 110, 25);
		frame.getContentPane().add(btnGpu_1);
		
		JButton btnMotherboard = new JButton("Motherboard");
		btnMotherboard.setBounds(299, 203, 110, 25);
		frame.getContentPane().add(btnMotherboard);
		
		JButton btnGeneralUse = new JButton("General Use");
		btnGeneralUse.setBounds(22, 238, 110, 25);
		frame.getContentPane().add(btnGeneralUse);
		
		JButton btnMemory = new JButton("Memory");
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
