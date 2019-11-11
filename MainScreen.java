import java.awt.EventQueue;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainScreen {

	public JFrame frame;
	public  JTextField textField;
	public  JTextField textField_1;
	public JTextField textField_2;
	public partBuilder pc;
	public currentPC save;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
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
	public currentPC open;
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
	public void initialize() {
		
		frame = new JFrame();
		pc = new partBuilder();
		pc.buildCPUs();
		
		
		frame.setBounds(100, 100, 704, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] ar = new String[pc.cpus.size()];
		JComboBox comboBox = new JComboBox();
		//add the cpu to the dropdown menu
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
				textField.repaint();
			}
		});
		comboBox.setBounds(0, 0, 98, 22);
		frame.getContentPane().add(comboBox);
		
		//add the gpu to the dropdown menu
		pc.buildGPUs();
		
		String[] gpuArr = new String[pc.gpus.size()];
		
		for(int i=0;i<pc.gpus.size();i++){
		 gpuArr[i]=pc.gpus.get(i).gpuName;
		}
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(gpuArr));
		comboBox_1.setBounds(97, 0, 98, 22);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_3.setText(comboBox_1.getSelectedItem().toString());
				GPUprice=pc.gpus.get(comboBox_1.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				GPUpower=pc.gpus.get(comboBox_1.getSelectedIndex()).power;
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textField_3.repaint();
			}
		});
		JComboBox comboBox_2 = new JComboBox();
		pc.buildBoards();
		String[] motherArr = new String[pc.boards.size()];
		
		for(int i=0;i<pc.boards.size();i++){
		 motherArr[i]=pc.boards.get(i).boardName;
		}
		comboBox_2.setModel(new DefaultComboBoxModel(motherArr));
		comboBox_2.setBounds(197, 0, 98, 22);
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
				textField_4.repaint();
			}
		});
		JComboBox comboBox_3 = new JComboBox();
		String[] memArr = new String[pc.memories.size()];
		
		for(int i=0;i<pc.memories.size();i++){
		 memArr[i]=pc.memories.get(i).memoryName;
		}
		comboBox_3.setModel(new DefaultComboBoxModel(memArr));
		comboBox_3.setBounds(295, 0, 98, 22);
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
				textField_7.repaint();
			}
		});
		JComboBox comboBox_4 = new JComboBox();
		String[] powerArr = new String[pc.gpus.size()];
		
		for(int i=0;i<pc.powers.size();i++){
		 powerArr[i]=pc.powers.get(i).powerName;
		}
		comboBox_4.setModel(new DefaultComboBoxModel(powerArr));
		comboBox_4.setBounds(393, 0, 116, 22);
		
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_6.setText(comboBox_4.getSelectedItem().toString());
				Powerprice=pc.powers.get(comboBox_4.getSelectedIndex()).price;
				total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
				
				powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textField_6.repaint();
			}
		});
		JLabel lblCpu = new JLabel("CPU");
		lblCpu.setBounds(12, 3, 56, 16);
		frame.getContentPane().add(lblCpu);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Save", "Open Build", "Home"}));
		
		
		comboBox_5.setBounds(603, 0, 88, 22);
		frame.getContentPane().add(comboBox_5);
		
		textField = new JTextField();
		textField.setBounds(0, 113, 167, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(246, 328, 167, 22);
		frame.getContentPane().add(textField_1);
		JLabel label = new JLabel(new ImageIcon("C:/Users/studm/workspace/HCI2/Images/computerPic.png"));
		label.setLocation(100,100);
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(454, 328, 167, 22);
		
		frame.getContentPane().add(textField_2);
		
		
		JLabel lblCurentParts = new JLabel("Current Parts");
		//set the text field to the part name 
		comboBox.getSelectedItem();
		//textField.setText(comboBox.getSelectedItem().toString());
		lblCurentParts.setBounds(37, 84, 81, 16);
		frame.getContentPane().add(lblCurentParts);
		
		JLabel lblPerformance = new JLabel("Performance");
		lblPerformance.setBounds(286, 309, 81, 16);
		frame.getContentPane().add(lblPerformance);
		
		JLabel lblOver = new JLabel("Total Cost");
		lblOver.setBounds(484, 309, 81, 16);
		frame.getContentPane().add(lblOver);
		
		JComboBox comboBox_6 = new JComboBox();
		
		comboBox_6.setBounds(506, 0, 98, 22);
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
				textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
				textField_2.setText(String.valueOf( String.format("%.2f", total)));
				textField_5.repaint();
			}
		});
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String command = arg0.getActionCommand();
				if("Save"==comboBox_5.getSelectedItem().toString()){
					
					
					save = new currentPC(1,"TEST",pc.cpus.get(comboBox.getSelectedIndex()),pc.gpus.get(comboBox_1.getSelectedIndex()),
						pc.boards.get(comboBox_2.getSelectedIndex()),pc.memories.get(comboBox_3.getSelectedIndex()),
							pc.powers.get(comboBox_4.getSelectedIndex()),pc.drives.get(comboBox_6.getSelectedIndex()));
					pc.save(save, "TEST");
				
					frame.setVisible(false);
					
				}
				else if("Open Build"==comboBox_5.getSelectedItem().toString()){
				
					File file = new File("C:/Users/studm/workspace/HCI2/src/csv/saves.csv");
					open=pc.load(file);
					textField.setText(open.currentCpu.cpuName);
			
					textField_3.setText(open.currentGpu.gpuName);
					textField_4.setText(open.currentBoard.boardName);
					textField_7.setText(open.currentMemory.memoryName);
					textField_6.setText(open.currentPower.powerName);
					
					textField_5.setText(open.currentDrive.storageName);
					Memprice=pc.memories.get(comboBox_3.getSelectedIndex()).price;
					total = CPUprice+GPUprice+Boardprice+Memprice+Storeprice+Powerprice;
					Mempower=pc.memories.get(comboBox_3.getSelectedIndex()).power;
					powerTot = CPUpower+GPUpower+Boardpower+Mempower+Storepower+Powerpower;
					textField_1.setText(String.valueOf( String.format("%.2f", powerTot)));
					textField_2.setText(String.valueOf( String.format("%.2f", total)));
					textField_7.repaint();
				}
				else{
					StartScreen start =new StartScreen();
			
					start.frame.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(0, 159, 167, 22);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(0, 201, 167, 22);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(0, 289, 167, 22);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(0, 251, 167, 22);
		frame.getContentPane().add(textField_6);
		
		JLabel lblCpu_1 = new JLabel("CPU");
		lblCpu_1.setBounds(54, 100, 56, 16);
		frame.getContentPane().add(lblCpu_1);
		
		JLabel lblGpu = new JLabel("GPU");
		lblGpu.setBounds(54, 142, 56, 16);
		frame.getContentPane().add(lblGpu);
		
		JLabel lblMotherboard = new JLabel("Motherboard");
		lblMotherboard.setBounds(54, 181, 98, 16);
		frame.getContentPane().add(lblMotherboard);
		
		JLabel lblPowerSupply = new JLabel("Power Supply");
		lblPowerSupply.setBounds(54, 226, 98, 16);
		frame.getContentPane().add(lblPowerSupply);
		
		JLabel lblStorage = new JLabel("Storage");
		lblStorage.setBounds(54, 275, 98, 16);
		frame.getContentPane().add(lblStorage);
		
		
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(0, 334, 167, 22);
		frame.getContentPane().add(textField_7);
		
		JLabel lblMemory = new JLabel("Memory");
		lblMemory.setBounds(54, 315, 98, 16);
		frame.getContentPane().add(lblMemory);
	}
}
