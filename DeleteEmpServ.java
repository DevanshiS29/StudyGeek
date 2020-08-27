import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteEmpServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private Connection con;
	public void init(ServletConfig config)throws ServletException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.DriverManager");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
		}
		catch(SQLException s) 
		{
			s.printStackTrace();
		}
		catch(ClassNotFoundException s) 
		{
			s.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			String query="delete from employee where Eno=?";
			PreparedStatement pmt=con.prepareStatement(query);
			pmt.setInt(1,no);
			int n=pmt.executeUpdate();
			if(n>0)
			{
				out.print("<html><body style='text-align:center'><h1 style='color:green'>Employee has been deleted successfully!!</h1>");
			}
			else
			{
				out.print("<html><body style='text-align:center'><h1 style='color:tomato'>An error occurred while deleting employee!!</h1>");
			}
		}
		catch(SQLException s) 
		{
			s.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ques2.html");
		rd.include(request, response);
		out.print("</body></html>");
	}
	
	public void destroy()
	{
		try
		{
			if(con!=null)
				con.close();
		}
		catch(SQLException s) 
		{
			s.printStackTrace();
		}
	}
}
