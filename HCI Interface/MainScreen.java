import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JPanel;

public class MainScreen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField horz;
	private JTextField vert;

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
		frame.setBounds(100, 100, 704, 411);
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
		textField.setBounds(44, 325, 167, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 325, 167, 22);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(new JLabel(new ImageIcon("C:/Users/studm/Documents/computerPic.png")));
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(454, 325, 167, 22);
		frame.getContentPane().add(textField_2);
		
		JLabel lblCurentParts = new JLabel("Current Parts");
		lblCurentParts.setBounds(97, 308, 81, 16);
		frame.getContentPane().add(lblCurentParts);
		
		JLabel lblPerformance = new JLabel("Performance");
		lblPerformance.setBounds(292, 308, 81, 16);
		frame.getContentPane().add(lblPerformance);
		
		JLabel lblOver = new JLabel("Total Cost");
		lblOver.setBounds(484, 308, 81, 16);
		frame.getContentPane().add(lblOver);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Storage", "Storage 1", "Storage 2", "Storage 3"}));
		comboBox_6.setBounds(506, 0, 98, 22);
		frame.getContentPane().add(comboBox_6);
		
		JButton cpuButton = new JButton("cpu");
		cpuButton.setBounds(268, 65, 60, 60);
		frame.getContentPane().add(cpuButton);
		
		JButton memoryButton = new JButton("ram");
		memoryButton.setBounds(433, 140, 60, 60);
		frame.getContentPane().add(memoryButton);
		
		JButton driveButton = new JButton("drive");
		driveButton.setBounds(268, 215, 60, 60);
		frame.getContentPane().add(driveButton);
		
		JButton psuButton = new JButton("psu");
		psuButton.setBounds(358, 215, 60, 60);
		frame.getContentPane().add(psuButton);
		
		JButton gpuButton = new JButton("gpu");
		gpuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		gpuButton.setBounds(193, 140, 60, 60);
		frame.getContentPane().add(gpuButton);
		
		JButton motherboardButton = new JButton("MB");
		motherboardButton.setBounds(358, 65, 60, 60);
		frame.getContentPane().add(motherboardButton);
		
		horz = new JTextField();
		horz.setBounds(0, 170, 687, 1);
		frame.getContentPane().add(horz);
		horz.setColumns(10);
		
		vert = new JTextField();
		vert.setBounds(344, 0, 1, 370);
		frame.getContentPane().add(vert);
		vert.setColumns(10);
		
		double cpuCenterX = 268+30;
		double cpuCenterY = 65+30;
		
		double gpuCenterX = 193+30;
		double gpuCenterY = 140+30;
		
		double driveCenterX = cpuCenterX;
		double driveCenterY = 215+30;
		
		double memCenterX = 433+30;
		double memCenterY = gpuCenterY;
		
		double psuCenterX = 358+30;
		double psuCenterY = driveCenterY;
		
		double boardCenterX = psuCenterX;
		double boardCenterY = cpuCenterY;
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				
				Shape cpuToGpu = new Line2D.Double(cpuCenterX, cpuCenterY, gpuCenterX, gpuCenterY);
				Shape cpuToDrive = new Line2D.Double(cpuCenterX, cpuCenterY, driveCenterX, driveCenterY);
				Shape cpuToPsu = new Line2D.Double(cpuCenterX, cpuCenterY, psuCenterX, psuCenterY);
				Shape cpuToRam = new Line2D.Double(cpuCenterX, cpuCenterY, memCenterX, memCenterY);
				Shape cpuToMB = new Line2D.Double(cpuCenterX, cpuCenterY, boardCenterX, boardCenterY);
				
				Shape gpuToDrive = new Line2D.Double(gpuCenterX, gpuCenterY, driveCenterX, driveCenterY);
				Shape gpuToPsu = new Line2D.Double(gpuCenterX, gpuCenterY, psuCenterX, psuCenterY);
				Shape gpuToRam = new Line2D.Double(gpuCenterX, gpuCenterY, memCenterX, memCenterY);
				Shape gpuToMB = new Line2D.Double(gpuCenterX, gpuCenterY, boardCenterX, boardCenterY);
				
				Shape driveToPsu = new Line2D.Double(driveCenterX, driveCenterY, psuCenterX, psuCenterY);
				Shape driveToRam = new Line2D.Double(driveCenterX, driveCenterY, memCenterX, memCenterY);
				Shape driveToMB = new Line2D.Double(driveCenterX, driveCenterY, boardCenterX, boardCenterY);
				
				Shape psuToRam = new Line2D.Double(psuCenterX, psuCenterY, memCenterX, memCenterY);
				Shape psuToMB = new Line2D.Double(psuCenterX, psuCenterY, boardCenterX, boardCenterY);
				
				Shape ramToMB = new Line2D.Double(memCenterX, memCenterY, boardCenterX, boardCenterY);
				
				g2.draw(cpuToGpu);
				g2.draw(cpuToDrive);
				g2.draw(cpuToPsu);
				g2.draw(cpuToRam);
				g2.draw(cpuToMB);
				g2.draw(gpuToDrive);
				g2.draw(gpuToPsu);
				g2.draw(gpuToRam);
				g2.draw(gpuToMB);
				g2.draw(driveToPsu);
				g2.draw(driveToRam);
				g2.draw(driveToMB);
				g2.draw(psuToRam);
				g2.draw(psuToMB);
				g2.draw(ramToMB);
			}
		};
		panel.setBounds(0, 0, 688, 372);
		frame.getContentPane().add(panel);		
	}
}
