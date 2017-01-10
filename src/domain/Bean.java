package domain;

public class Bean {

	private String packageName;
	private String beanName;
	
	public void setPackageName( String packageName ) {
		this.packageName = packageName;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setBeanName( String beanName ) {
		this.beanName = beanName;
	}
	
	public String getBeanName() {
		return beanName;
	}
}
