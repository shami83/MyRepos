package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PlayerBean;

import dao.PlayerDao;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String LOC ="C:\\ukpl\\";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
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
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		try {
		PlayerDao dao =new PlayerDao();
		PlayerBean bean = dao.findByID(new Integer(id.trim()));
		String fileName =LOC+bean.getImage();
		System.out.println("filepath : " + fileName);
		ServletContext sc = getServletContext();
		 String mimeType = sc.getMimeType(fileName);
		    if (mimeType == null) {
		        sc.log("Could not get MIME type of "+ LOC+bean.getImage());
		        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		        return;
		    }
		    response.setContentType(mimeType);

		    // Set content size
		    File file = new File(fileName);
		    response.setContentLength((int)file.length());

		    // Open the file and output streams
		    FileInputStream in = new FileInputStream(file);
		    OutputStream out = response.getOutputStream();

		    // Copy the contents of the file to the output stream
		    byte[] buf = new byte[1024];
		    int count = 0;
		    while ((count = in.read(buf)) >= 0) {
		        out.write(buf, 0, count);
		    }
		    in.close();
		    out.close();



		} catch (NumberFormatException e) {
				e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
