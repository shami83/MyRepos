package bean;

public class PlayerBean implements UKPLBean{
	
	private Integer id;
	private String name;
	private String category;
	private String grade;
	private Integer team;
	private String image;
	private String table;
	private String teamName;
	private String anchorImage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getTeam() {
		return team;
	}
	public void setTeam(Integer team) {
		this.team = team;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getAnchorImage() {
		return anchorImage;
	}
	public void setAnchorImage(String anchorImage) {
		this.anchorImage = anchorImage;
	}
	@Override
	public String toString() {
		return "PlayerBean [id=" + id + ", name=" + name + ", category="
				+ category + ", grade=" + grade + ", team=" + team + ", image="
				+ image + ", table=" + table + "]";
	}
	

}
