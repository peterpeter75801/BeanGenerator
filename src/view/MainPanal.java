package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import domain.Attribute;
import domain.Bean;
import service.BeanExportService;
import utils.StringUtils;

public class MainPanal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Font unifiedFont;
	private Border unifiedBorder;
	private JLabel beanNameLabel;
	private JTextField beanNameTextField;
	private JLabel packageNameLabel;
	private JTextField packageNameTextField;
	private JLabel attributesLabel;
	private JLabel attrNameLabel;
	private JLabel typeLabel;
	private JLabel descriptionLabel;
	private AttributesPanel attributesPanel;
	private JScrollPane attributesScrollPane;
	private JButton exportButton;
	
	private BeanExportService beanExportService;
	
	public MainPanal() {
		setLayout( null );
		
		setPreferredSize( new Dimension( 792, 566 ) );
		
		unifiedFont = new Font( "細明體", Font.PLAIN, 16 );
		unifiedBorder = new JTextField().getBorder();
		
		beanNameLabel = new JLabel( "Bean name: " );
		beanNameLabel.setFont( unifiedFont );
		beanNameLabel.setBounds( 35, 5, 113, 22 );
		add( beanNameLabel );
		
		beanNameTextField = new JTextField();
		beanNameTextField.setFont( unifiedFont );
		beanNameTextField.setBounds( 148, 5, 209, 22 );
		add( beanNameTextField );
		
		packageNameLabel = new JLabel( "Package name: " );
		packageNameLabel.setFont( unifiedFont );
		packageNameLabel.setBounds( 396, 5, 113, 22 );
		add( packageNameLabel );
		
		packageNameTextField = new JTextField();
		packageNameTextField.setFont( unifiedFont );
		packageNameTextField.setBounds( 509, 5, 233, 22 );
		add( packageNameTextField );
		
		attributesLabel = new JLabel( "Attributes: " );
		attributesLabel.setFont( unifiedFont );
		attributesLabel.setBounds( 35, 71, 97, 22 );
		add( attributesLabel );
		
		attrNameLabel = new JLabel( "Name" );
		attrNameLabel.setFont( unifiedFont );
		attrNameLabel.setBounds( 149, 49, 161, 22 );
		attrNameLabel.setBorder( unifiedBorder );
		add( attrNameLabel );
		
		typeLabel = new JLabel( "Type" );
		typeLabel.setFont( unifiedFont );
		typeLabel.setBounds( 310, 49, 80, 22 );
		typeLabel.setBorder( unifiedBorder );
		add( typeLabel );
		
		descriptionLabel = new JLabel( "Description" );
		descriptionLabel.setFont( unifiedFont );
		descriptionLabel.setBounds( 390, 49, 305, 22 );
		descriptionLabel.setBorder( unifiedBorder );
		add( descriptionLabel );
		
		attributesPanel = new AttributesPanel( this );
		attributesScrollPane = new JScrollPane( 
			attributesPanel, 
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		attributesScrollPane.setBounds( 148, 71, 630, 443 );
		attributesScrollPane.getVerticalScrollBar().setUnitIncrement(22);
		add( attributesScrollPane );
		
		exportButton = new JButton( "Export" );
		exportButton.setFont( unifiedFont );
		exportButton.setMargin( new Insets( 0, 0, 0, 0 ) );
		exportButton.setBounds( 677, 528, 81, 22 );
		exportButton.setMnemonic( KeyEvent.VK_E );
		exportButton.addActionListener( new ExportButtonHandler( this ) );
		exportButton.addKeyListener( new MnemonicKeyHandler() );
		add( exportButton );
		
		beanExportService = new BeanExportService();
	}
	
	public boolean checkIllegalColumn() {
		Color defaultTextFieldsColor = new JTextField().getBackground();
		Color errorTextFieldsColor = new Color( 255, 187, 187 );
		beanNameTextField.setBackground( defaultTextFieldsColor );
		attributesPanel.setTextFieldsColor(defaultTextFieldsColor);
		if( StringUtils.isBlank( beanNameTextField.getText() ) ) {
			beanNameTextField.requestFocus();
			beanNameTextField.setBackground( errorTextFieldsColor );
			JOptionPane.showMessageDialog(
					this, "Bean name cannot be blank!", "Warning",
					JOptionPane.WARNING_MESSAGE );
			return false;
		} else if( !StringUtils.isAsciiPrintable( beanNameTextField.getText() ) ) {
			beanNameTextField.requestFocus();
			beanNameTextField.setBackground( errorTextFieldsColor );
			JOptionPane.showMessageDialog(
					this, "Bean name containing illegal charater!", "Warning",
					JOptionPane.WARNING_MESSAGE );
			return false;
		}
		
		return attributesPanel.checkIllegalColumn();
	}
	
	public JButton getExportButton() {
		return exportButton;
	}
	
	private class ExportButtonHandler implements ActionListener {
		
		private JPanel mainPanel;
		
		public ExportButtonHandler( JPanel mainPanelRef ) {
			mainPanel = mainPanelRef;
		}
		
		@Override
		public void actionPerformed( ActionEvent event ) {
			if( !checkIllegalColumn() ) {
				return;
			}
			
			ArrayList<Attribute> attributes = attributesPanel.getAttributes();
			Bean bean = new Bean();
			bean.setBeanName( beanNameTextField.getText() );
			bean.setPackageName( packageNameTextField.getText() );
			try {
				beanExportService.export( bean, attributes );
				JOptionPane.showMessageDialog(
					mainPanel, "Export Success", "Success",
					JOptionPane.INFORMATION_MESSAGE );
			} catch( IOException e ) {
				JOptionPane.showMessageDialog(
					mainPanel, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE );
			}
		}
	}
	
	private class MnemonicKeyHandler implements KeyListener {
		
		@Override
		public void keyPressed( KeyEvent e ) {
			switch( e.getKeyCode() ) {
			case KeyEvent.VK_A:
				attributesPanel.getAddButton().requestFocus();
				attributesPanel.getAddButton().doClick();
				break;
			case KeyEvent.VK_E:
				exportButton.requestFocus();
				exportButton.doClick();
				break;
			}
		}
		
		@Override
		public void keyReleased( KeyEvent e ) { }
		
		@Override
		public void keyTyped( KeyEvent e ) { }
	}
}
