package test.integrating;

import view.MainFrame;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import junit.framework.TestCase;

public class IntegratingTests extends TestCase {
    
    public void testNormal1() {
        ArrayList<String> actualExportedContents = new ArrayList<String>();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible( true );
        try {
            File f = new File( "Attribute.java" );
            if( f.exists() && !f.isDirectory() ) {
                f.renameTo( new File( "Attribute_backup.java" ) );
            }
            
            Robot bot =  new Robot();
            Thread.sleep( 3000 );
            inputString( bot, "Attribute" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "domain" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "attrName" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "Attribute name" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 1000 );
            inputString( bot, "type" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "Type of this attribute" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 1000 );
            inputString( bot, "description" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "Attribute description" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_E ); bot.keyRelease( KeyEvent.VK_E );
            Thread.sleep( 3000 );

            BufferedReader bufReader = 
                new BufferedReader(new FileReader( "Attribute.java" ));
            String stringBuf;
            for( int i = 0; i < 33; i++ ) {
                stringBuf = bufReader.readLine();
                actualExportedContents.add( (stringBuf != null) ? stringBuf : "" );
            }
            assertNull( bufReader.readLine() );
            bufReader.close();
            
            assertEquals( "package domain;", actualExportedContents.get(0) );
            assertEquals( "", actualExportedContents.get(1) );
            assertEquals( "public class Attribute {", actualExportedContents.get(2) );
            assertEquals( "", actualExportedContents.get(3) );
            assertEquals( "    private String attrName;  // Attribute name", actualExportedContents.get(4) );
            assertEquals( "    private String type;  // Type of this attribute", actualExportedContents.get(5) );
            assertEquals( "    private String description;  // Attribute description", actualExportedContents.get(6) );
            assertEquals( "", actualExportedContents.get(7) );
            assertEquals( "    public void setAttrName( String attrName ) {", actualExportedContents.get(8) );
            assertEquals( "        this.attrName = attrName;", actualExportedContents.get(9) );
            assertEquals( "    }", actualExportedContents.get(10) );
            assertEquals( "", actualExportedContents.get(11) );
            assertEquals( "    public String getAttrName() {", actualExportedContents.get(12) );
            assertEquals( "        return attrName;", actualExportedContents.get(13) );
            assertEquals( "    }", actualExportedContents.get(14) );
            assertEquals( "", actualExportedContents.get(15) );
            assertEquals( "    public void setType( String type ) {", actualExportedContents.get(16) );
            assertEquals( "        this.type = type;", actualExportedContents.get(17) );
            assertEquals( "    }", actualExportedContents.get(18) );
            assertEquals( "", actualExportedContents.get(19) );
            assertEquals( "    public String getType() {", actualExportedContents.get(20) );
            assertEquals( "        return type;", actualExportedContents.get(21) );
            assertEquals( "    }", actualExportedContents.get(22) );
            assertEquals( "", actualExportedContents.get(23) );
            assertEquals( "    public void setDescription( String description ) {", actualExportedContents.get(24) );
            assertEquals( "        this.description = description;", actualExportedContents.get(25) );
            assertEquals( "    }", actualExportedContents.get(26) );
            assertEquals( "", actualExportedContents.get(27) );
            assertEquals( "    public String getDescription() {", actualExportedContents.get(28) );
            assertEquals( "        return description;", actualExportedContents.get(29) );
            assertEquals( "    }", actualExportedContents.get(30) );
            assertEquals( "}", actualExportedContents.get(31) );
            assertEquals( "", actualExportedContents.get(32) );
            
            f = new File( "Attribute.java" );
            f.delete();
            f = new File( "Attribute_backup.java" );
            if( f.exists() && !f.isDirectory() ) {
                f.renameTo( new File( "Attribute.java" ) );
            }
            
            mainFrame.setVisible( false );
            Thread.sleep( 3000 );
        } catch( Exception e ) {
            assertTrue( e.getMessage(), false );
        }
    }
    
