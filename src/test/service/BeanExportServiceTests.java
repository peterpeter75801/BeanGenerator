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
        assertEquals( "    private String description;  // Attribute descrption", exportContent.get(6) );
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
        testData.get(2).setDescription( "Attribute descrption" );
        testData.get(2).setType( "String" );
        
        return testData;
    }
    
    private Bean getBeanTestData1() {
        Bean testData = new Bean();
        testData.setBeanName( "Attribute" );
        testData.setPackageName( "domain" );
        return testData;
    }
}
