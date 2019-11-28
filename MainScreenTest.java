import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;

public class MainScreenTest {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private JButton cpuButton;
	private JButton gpuButton;
	private JButton memoryButton;
	private JButton driveButton;
	private JButton psuButton;
	private JButton motherboardButton;
	
	public partBuilder pc;
	public currentPC open;
	public JTextPane textPane;
	public JTextPane compPane;
	
	public double CPUprice;
	public double GPUprice;
	public double Boardprice;
	public double Memprice;
	public double Storeprice;
	public double Powerprice;
	public double CPUpower;
	public double GPUpower;
	public double Boardpower;
	public double Mempower;
	public double Storepower;
	public double Powerpower;
	public double total;
	public double powerTot;
	
	private JTextField horz;
	private JTextField vert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreenTest window = new MainScreenTest();
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
	public MainScreenTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pc = new partBuilder();
		open = new currentPC(0,"untitled",null,null,null,null,null,null);
		
		
		String[] ar = new String[pc.cpus.size()];
				
		JComboBox comboBox = new JComboBox();
		for(int i=0;i<pc.cpus.size();i++){
			 ar[i]=pc.cpus.get(i).getName();
			}
			comboBox.setModel(new DefaultComboBoxModel(ar));
			comboBox.setToolTipText("CPU");
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					textField.setText(comboBox.getSelectedItem().toString());
					
