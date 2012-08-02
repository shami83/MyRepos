package delegator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GameProperties;

import bean.PlayerBean;

import dao.AlbumDao;
import dao.DataType;
import dao.PlayerDao;

/**
 * Servlet implementation class PlayerDelegator
 */
public class PlayerDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerDelegator() {
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
		else if(param.equalsIgnoreCase("changeView"))
		{
			try {
				changeView(request,response);
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
		else if(param.equalsIgnoreCase("delete"))
		{
			try {
				delete(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("update"))
		{
			try {
				updatePlayerInfo(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("edit"))
		{
			try {
				editPlayer(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("view"))
		{
			try {
				viewPlayer(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("assign"))
		{
			try {
				updatePlayer(request, response);
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
				String category = request.getParameter("cat");
				String grade = request.getParameter("grd");
				String image = request.getParameter("img")!= null || !request.getParameter("img").equalsIgnoreCase("") ?request.getParameter("img"):"player.jpg";
				String team ="0";
				DataType nameType =new DataType(DataType.Text,name);
				DataType catType =new DataType(DataType.Text,category.toLowerCase());
				DataType grdType =new DataType(DataType.Text,grade.toLowerCase());
				DataType imgType =new DataType(DataType.Text,image);
				DataType teamType =new DataType(DataType.Integer,team);
				Map<String,String> map =new HashMap<String,String>();
				map.put("Name", name);
				map.put("Category", category);
				map.put("Grade", grade);
				map.put("Team", team);
				
				List list = new ArrayList();
				list.add(nameType);
				list.add(grdType);
				list.add(catType);
				list.add(teamType);
				list.add(imgType);
				
				
				List columnList =new ArrayList();
				columnList.add("name");
				columnList.add("grade");
				columnList.add("category");
				columnList.add("team");
				columnList.add("image");
				PlayerDao dao =new PlayerDao();
				dao.insert(dao.getTable(), list,columnList);
				request.setAttribute("title","Created Player");
				request.setAttribute("status",map);
				this.getServletContext().getRequestDispatcher("/outcome.jsp").forward(request, response);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		private void changeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
			PlayerDao dao =new PlayerDao();
			List list = dao.findAllPlayer(map,"category");
			request.setAttribute("PlayerList", list);
			this.getServletContext().getRequestDispatcher("/HorizontalView.jsp").forward(request, response);
			
		}
		
	private void viewAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String cat = request.getParameter("cat");
		String grade =request.getParameter("grd");
		String team = request.getParameter("team");
		Map map =null;
		if(name!= null || cat!= null || grade!=null || team !=null)
		{
			map =new HashMap();
			if(name != null)
			{
				map.put("name", name);
			}
			if(cat!=null && !cat.equalsIgnoreCase("default"))
			{
				map.put("category", cat.toLowerCase());
			}
			if(grade!=null)
			{
				map.put("grade", grade.toLowerCase());
			}
			if(team!=null && !team.equalsIgnoreCase("-1"))
			{
				
				map.put("team", team);
			}
		}
		PlayerDao dao =new PlayerDao();
		request.getSession().setAttribute("SEARCH_MAP", map);
		List list = dao.findAllPlayer(map,"name");
		request.setAttribute("PlayerList", list);
		this.getServletContext().getRequestDispatcher("/AllPlayerView.jsp").forward(request, response);
	}
	
	private void viewPlayer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String playerId = request.getParameter("id");
		Integer id = Integer.parseInt(playerId.trim());
		PlayerDao dao =new PlayerDao();
		PlayerBean bean = dao.findByID(id);
		Map<String,String> map = GameProperties.getInstance().getMapProperty(GameProperties.CATEGORY);
		String imageName=map.get(bean.getCategory());
		String anchorImage=null;
		if(imageName.equalsIgnoreCase("default.jpg"))
		{
			anchorImage = "image?id="+bean.getId();
		}
		else
		{
			anchorImage="images/"+imageName;
		}
		bean.setAnchorImage(anchorImage);
		request.setAttribute("Player", bean);
		this.getServletContext().getRequestDispatcher("/viewPlayer.jsp").forward(request, response);
	}
	
	private void updatePlayer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String playerId = request.getParameter("id");
		String team = request.getParameter("team");
		Integer id = Integer.parseInt(playerId.trim());
		PlayerDao dao =new PlayerDao();
		dao.updateTeam(id, team);
		Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
		List list = dao.findAllPlayer(map,"name");
		request.setAttribute("PlayerList", list);
		this.getServletContext().getRequestDispatcher("/AllPlayerView.jsp").forward(request, response);
		
	}
	
	private void editPlayer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String playerId = request.getParameter("id");
		Integer id = Integer.parseInt(playerId.trim());
		PlayerDao dao =new PlayerDao();
		PlayerBean bean = dao.findByID(id);
		request.setAttribute("Player", bean);
		this.getServletContext().getRequestDispatcher("/editPlayer.jsp").forward(request, response);
		
	}
	
	private void updatePlayerInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String playerId = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("cat");
		String grade = request.getParameter("grd");
		String image = request.getParameter("img")!= null || !request.getParameter("img").equalsIgnoreCase("") ?request.getParameter("img"):"player.jpg";
		Integer id = Integer.parseInt(playerId.trim());
		PlayerDao dao =new PlayerDao();
		dao.updatePlayer(id, name,grade,category,image);
		Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
		List list = dao.findAllPlayer(map,"name");
		request.setAttribute("PlayerList", list);
		this.getServletContext().getRequestDispatcher("/AllPlayerView.jsp").forward(request, response);
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String playerId = request.getParameter("id");
		Integer id = Integer.parseInt(playerId.trim());
		PlayerDao dao =new PlayerDao();
		dao.deletePlayer(id);
		Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
		List list = dao.findAllPlayer(map,"name");
		request.setAttribute("PlayerList", list);
		this.getServletContext().getRequestDispatcher("/AllPlayerView.jsp").forward(request, response);
		
	}
	
		
	

}
