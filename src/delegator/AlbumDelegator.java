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
import bean.PlayerBean;

import paging.PagableList;
import util.GameProperties;

import dao.AlbumDao;
import dao.DataType;
import dao.PlayerDao;

/**
 * Servlet implementation class AlbumDelegator
 */
public class AlbumDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PagableList list = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumDelegator() {
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
		if(param.equalsIgnoreCase("create"))
		{
			create(request,response);
		}
		else if(param.equalsIgnoreCase("view"))
		{
			try {
				viewAlbum(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("viewAll"))
		{
			try {
				viewAll(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			String name = request.getParameter("name");
			String desc = request.getParameter("des");
			String gameMode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
			String site = GameProperties.getInstance().getStringProperty(GameProperties.SITE);
			Date date =new Date();
			DataType nameType =new DataType(DataType.Text,name);
			DataType descType =new DataType(DataType.Text,desc);
			DataType dateType =new DataType(DataType.Date,null);
			DataType gameModeType =new DataType(DataType.Text,gameMode);
			DataType siteType =new DataType(DataType.Text,site);
			Map<String,String> map =new HashMap<String,String>();
			map.put("Title", name);
			map.put("Description", desc);
			map.put("Description", desc);
			map.put("Create Date", date.toLocaleString());
			
			List list = new ArrayList();
			list.add(nameType);
			list.add(descType);
			list.add(dateType);
			list.add(gameModeType);
			list.add(siteType);
			
			List columnList =new ArrayList();
			columnList.add("name");
			columnList.add("description");
			columnList.add("date");
			columnList.add("gamemode");
			columnList.add("site");
			AlbumDao dao =new AlbumDao();
			dao.insert("u_album", list,columnList);
			request.setAttribute("title","Created Album Details");
			request.setAttribute("status",map);
			this.getServletContext().getRequestDispatcher("/outcome.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
	}
	
	
	private void viewAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action =request.getParameter("action");
		String gameMode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
		String site = GameProperties.getInstance().getStringProperty(GameProperties.SITE);
		List result =new ArrayList();
		ResultSet rs =null;
		if(action == null)
		{
			Map paramMap = new HashMap();
			paramMap.put("gamemode", gameMode);
			paramMap.put("site", site);
			list = new PagableList("u_album",2,paramMap);
			rs = list.doNext();
			
		}
		else if(action.equalsIgnoreCase("next"))
		{
			rs = list.doNext();
		}
		else if(action.equalsIgnoreCase("prev"))
		{
			rs = list.doPrevious();
		}
		while(rs.next())
		{
			AlbumBean bean =new AlbumBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setDate(rs.getDate(4));
			result.add(bean);
		}
		request.setAttribute("result", result);
		request.setAttribute("prev", list.hasPrevious());
		request.setAttribute("next", list.hasNext());
		this.getServletContext().getRequestDispatcher("/AllAlbumView.jsp").forward(request, response);
	}

	private void viewAlbum(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String albumId = request.getParameter("id");
		Integer id = Integer.parseInt(albumId.trim());
		AlbumDao dao =new AlbumDao();
		AlbumBean bean = dao.findByID(id);
		request.setAttribute("Album", bean);
		request.getSession().setAttribute("AlbumID",albumId);
		this.getServletContext().getRequestDispatcher("/ViewImages.jsp").forward(request, response);
	}
	
}
