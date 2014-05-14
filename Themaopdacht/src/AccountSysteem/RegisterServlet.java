package AccountSysteem;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static int id = 1;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String[] userinfo = new String[8];
		boolean error = false;
		
		userinfo[0] = req.getParameter("Username");
		userinfo[1] = req.getParameter("Realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("pwd2");
		userinfo[4] = req.getParameter("email");
		userinfo[5] = req.getParameter("email2");
		userinfo[6] = req.getParameter("Adress");
		userinfo[7] = req.getParameter("Country");
		
		for(int i = 0; i<8; i++){
			if(userinfo[i].equals("") || userinfo[i].equals(null)){
				error = true;
			}
		}
		if(!userinfo[2].equals(userinfo[3])){
			error = true;
		}
		if(!userinfo[4].equals(userinfo[5])){
			error = true;
		}
		RequestDispatcher rd = null; 
		if (error){
			req.setAttribute("msgs", "Input was empty or password/email didn't match");	
			rd = req.getRequestDispatcher("register.jsp");
			
			
		}else{
			FileWriter fw = new FileWriter("C:/xampp/tomcat/webapps/AccountSysteem/users.dat", true);
			
			fw.write("\n"+ id++ +" "+userinfo[0]+":"+userinfo[2]+";"+userinfo[1]+" "+userinfo[4]+" "+userinfo[6]+" "+userinfo[7]);
			fw.flush();
			fw.close();
			
			rd = req.getRequestDispatcher("login.jsp");
			
		}
		rd.forward(req,resp);
		
	}
	
}
