import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/** Characters
 * 
 * Program that stores Characters represented from League of Legends.
 * 
 * @author Cassidy Halvorson
 *		   Due: Sept. 10 2014
 *
 *Source: GroceryList.java 		by Sue Fitzgerald 
 *
 */

public class GUI extends JFrame {

	//input panel
	private JPanel inputPane;		
	private JTextField nameTextField;
	private JTextField titleTextField;
	private JTextField priceTextField;
	private JTextField roleTextField;
	private JTextField dateTextField;
	private JButton enterDataButton;
	private JButton editDataButton;
	
	// output panel
	private JPanel contentPane;  
	private JTable searchTable;			
	private JButton displayButton;	
	private JButton removeButton;
	private JTextField numItemDisplay;
	private JButton searchButton;

	// data collection
	private CharacterList cl;

	
/** UI - manages interaction with user
 * 
 * Collects data when button is pressed and stores data in array
 * Displays all data collected in text area
 * Searches for matching name and displays associated data	
 */
	public GUI() {
		
		cl = new CharacterList();

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 200);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Default font for the user interface
		Font defaultFont = new Font("Arial", Font.PLAIN, 11);
		
		//input Pane
		inputPane = new JPanel();		
		inputPane.setBounds(10, 32, 574, 200);		
		contentPane.add(inputPane);
		inputPane.setLayout(null);
		
		// labels for input fields
		JLabel lblCharacterName = new JLabel("Name");
		lblCharacterName.setFont(defaultFont);
		lblCharacterName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacterName.setBounds(16, 11, 70, 14);
		inputPane.add(lblCharacterName);
		
		JLabel lblCharacterTitle = new JLabel("Title");
		lblCharacterTitle.setFont(defaultFont);
		lblCharacterTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacterTitle.setBounds(16, 36, 70, 14);
		inputPane.add(lblCharacterTitle);
				
		JLabel lblCharacterPrice = new JLabel("Price");
		lblCharacterPrice.setFont(defaultFont);
		lblCharacterPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacterPrice.setBounds(16, 58, 70, 14);
		inputPane.add(lblCharacterPrice);
		
		JLabel lblCharacterRole = new JLabel("Role");
		lblCharacterRole.setFont(defaultFont);
		lblCharacterRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacterRole.setBounds(16, 83, 70, 14);
		inputPane.add(lblCharacterRole);
		
		JLabel lblCharacterDate = new JLabel("Release Date");
		lblCharacterDate.setFont(defaultFont);
		lblCharacterDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacterDate.setBounds(16, 108, 70, 14);
		inputPane.add(lblCharacterDate); 
				
		//input field for name
		nameTextField = new JTextField();
		nameTextField.setFont(defaultFont);
		nameTextField.setBounds(110, 8, 220, 20);
		inputPane.add(nameTextField);
		nameTextField.setColumns(25);
		
		titleTextField = new JTextField();
		titleTextField.setFont(defaultFont);
		titleTextField.setBounds(110, 33, 220, 20);
		inputPane.add(titleTextField);
		titleTextField.setColumns(25);
				
		// input field for price
		priceTextField = new JTextField();
		priceTextField.setFont(defaultFont);
		priceTextField.setBounds(110, 58, 220, 20);
		inputPane.add(priceTextField);
		priceTextField.setColumns(25);
		
		//input field for role
		roleTextField = new JTextField();
		roleTextField.setFont(defaultFont);
		roleTextField.setBounds(110, 83, 220, 20);
		inputPane.add(roleTextField);
		roleTextField.setColumns(25);
		
		//input field for date
		dateTextField = new JTextField();
		dateTextField.setFont(defaultFont);
		dateTextField.setBounds(110, 108, 220, 20);
		inputPane.add(dateTextField);
		dateTextField.setColumns(25); 
		
