package bean;

import java.util.Date;

public class ImageBean implements UKPLBean{
	
	private Integer Id;
	private String albumId;
	private String displayName;
	private String internalName;
	private String  table;
	private String  gameMode;
	private String  site;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getInternalName() {
		return internalName;
	}
	public void setInternalName(String internalName) {
		this.internalName = internalName;
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
	
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	@Override
	public String toString() {
		return "ImageBean [Id=" + Id + ", displayName=" + displayName
				+ ", internalName=" + internalName + ", table=" + table
				+ ", gameMode=" + gameMode + ", site=" + site + "]";
	}
	
	

}