    public void testNormal2() {
        ArrayList<String> actualExportedContents = new ArrayList<String>();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible( true );
        try {
            File f = new File( "Attribute.java" );
            if( f.exists() && !f.isDirectory() ) {
                f.renameTo( new File( "Attribute_backup.java" ) );
            }
            
            Robot bot =  new Robot();
            Thread.sleep( 3000 );
            inputString( bot, "Attribute" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "attrName" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 1000 );
            inputString( bot, "type" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 1000 );
            inputString( bot, "description" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_E ); bot.keyRelease( KeyEvent.VK_E );
            Thread.sleep( 3000 );

            BufferedReader bufReader = 
                new BufferedReader(new FileReader( "Attribute.java" ));
            String stringBuf;
            for( int i = 0; i < 31; i++ ) {
                stringBuf = bufReader.readLine();
                actualExportedContents.add( (stringBuf != null) ? stringBuf : "" );
            }
            assertNull( bufReader.readLine() );
            bufReader.close();
            
            assertEquals( "public class Attribute {", actualExportedContents.get(0) );
            assertEquals( "", actualExportedContents.get(1) );
            assertEquals( "    private String attrName;", actualExportedContents.get(2) );
            assertEquals( "    private String type;", actualExportedContents.get(3) );
            assertEquals( "    private String description;", actualExportedContents.get(4) );
            assertEquals( "", actualExportedContents.get(5) );
            assertEquals( "    public void setAttrName( String attrName ) {", actualExportedContents.get(6) );
            assertEquals( "        this.attrName = attrName;", actualExportedContents.get(7) );
            assertEquals( "    }", actualExportedContents.get(8) );
            assertEquals( "", actualExportedContents.get(9) );
            assertEquals( "    public String getAttrName() {", actualExportedContents.get(10) );
            assertEquals( "        return attrName;", actualExportedContents.get(11) );
            assertEquals( "    }", actualExportedContents.get(12) );
            assertEquals( "", actualExportedContents.get(13) );
            assertEquals( "    public void setType( String type ) {", actualExportedContents.get(14) );
            assertEquals( "        this.type = type;", actualExportedContents.get(15) );
            assertEquals( "    }", actualExportedContents.get(16) );
            assertEquals( "", actualExportedContents.get(17) );
            assertEquals( "    public String getType() {", actualExportedContents.get(18) );
            assertEquals( "        return type;", actualExportedContents.get(19) );
            assertEquals( "    }", actualExportedContents.get(20) );
            assertEquals( "", actualExportedContents.get(21) );
            assertEquals( "    public void setDescription( String description ) {", actualExportedContents.get(22) );
            assertEquals( "        this.description = description;", actualExportedContents.get(23) );
            assertEquals( "    }", actualExportedContents.get(24) );
            assertEquals( "", actualExportedContents.get(25) );
            assertEquals( "    public String getDescription() {", actualExportedContents.get(26) );
            assertEquals( "        return description;", actualExportedContents.get(27) );
            assertEquals( "    }", actualExportedContents.get(28) );
            assertEquals( "}", actualExportedContents.get(29) );
            assertEquals( "", actualExportedContents.get(30) );
            
            f = new File( "Attribute.java" );
            f.delete();
            f = new File( "Attribute_backup.java" );
            if( f.exists() && !f.isDirectory() ) {
                f.renameTo( new File( "Attribute.java" ) );
            }
            
            mainFrame.setVisible( false );
            Thread.sleep( 3000 );
        } catch( Exception e ) {
            assertTrue( e.getMessage(), false );
        }
    }
    
    public void testTypeCorrection() {
        ArrayList<String> actualExportedContents = new ArrayList<String>();
        Color errorTextFieldsColor = new Color( 255, 187, 187 );
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible( true );
        try {
            File f = new File( "Attribute.java" );
            if( f.exists() && !f.isDirectory() ) {
                f.renameTo( new File( "Attribute_backup.java" ) );
            }
            
            Robot bot =  new Robot();
            Thread.sleep( 3000 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "attrName" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 1000 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 1000 );
            inputString( bot, "description" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            inputString( bot, "String" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 ); 
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_E ); bot.keyRelease( KeyEvent.VK_E );
            Thread.sleep( 1000 );
            
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 500 );
            assertEquals( errorTextFieldsColor, mainFrame.getFocusOwner().getBackground() );
            inputString( bot, "Attribute" );
            bot.keyPress( KeyEvent.VK_SHIFT );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyRelease( KeyEvent.VK_SHIFT );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_E ); bot.keyRelease( KeyEvent.VK_E );
            Thread.sleep( 1000 );
            
