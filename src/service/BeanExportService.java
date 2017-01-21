package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Attribute;
import domain.Bean;
import utils.StringUtils;

public class BeanExportService {
	
	public void export( Bean bean, ArrayList<Attribute> attributes ) 
			throws IOException {
		BufferedWriter bufWriter = new BufferedWriter(
        	new FileWriter( bean.getBeanName() + ".java" ) );
		ArrayList<String> exportContent = getExportContent( bean, attributes );
		for( String line : exportContent ) {
			bufWriter.write( line );
			bufWriter.newLine();
		}
		bufWriter.close();
	}
	
	public ArrayList<String> getExportContent( 
			Bean bean, ArrayList<Attribute> attributes ) {
		ArrayList<String> exportContent = new ArrayList<String>();
		
		if( StringUtils.isNotBlank( bean.getPackageName() ) ) {
			exportContent.add( String.format( "package %s;", bean.getPackageName()) );
			exportContent.add( "" );
		}
		exportContent.add( String.format( "public class %s {", bean.getBeanName() ) );
		exportContent.add( "" );
		
		for( Attribute attr : attributes ) {
			StringBuffer attrDefineString = new StringBuffer();
			attrDefineString.append( String.format( 
				"    private %s %s;", attr.getType(), attr.getAttrName() ) );
			if( StringUtils.isNotBlank( attr.getDescription() ) ) {
				attrDefineString.append( String.format(
					"  // %s", attr.getDescription() ) );
			}
			exportContent.add( attrDefineString.toString() );
		}
		
		for( Attribute attr : attributes ) {
			String upperCaseAttrName = 
				Character.toString( Character.toUpperCase( attr.getAttrName().charAt(0) ) ) +
				attr.getAttrName().substring(1);
			exportContent.add( "" );
			exportContent.add( String.format( 
				"    public void set%s( %s %s ) {", 
				upperCaseAttrName, attr.getType(), attr.getAttrName() ) );
			exportContent.add( String.format( 
				"        this.%s = %s;", attr.getAttrName(), attr.getAttrName() ) );
			exportContent.add( "    }" );
			exportContent.add( "" );
			exportContent.add( String.format( 
				"    public %s get%s() {", attr.getType(), upperCaseAttrName ) );
			exportContent.add( String.format( 
				"        return %s;", attr.getAttrName() ) );
			exportContent.add( "    }" );
		}
		
		exportContent.add( "}" );
		exportContent.add( "" );
		
		return exportContent;
	}

}
