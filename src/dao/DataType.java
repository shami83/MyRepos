package dao;

public class DataType {
	private String type;
	private Object value;
	public static final String Integer="integer";
	public static final String Float="float";
	public static final String Long="long";
	public static final String Boolean="boolean";
	public static final String Date="date";
	public static final String Text="text";
	
	public DataType(String type,Object value)
	{
		this.type =type;
		this.value=value;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	

}