            bot.keyPress( KeyEvent.VK_SPACE ); bot.keyRelease( KeyEvent.VK_SPACE );
            Thread.sleep( 500 );
            assertEquals( errorTextFieldsColor, mainFrame.getFocusOwner().getBackground() );
            inputString( bot, "type" );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB ); Thread.sleep( 100 );
            bot.keyPress( KeyEvent.VK_TAB ); bot.keyRelease( KeyEvent.VK_TAB );
            Thread.sleep( 500 );
            bot.keyPress( KeyEvent.VK_E ); bot.keyRelease( KeyEvent.VK_E );
            Thread.sleep( 3000 );

            BufferedReader bufReader = 
                new BufferedReader(new FileReader( "Attribute.java" ));
            String stringBuf;
            for( int i = 0; i < 31; i++ ) {
                stringBuf = bufReader.readLine();
                actualExportedContents.add( (stringBuf != null) ? stringBuf : "" );
            }
            assertNull( bufReader.readLine() );
            bufReader.close();
            
            assertEquals( "public class Attribute {", actualExportedContents.get(0) );
            assertEquals( "", actualExportedContents.get(1) );
            assertEquals( "    private String attrName;", actualExportedContents.get(2) );
            assertEquals( "    private String type;", actualExportedContents.get(3) );
            assertEquals( "    private String description;", actualExportedContents.get(4) );
            assertEquals( "", actualExportedContents.get(5) );
            assertEquals( "    public void setAttrName( String attrName ) {", actualExportedContents.get(6) );
            assertEquals( "        this.attrName = attrName;", actualExportedContents.get(7) );
            assertEquals( "    }", actualExportedContents.get(8) );
            assertEquals( "", actualExportedContents.get(9) );
            assertEquals( "    public String getAttrName() {", actualExportedContents.get(10) );
            assertEquals( "        return attrName;", actualExportedContents.get(11) );
            assertEquals( "    }", actualExportedContents.get(12) );
            assertEquals( "", actualExportedContents.get(13) );
            assertEquals( "    public void setType( String type ) {", actualExportedContents.get(14) );
            assertEquals( "        this.type = type;", actualExportedContents.get(15) );
            assertEquals( "    }", actualExportedContents.get(16) );
            assertEquals( "", actualExportedContents.get(17) );
            assertEquals( "    public String getType() {", actualExportedContents.get(18) );
            assertEquals( "        return type;", actualExportedContents.get(19) );
            assertEquals( "    }", actualExportedContents.get(20) );
            assertEquals( "", actualExportedContents.get(21) );
            assertEquals( "    public void setDescription( String description ) {", actualExportedContents.get(22) );
            assertEquals( "        this.description = description;", actualExportedContents.get(23) );
            assertEquals( "    }", actualExportedContents.get(24) );
            assertEquals( "", actualExportedContents.get(25) );
            assertEquals( "    public String getDescription() {", actualExportedContents.get(26) );
            assertEquals( "        return description;", actualExportedContents.get(27) );
            assertEquals( "    }", actualExportedContents.get(28) );
            assertEquals( "}", actualExportedContents.get(29) );
            assertEquals( "", actualExportedContents.get(30) );
            
            f = new File( "Attribute.java" );
            f.delete();
            f = new File( "Attribute_backup.java" );
            if( f.exists() && !f.isDirectory() ) {
                f.renameTo( new File( "Attribute.java" ) );
            }
            
            mainFrame.setVisible( false );
            Thread.sleep( 3000 );
        } catch( Exception e ) {
            assertTrue( e.getMessage(), false );
        }
    }
    
    private void inputString( Robot bot, String s ) {
        HashMap<Character, Integer> charToKeyCodeMap = new HashMap<Character, Integer>();
        charToKeyCodeMap.put( 'a', KeyEvent.VK_A ); charToKeyCodeMap.put( 'A', KeyEvent.VK_A );
        charToKeyCodeMap.put( 'b', KeyEvent.VK_B ); charToKeyCodeMap.put( 'B', KeyEvent.VK_B );
        charToKeyCodeMap.put( 'c', KeyEvent.VK_C ); charToKeyCodeMap.put( 'C', KeyEvent.VK_C );
        charToKeyCodeMap.put( 'd', KeyEvent.VK_D ); charToKeyCodeMap.put( 'D', KeyEvent.VK_D );
        charToKeyCodeMap.put( 'e', KeyEvent.VK_E ); charToKeyCodeMap.put( 'E', KeyEvent.VK_E );
        charToKeyCodeMap.put( 'f', KeyEvent.VK_F ); charToKeyCodeMap.put( 'F', KeyEvent.VK_F );
        charToKeyCodeMap.put( 'g', KeyEvent.VK_G ); charToKeyCodeMap.put( 'G', KeyEvent.VK_G );
        charToKeyCodeMap.put( 'h', KeyEvent.VK_H ); charToKeyCodeMap.put( 'H', KeyEvent.VK_H );
        charToKeyCodeMap.put( 'i', KeyEvent.VK_I ); charToKeyCodeMap.put( 'I', KeyEvent.VK_I );
        charToKeyCodeMap.put( 'j', KeyEvent.VK_J ); charToKeyCodeMap.put( 'J', KeyEvent.VK_J );
        charToKeyCodeMap.put( 'k', KeyEvent.VK_K ); charToKeyCodeMap.put( 'K', KeyEvent.VK_K );
        charToKeyCodeMap.put( 'l', KeyEvent.VK_L ); charToKeyCodeMap.put( 'L', KeyEvent.VK_L );
        charToKeyCodeMap.put( 'm', KeyEvent.VK_M ); charToKeyCodeMap.put( 'M', KeyEvent.VK_M );
        charToKeyCodeMap.put( 'n', KeyEvent.VK_N ); charToKeyCodeMap.put( 'N', KeyEvent.VK_N );
        charToKeyCodeMap.put( 'o', KeyEvent.VK_O ); charToKeyCodeMap.put( 'O', KeyEvent.VK_O );
        charToKeyCodeMap.put( 'p', KeyEvent.VK_P ); charToKeyCodeMap.put( 'P', KeyEvent.VK_P );
        charToKeyCodeMap.put( 'q', KeyEvent.VK_Q ); charToKeyCodeMap.put( 'Q', KeyEvent.VK_Q );
        charToKeyCodeMap.put( 'r', KeyEvent.VK_R ); charToKeyCodeMap.put( 'R', KeyEvent.VK_R );
        charToKeyCodeMap.put( 's', KeyEvent.VK_S ); charToKeyCodeMap.put( 'S', KeyEvent.VK_S );
        charToKeyCodeMap.put( 't', KeyEvent.VK_T ); charToKeyCodeMap.put( 'T', KeyEvent.VK_T );
        charToKeyCodeMap.put( 'u', KeyEvent.VK_U ); charToKeyCodeMap.put( 'U', KeyEvent.VK_U );
        charToKeyCodeMap.put( 'v', KeyEvent.VK_V ); charToKeyCodeMap.put( 'V', KeyEvent.VK_V );
        charToKeyCodeMap.put( 'w', KeyEvent.VK_W ); charToKeyCodeMap.put( 'W', KeyEvent.VK_W );
        charToKeyCodeMap.put( 'x', KeyEvent.VK_X ); charToKeyCodeMap.put( 'X', KeyEvent.VK_X );
        charToKeyCodeMap.put( 'y', KeyEvent.VK_Y ); charToKeyCodeMap.put( 'Y', KeyEvent.VK_Y );
        charToKeyCodeMap.put( 'z', KeyEvent.VK_Z ); charToKeyCodeMap.put( 'Z', KeyEvent.VK_Z );
        charToKeyCodeMap.put( '1', KeyEvent.VK_1 ); charToKeyCodeMap.put( '!', KeyEvent.VK_1 );
        charToKeyCodeMap.put( '2', KeyEvent.VK_2 ); charToKeyCodeMap.put( '@', KeyEvent.VK_2 );
        charToKeyCodeMap.put( '3', KeyEvent.VK_3 ); charToKeyCodeMap.put( '#', KeyEvent.VK_3 );
        charToKeyCodeMap.put( '4', KeyEvent.VK_4 ); charToKeyCodeMap.put( '$', KeyEvent.VK_4 );
        charToKeyCodeMap.put( '5', KeyEvent.VK_5 ); charToKeyCodeMap.put( '%', KeyEvent.VK_5 );
        charToKeyCodeMap.put( '6', KeyEvent.VK_6 ); charToKeyCodeMap.put( '^', KeyEvent.VK_6 );
        charToKeyCodeMap.put( '7', KeyEvent.VK_7 ); charToKeyCodeMap.put( '&', KeyEvent.VK_7 );
        charToKeyCodeMap.put( '8', KeyEvent.VK_8 ); charToKeyCodeMap.put( '*', KeyEvent.VK_8 );
        charToKeyCodeMap.put( '9', KeyEvent.VK_9 ); charToKeyCodeMap.put( '(', KeyEvent.VK_9 );
        charToKeyCodeMap.put( '0', KeyEvent.VK_0 ); charToKeyCodeMap.put( ')', KeyEvent.VK_0 );
        charToKeyCodeMap.put( '-', KeyEvent.VK_MINUS ); charToKeyCodeMap.put( '_', KeyEvent.VK_MINUS );
        charToKeyCodeMap.put( '=', KeyEvent.VK_EQUALS ); charToKeyCodeMap.put( '+', KeyEvent.VK_EQUALS );
        charToKeyCodeMap.put( '[', KeyEvent.VK_OPEN_BRACKET ); charToKeyCodeMap.put( '{', KeyEvent.VK_OPEN_BRACKET );
        charToKeyCodeMap.put( ']', KeyEvent.VK_CLOSE_BRACKET ); charToKeyCodeMap.put( '}', KeyEvent.VK_CLOSE_BRACKET );
        charToKeyCodeMap.put( '\\', KeyEvent.VK_BACK_SLASH ); charToKeyCodeMap.put( '|', KeyEvent.VK_BACK_SLASH );
        charToKeyCodeMap.put( ';', KeyEvent.VK_SEMICOLON ); charToKeyCodeMap.put( ':', KeyEvent.VK_SEMICOLON );
        charToKeyCodeMap.put( '\'', KeyEvent.VK_QUOTE ); charToKeyCodeMap.put( '\"', KeyEvent.VK_QUOTE );
        charToKeyCodeMap.put( ',', KeyEvent.VK_COMMA ); charToKeyCodeMap.put( '<', KeyEvent.VK_COMMA );
        charToKeyCodeMap.put( '.', KeyEvent.VK_PERIOD ); charToKeyCodeMap.put( '>', KeyEvent.VK_PERIOD );
        charToKeyCodeMap.put( '/', KeyEvent.VK_SLASH ); charToKeyCodeMap.put( '?', KeyEvent.VK_SLASH );
        charToKeyCodeMap.put( '`', KeyEvent.VK_BACK_QUOTE ); charToKeyCodeMap.put( '~', KeyEvent.VK_BACK_QUOTE );
        charToKeyCodeMap.put( ' ', KeyEvent.VK_SPACE );
        ArrayList<Character> shiftPunctuationList = new ArrayList<Character>( 
                Arrays.asList( '~', '!', '@', '#', '$', '%', '^', '&', '*', 
                '(', ')', '_', '+', '{', '}', '|', ':', '\"', '<', '>', '?' ) );
        for( int i = 0; i < s.length(); i++ ) {
            if( Character.isUpperCase( s.charAt( i ) ) || 
                    shiftPunctuationList.indexOf( s.charAt( i ) ) >= 0 ) {
                bot.keyPress( KeyEvent.VK_SHIFT );
            }
            bot.keyPress( charToKeyCodeMap.get( s.charAt( i ) ) );
            bot.keyRelease( charToKeyCodeMap.get( s.charAt( i ) ) );
            if( Character.isUpperCase( s.charAt( i ) ) || 
                    shiftPunctuationList.indexOf( s.charAt( i ) ) >= 0 ) {
                bot.keyRelease( KeyEvent.VK_SHIFT );
            }
        }
    }
}
