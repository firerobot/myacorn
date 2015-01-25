package com.myacorn.rest.status;

import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import com.myacorn.dao.*;

@Path("/v1/status")
public class V1_status {

	private static final String apiVersion = "00.01.00"; 
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version: " + apiVersion + "</p>";
	}
	
	/**
	 * This method will connect to the oracle database and return the date/time stamp.
	 * It will then return the date/time to the user in String format
	 * 
	 * This was explained in Part 3 of the Java Rest Tutorial Series on YouTube
	 * 
	 * Pre-episode 6, updated because Oracle308tube.java no longer accessible.
	 * 
	 * @return String -  returns the database date/time stamp
	 * @throws Exception
	 */
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
//		JSONArray json = new JSONArray();
		
		try {
			conn = MySqlDatabase.MySqlDataSource().getConnection();
			query = conn.prepareStatement("select sysdate() DATETIME ");
/*			
			query = conn.prepareStatement("select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') DATETIME " +
					"from dual");
 */
			ResultSet rs = query.executeQuery();
			
			while (rs.next()) {
				myString = rs.getString("DATETIME");
			}
/*			
			Schema308tube dao = new Schema308tube();
			
			json = dao.queryCheckDbConnection();
			myString = json.toString();
*/
			query.close();
			
			returnString = "<p>Database Status</p> " +
				"<p>Database Date/Time return: " + myString + "</p>";
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return returnString; 
	}
}
