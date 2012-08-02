package delegator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GameProperties;

import dao.AdminDao;
import dao.TeamDao;

import bean.AdminBean;

/**
 * Servlet implementation class AdminLoginDelegator
 */
public class AdminLoginDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String forwardURL = "/loginLandingPage.jsp";
	private static final String errorUrl = "/welcome.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginDelegator() {
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
		String name =request.getParameter("name");
		String pass =request.getParameter("password");
		AdminBean bean =new AdminBean();
		bean.setName(name);
		bean.setPassword(pass);
		bean.setTable("u_admin");
		try
		{
			AdminDao dao =new AdminDao();
			bean = dao.findByNameAndPassword(bean);
			if(bean == null)
			{
				getServletContext().getRequestDispatcher(errorUrl).forward(request, response);
			}
			else
			{
				System.out.println(bean);
				System.out.println("PROPERTIES LOADED :::"+GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE));
				TeamDao tDao =new TeamDao();
				List teams = tDao.findAllTeam();
				request.getSession().setAttribute("ADMIN", bean);
				request.getSession().setAttribute("TEAMS", teams);
				request.getSession().setAttribute("LOGIN", "true");
				getServletContext().getRequestDispatcher(forwardURL).forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
