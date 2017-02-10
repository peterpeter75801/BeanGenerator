package test.service;

import java.util.ArrayList;

import domain.Attribute;
import domain.Bean;
import service.BeanExportService;

import junit.framework.TestCase;

public class BeanExportServiceTests extends TestCase {

    public void testGetExportContent() {
        ArrayList<Attribute> attributesTestData = getAttributesTestData1();
        Bean beanTestData = getBeanTestData1();
        
        ArrayList<String> exportContent = 
            new BeanExportService().getExportContent( beanTestData, attributesTestData );
        
        assertEquals( 33, exportContent.size() );
        assertEquals( "package domain;", exportContent.get(0) );
        assertEquals( "", exportContent.get(1) );
        assertEquals( "public class Attribute {", exportContent.get(2) );
        assertEquals( "", exportContent.get(3) );
        assertEquals( "    private String attrName;  // Attribute name", exportContent.get(4) );
        assertEquals( "    private String type;  // Type of this attribute", exportContent.get(5) );
        assertEquals( "    private String description;  // Attribute description", exportContent.get(6) );
        assertEquals( "", exportContent.get(7) );
        assertEquals( "    public void setAttrName( String attrName ) {", exportContent.get(8) );
        assertEquals( "        this.attrName = attrName;", exportContent.get(9) );
        assertEquals( "    }", exportContent.get(10) );
        assertEquals( "", exportContent.get(11) );
        assertEquals( "    public String getAttrName() {", exportContent.get(12) );
        assertEquals( "        return attrName;", exportContent.get(13) );
        assertEquals( "    }", exportContent.get(14) );
        assertEquals( "", exportContent.get(15) );
        assertEquals( "    public void setType( String type ) {", exportContent.get(16) );
        assertEquals( "        this.type = type;", exportContent.get(17) );
        assertEquals( "    }", exportContent.get(18) );
        assertEquals( "", exportContent.get(19) );
        assertEquals( "    public String getType() {", exportContent.get(20) );
        assertEquals( "        return type;", exportContent.get(21) );
        assertEquals( "    }", exportContent.get(22) );
        assertEquals( "", exportContent.get(23) );
        assertEquals( "    public void setDescription( String description ) {", exportContent.get(24) );
        assertEquals( "        this.description = description;", exportContent.get(25) );
        assertEquals( "    }", exportContent.get(26) );
        assertEquals( "", exportContent.get(27) );
        assertEquals( "    public String getDescription() {", exportContent.get(28) );
        assertEquals( "        return description;", exportContent.get(29) );
        assertEquals( "    }", exportContent.get(30) );
        assertEquals( "}", exportContent.get(31) );
        assertEquals( "", exportContent.get(32) );
    }
    
    public void testGetExportContentWithNullDesc() {
        ArrayList<Attribute> attributesTestData = getAttributesTestData2();
        Bean beanTestData = getBeanTestData1();
        
        ArrayList<String> exportContent = 
            new BeanExportService().getExportContent( beanTestData, attributesTestData );
        
        assertEquals( 33, exportContent.size() );
        assertEquals( "package domain;", exportContent.get(0) );
        assertEquals( "", exportContent.get(1) );
        assertEquals( "public class Attribute {", exportContent.get(2) );
        assertEquals( "", exportContent.get(3) );
        assertEquals( "    private String attrName;", exportContent.get(4) );
        assertEquals( "    private String type;", exportContent.get(5) );
        assertEquals( "    private String description;", exportContent.get(6) );
        assertEquals( "", exportContent.get(7) );
        assertEquals( "    public void setAttrName( String attrName ) {", exportContent.get(8) );
        assertEquals( "        this.attrName = attrName;", exportContent.get(9) );
        assertEquals( "    }", exportContent.get(10) );
        assertEquals( "", exportContent.get(11) );
        assertEquals( "    public String getAttrName() {", exportContent.get(12) );
        assertEquals( "        return attrName;", exportContent.get(13) );
        assertEquals( "    }", exportContent.get(14) );
        assertEquals( "", exportContent.get(15) );
        assertEquals( "    public void setType( String type ) {", exportContent.get(16) );
        assertEquals( "        this.type = type;", exportContent.get(17) );
        assertEquals( "    }", exportContent.get(18) );
        assertEquals( "", exportContent.get(19) );
        assertEquals( "    public String getType() {", exportContent.get(20) );
        assertEquals( "        return type;", exportContent.get(21) );
        assertEquals( "    }", exportContent.get(22) );
        assertEquals( "", exportContent.get(23) );
        assertEquals( "    public void setDescription( String description ) {", exportContent.get(24) );
        assertEquals( "        this.description = description;", exportContent.get(25) );
        assertEquals( "    }", exportContent.get(26) );
        assertEquals( "", exportContent.get(27) );
        assertEquals( "    public String getDescription() {", exportContent.get(28) );
        assertEquals( "        return description;", exportContent.get(29) );
        assertEquals( "    }", exportContent.get(30) );
        assertEquals( "}", exportContent.get(31) );
        assertEquals( "", exportContent.get(32) );
    }
    
