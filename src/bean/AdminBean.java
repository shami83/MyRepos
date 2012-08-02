package bean;

public class AdminBean implements UKPLBean{
	
	private Integer Id;
	private String name;
	private String password;
	private String url;
	private Integer sex;
	private String  table;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		this.Id =id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	@Override
	public String toString() {
		return "AdminBean [Id=" + Id + ", name=" + name + ", password="
				+ password + ", url=" + url + ", sex=" + sex + ", table="
				+ table + "]";
	}
	
	
	

}
