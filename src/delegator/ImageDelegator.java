package delegator;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AlbumBean;

import paging.PagableList;
import util.GameProperties;

import dao.AlbumDao;
import dao.DataType;
import dao.ImageDao;

/**
 * Servlet implementation class AlbumDelegator
 */
public class ImageDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PagableList list = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDelegator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		if(param == null)
		{
			return;
		}
		if(param.equalsIgnoreCase("upload"))
		{
			upload(request,response);
		}
		else if(param.equalsIgnoreCase("viewbyalbum"))
		{
			try {
				viewByAlbum(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void upload(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	
private void viewByAlbum(HttpServletRequest request, HttpServletResponse response) throws Exception{
	   String albumId = request.getParameter("id");
	   request.getSession().setAttribute("AlbumID", albumId);
	    String gameMode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
		String site = GameProperties.getInstance().getStringProperty(GameProperties.SITE);
		ImageDao dao = new ImageDao();
		List imageList = dao.viewAllByAlbumId(albumId,gameMode,site);
		request.setAttribute("imageList",imageList);
		this.getServletContext().getRequestDispatcher("/ViewImages.jsp").forward(request, response);
		
	}
	
	
}
	
	
	