					CPUprice=pc.cpus.get(comboBox.getSelectedIndex()).price;
					total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
					CPUpower=pc.cpus.get(comboBox.getSelectedIndex()).power;
					powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
					textField_1.setText(String.valueOf(powerTot));
					textPane.setText("CPU Speed: "+pc.cpus.get(comboBox.getSelectedIndex()).ghzSpeed+"\n"+"CPU Cores: "+pc.cpus.get(comboBox.getSelectedIndex()).cores 
							+"\n"+"CPU Threads: "+pc.cpus.get(comboBox.getSelectedIndex()).threads+"\n"+"CPU Memory: "+pc.cpus.get(comboBox.getSelectedIndex()).memSize+
							"\n"+"CPU Memory Size: "+pc.cpus.get(comboBox.getSelectedIndex()).memMeasure);
					cpuButton.setEnabled(true);
					textField.repaint();
					int partLocatator = comboBox.getSelectedIndex() + 1;
					cpuPart testeeds = pc.findCPU(partLocatator);
					System.out.println(testeeds.cpuName);
					open.currentCpu = pc.findCPU(partLocatator);
				}
			});		
		comboBox.setBounds(1, 0, 98, 22);
		frame.getContentPane().add(comboBox);
		
		
		//GPU combo box
		String[] gpuArr = new String[pc.gpus.size()];
		
		JComboBox comboBox_1 = new JComboBox();		
		for(int i=0;i<pc.gpus.size();i++){
			 gpuArr[i]=pc.gpus.get(i).gpuName;
			}
		comboBox_1.setModel(new DefaultComboBoxModel(gpuArr));
		comboBox_1.setToolTipText("GPU");
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_3.setText(comboBox_1.getSelectedItem().toString());
				GPUprice=pc.gpus.get(comboBox_1.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				GPUpower=pc.gpus.get(comboBox_1.getSelectedIndex()).power;
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textPane.setText("GPU Chip Name: "+pc.gpus.get(comboBox_1.getSelectedIndex()).chipName+"\n"+"Bus: "+pc.gpus.get(comboBox.getSelectedIndex()).bus 
						+"\n"+"CPU Clock Speed: "+pc.gpus.get(comboBox_1.getSelectedIndex()).gpuClockSpeed+"\n"+"GPU Memory: "+pc.gpus.get(comboBox.getSelectedIndex()).memory+
						"\n"+"CPU Memory Clock: "+pc.gpus.get(comboBox_1.getSelectedIndex()).memoryClock);
				gpuButton.setEnabled(true);
				textField_3.repaint();
				int partLocatator = comboBox_1.getSelectedIndex() + 1;
				gpuPart testeeds = pc.findGPU(partLocatator);
				System.out.println(testeeds.gpuName);
				open.currentGpu = pc.findGPU(partLocatator);
			}
		});
		comboBox_1.setBounds(100, 0, 98, 22);
		frame.getContentPane().add(comboBox_1);
		
		
		//Board combo box		
		JComboBox comboBox_2 = new JComboBox();
		pc.buildBoards();
		String[] motherArr = new String[pc.boards.size()/2];
		
		for(int i=0;i<pc.boards.size()/2;i++){
		 motherArr[i]=pc.boards.get(i).boardName;
		}
		comboBox_2.setModel(new DefaultComboBoxModel(motherArr));
		comboBox_2.setBounds(199, 0, 98, 22);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_4.setText(comboBox_2.getSelectedItem().toString());
				Boardprice=pc.boards.get(comboBox_2.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				Boardpower=pc.boards.get(comboBox_2.getSelectedIndex()).power;
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textPane.setText("CPU Socket: "+pc.boards.get(comboBox_2.getSelectedIndex()).cpuSocketType+"\n"+"CPU Socket: "+pc.boards.get(comboBox.getSelectedIndex()).cpuSocket 
						+"\n"+"Max CPU Support: "+pc.boards.get(comboBox_2.getSelectedIndex()).cpuMaxSupport+"\n"+"GPU Sockets: "
						+pc.boards.get(comboBox_2.getSelectedIndex()).gpuSockets+
						"\n"+"RAM Sockets: "+pc.boards.get(comboBox_2.getSelectedIndex()).ramSockets+
						"\n"+"RAM Scoket Type: "+pc.boards.get(comboBox_2.getSelectedIndex()).ramSocketType+
						"\n"+"Max RAM Memory: "+pc.boards.get(comboBox_2.getSelectedIndex()).ramMaxMemory+
						"\n"+"Peripheral Sockets Available: "+pc.boards.get(comboBox_2.getSelectedIndex()).peripheralSocketsAvaliable+
						"\n"+"Total Peripheral Sockets: "+pc.boards.get(comboBox_2.getSelectedIndex()).peripheralSocketsTotal);
				motherboardButton.setEnabled(true);
				textField_4.repaint();
				int partLocatator = comboBox_2.getSelectedIndex() + 1;
				boardPart testeeds = pc.findBoard(partLocatator);
				System.out.println(testeeds.boardName);
				open.currentBoard = pc.findBoard(partLocatator);
			}
		});
		
		//Memory combo box		
		JComboBox comboBox_3 = new JComboBox();
		String[] memArr = new String[pc.memories.size()];
		
		for(int i=0;i<pc.memories.size();i++){
		 memArr[i]=pc.memories.get(i).memoryName;
		}
		comboBox_3.setModel(new DefaultComboBoxModel(memArr));
		comboBox_3.setBounds(298, 0, 98, 22);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_7.setText(comboBox_3.getSelectedItem().toString());
				Memprice=pc.memories.get(comboBox_3.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				Mempower=pc.memories.get(comboBox_3.getSelectedIndex()).power;
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textPane.setText("Socket Type: "+pc.memories.get(comboBox_3.getSelectedIndex()).socketType+"\n"+"Memory Size: "+pc.memories.get(comboBox.getSelectedIndex()).memorySize 
						+"\n"+"CPU Clock Speed: "+pc.gpus.get(comboBox_3.getSelectedIndex()).gpuClockSpeed+"\n"+"GPU Memory: "+pc.gpus.get(comboBox.getSelectedIndex()).memory+
						"\n"+"RAM Type: "+pc.memories.get(comboBox_3.getSelectedIndex()).socketType+
						"\n"+"RAM Stick Amount: "+pc.memories.get(comboBox_3.getSelectedIndex()).ramStickAmount);
				memoryButton.setEnabled(true);
				textField_7.repaint();
				int partLocatator = comboBox_3.getSelectedIndex() + 1;
				memoryPart testeeds = pc.findMemory(partLocatator);
				//System.out.println(testeeds.memoryName);
				open.currentMemory = pc.findMemory(partLocatator);
			}
		});
		
		
		//PSU combo box		
		JComboBox comboBox_4 = new JComboBox();
		String[] powerArr = new String[pc.powers.size()];
		
		for(int i=0;i<pc.powers.size();i++){
		 powerArr[i]=pc.powers.get(i).powerName;
		}
		comboBox_4.setModel(new DefaultComboBoxModel(powerArr));
		comboBox_4.setBounds(397, 0, 116, 22);
		
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_6.setText(comboBox_4.getSelectedItem().toString());
				Powerprice=pc.powers.get(comboBox_4.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textPane.setText("Max Wattage: "+pc.powers.get(comboBox_4.getSelectedIndex()).maxWattage+"\n");
				psuButton.setEnabled(true);
				textField_6.repaint();
				int partLocatator = comboBox_4.getSelectedIndex() + 1;
				powerPart testeeds = pc.findPower(partLocatator);
				System.out.println(testeeds.powerName);
				open.currentPower = pc.findPower(partLocatator);
			}
		});
		
		/*
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Save", "Open Build", "Home"}));
		comboBox_5.setBounds(603, 0, 88, 22);
		frame.getContentPane().add(comboBox_5);
		*/
		textField = new JTextField();
		textField.setBounds(5, 120, 167, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 400, 137, 22);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(new JLabel(new ImageIcon("C:/Users/studm/Documents/computerPic.png")));
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(363, 400, 137, 22);
		frame.getContentPane().add(textField_2);
		
		JLabel lblPerformance = new JLabel("Performance");
		lblPerformance.setBounds(215, 380, 81, 16);
		frame.getContentPane().add(lblPerformance);
		
		JLabel lblOver = new JLabel("Total Cost");
		lblOver.setBounds(378, 380, 81, 16);
		frame.getContentPane().add(lblOver);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(514, 0, 98, 22);
		String[] driveArr = new String[pc.drives.size()];
		
		for(int i=0;i<pc.drives.size();i++){
			 driveArr[i]=pc.drives.get(i).storageName;
			}
		comboBox_6.setModel(new DefaultComboBoxModel(driveArr));
		frame.getContentPane().add(comboBox_6);
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_5.setText(comboBox_6.getSelectedItem().toString());
				Boardprice=pc.boards.get(comboBox_6.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				Boardpower=pc.boards.get(comboBox_6.getSelectedIndex()).power;
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textPane.setText("Storage Type: "+pc.drives.get(comboBox.getSelectedIndex()).storageType+"\n"+"Storage: "+pc.drives.get(comboBox.getSelectedIndex()).storageSize 
						+"\n"+"Storage Measure: "+pc.drives.get(comboBox.getSelectedIndex()).sizeMeasure+"\n"+"Hard Drive RPM: "+pc.drives.get(comboBox.getSelectedIndex()).hardDriveRPM+
						"\n"+"Solid State: "+pc.drives.get(comboBox.getSelectedIndex()).ssdDTR+
						"\n"+"RAM Stick Amount: "+pc.memories.get(comboBox.getSelectedIndex()).ramStickAmount);
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				driveButton.setEnabled(true);
				textField_5.repaint();
				int partLocatator = comboBox_6.getSelectedIndex() + 1;
				drivePart testeeds = pc.findDrives(partLocatator);
				System.out.println(testeeds.storageName);
				open.currentDrive = pc.findDrives(partLocatator);
			}
		});
		
		cpuButton = new JButton("cpu");
		cpuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cpuButton.setBounds(275, 90, 60, 60);
		cpuButton.setEnabled(false);
		frame.getContentPane().add(cpuButton);
		cpuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("CPU Speed: "+pc.cpus.get(comboBox.getSelectedIndex()).ghzSpeed+"\n"+"CPU Cores: "+pc.cpus.get(comboBox.getSelectedIndex()).cores 
						+"\n"+"CPU Threads: "+pc.cpus.get(comboBox.getSelectedIndex()).threads+"\n"+"CPU Memory: "+pc.cpus.get(comboBox.getSelectedIndex()).memSize+
						"\n"+"CPU Memory Size: "+pc.cpus.get(comboBox.getSelectedIndex()).memMeasure);
			}			
		});
		
		memoryButton = new JButton("ram");
		memoryButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		memoryButton.setBounds(440, 185, 60, 60);
		memoryButton.setEnabled(false);
		frame.getContentPane().add(memoryButton);
		memoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("Socket Type: "+pc.memories.get(comboBox.getSelectedIndex()).socketType+"\n"+"Memory Size: "+pc.memories.get(comboBox.getSelectedIndex()).memorySize 
						+"\n"+"CPU Clock Speed: "+pc.gpus.get(comboBox.getSelectedIndex()).gpuClockSpeed+"\n"+"GPU Memory: "+pc.gpus.get(comboBox.getSelectedIndex()).memory+
						"\n"+"RAM Type: "+pc.memories.get(comboBox.getSelectedIndex()).socketType+
						"\n"+"RAM Stick Amount: "+pc.memories.get(comboBox.getSelectedIndex()).ramStickAmount);
			}			
		});
		
		driveButton = new JButton("drive");
		driveButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		driveButton.setBounds(275, 280, 60, 60);
		driveButton.setEnabled(false);
		frame.getContentPane().add(driveButton);	
		driveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("Storage Type: "+pc.drives.get(comboBox.getSelectedIndex()).storageType+"\n"+"Storage: "+pc.drives.get(comboBox.getSelectedIndex()).storageSize 
						+"\n"+"Storage Measure: "+pc.drives.get(comboBox.getSelectedIndex()).sizeMeasure+"\n"+"Hard Drive RPM: "+pc.drives.get(comboBox.getSelectedIndex()).hardDriveRPM+
						"\n"+"Solid State: "+pc.drives.get(comboBox.getSelectedIndex()).ssdDTR+
						"\n"+"RAM Stick Amount: "+pc.memories.get(comboBox.getSelectedIndex()).ramStickAmount);
			}			
		});
		
		psuButton = new JButton("psu");
		psuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		psuButton.setBounds(365, 280, 60, 60);
		psuButton.setEnabled(false);
		frame.getContentPane().add(psuButton);
		psuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("Max Wattage: "+pc.powers.get(comboBox.getSelectedIndex()).maxWattage+"\n");
			}			
		});
		
		gpuButton = new JButton("gpu");
		gpuButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		gpuButton.setBounds(200, 185, 60, 60);
		gpuButton.setEnabled(false);
		frame.getContentPane().add(gpuButton);
		gpuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("GPU Chip Name: "+pc.gpus.get(comboBox.getSelectedIndex()).chipName+"\n"+"Bus: "+pc.gpus.get(comboBox.getSelectedIndex()).bus 
						+"\n"+"CPU Clock Speed: "+pc.gpus.get(comboBox.getSelectedIndex()).gpuClockSpeed+"\n"+"GPU Memory: "+pc.gpus.get(comboBox.getSelectedIndex()).memory+
						"\n"+"CPU Memory Clock: "+pc.gpus.get(comboBox.getSelectedIndex()).memoryClock);
			}			
		});
		
		motherboardButton = new JButton("MB");
		motherboardButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		motherboardButton.setBounds(365, 90, 60, 60);
		motherboardButton.setEnabled(false);
		frame.getContentPane().add(motherboardButton);
		motherboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("CPU Socket: "+pc.boards.get(comboBox.getSelectedIndex()).cpuSocketType+"\n"+"CPU Socket: "+pc.boards.get(comboBox.getSelectedIndex()).cpuSocket 
						+"\n"+"Max CPU Support: "+pc.boards.get(comboBox.getSelectedIndex()).cpuMaxSupport+"\n"+"GPU Sockets: "
						+pc.boards.get(comboBox.getSelectedIndex()).gpuSockets+
						"\n"+"RAM Sockets: "+pc.boards.get(comboBox.getSelectedIndex()).ramSockets+
						"\n"+"RAM Scoket Type: "+pc.boards.get(comboBox.getSelectedIndex()).ramSocketType+
						"\n"+"Max RAM Memory: "+pc.boards.get(comboBox.getSelectedIndex()).ramMaxMemory+
						"\n"+"Peripheral Sockets Available: "+pc.boards.get(comboBox.getSelectedIndex()).peripheralSocketsAvaliable+
						"\n"+"Total Peripheral Sockets: "+pc.boards.get(comboBox.getSelectedIndex()).peripheralSocketsTotal);
			}			
		});
		
		/*
		horz = new JTextField();
		horz.setBounds(0, 170, 687, 1);
		frame.getContentPane().add(horz);
		horz.setColumns(10);
		
		vert = new JTextField();
		vert.setBounds(344, 0, 1, 370);
		frame.getContentPane().add(vert);
		vert.setColumns(10);
		*/
						
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				
				Shape cpuToGpu = new Line2D.Double(105, 30, 30, 125);
				Shape cpuToDrive = new Line2D.Double(105, 30, 105, 220);
				Shape cpuToPsu = new Line2D.Double(105, 30, 195, 220);
				Shape cpuToRam = new Line2D.Double(105, 30, 270, 125);
				Shape cpuToMB = new Line2D.Double(105, 30, 195, 30);
				
				Shape gpuToDrive = new Line2D.Double(30, 125, 105, 220);
				Shape gpuToPsu = new Line2D.Double(30, 125, 195, 220);
				Shape gpuToRam = new Line2D.Double(30, 125, 270, 125);
				Shape gpuToMB = new Line2D.Double(30, 125, 195, 30);
				
				Shape driveToPsu = new Line2D.Double(105, 220, 195, 220);
				Shape driveToRam = new Line2D.Double(105, 220, 270, 125);
				Shape driveToMB = new Line2D.Double(105, 220, 195, 30);
				
				Shape psuToRam = new Line2D.Double(195, 220, 270, 125);
				Shape psuToMB = new Line2D.Double(195, 220, 195, 30);
				
				Shape ramToMB = new Line2D.Double(270, 125, 195, 30);
								
				if(cpuButton.isEnabled() == true && gpuButton.isEnabled() == true)	g2.draw(cpuToGpu);
				if(cpuButton.isEnabled() == true && driveButton.isEnabled() == true)	g2.draw(cpuToDrive);
				if(cpuButton.isEnabled() == true && psuButton.isEnabled() == true)	g2.draw(cpuToPsu);
				if(cpuButton.isEnabled() == true && memoryButton.isEnabled() == true)	g2.draw(cpuToRam);
				if(cpuButton.isEnabled() == true && motherboardButton.isEnabled() == true)	g2.draw(cpuToMB);
				
				if(gpuButton.isEnabled() == true && driveButton.isEnabled() == true)	g2.draw(gpuToDrive);
				if(gpuButton.isEnabled() == true && psuButton.isEnabled() == true)	g2.draw(gpuToPsu);
				if(gpuButton.isEnabled() == true && memoryButton.isEnabled() == true)	g2.draw(gpuToRam);
				if(gpuButton.isEnabled() == true && motherboardButton.isEnabled() == true)	g2.draw(gpuToMB);
				
				if(driveButton.isEnabled() == true && psuButton.isEnabled() == true)	g2.draw(driveToPsu);
				if(driveButton.isEnabled() == true && memoryButton.isEnabled() == true)		g2.draw(driveToRam);
				if(driveButton.isEnabled() == true && motherboardButton.isEnabled() == true)	g2.draw(driveToMB);
				
				if(psuButton.isEnabled() == true && memoryButton.isEnabled() == true)	g2.draw(psuToRam);
				if(psuButton.isEnabled() == true && motherboardButton.isEnabled() == true)	g2.draw(psuToMB);
				
				if(memoryButton.isEnabled() == true && motherboardButton.isEnabled() == true)	g2.draw(ramToMB);
				
				if(comboBox_4.getSelectedIndex() == 2) {
					g2.setColor(Color.red);
					if(motherboardButton.isEnabled() == true)	g2.draw(psuToMB);
					if(memoryButton.isEnabled() == true)	g2.draw(psuToRam);
					if(driveButton.isEnabled() == true)	g2.draw(driveToPsu);
					if(gpuButton.isEnabled() == true)	g2.draw(gpuToPsu);
					if(cpuButton.isEnabled() == true)	g2.draw(cpuToPsu);
				}
			}
		};
		panel.setBounds(200, 90, 300, 250);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(612, 22, 89, 23);
		frame.getContentPane().add(saveBtn);
		saveBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser j = new JFileChooser();
				j.showSaveDialog(null);
				String path = j.getSelectedFile().getAbsolutePath();
				path = path.substring(0,path.lastIndexOf(File.separator));
				String filename = j.getSelectedFile().getName();
				pc.save(open, filename, path);
			}			
		});
		
		System.out.println(comboBox_4.getItemAt(1).toString());
		
		JButton openBtn = new JButton("Open");
		openBtn.setBounds(612, 44, 89, 23);
		frame.getContentPane().add(openBtn);
		openBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.showOpenDialog(null);
								String path = j.getSelectedFile().getAbsolutePath();
				//path = path.substring(0,path.lastIndexOf(File.separator));
				String filename = j.getSelectedFile().getName();
				File temp = new File(path);
				open = pc.load(temp);

				if(open.currentGpu != null){
					textField.setText(open.currentCpu.cpuName);//comboBox
					int location = open.currentBoard.boardID - 1;
					comboBox.setSelectedIndex(location);
					CPUprice = open.currentCpu.price;
					CPUpower = open.currentCpu.power;
					cpuButton.setEnabled(true);
				}

				if(open.currentGpu != null){
					textField_3.setText(open.currentGpu.gpuName);
					int location = open.currentBoard.boardID - 1;
					comboBox_1.setSelectedIndex(location);
					GPUprice = open.currentGpu.price;
					GPUpower = open.currentGpu.power;
					gpuButton.setEnabled(true);
				}

				if(open.currentBoard != null){
					textField_4.setText(open.currentBoard.boardName);
					int location = open.currentBoard.boardID - 1;
					comboBox_2.setSelectedIndex(location);
					Boardprice = open.currentBoard.price;
					Boardpower = open.currentBoard.power;
					motherboardButton.setEnabled(true);
				}

				if(open.currentMemory != null){
					textField_7.setText(open.currentMemory.memoryName);
					int location = open.currentMemory.memoryID - 1;
					comboBox_3.setSelectedIndex(location);
					Memprice = open.currentMemory.price;
					Mempower = open.currentMemory.power;
					memoryButton.setEnabled(true);
				}

				if(open.currentPower != null){
					textField_6.setText(open.currentPower.powerName);
					int location = open.currentPower.powerID - 1;
					comboBox_4.setSelectedIndex(location);
					Powerprice = open.currentPower.price;
					Powerpower = open.currentPower.maxWattage;
					psuButton.setEnabled(true);
				}

				if(open.currentDrive != null){
					textField_5.setText(open.currentDrive.storageName);
					int location = open.currentDrive.storageID - 1;
					comboBox_6.setSelectedIndex(location);
					Storeprice = open.currentPower.price;
					Storepower = open.currentPower.maxWattage;
					driveButton.setEnabled(true);
				}


				total = open.cost();
				powerTot = open.powerCheck();
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
			}			
		});
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setBounds(612, 0, 89, 23);
		frame.getContentPane().add(homeBtn);
		frame.getContentPane().add(panel);
		homeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				StartScreen start = new StartScreen();
				String[] args = null;
				start.main(args);
				frame.dispose();
			}			
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(5, 170, 167, 22);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(5, 220, 167, 22);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(5, 370, 167, 22);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(5, 320, 167, 22);
		frame.getContentPane().add(textField_6);
		
		JLabel lblCpu_1 = new JLabel("CPU");
		lblCpu_1.setBounds(40, 100, 56, 16);
		frame.getContentPane().add(lblCpu_1);
		
		JLabel lblGpu = new JLabel("GPU");
		lblGpu.setBounds(40, 150, 56, 16);
		frame.getContentPane().add(lblGpu);
		
		JLabel lblMotherboard = new JLabel("Motherboard");
		lblMotherboard.setBounds(40, 200, 98, 16);
		frame.getContentPane().add(lblMotherboard);
		
		JLabel lblPowerSupply = new JLabel("Power Supply");
		lblPowerSupply.setBounds(40, 300, 98, 16);
		frame.getContentPane().add(lblPowerSupply);
		
		JLabel lblStorage = new JLabel("Storage");
		lblStorage.setBounds(40, 350, 98, 16);
		frame.getContentPane().add(lblStorage);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(5, 270, 167, 22);
		frame.getContentPane().add(textField_7);
		
		JLabel lblMemory = new JLabel("RAM Memory");
		lblMemory.setBounds(40, 250, 98, 16);
		frame.getContentPane().add(lblMemory);
		
		 textPane = new JTextPane();
		 textPane.setEditable(false);
		 textPane.setBackground(Color.WHITE);
		 textPane.setBounds(530, 150, 153, 164);
		 textPane.setBorder(new EtchedBorder(EtchedBorder.RAISED,null,null));
		 frame.getContentPane().add(textPane);
			
		 JLabel lblPartInfo = new JLabel("Part Info");
		 lblPartInfo.setBounds(535, 125, 81, 16);
		 frame.getContentPane().add(lblPartInfo);
		 
		 JLabel lblComp = new JLabel("Incompatabilities");
		 lblComp.setBounds(535, 100, 120, 14);
		 lblComp.setVisible(false);
		 frame.getContentPane().add(lblComp);
			
		 JTextPane compPane = new JTextPane();
		 compPane.setEditable(false);
		 compPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		 compPane.setBackground(Color.WHITE);
		 compPane.setBounds(530, 120, 153, 100);
		 compPane.setBorder(new EtchedBorder(EtchedBorder.RAISED,null,null));
		 compPane.setVisible(false);
		 frame.getContentPane().add(compPane);
	}
}
