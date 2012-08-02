package delegator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PlayerBean;
import bean.TeamBean;

import dao.DataType;
import dao.PlayerDao;
import dao.TeamDao;

/**
 * Servlet implementation class TeamDelegator
 */
public class TeamDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamDelegator() {
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
		else if(param.equalsIgnoreCase("viewAll"))
		{
			try {
				viewAll(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("edit"))
		{
			try {
				editTeam(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("update"))
		{
			try {
				updateTeam(request, response);
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
				String owner = request.getParameter("owner");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				DataType nameType =new DataType(DataType.Text,name);
				DataType ownerType =new DataType(DataType.Text,owner);
				DataType addressType =new DataType(DataType.Text,address);
				DataType phoneType =new DataType(DataType.Text,phone);
				Map<String,String> map =new HashMap<String,String>();
				map.put("Name", name);
				map.put("owner", owner);
				map.put("address", address);
				map.put("Phone", phone);
				
				List list = new ArrayList();
				list.add(nameType);
				list.add(ownerType);
				list.add(addressType);
				list.add(phoneType);
				
				
				
				List columnList =new ArrayList();
				columnList.add("name");
				columnList.add("owner");
				columnList.add("adress");
				columnList.add("phone");
				TeamDao dao =new TeamDao();
				dao.insert(dao.getTable(), list,columnList);
				request.setAttribute("title","Created Team");
				request.setAttribute("status",map);
				this.getServletContext().getRequestDispatcher("/outcome.jsp").forward(request, response);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		
		private void viewAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
			TeamDao dao =new TeamDao();
			List list = dao.findAllTeam();
			request.setAttribute("TeamList", list);
			this.getServletContext().getRequestDispatcher("/AllTeamView.jsp").forward(request, response);
		}
		
		private void updateTeam(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String teamId = request.getParameter("id");
			String name = request.getParameter("name");
			String owner = request.getParameter("owner");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			Integer id = Integer.parseInt(teamId.trim());
			TeamDao dao =new TeamDao();
			dao.updateTeam(id, name,owner,address,phone);
			viewAll(request,response);						
		}
		private void editTeam(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String teamId = request.getParameter("id");
			Integer id = Integer.parseInt(teamId.trim());
			TeamDao dao =new TeamDao();
			TeamBean bean = dao.findByID(id);
			request.setAttribute("Team", bean);
			this.getServletContext().getRequestDispatcher("/editTeam.jsp").forward(request, response);
		}
			
		

}
