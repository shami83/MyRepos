package delegator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GameProperties;

/**
 * Servlet implementation class MiscDelegator
 */
public class MiscDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiscDelegator() {
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
		String mode = request.getParameter("mode");
		if(mode != null)
		{
			for(Object  key :GameProperties.getInstance().getinMemoryProp().keySet())
			{
				String value = (String)GameProperties.getInstance().getinMemoryProp().get(key);
				String newValue = request.getParameter(key.toString());
				System.out.println(value + "==>" + newValue);
				if(!value.equalsIgnoreCase(newValue))
				{
					GameProperties.getInstance().setDynamicProp(key.toString(), newValue);
				}
			}
		}
		
		this.getServletContext().getRequestDispatcher("/metadataView.jsp").forward(request, response);
	}

}