		// Add Character Button
		enterDataButton = new JButton("Add");
		enterDataButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addCharacterToList();
			}
		});
		enterDataButton.setFont(defaultFont);
		enterDataButton.setBounds(360, 11, 90, 28);
		inputPane.add(enterDataButton);
		
		//Display total number of Items Layout
		JLabel lblNumItems = new JLabel("Total Characters:");
		lblNumItems.setFont(defaultFont);
		lblNumItems.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumItems.setBounds(16, 250, 90, 14);
		contentPane.add( lblNumItems);
		 
		numItemDisplay = new JTextField();
		numItemDisplay.setFont(defaultFont);
		numItemDisplay.setBounds(120, 250, 220, 20);
		numItemDisplay.setEditable(false);	
		contentPane.add(numItemDisplay);
		numItemDisplay.setColumns(25); 
		
		// Search Character	Button
		searchButton = new JButton("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				searchForCharacter();
			}
		});
		searchButton.setFont(defaultFont);
		searchButton.setBounds(475, 50, 90, 28);
		inputPane.add(searchButton); 	
						
		// output Pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 300, 574, 203);
		contentPane.add(scrollPane);
		
		// output table
		searchTable = new JTable();
		searchTable.setFont(defaultFont);
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Set the model of the search results table that defines the layout of the data
		searchTable.setModel(new DefaultTableModel(new String[] {"Name", "Title", "Price", "Role", "Date Released"}, 0) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		searchTable.getTableHeader().setFont(defaultFont);
		
		// display all characters button
		displayButton = new JButton("Display");
		displayButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				displayList();
				numItemDisplay.setText (getNumItems());
			}
		});
		displayButton.setFont(defaultFont);		
		displayButton.setBounds(370, 250, 90, 28); 
		contentPane.add(displayButton);
		scrollPane.setViewportView(searchTable);
		setLocationRelativeTo(null);
		setVisible(true);	
		
		//remove Button
		removeButton = new JButton("Remove");
		removeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				removeCharacterFromList();
			
			}
		});
		removeButton.setFont(defaultFont);
		removeButton.setBounds(475, 11, 90, 28);
		inputPane.add(removeButton);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//edit button
		editDataButton = new JButton("Update");
		editDataButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					updateCharacterToList();		
			}
		});
		editDataButton.setFont(defaultFont);
		editDataButton.setBounds(360, 50, 90, 28);
		inputPane.add(editDataButton);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/** displayList()
	 * 
	 * Gets each element in array and displays on the searchTable
	 * 
	 */

	public void displayList()	{ 
		DefaultTableModel model = (DefaultTableModel)searchTable.getModel();
		for(int i = model.getRowCount() - 1; i >= 0; i--)
			model.removeRow(i);
		
		Character [] list = cl.getList();
		for(int i = 0; i < cl.listSize(); i++)	{
			model.addRow(new Object[] {list[i].getName(), list[i].getTitle(), list[i].getPrice(), 
				list[i].getRole(), list[i].getReleaseDate()});
		}
	}
	
	/** addCharactertoList()
	 * 
	 * Utilizes add method from CharacterList class.
	 * Adds Character from entered text into the Array.
	 * Resets all TextFields once the Character has been added.
	 * 
	 */
	
	public void addCharacterToList ()	{
		try
		{
			cl.add(new Character(nameTextField.getText(), titleTextField.getText(), Integer.parseInt(priceTextField.getText()), roleTextField.getText(), 
				dateTextField.getText()));
			nameTextField.setText("");
			titleTextField.setText("");
			priceTextField.setText("");
			roleTextField.setText("");
			dateTextField.setText("");
		}
		catch (IllegalArgumentException e)
		{	
		}
	}
	
	/** removeCharacterFromList()
	 * 
	 * utilizes removeCharacterFromList method from CharacterList class.
	 * removes Character from Array List
	 * displays updated Array List
	 * 
	 */
	
	public void removeCharacterFromList() {
			cl.removeCharacterFromList(nameTextField.getText());
			displayList();
	}
	
	/** updateCharacterToList()
	 * 
	 * utilizes change method from CharacterList class
	 * Retrieves entered data from text Fields
	 * Clears TextFields before displaying updated list.
	 * 
	 */
	
		
	public void updateCharacterToList()  {
		try
		{
		cl.change(nameTextField.getText(), titleTextField.getText(), Integer.parseInt(priceTextField.getText()), roleTextField.getText(), dateTextField.getText());
		nameTextField.setText("");
		titleTextField.setText("");
		priceTextField.setText("");
		roleTextField.setText("");
		dateTextField.setText("");
		displayList();	
		}
		catch (IllegalArgumentException e)
		{	
		}
	}
	
	/** getNumItems()
	 * 
	 * @return Gets the total number of items in the Array and returns number as a string
	 * 
	 */
	
	public String getNumItems() {		
		return (Integer.toString (cl.listSize()));
	}
	
	/** searchForCharacter()
	 * 
	 * utilizes searchForCharacter method from CharacterList class
	 * Searches for character by name
	 * retrieves and displays the other TextFields of the Character
	 * 
	 */
	
	public void searchForCharacter() {
		try
		{
		Character character = cl.searchForCharacter(nameTextField.getText());
		titleTextField.setText(character.getTitle());
		priceTextField.setText(Integer.toString(character.getPrice()));
		roleTextField.setText(character.getRole());
		dateTextField.setText(character.getReleaseDate());
		}
		catch (NullPointerException e)
		{	
		}
	}
 	
	//Main Method
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.pack();
		frame.setTitle("Characters");
		frame.setSize(610,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
