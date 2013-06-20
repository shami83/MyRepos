package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GameProperties {
	
	private static GameProperties instance;
	private static String PROP_FILE="game.properties";
	private static String PROP_FILE_FULLPATH="/util/"+PROP_FILE;
	private  Properties prop;
	public static final String GAME_MODE="gameMode";
	public static final String CATEGORY="category";
	public static final String SITE="site";
	public static final String SITE_FULLNAME="site.fullName";
	public static final String THEME="theme";
	public static final String THEMEFONT="theme.font";
	public static final String DB_USER="db.user";
	public static final String DB_PASSWORD="db.password";
	public static GameProperties getInstance()
	{
		return instance==null?instance=new GameProperties():instance;
	}
	private GameProperties()
	{
		initProp();
	}
	
	private void initProp()
	{
		prop = new Properties();
		InputStream in = getClass().getResourceAsStream(PROP_FILE_FULLPATH);
		try {
			prop.load(in);
			System.out.println(prop.keySet());
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
		
		public String getStringProperty(String key)
		{
			return prop.getProperty(key);
		}
		
		public String[] getStringArrayProperty(String key)
		{
			String str = prop.getProperty(key);
			return str.split(",");
		}
		
		public Map<String,String> getMapProperty(String key)
		{
			Map<String,String> map =new HashMap<String,String>();
			String str = prop.getProperty(key);
			String[] strArr = str.split(",");
			for(String res: strArr)
			{
				String[] pair = res.split(":");
				map.put(pair[0], pair[1]);
			}
			return map;
		}
		
		
	public void setDynamicProp(String key,String value)
	{
		String oldValue = prop.getProperty(key);
		prop.setProperty(key, value);
		System.out.println(oldValue + "Change to"+ value);
	}
	
	public Properties getinMemoryProp()
	{
		return prop;
	}
	



}
