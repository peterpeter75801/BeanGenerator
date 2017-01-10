package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import domain.Attribute;
import domain.Bean;
import service.BeanExportService;

public class MainPanal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Font unifiedFont;
	private JLabel packageNameLabel;
	private JTextField packageNameTextField;
	private JLabel beanNameLabel;
	private JTextField beanNameTextField;
	private JLabel attributesLabel;
	private AttributesPanel attributesPanel;
	private JScrollPane attributesScrollPane;
	private JButton exportButton;
	
	private BeanExportService beanExportService;
	
	public MainPanal() {
		setLayout( null );
		
		setPreferredSize( new Dimension( 792, 566 ) );
		
		unifiedFont = new Font( "細明體", Font.PLAIN, 16 );
		
		packageNameLabel = new JLabel( "Package name: " );
		packageNameLabel.setFont( unifiedFont );
		packageNameLabel.setBounds( 35, 5, 113, 22 );
		add( packageNameLabel );
		
		packageNameTextField = new JTextField();
		packageNameTextField.setFont( unifiedFont );
		packageNameTextField.setBounds( 148, 5, 209, 22 );
		add( packageNameTextField );
		
		beanNameLabel = new JLabel( "Bean name: " );
		beanNameLabel.setFont( unifiedFont );
		beanNameLabel.setBounds( 396, 5, 89, 22 );
		add( beanNameLabel );
		
		beanNameTextField = new JTextField();
		beanNameTextField.setFont( unifiedFont );
		beanNameTextField.setBounds( 485, 5, 233, 22 );
		add( beanNameTextField );
		
		attributesLabel = new JLabel( "Attributes: " );
		attributesLabel.setFont( unifiedFont );
		attributesLabel.setBounds( 35, 71, 97, 22 );
		add( attributesLabel );
		
		attributesPanel = new AttributesPanel();
		attributesScrollPane = new JScrollPane( 
			attributesPanel, 
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		attributesScrollPane.setBounds( 148, 49, 630, 465 );
		add( attributesScrollPane );
		
		exportButton = new JButton( "Export" );
		exportButton.setFont( unifiedFont );
		exportButton.setMargin( new Insets( 0, 0, 0, 0 ) );
		exportButton.setBounds( 677, 528, 81, 22 );
		exportButton.addActionListener( new ExportButtonHandler( this ) );
		add( exportButton );
		
		beanExportService = new BeanExportService();
	}
	
	private class ExportButtonHandler implements ActionListener {
		
		private JPanel mainPanel;
		
		public ExportButtonHandler( JPanel mainPanelRef ) {
			mainPanel = mainPanelRef;
		}
		
		public void actionPerformed( ActionEvent event ) {
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
}
