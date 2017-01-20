package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Attribute;

public class AttributesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private FocusChangeHandler focusChangeHandler;
	
	private int panelWidth;
	private int panelHeight;
	private Font unifiedFont;
	private Border unifiedBorder;
	private JLabel attrNameLabel;
	private JLabel typeLabel;
	private JLabel descriptionLabel;
	private ArrayList<JTextField> attrNameTextFields;
	private ArrayList<JTextField> typeTextFields;
	private ArrayList<JTextField> descriptionTextFields;
	private ArrayList<RemoveButton> removeButtons;
	private JButton addButton;
	private int attrNumber;
	
	public AttributesPanel() {
		focusChangeHandler = new FocusChangeHandler();
		
		panelWidth = 630;
		panelHeight = 66;
		setPreferredSize( new Dimension( panelWidth, panelHeight ) );
		
		setLayout( null );
		
		unifiedFont = new Font( "細明體", Font.PLAIN, 16 );
		unifiedBorder = new JTextField().getBorder();
		
		attrNameLabel = new JLabel( "Name" );
		attrNameLabel.setFont( unifiedFont );
		attrNameLabel.setBounds( 0, 0, 161, 22 );
		attrNameLabel.setBorder( unifiedBorder );
		add( attrNameLabel );
		
		typeLabel = new JLabel( "Type" );
		typeLabel.setFont( unifiedFont );
		typeLabel.setBounds( 161, 0, 80, 22 );
		typeLabel.setBorder( unifiedBorder );
		add( typeLabel );
		
		descriptionLabel = new JLabel( "Description" );
		descriptionLabel.setFont( unifiedFont );
		descriptionLabel.setBounds( 241, 0, 305, 22 );
		descriptionLabel.setBorder( unifiedBorder );
		add( descriptionLabel );
		
		attrNameTextFields = new ArrayList<JTextField>();
		attrNameTextFields.add( new JTextField() );
		attrNameTextFields.get(0).setFont( unifiedFont );
		attrNameTextFields.get(0).setBounds( 0, 22, 161, 22 );
		attrNameTextFields.get(0).addFocusListener( focusChangeHandler );
		add( attrNameTextFields.get(0) );
		
		typeTextFields = new ArrayList<JTextField>();
		typeTextFields.add( new JTextField() );
		typeTextFields.get(0).setFont( unifiedFont );
		typeTextFields.get(0).setBounds( 161, 22, 80, 22 );
		typeTextFields.get(0).addFocusListener( focusChangeHandler );
		add( typeTextFields.get(0) );
		
		descriptionTextFields = new ArrayList<JTextField>();
		descriptionTextFields.add( new JTextField() );
		descriptionTextFields.get(0).setFont( unifiedFont );
		descriptionTextFields.get(0).setBounds( 241, 22, 305, 22 );
		descriptionTextFields.get(0).addFocusListener( focusChangeHandler );
		add( descriptionTextFields.get(0) );
		
		removeButtons = new ArrayList<RemoveButton>();
		removeButtons.add( new RemoveButton( 0 ) );
		removeButtons.get(0).setFont( unifiedFont );
		removeButtons.get(0).setMargin( new Insets( 0, 0, 0, 0 ) );
		removeButtons.get(0).setBounds( 546, 22, 65, 22 );
		removeButtons.get(0).setEnabled( false );
		removeButtons.get(0).addActionListener( new RemoveButtonHandler( this ) );
		removeButtons.get(0).addFocusListener( focusChangeHandler );
		add( removeButtons.get(0) );
		
		addButton = new JButton( "Add" );
		addButton.setFont( unifiedFont );
		addButton.setMargin( new Insets( 0, 0, 0, 0 ) );
		addButton.setBounds( 0, 44, 50, 22 );
		addButton.setMnemonic( 'A' );
		addButton.addActionListener( new AddButtonHandler( this ) );
		addButton.addFocusListener( focusChangeHandler );
		add( addButton );
		
		attrNumber = 1;
	}
	
	public ArrayList<Attribute> getAttributes() {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		for( int i = 0; i < attrNumber; i++ ) {
			Attribute attr = new Attribute();
			attr.setAttrName( attrNameTextFields.get(i).getText() );
			attr.setType( typeTextFields.get(i).getText() );
			attr.setDescription( descriptionTextFields.get(i).getText() );
			attributes.add( attr );
		}
		return attributes;
	}
	
	private class RemoveButton extends JButton {
		
		private static final long serialVersionUID = 1L;
		
		private int index;
		
		public RemoveButton( int index ) {
			super( "Remove" );
			this.index = index;
		}
		
		public void setIndex( int index ) {
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
	}
	
	private class AddButtonHandler implements ActionListener {
		
		private JPanel attributesPanel;
		
		public AddButtonHandler( JPanel attributesPanelRef ) {
			attributesPanel = attributesPanelRef;
		}
		
		public void actionPerformed( ActionEvent event ) {
			
			JTextField newAttrNameTextField;
			JTextField newTypeTextField;
			JTextField newDescriptionTextField;
			RemoveButton newRemoveButton;
			
			newAttrNameTextField = new JTextField();
			newAttrNameTextField.setFont( unifiedFont );
			newAttrNameTextField.setBounds( 0, 22*(attrNumber+1), 161, 22 );
			newAttrNameTextField.addFocusListener( focusChangeHandler );
			attributesPanel.add( newAttrNameTextField );
			
			newTypeTextField = new JTextField();
			newTypeTextField.setFont( unifiedFont );
			newTypeTextField.setBounds( 161, 22*(attrNumber+1), 80, 22 );
			newTypeTextField.addFocusListener( focusChangeHandler );
			attributesPanel.add( newTypeTextField );
			
			newDescriptionTextField = new JTextField();
			newDescriptionTextField.setFont( unifiedFont );
			newDescriptionTextField.setBounds( 241, 22*(attrNumber+1), 305, 22 );
			newDescriptionTextField.addFocusListener( focusChangeHandler );
			attributesPanel.add( newDescriptionTextField );
			
			newRemoveButton = new RemoveButton( attrNumber );
			newRemoveButton.setFont( unifiedFont );
			newRemoveButton.setMargin( new Insets( 0, 0, 0, 0 ) );
			newRemoveButton.setBounds( 546, 22*(attrNumber+1), 65, 22 );
			newRemoveButton.addActionListener( 
				new RemoveButtonHandler( attributesPanel ) );
			newRemoveButton.addFocusListener( focusChangeHandler );
			attributesPanel.add( newRemoveButton );
			
			addButton.setBounds( 0, 22*(attrNumber+2), 50, 22 );
			
			attrNameTextFields.add( newAttrNameTextField );
			typeTextFields.add( newTypeTextField );
			descriptionTextFields.add( newDescriptionTextField );
			removeButtons.add( newRemoveButton );
			
			if( attrNumber == 1 ) {
				removeButtons.get(0).setEnabled( true );
			}
			attrNumber++;
			panelHeight = (attrNumber + 2) * 22;
			setPreferredSize( new Dimension( panelWidth, panelHeight ) );
			scrollRectToVisible( addButton.getBounds() );
			
			repaint();
			revalidate();
		}
	}
	
	private class RemoveButtonHandler implements ActionListener {
		
		private JPanel attributesPanel;
		
		public RemoveButtonHandler( JPanel attributesPanelRef ) {
			attributesPanel = attributesPanelRef;
		}
		
		public void actionPerformed( ActionEvent event ) {
			RemoveButton sourceButton = (RemoveButton)event.getSource();
			int index = sourceButton.getIndex();
			JTextField removingAttrNameTextField = attrNameTextFields.get(index);
			JTextField removingTypeTextField = typeTextFields.get(index);
			JTextField removingDescriptionTextField = descriptionTextFields.get(index);
			
			attributesPanel.remove( removingAttrNameTextField );
			attributesPanel.remove( removingTypeTextField );
			attributesPanel.remove( removingDescriptionTextField );
			attributesPanel.remove( sourceButton );
			attrNameTextFields.remove(index);
			typeTextFields.remove(index);
			descriptionTextFields.remove(index);
			removeButtons.remove(index);
			
			attrNumber--;
			addButton.setBounds( 0, 22*(attrNumber+1), 50, 22 );
			for( int i = index; i < attrNumber; i++ ) {
				attrNameTextFields.get(i).setBounds( 0, 22*(i+1), 161, 22 );
				typeTextFields.get(i).setBounds( 161, 22*(i+1), 80, 22 );
				descriptionTextFields.get(i).setBounds( 241, 22*(i+1), 305, 22 );
				removeButtons.get(i).setBounds( 546, 22*(i+1), 65, 22 );
				removeButtons.get(i).setIndex( i );
			}
			if( attrNumber == 1 ) {
				removeButtons.get(0).setEnabled( false );
			}
			panelHeight = (attrNumber + 2) * 22;
			setPreferredSize( new Dimension( panelWidth, panelHeight ) );
			
			repaint();
			revalidate();
		}
	}
	
	private class FocusChangeHandler implements FocusListener {
		
		public void focusGained( FocusEvent e ) {
			scrollRectToVisible( ((JComponent)e.getSource()).getBounds() );
		}
		
		public void focusLost( FocusEvent e ) {
			
		}
	}
}
