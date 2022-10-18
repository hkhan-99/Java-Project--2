//Hassan Khan

package guiIntro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

import project1.ShowWeek;
import project1.Shows;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainPanel extends JPanel{
	
	private int count;
	private JButton push;
	private JLabel lblPushes;
	private JTextField showTitle;
	private Shows allData;
	private JTextArea textArea;
	private JScrollPane scrollPane; 
	private ImageIcon image;
	private int x,y;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public MainPanel() {
		allData = new Shows("allData","./project1/netflixAllWeeksGlobalProcessed.txt");
		//System.out.println(allData); //test if read worked, commented out to prevent console overload
		
		image = new ImageIcon (this.getClass().getResource("/film.png"));
		x = 250;
		y = 100;

		setForeground(new Color(255, 255, 0));
		count = 0;
		push = new JButton ("Push Me!");
		push.setForeground(new Color(255, 0, 0));
		push.setBounds(6, 442, 118, 32);
		push.setFont(new Font("Tahoma", Font.BOLD, 15));
		push.setBackground(new Color(0, 0, 0));
		push.addActionListener(new ButtonListener());
		lblPushes = new JLabel ("Pushes: 0");
		lblPushes.setForeground(new Color(255, 255, 255));
		lblPushes.setBounds(41, 484, 105, 23);
		lblPushes.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		setLayout(null);
		
		add (push);
		add(lblPushes); 
		setBackground(new Color(165, 42, 42));
		setPreferredSize(new Dimension(1013, 594));
		
		JButton btnClearCount = new JButton("Clear!");
		btnClearCount.setForeground(new Color(255, 0, 0));
		btnClearCount.setBounds(6, 514, 118, 37);
		btnClearCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClearCount.setBackground(new Color(0, 0, 0));
		btnClearCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				lblPushes.setText ("Pushes: "+count);
			}
		});
		add(btnClearCount);
		
		showTitle = new JTextField("2021-07-04");
		showTitle.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		showTitle.setForeground(new Color(0, 0, 0));
		showTitle.setBounds(121, 57, 165, 32);
		add(showTitle);
		showTitle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Date:");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(123, 29, 163, 29);
		add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(504, 116, 437, 408);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(allData.toString());
		
		JComboBox movies = new JComboBox();
		ArrayList<ShowWeek> moviesInWeek  = allData.getOneWeek("2021-07-04");
		
		String[] data = new String[moviesInWeek.size()];
		int index = 0;
		for(ShowWeek sw : moviesInWeek){
			data[index] = sw.getShowTitle();
			index++;
		}
		movies.setModel(new DefaultComboBoxModel(data));
		movies.setBounds(322, 57, 172, 32);
		add(movies);
		
		JLabel lblNewLabel_1 = new JLabel("Week's shows: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(322, 27, 191, 32);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Search in Week");
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ShowWeek> moviesInWeek  = allData.getOneWeek(showTitle.getText());
				if(moviesInWeek != null && moviesInWeek.size()> 0) {
				String[] data = new String[moviesInWeek.size()];
				int index = 0;
				for(ShowWeek sw : moviesInWeek){
					data[index] = sw.getShowTitle();
					index++;
				}
				movies.setModel(new DefaultComboBoxModel(data));
			}
		}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(121, 99, 147, 32);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("NotFlix!");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_2.setBounds(682, 10, 193, 51);
		add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Perform Edit");
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(rdbtnNewRadioButton.isSelected())
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(6, 193, 140, 33);
		add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Fiction");
		chckbxNewCheckBox_1.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox_1.setForeground(new Color(255, 0, 0));
		chckbxNewCheckBox_1.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxNewCheckBox_1.setBounds(121, 160, 106, 21);
		add(chckbxNewCheckBox_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainPanel.class.getResource("/guiIntro/film-bind.gif")));
		lblNewLabel_3.setBounds(885, 0, 128, 116);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Select Video Quality");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(6, 231, 147, 47);
		add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("1080p");
		rdbtnNewRadioButton_1_1.setForeground(Color.RED);
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1_1.setBackground(Color.BLACK);
		rdbtnNewRadioButton_1_1.setBounds(6, 275, 103, 21);
		add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_3_1 = new JRadioButton("720p");
		rdbtnNewRadioButton_3_1.setForeground(Color.RED);
		rdbtnNewRadioButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_3_1.setBackground(Color.BLACK);
		rdbtnNewRadioButton_3_1.setBounds(124, 275, 103, 21);
		add(rdbtnNewRadioButton_3_1);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("360p");
		rdbtnNewRadioButton_2_1.setForeground(Color.RED);
		rdbtnNewRadioButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_2_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2_1.setBounds(242, 275, 126, 21);
		add(rdbtnNewRadioButton_2_1);
		
		JLabel lblNewLabel_5 = new JLabel("Type");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(6, 141, 140, 19);
		add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Purged");
		chckbxNewCheckBox_1_1.setForeground(new Color(255, 0, 0));
		chckbxNewCheckBox_1_1.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxNewCheckBox_1_1.setBounds(6, 160, 105, 21);
		add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Non-fiction");
		chckbxNewCheckBox_1_2.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_1_2.setForeground(new Color(255, 0, 0));
		chckbxNewCheckBox_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxNewCheckBox_1_2.setBounds(242, 160, 105, 21);
		add(chckbxNewCheckBox_1_2);
		
		JLabel lblNewLabel_6 = new JLabel("Can't decide what to watch!? ");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_6.setBounds(6, 387, 309, 33);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fidget while you think of something.");
		lblNewLabel_7.setForeground(new Color(255, 255, 0));
		lblNewLabel_7.setBackground(new Color(255, 255, 0));
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_7.setBounds(97, 417, 378, 23);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("^^^A peek into our data-backend.");
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_8.setBounds(597, 531, 331, 32);
		add(lblNewLabel_8);
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		image.paintIcon(this,  page, x, y);
	}
	
	public void doClose() {
		allData.doWrite("./textwrite.csv");
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event){
			count++;
			lblPushes.setText ("Pushes: "+count);
		}
	}
}
