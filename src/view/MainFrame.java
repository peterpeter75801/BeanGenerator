package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final static String FRAME_TITLE = "Bean Generator";
	
	private MainPanal mainPanel;
	
	public MainFrame() {
		super( FRAME_TITLE );
		
		mainPanel = new MainPanal();
		add( mainPanel );
		
		//pack();
		setSize( 800, 600 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
