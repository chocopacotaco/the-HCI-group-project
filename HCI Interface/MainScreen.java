import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainScreen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CPU", "CPU 1", "CPU 2", "CPU 3"}));
		comboBox.setToolTipText("CPU");
		
		comboBox.setBounds(0, 0, 98, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"GPU", "GPU 1", "GPU 2", "GPU 3"}));
		comboBox_1.setBounds(97, 0, 98, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Motherboard", "Motherboard 1", "Motherboard 2", "Motherboard 3", ""}));
		comboBox_2.setBounds(197, 0, 98, 22);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Memory", "Memory 1", "Memory 2", "Memory 3"}));
		comboBox_3.setBounds(295, 0, 98, 22);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Power Supply", "Power Supply 1", "Power Supply 2", "Power Supply 3", "", ""}));
		comboBox_4.setBounds(393, 0, 116, 22);
		frame.getContentPane().add(comboBox_4);
		
		JLabel lblCpu = new JLabel("CPU");
		lblCpu.setBounds(12, 3, 56, 16);
		frame.getContentPane().add(lblCpu);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Save", "Open Build", "Home"}));
		comboBox_5.setBounds(603, 0, 88, 22);
		frame.getContentPane().add(comboBox_5);
		
		textField = new JTextField();
		textField.setBounds(44, 309, 167, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 309, 167, 22);
		frame.getContentPane().add(textField_1);
		frame.add(new JLabel(new ImageIcon("C:/Users/studm/Documents/computerPic.png")));
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(454, 309, 167, 22);
		frame.getContentPane().add(textField_2);
		
		JLabel lblCurentParts = new JLabel("Current Parts");
		lblCurentParts.setBounds(97, 292, 81, 16);
		frame.getContentPane().add(lblCurentParts);
		
		JLabel lblPerformance = new JLabel("Performance");
		lblPerformance.setBounds(292, 292, 81, 16);
		frame.getContentPane().add(lblPerformance);
		
		JLabel lblOver = new JLabel("Total Cost");
		lblOver.setBounds(484, 292, 81, 16);
		frame.getContentPane().add(lblOver);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Storage", "Storage 1", "Storage 2", "Storage 3"}));
		comboBox_6.setBounds(506, 0, 98, 22);
		frame.getContentPane().add(comboBox_6);
	}
}
