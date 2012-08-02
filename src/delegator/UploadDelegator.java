package delegator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import util.GameProperties;

import com.oreilly.servlet.MultipartRequest;

import dao.AlbumDao;
import dao.DataType;
import dao.ImageDao;

/**
 * Servlet implementation class UploadDelegator
 */
public class UploadDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TMP_DIR_PATH = "C:\\tmp";
	private File tmpDir;
	private static final String DESTINATION_DIR_PATH ="C:\\upload";
	private File destinationDir;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDelegator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmpDir = new File(TMP_DIR_PATH);
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		//String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
		destinationDir = new File(DESTINATION_DIR_PATH);
		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
		}
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
		String displayName=null;
		String internalName = System.currentTimeMillis()+".jpg";
		 PrintWriter out = response.getWriter();
		  DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
			/*
			 *Set the size threshold, above which content will be stored on disk.
			 */
			//fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
			/*
			 * Set the temporary directory to store the uploaded files of size above threshold.
			 */
			fileItemFactory.setRepository(tmpDir);
	 
			ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
			try {
				/*
				 * Parse the request
				 */
				List items = uploadHandler.parseRequest(request);
				Iterator itr = items.iterator();
				while(itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					 System.out.println(item.getFieldName()+ "::" + item.getString());
					/*
					 * Handle Form Fields.
					 */
					if(item.isFormField()) {
												
									
						
					} else {
						//Handle Uploaded files.
						displayName=item.getName();
						out.println("Field Name = "+item.getFieldName()+
							", File Name = "+item.getName()+
							", Content type = "+item.getContentType()+
							", File Size = "+item.getSize());
						/*
						 * Write file to the ultimate location.
						 */
						File file = new File(destinationDir,internalName);
						item.write(file);
					}
					out.close();
					String IdStr = (String)request.getSession().getAttribute("AlbumID");
					String gameMode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
					String site = GameProperties.getInstance().getStringProperty(GameProperties.SITE);
					Integer id = new Integer(IdStr.trim());
					DataType idType =new DataType(DataType.Integer,id);
					DataType nameType =new DataType(DataType.Text,displayName);
					DataType internalType =new DataType(DataType.Text,internalName);
					DataType gamemodeType =new DataType(DataType.Text,gameMode);
					DataType siteType =new DataType(DataType.Text,site);
					Map<String,String> map =new HashMap<String,String>();
					map.put("File name", displayName);
					
					
					List list = new ArrayList();
					list.add(idType);
					list.add(nameType);
					list.add(internalType);
					list.add(gamemodeType);
					list.add(siteType);
					
					
					List columnList =new ArrayList();
					columnList.add("album_id");
					columnList.add("displayname");
					columnList.add("internalname");
					columnList.add("gamemode");
					columnList.add("site");
					ImageDao dao =new ImageDao();
					dao.insert("u_img", list,columnList);
					request.setAttribute("title","Uploaded File Details");
					request.setAttribute("status",map);
					this.getServletContext().getRequestDispatcher("/outcome.jsp").forward(request, response);
				
				}
			}catch(FileUploadException ex) {
				log("Error encountered while parsing the request",ex);
			} catch(Exception ex) {
				log("Error encountered while uploading file",ex);
			}
	 
		}


	}


