package applet;

import java.applet.Applet;
import java.awt.Graphics;

import bean.PlayerBean;

import dao.PlayerDao;

public class Test extends Applet {
    public void paint(Graphics g) {
    	try {
			PlayerDao dao = new PlayerDao();
			PlayerBean bean = dao.findByID(34);
			g.drawString(bean.toString(), 50, 25);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
