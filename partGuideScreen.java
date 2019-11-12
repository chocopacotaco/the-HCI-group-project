
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class partGuideScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					partGuideScreen frame = new partGuideScreen();
					ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/PCLogoNewC.png");
					frame.setIconImage(img.getImage());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public partGuideScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	    
		
		JLabel lblPcPartGuide = new JLabel("PC Part Guide");
		lblPcPartGuide.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 34));
		lblPcPartGuide.setBounds(10, 11, 214, 51);
		contentPane.add(lblPcPartGuide);
		
		JLabel lblStuffAbout = new JLabel("Stuff About:");
		lblStuffAbout.setFont(new Font("Arial", Font.BOLD, 22));
		lblStuffAbout.setBounds(234, 37, 123, 25);
		contentPane.add(lblStuffAbout);
		
		JLabel lblTitleBox = new JLabel(" ");
		lblTitleBox.setFont(new Font("Arial", Font.PLAIN, 22));
		lblTitleBox.setBounds(367, 34, 164, 28);
		contentPane.add(lblTitleBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 73, 123, 550);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(198, 73, 410, 550);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtrTextStuffHere = new JTextArea();
		txtrTextStuffHere.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrTextStuffHere.setBounds(10, 125, 390, 414);
		panel_1.add(txtrTextStuffHere);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 390, 128);
		panel_1.add(textPane);
		

		/* Action Listeners to use the buttons in the menu to set the Text in the main text area */
		
		ActionListener setCPUAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon(getClass().getResource("/pics/cpu.jpg")); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("CPU");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the CPU. \n The Cpu is the Brain of the Computer that does the brain stuff. \n It does important things like accessing the memory and running multple math problems in seconds. \n The more cores your processor has, the better its performance should be. For example: \n A processor with 4 cores runs slower than a core with 6 threads");
	        }
	    };
		ActionListener setGPUAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon(getClass().getResource("/pics/gpu.jpg")); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back

	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("GPU");
	        	txtrTextStuffHere.setText("\"\r\n" + 
	        			"\r\n" + 
	        			"Here is stuff About the Graphics Processing Unit.\r\n" + 
	        			"A graphics processing unit (GPU) is a specialized electronic circuit designed\r\n" + 
	        			"to rapidly manipulate and alter memory to accelerate the creation of images in a\r\n" + 
	        			"frame buffer intended for output to a display device. GPUs are used in embedded\r\n" + 
	        			"systems, mobile phones, personal computers, workstations, and game consoles. Modern\r\n" + 
	        			"GPUs are very efficient at manipulating computer graphics and image processing.\"");
	        }
	    };
		ActionListener setMotherboardAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon(getClass().getResource("/pics/motherboard.png")); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("CPU");
	        	txtrTextStuffHere.setText("\r\n" + 
	        			"\r\n" + 
	        			"Here is stuff About the Mother Board.\r\n" + 
	        			"A motherboard (sometimes alternatively known as the mainboard, main circuit board, system board, baseboard, planar\r\n" + 
	        			"board or logic board,[1] or colloquially, a mobo) is the main printed circuit board (PCB) found in general purpose \r\n" + 
	        			"computers and other expandable systems. It holds, and allows, communication between many of the crucial electronic components\r\n" + 
	        			"of a system, such as the central processing unit (CPU) and memory, and provides connectors for other peripherals. Unlike\r\n" + 
	        			"a backplane, a motherboard usually contains significant sub-systems such as the central processor, the chipset's input/output\r\n" + 
	        			"and memory controllers,  connectors, and other components integrated for general purpose use and applications.");
	        }
	    };
		ActionListener setPSUAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("/pics/psu.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back

	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("CPU");
	        	txtrTextStuffHere.setText("\"\r\n" + 
	        			"\r\n" + 
	        			"Here is stuff About the Power Supply.\r\n" + 
	        			"A power supply unit (or PSU) converts mains AC to low-voltage regulated DC power for the\r\n" + 
	        			"internal components of a computer. Modern personal computers universally use switched-mode power\r\n" + 
	        			"supplies. Some power supplies have a manual switch for selecting input voltage, while others\r\n" + 
	        			"automatically adapt to the mains voltage.\\n\r\n" + 
	        			"\\n\r\n" + 
	        			"Most modern desktop personal computer power supplies conform to the ATX specification, which includes\r\n" + 
	        			"form factor and voltage tolerances. While an ATX power supply is connected to the mains supply, it always\r\n" + 
	        			"provides a 5 Volt standby (5VSB) voltage so that the standby functions on the computer and certain peripherals\r\n" + 
	        			"are powered. ATX power supplies are turned on and off by a signal from the motherboard");
	        }
	    };
		ActionListener setRAMAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("/pics/ram.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("RAM");
	        	txtrTextStuffHere.setText("\r\n" + 
	        			"\r\n" + 
	        			"Here is stuff About the System Random Access Memory .\r\n" + 
	        			"RAM (Random Access Memory) is the hardware in a computing device where the operating system (OS)\r\n" + 
	        			", application programs and data in current use are kept so they can be quickly reached by the device's processor.\r\n" + 
	        			"RAM is the main memory in a computer, and it is much faster to read from and write to than other kinds of storage\r\n" + 
	        			", such as a hard disk drive (HDD), solid-state drive (SSD) or optical drive.");
	        }
	    };
		ActionListener setHDDAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("/pics/hdd.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("HDD");
	        	txtrTextStuffHere.setText("\\n\r\n" + 
	        			"\\n\r\n" + 
	        			"Here is stuff About the System Memory Hard Drive.\\n\r\n" + 
	        			"A hard disk drive (HDD), hard disk, hard drive, or fixed disk[b] is an electro-mechanical data\\n\r\n" + 
	        			"storage device that uses magnetic storage to store and retrieve digital information using one or\\n\r\n" + 
	        			"more rigid rapidly rotating disks (platters) coated with magnetic material. The platters are paired with\\n\r\n" + 
	        			"magnetic heads, usually arranged on a moving actuator arm, which read and write data to the platter surfaces.\\n\r\n" + 
	        			"[2] Data is accessed in a random-access manner, meaning that individual blocks of data can be stored or\\n\r\n" + 
	        			"retrieved in any order and not only sequentially. HDDs are a type of non-volatile storage, retaining stored\\n\r\n" + 
	        			"data even when powered off.\\n");
	        }
	    };
		ActionListener setCPUInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	
	        	ImageIcon imageIcon = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("GPU");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the CPU. \n The Cpu is the Brain of the Computer that does the brain stuff. \n It does important things like accessing the memory and running multple math problems in seconds. \n The more cores your processor has, the better its performance should be. For example: \n A processor with 4 cores runs slower than a core with 6 threads");
	        }
	    };
		ActionListener setMemoryAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	
	        	ImageIcon imageIcon = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("Memory");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the CPU. \n The Cpu is the Brain of the Computer that does the brain stuff. \n It does important things like accessing the memory and running multple math problems in seconds. \n The more cores your processor has, the better its performance should be. For example: \n A processor with 4 cores runs slower than a core with 6 threads");
	        }
	    };
	    
		/* The menu items on the left side of the pane*/
	    
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 97, 30);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("CPU");
		menuBar.add(mnNewMenu);
	    
		JMenuItem mntmAboutCPU = new JMenuItem("About");
		mnNewMenu.add(mntmAboutCPU);
		
		JMenuItem mntmHowToInstall = new JMenuItem("How To Install");
		mnNewMenu.add(mntmHowToInstall);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(10, 60, 97, 21);
		panel.add(menuBar_1);
		
		JMenu mnGpu = new JMenu("GPU");
		menuBar_1.add(mnGpu);
		
		JMenuItem mntmAboutGPU = new JMenuItem("About");
		mnGpu.add(mntmAboutGPU);
		
		JMenuItem mntmHowToInstall_1 = new JMenuItem("How To Install");
		mnGpu.add(mntmHowToInstall_1);
		
		JMenuBar menuBar_PowerSupply = new JMenuBar();
		menuBar_PowerSupply.setBounds(10, 100, 97, 21);
		panel.add(menuBar_PowerSupply);
		
		JMenu mnNewMenu_PowerSupply = new JMenu("Power Supply");
		menuBar_PowerSupply.add(mnNewMenu_PowerSupply);
		
		JMenuItem mntmAbout_PowerSupply = new JMenuItem("About");
		mnNewMenu_PowerSupply.add(mntmAbout_PowerSupply);
		
		JMenuItem mntmHowToInstall_2 = new JMenuItem("How To Install");
		mnNewMenu_PowerSupply.add(mntmHowToInstall_2);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setToolTipText("");
		menuBar_3.setBounds(10, 140, 97, 21);
		panel.add(menuBar_3);
		
		JMenu mnProcessor = new JMenu("Motherboard");
		menuBar_3.add(mnProcessor);
		
		JMenuItem mntmAbout_MotherBoard = new JMenuItem("About");
		mnProcessor.add(mntmAbout_MotherBoard);
		
		JMenuItem mntmHowToInstall_4 = new JMenuItem("How To Install");
		mnProcessor.add(mntmHowToInstall_4);
		
		JMenuBar menuBar_Memory = new JMenuBar();
		menuBar_Memory.setBounds(10, 180, 97, 21);
		panel.add(menuBar_Memory);
		
		JMenu mnMemory = new JMenu("Memory");
		menuBar_Memory.add(mnMemory);
		
		JMenuItem mntmAbout_Memory = new JMenuItem("About");
		mnMemory.add(mntmAbout_Memory);
		
		JMenuItem mntmHowToInstall_3 = new JMenuItem("How To Install");
		mnMemory.add(mntmHowToInstall_3);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(400, 0, 224, 25);
		contentPane.add(menuBar_2);
		
		JMenuItem mntmBuilder = new JMenuItem("Builder");
		menuBar_2.add(mntmBuilder);
		/*mntmBuilder.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	BuildScreen buildwindow = new BuildScreen();
		    	ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/PCLogoNewC.png");
		    	String[] args = null;
		    	buildwindow.main(args);
		    }
		});
		*/
		
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar_2.add(mntmHome);
		mntmHome.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	StartScreen startwindow = new StartScreen();
		    	ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/PCLogoNewC.png");
		    	String[] args = null;
		    	startwindow.main(args);
		    }
		});
		
		
		/* The actions each button in the menus call */
		
		/* mntmAbout_MotherBoard setMotherBoardAbout
		 * mntmAboutGPU setGPUAbout
		 * mntmAbout_PowerSupply setPSUAbout
		 * mntmAbout_Memory setRAMAbout
		 * mntmAbout_Memory setHDDAbout
		 */
		
		mntmAboutCPU.addActionListener(setCPUAbout);
		mntmHowToInstall_1.addActionListener(setCPUInstall);
		mntmAbout_MotherBoard.addActionListener(setMotherboardAbout);
		mntmAboutGPU.addActionListener(setGPUAbout);
		mntmAbout_PowerSupply.addActionListener(setPSUAbout);
		

	}
}