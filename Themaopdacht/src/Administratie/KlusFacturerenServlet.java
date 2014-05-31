package Administratie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KlusFacturerenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String klusid = req.getParameter("id");
		req.setAttribute("ID", klusid);
		String id = "";
		String klantid = "";
		String klantname = "";
		String title = "";
		String type = "";
		String comments = "";
		// verbeteren van absoluut path!!
		BufferedReader br = new BufferedReader(new FileReader(
				"C:/xampp/tomcat/webapps/AccountSysteem/klussenaf.dat"));
		String str = "";
		while ((str = br.readLine()) != null) {
			if (str.length() > 0) {
				// inlezen van het bestand
				int endID = str.indexOf(":");
				int endKlantID = str.indexOf(";");
				int endKlantName = str.indexOf(",");
				int endTitle = str.indexOf(".");
				int endType = str.indexOf("|");
				int end = str.indexOf("/");
				id = str.substring(0, (endID));
				System.out.println(endID);
				klantid = str.substring((endID + 1), (endKlantID));
				klantname = str.substring((endKlantID + 1), (endKlantName));
				title = str.substring((endKlantName + 1), (endTitle));
				type = str.substring((endTitle + 1), (endType));
				comments = str.substring((endType + 1), (end));
				if (klusid.equals(id)) {
					break;
				}
			}
		}
		br.close();

		// absoluut path weg!!
		FileWriter fw = new FileWriter(
				"C:/xampp/tomcat/webapps/AccountSysteem/factuurgemaakt.dat",
				true);

		fw.write("\n" + id + ":" + klantid + ";" + klantname + "," + title
				+ "." + type + "|" + comments + "/");
		fw.flush();
		fw.close();

		// same here!
		BufferedReader br2 = new BufferedReader(new FileReader(
				"C:/xampp/tomcat/webapps/AccountSysteem/klussenaf.dat"));
		BufferedWriter out = new BufferedWriter(new FileWriter(
				"C:/xampp/tomcat/webapps/AccountSysteem/klussenaf.dat"));

		str = "";

		// inlezen van bestand
		ArrayList<String> overige = new ArrayList<String>();
		while ((str = br2.readLine()) != null) {
			int endID = str.indexOf(":");
			id = str.substring(0, (endID));
			if (klusid.equals(id)) {
				str.replace("", "");
				overige.add(str);
				out.write(str);
			} else {

				for (int i = 0; i < overige.size(); i++) {
					if (!(overige.get(i).equals(str))) {
						overige.add(str);
					}
				}
			}
		}
		br2.close();
		out.flush();
		out.close();

		rd = req.getRequestDispatcher("administratie/factuur.jsp");
		rd.forward(req, resp);
	}

}