    public void testGetExportContentWithNullPackage() {
        ArrayList<Attribute> attributesTestData = getAttributesTestData1();
        Bean beanTestData = getBeanTestData2();
        
        ArrayList<String> exportContent = 
            new BeanExportService().getExportContent( beanTestData, attributesTestData );
        
        assertEquals( 31, exportContent.size() );
        assertEquals( "public class Attribute {", exportContent.get(0) );
        assertEquals( "", exportContent.get(1) );
        assertEquals( "    private String attrName;  // Attribute name", exportContent.get(2) );
        assertEquals( "    private String type;  // Type of this attribute", exportContent.get(3) );
        assertEquals( "    private String description;  // Attribute description", exportContent.get(4) );
        assertEquals( "", exportContent.get(5) );
        assertEquals( "    public void setAttrName( String attrName ) {", exportContent.get(6) );
        assertEquals( "        this.attrName = attrName;", exportContent.get(7) );
        assertEquals( "    }", exportContent.get(8) );
        assertEquals( "", exportContent.get(9) );
        assertEquals( "    public String getAttrName() {", exportContent.get(10) );
        assertEquals( "        return attrName;", exportContent.get(11) );
        assertEquals( "    }", exportContent.get(12) );
        assertEquals( "", exportContent.get(13) );
        assertEquals( "    public void setType( String type ) {", exportContent.get(14) );
        assertEquals( "        this.type = type;", exportContent.get(15) );
        assertEquals( "    }", exportContent.get(16) );
        assertEquals( "", exportContent.get(17) );
        assertEquals( "    public String getType() {", exportContent.get(18) );
        assertEquals( "        return type;", exportContent.get(19) );
        assertEquals( "    }", exportContent.get(20) );
        assertEquals( "", exportContent.get(21) );
        assertEquals( "    public void setDescription( String description ) {", exportContent.get(22) );
        assertEquals( "        this.description = description;", exportContent.get(23) );
        assertEquals( "    }", exportContent.get(24) );
        assertEquals( "", exportContent.get(25) );
        assertEquals( "    public String getDescription() {", exportContent.get(26) );
        assertEquals( "        return description;", exportContent.get(27) );
        assertEquals( "    }", exportContent.get(28) );
        assertEquals( "}", exportContent.get(29) );
        assertEquals( "", exportContent.get(30) );
    }
    
    private ArrayList<Attribute> getAttributesTestData1() {
        ArrayList<Attribute> testData = new ArrayList<Attribute>();
        
        testData.add( new Attribute() );
        testData.get(0).setAttrName( "attrName" );
        testData.get(0).setDescription( "Attribute name" );
        testData.get(0).setType( "String" );
        
        testData.add( new Attribute() );
        testData.get(1).setAttrName( "type" );
        testData.get(1).setDescription( "Type of this attribute" );
        testData.get(1).setType( "String" );
        
        testData.add( new Attribute() );
        testData.get(2).setAttrName( "description" );
        testData.get(2).setDescription( "Attribute description" );
        testData.get(2).setType( "String" );
        
        return testData;
    }
    
    private ArrayList<Attribute> getAttributesTestData2() {
        ArrayList<Attribute> testData = new ArrayList<Attribute>();
        
        testData.add( new Attribute() );
        testData.get(0).setAttrName( "attrName" );
        testData.get(0).setDescription( "" );
        testData.get(0).setType( "String" );
        
        testData.add( new Attribute() );
        testData.get(1).setAttrName( "type" );
        testData.get(1).setDescription( "" );
        testData.get(1).setType( "String" );
        
        testData.add( new Attribute() );
        testData.get(2).setAttrName( "description" );
        testData.get(2).setDescription( "" );
        testData.get(2).setType( "String" );
        
        return testData;
    }
    
    private Bean getBeanTestData1() {
        Bean testData = new Bean();
        testData.setBeanName( "Attribute" );
        testData.setPackageName( "domain" );
        return testData;
    }
    
    private Bean getBeanTestData2() {
        Bean testData = new Bean();
        testData.setBeanName( "Attribute" );
        testData.setPackageName( "" );
        return testData;
    }
}
