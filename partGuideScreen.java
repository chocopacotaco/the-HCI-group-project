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
	JTextPane textPane;
	JLabel lblTitleBox;
	JTextArea txtrTextStuffHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(args[0]=="cpu") {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.setIconImage(img.getImage());
						frame.loadCpu();
						frame.setVisible(true);
					} else if(args[0]=="gpu") {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.loadGpu();
						frame.setIconImage(img.getImage());
						frame.setVisible(true);
					}else if(args[0]=="board") {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.loadBoard();
						frame.setIconImage(img.getImage());
						frame.setVisible(true);
					}else if(args[0]=="memory") {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.loadMemory();
						frame.setIconImage(img.getImage());
						frame.setVisible(true);
					}else if(args[0]=="hhd") {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.loadHHD();
						frame.setIconImage(img.getImage());
						frame.setVisible(true);
					}else if(args[0]=="power") {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.loadPower();
						frame.setIconImage(img.getImage());
						frame.setVisible(true);
					} else {
						partGuideScreen frame = new partGuideScreen();
						ImageIcon img = new ImageIcon("PCLogoNewC.png");
						frame.setIconImage(img.getImage());
						frame.setVisible(true);
					}
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
		
    	ImageIcon imageIcon = new ImageIcon(getClass().getResource("cpu.jpg")); // load the image to a imageIcon
    	Image image = imageIcon.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	//imageIcon = new ImageIcon(newimg);  // transform it back
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
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
		
		lblTitleBox = new JLabel(" ");
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
		panel_1.setBounds(198, 73, 480, 550);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtrTextStuffHere = new JTextArea();
		txtrTextStuffHere.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrTextStuffHere.setBounds(10, 125, 390, 414);
		txtrTextStuffHere.setLineWrap(true);
		txtrTextStuffHere.setWrapStyleWord(true);
		panel_1.add(txtrTextStuffHere);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 11, 390, 128);
		panel_1.add(textPane);
		

		/* Action Listeners to use the buttons in the menu to set the Text in the main text area */
		
		ActionListener setCPUAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIconcpu = new ImageIcon(getClass().getResource("cpu.jpg")); // load the image to a imageIcon
	        	Image image = imageIconcpu.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIconcpu = new ImageIcon(newimg);  // transform it back
	        	//imageIconcpu.
	        	
	        	textPane.insertIcon(imageIconcpu);
	        	lblTitleBox.setText("CPU");
	        	txtrTextStuffHere.setText("\n\nThe Central Processing Unit that is located on the motherboard."
	        			+ "Often referred to as the computer’s brain." 
	        			+ "The CPU’s main job is to carry out commands."
	        			+ "Every key pressed, mouse clicked, and application launched are instructions sent to the CPU.\n" 
	        			+ "\nThe CPU is usually a two-inch ceramic square with a silicon chip the size of a thumbnail."
	        			+ "The CPU is stored into the motherboard’s CPU socket, which is covered by a heat sink that regulates heat from the CPU.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
		ActionListener setGPUAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	//textPane.remove(textPane.get)
	        	txtrTextStuffHere.removeAll();
	        	ImageIcon imageIcongpu = new ImageIcon(getClass().getResource("gpu.png")); // load the image to a imageIcon
	        	Image image = imageIcongpu.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcongpu = new ImageIcon(newimg);  // transform it back

	        	//textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("GPU");
	        	txtrTextStuffHere.setText("\n\nThe Graphics Processing Unit, or video card, is responsible for what you see when you turn a computer on with a monitor."
	        			+ "Some GPUs are built into the motherboard but can be purchased as an external device for the motherboards expansion slot. "
	        			+ "Video games with high end graphics often require powerful GPU for better performance.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
		ActionListener setMotherboardAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon(getClass().getResource("motherboard.png")); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("Motherboard");
	        	txtrTextStuffHere.setText("\n\nThe motherboard is a thin plate that holds the computer’s CPU, memory, hard drive connectors, video card slots, and USB ports. "
	        			+ "As the main circuit board, the motherboard is both directly and indirectly responsible the computer’s every function.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
		ActionListener setPSUAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("psu.png"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back

	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("Power Supply");
	        	txtrTextStuffHere.setText("\n\nThe power supply is the computer’s battery that supplies the power that it needs to operate."
	        			+ "You plug it into a wall outlet to power the computer. "
	        			+ "It sends power through cables to the motherboard and its other components."
	        			+ "\n\nMost modern desktop personal computer power supplies conform to the ATX specification, "
	        			+ "which includes form factor and voltage tolerances. "
	        			+ "While an ATX power supply is connected to the mains supply, it always "
	        			+ "provides a 5 Volt standby (5VSB) voltage so that the standby functions on the computer and certain peripherals are powered. "
	        			+ "ATX power supplies are turned on and off by a signal from the motherboard");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
		ActionListener setRAMAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("ram.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("RAM");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the System Random Access Memory.\n"
	        			+ "RAM (Random Access Memory) is the hardware in a computing device where the operating system (OS), application programs and data in current use are kept so they can be quickly reached by the device's processor. "
	        			+ "RAM is the main memory in a computer, and it is much faster to read from and write to than other kinds of storage, such as a hard disk drive (HDD), solid-state drive (SSD) or optical drive."
	        			+ "\n\nThe Random Access Memory is the computer’s short-term memory. "
	        			+ "Whenever a computer is turned on, it temporarily stores the data in the RAM until it is needed and it erased when it is turned off. "
	        			+ "Since the memory is temporary, remember to save your files to a long term storage device, such as a hard drive, to avoid losing it. "
	        			+ "The more RAM you have, the more applications the computer can handle.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
		ActionListener setHDDAbout = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("hdd.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("HDD");
	        	txtrTextStuffHere.setText("\n\n"
	        			+ "A hard disk drive (HDD), hard disk, hard drive, or fixed disk is an electro-mechanical data storage device that uses magnetic storage to store and retrieve digital information using one or more rigid rapidly rotating disks (platters) coated with magnetic material. "
	        			+ "The platters are paired with magnetic heads, usually arranged on a moving actuator arm, which read and write data to the platter surfaces. "
	        			+ "Data is accessed in a random-access manner, meaning that individual blocks of data can be stored or retrieved in any order and not only sequentially. "
	        			+ "HDDs are a type of non-volatile storage, meaning it retains stored data even when powered off.\n");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
	    ActionListener setHHDInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("hdd.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("HDD");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the System Memory Hard Drive.\n"
	        			+ "First make sure to back up any data that you want to save and install on your new hard drive."
	        			+ "\nUnplug its data and power cables, and remove it from the case. "
	        			+ "\nit might slide out but it other cases you will have to unscrew it."
	        			+ "\nRemove the rails from the drive you took out and install them on the new drive(if needed for new drive)"
	        			+ "\nSlide the new drive partway into where the last drive was."
	        			+ "\nHook up the data and power cables"
	        			+ "\nFinish sliding the hard drive into place, if needed screwing it in");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
		ActionListener setCPUInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("cpu.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("CPU");
	        	txtrTextStuffHere.setText("\n\nIf you have a new CPU, inspect the pins on the underside and make sure the pins are not bent. "
	        			+ "Some CPUs may not have pins because they are on the motherboard. "
	        			+ "Locate the CPU socket and open the leaver. "
	        			+ "Insert the CPU into the processor and close the leaver.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
	    
		ActionListener setRAMInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("ram.jpg"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("Memory");
	        	txtrTextStuffHere.setText("\n\nYou normally find RAM slots in the CPU socket. "
	        			+ "\nSome motherboards have two or more slots and arrange them in different ways so make sure to check your motherboard’s manual. "
	        			+ "\nOnce you’ve identified theslots you open their clasps and Insert the RAM sticks into their slots until they click into place.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
	    
	    ActionListener setGPUInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("gpu.png"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("GPU");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the GPU.\n"
	        			+ "\nBefore installing a new video card make sure the PC is turned off. "
	        			+ "\nMost GPUs connect to themotherboard’s expansion slots. "
	        			+ "\nInsert the new GPU into the PCI-e slot and make sure it is secured by clicking the card into place and screwing the rear bracket down. "
	        			+ "\nConnect the GPU to the power supplyand turn on the PC."
	        			+ "\nFinal step it to install the required driver and you’re finished.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
	    
	    ActionListener setBoardInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("motherboard.png"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("Motherboard");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the Motherboard."
	        			+ "\nSome motherboards come with a thin metal back plate that goes in front of the motherboard and keepsthings organized. "
	        			+ "\nMeasure you PC case and check the pre-drilled holes on the back and where yourmotherboard fits. "
	        			+ "\nLine up the motherboard and screw it in.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
	        }
	    };
	    
	    ActionListener setPowerInstall = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	textPane.removeAll();
	        	textPane.removeAll();
	        	ImageIcon imageIcon = new ImageIcon("psu.png"); // load the image to a imageIcon
	        	Image image = imageIcon.getImage(); // transform it 
	        	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	        	imageIcon = new ImageIcon(newimg);  // transform it back
	        	
	        	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
	        	//img.
	        	textPane.insertIcon(imageIcon);
	        	lblTitleBox.setText("PSU");
	        	txtrTextStuffHere.setText("\n\nHere is stuff About the Power supply."
	        			+"\nThe power supply is typically the easiest component to install. "
	        			+ "Most PC cases have a designated area positioned at the bottom of the case. "
	        			+ "\n\nRemove the case’s back plates and place the power supply in its designated area and use a screwdriver and the necessary screws to secure it in place. "
	        			+ "\nPlug theconnectors to the motherboard and plug the power supply to the wall outlet and turn it on.");
	        	txtrTextStuffHere.setLineWrap(true);
	        	txtrTextStuffHere.setWrapStyleWord(true);
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
		
		//
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
		//
		JMenuBar menuBar_Hdd = new JMenuBar();
		menuBar_Hdd.setBounds(10, 220, 97, 21);
		panel.add(menuBar_Hdd);
		
		JMenu mnHDD = new JMenu("Hard Drive");
		menuBar_Hdd.add(mnHDD);
		
		JMenuItem mntmAbout_HDD = new JMenuItem("About");
		mnHDD.add(mntmAbout_HDD);
		
		JMenuItem mntmHowToInstall_HDD = new JMenuItem("How To Install");
		mnHDD.add(mntmHowToInstall_HDD);
		
		
		
		JMenuItem mntmBuilder = new JMenuItem("Builder");
		menuBar_2.add(mntmBuilder);
		mntmBuilder.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	MainScreenTest mainwindow = new MainScreenTest();
		    	ImageIcon img = new ImageIcon("PCLogoNewC.png");
		    	String[] args = null;
		    	mainwindow.main(args);
		    	dispose();
		    	
		    }
		});
		
		
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar_2.add(mntmHome);
		mntmHome.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	StartScreen startwindow = new StartScreen();
		    	ImageIcon img = new ImageIcon("PCLogoNewC.png");
		    	String[] args = null;
		    	startwindow.main(args);
		    	dispose();
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
		mntmHowToInstall.addActionListener(setCPUInstall);
		
		mntmAbout_MotherBoard.addActionListener(setMotherboardAbout);
		mntmHowToInstall_4.addActionListener(setBoardInstall);
		
		mntmAboutGPU.addActionListener(setGPUAbout);
		mntmHowToInstall_1.addActionListener(setGPUInstall);
		
		mntmAbout_PowerSupply.addActionListener(setPSUAbout);
		mntmHowToInstall_2.addActionListener(setPowerInstall);
		
		mntmAbout_Memory.addActionListener(setRAMAbout);
		mntmHowToInstall_3.addActionListener(setRAMInstall);
		
		mntmAbout_HDD.addActionListener(setHDDAbout);
		mntmHowToInstall_HDD.addActionListener(setHHDInstall);

	}
	
	void loadGpu(){
		textPane.removeAll();
    	textPane.removeAll();
    	//textPane.remove(textPane.get)
    	txtrTextStuffHere.removeAll();
    	ImageIcon imageIcongpu = new ImageIcon(getClass().getResource("gpu.png")); // load the image to a imageIcon
    	Image image = imageIcongpu.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	imageIcongpu = new ImageIcon(newimg);  // transform it back

    	//textPane.insertIcon(imageIcon);
    	lblTitleBox.setText("GPU");
    	txtrTextStuffHere.setText("\n\nThe Graphics Processing Unit, or video card, is responsible for what you see when you turn a computer on with a monitor."
    			+ "Some GPUs are built into the motherboard but can be purchased as an external device for the motherboards expansion slot. "
    			+ "Video games with high end graphics often require powerful GPU for better performance.");
    	txtrTextStuffHere.setLineWrap(true);
    	txtrTextStuffHere.setWrapStyleWord(true);
	}
	
	void loadCpu(){
		textPane.removeAll();
    	textPane.removeAll();
    	ImageIcon imageIconcpu = new ImageIcon(getClass().getResource("cpu.jpg")); // load the image to a imageIcon
    	Image image = imageIconcpu.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	imageIconcpu = new ImageIcon(newimg);  // transform it back
    	//imageIconcpu.
    	
    	textPane.insertIcon(imageIconcpu);
    	lblTitleBox.setText("CPU");
    	txtrTextStuffHere.setText("\n\nThe Central Processing Unit that is located on the motherboard."
    			+ "Often referred to as the computer’s brain." 
    			+ "The CPU’s main job is to carry out commands."
    			+ "Every key pressed, mouse clicked, and application launched are instructions sent to the CPU.\n" 
    			+ "\nThe CPU is usually a two-inch ceramic square with a silicon chip the size of a thumbnail."
    			+ "The CPU is stored into the motherboard’s CPU socket, which is covered by a heat sink that regulates heat from the CPU.");
    	txtrTextStuffHere.setLineWrap(true);
    	txtrTextStuffHere.setWrapStyleWord(true);
	}
	
	void loadBoard(){
		textPane.removeAll();
    	textPane.removeAll();
    	ImageIcon imageIcon = new ImageIcon(getClass().getResource("motherboard.png")); // load the image to a imageIcon
    	Image image = imageIcon.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);  // transform it back
    	
    	textPane.insertIcon(imageIcon);
    	lblTitleBox.setText("Motherboard");
    	txtrTextStuffHere.setText("\n\nTThe motherboard is a thin plate that holds the computer’s CPU, memory, hard drive connectors, video card slots, and USB ports. "
    			+ "As the main circuit board, the motherboard is both directly and indirectly responsible the computer’s every function.");
    	txtrTextStuffHere.setLineWrap(true);
    	txtrTextStuffHere.setWrapStyleWord(true);
	}
	
	void loadMemory(){
		textPane.removeAll();
    	textPane.removeAll();
    	ImageIcon imageIcon = new ImageIcon("ram.jpg"); // load the image to a imageIcon
    	Image image = imageIcon.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);  // transform it back
    	
    	textPane.insertIcon(imageIcon);
    	lblTitleBox.setText("RAM");
    	txtrTextStuffHere.setText("\n\nHere is stuff About the System Random Access Memory.\n"
    			+ "RAM (Random Access Memory) is the hardware in a computing device where the operating system (OS), application programs and data in current use are kept so they can be quickly reached by the device's processor. "
    			+ "RAM is the main memory in a computer, and it is much faster to read from and write to than other kinds of storage, such as a hard disk drive (HDD), solid-state drive (SSD) or optical drive."
    			+ "\n\nThe Random Access Memory is the computer’s short-term memory. "
    			+ "Whenever a computer is turned on, it temporarily stores the data in the RAM until it is needed and it erased when it is turned off. "
    			+ "Since the memory is temporary, remember to save your files to a long term storage device, such as a hard drive, to avoid losing it. "
    			+ "The more RAM you have, the more applications the computer can handle.");
    	txtrTextStuffHere.setLineWrap(true);
    	txtrTextStuffHere.setWrapStyleWord(true);
	}
	
	void loadHHD(){
		textPane.removeAll();
    	textPane.removeAll();
    	ImageIcon imageIcon = new ImageIcon("hdd.jpg"); // load the image to a imageIcon
    	Image image = imageIcon.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);  // transform it back
    	
    	//ImageIcon img = new ImageIcon("C:/Users/dn01284.AD/Pictures/cpu.jpg");
    	//img.
    	textPane.insertIcon(imageIcon);
    	lblTitleBox.setText("HDD");
    	txtrTextStuffHere.setText("\n\n"
    			+ "A hard disk drive (HDD), hard disk, hard drive, or fixed disk is an electro-mechanical data storage device that uses magnetic storage to store and retrieve digital information using one or more rigid rapidly rotating disks (platters) coated with magnetic material. "
    			+ "The platters are paired with magnetic heads, usually arranged on a moving actuator arm, which read and write data to the platter surfaces. "
    			+ "Data is accessed in a random-access manner, meaning that individual blocks of data can be stored or retrieved in any order and not only sequentially. "
    			+ "HDDs are a type of non-volatile storage, meaning it retains stored data even when powered off.\n");
    	txtrTextStuffHere.setLineWrap(true);
    	txtrTextStuffHere.setWrapStyleWord(true);
	}
	
	void loadPower(){
		textPane.removeAll();
    	textPane.removeAll();
    	ImageIcon imageIcon = new ImageIcon("psu.png"); // load the image to a imageIcon
    	Image image = imageIcon.getImage(); // transform it 
    	Image newimg = image.getScaledInstance(180, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	imageIcon = new ImageIcon(newimg);  // transform it back

    	textPane.insertIcon(imageIcon);
    	lblTitleBox.setText("Power Supply");
    	txtrTextStuffHere.setText("\n\nThe power supply is the computer’s battery that supplies the power that it needs to operate."
    			+ "You plug it into a wall outlet to power the computer. "
    			+ "It sends power through cables to the motherboard and its other components."
    			+ "\n\nMost modern desktop personal computer power supplies conform to the ATX specification, "
    			+ "which includes form factor and voltage tolerances. "
    			+ "While an ATX power supply is connected to the mains supply, it always "
    			+ "provides a 5 Volt standby (5VSB) voltage so that the standby functions on the computer and certain peripherals are powered. "
    			+ "ATX power supplies are turned on and off by a signal from the motherboard");
    	txtrTextStuffHere.setLineWrap(true);
    	txtrTextStuffHere.setWrapStyleWord(true);
	}
	
}