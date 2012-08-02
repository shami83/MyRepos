package bean;

import java.util.Date;

public class AlbumBean implements UKPLBean{
	private Integer Id;
	private String name;
	private String description;
	private Date date ;
	private String  table;
	private String  gameMode;
	private String  site;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	@Override
	public String toString() {
		return "AlbumBean [Id=" + Id + ", name=" + name + ", description="
				+ description + ", date=" + date + ", table=" + table + "]";
	}
	
	

}
