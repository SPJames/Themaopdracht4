package Monteur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginMonteurServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;
		
		if(username.equals("") || username.equals(null)){
			error = true;
		}
		if(password.equals("") || password.equals(null)){
			error = true;
		}
		RequestDispatcher rd = null;
		if(error){
			req.setAttribute("msgs", "Input was empty");
			rd = req.getRequestDispatcher("/monteur/loginmonteur.jsp");
		}else{
			BufferedReader br = new BufferedReader(new FileReader("C:/xampp/tomcat/webapps/AccountSysteem/monteur/monteurs.dat"));
			String str = "";
			while((str=br.readLine())!=null){
				if(str.length()>0){
					int firstSpace = str.indexOf(" ");
					int endName = str.indexOf(":");
					int endPassword = str.indexOf(";");
					String id = str.substring(0, (firstSpace));
					String str1 = str.substring((firstSpace+1), (endName));
					String str2 = str.substring((endName+1), (endPassword));
				
					if((str1.contains(username)) && (str2.contains(password))){
						rd = req.getRequestDispatcher("index.jsp");
						req.setAttribute("msgs", null);
						
						Cookie c = new Cookie("C_Username", username);
						c.setMaxAge(3600*24);
						Cookie c2 = new Cookie("C_Password", password);
						c2.setMaxAge(3600*24);
						Cookie c3 = new Cookie("C_ID", id);
						c3.setMaxAge(3600*24);
						Cookie c4 = new Cookie("C_Usertype", "Monteur");
						c4.setMaxAge(3600*24);
						resp.addCookie(c);
						resp.addCookie(c2);
						resp.addCookie(c3);
						resp.addCookie(c4);
						break;
					}else{
						req.setAttribute("msgs", "Unknown username/password combo");
						rd = req.getRequestDispatcher("/monteur/loginmonteur.jsp");
					}
				}
			}
			br.close();
			
		}
		rd.forward(req,resp);
	}

}
