package domain;

public class Attribute {

    private String attrName;
    private String type;
    private String description;
    
    public void setAttrName( String attrName ) {
        this.attrName = attrName;
    }
    
    public String getAttrName() {
        return attrName;
    }
    
    public void setType( String type ) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
