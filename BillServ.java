import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BillServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.print("<html><head><title>BILL</title></head><body bgcolor='tomato' style='text-align:center;'>");
		//creating bill page
		String[] cards=request.getParameterValues("card");
		String[] flowers=request.getParameterValues("flow");
		//getting check box values
		if(request.getRequestURL().equals(new StringBuffer("/cards.html")))
		//checking if request came from card page
		{
			if(cards==null)
			//if user selected nothing
			{
				out.print("<html><body style='text-color:white;text-align:center;'><p>You haven't selected anything..!!</p><br>");
				RequestDispatcher rd=request.getRequestDispatcher("home.html");
				rd.include(request, response);
				//sending a message including the home page
			}
			else
			{
				out.print("<h1>WELCOME TO THE BILL PAGE</h1><hr color='black'><br><br>");
				out.print("<table align='center' border='5px'><tr><th>ITEMS</th><th>AMOUNT</th></tr>");
				//else printing the amount of selected item
				for(int i=0;i<cards.length;++i)
				//loop to traverse through the values and print the amount
				{
					if(cards[i].equals("red"))
					{
						out.print("<tr><td>Red Card</td><td>80/-</td></tr>");
					}
					else if(cards[i].equals("blue"))
					{
						out.print("<tr><td>Blue Card</td><td>95/-</td></tr>");
					}
					else if(cards[i].equals("pink"))
					{
						out.print("<tr><td>Pink Card</td><td>90/-</td></tr>");
					}
					else if(cards[i].equals("yellow"))
					{
						out.print("<tr><td>Yellow Card</td><td>55/-</td></tr>");
					}
					else if(cards[i].equals("green"))
					{
						out.print("<tr><td>Green Card</td><td>75/-</td></tr>");
					}
				}
			}
		}
		else if(request.getRequestURL().equals(new StringBuffer("/flowers.html")))
		//checking if request came from card page
		{
			if(flowers==null)
			//if user selected nothing
			{
				out.print("<html><body style='text-color:white;text-align:center;'><p>You haven't selected anything..!!</p><br>");
				RequestDispatcher rd=request.getRequestDispatcher("home.html");
				rd.include(request, response);
				//sending a message including the home page
			}
			else
			{
				out.print("<h1>WELCOME TO THE BILL PAGE</h1><hr color='black'><br><br>");
				out.print("<table align='center' border='5px'><tr><th>ITEMS</th><th>AMOUNT</th></tr>");
				for(int i=0;i<flowers.length;++i)
				//traversing through the items selected and printing the amount
				{						
					if(flowers[i].equals("lily"))
					{
						out.print("<tr><td>Lily</td><td>40/-</td></tr>");
					}
					else if(flowers[i].equals("rose"))
					{
						out.print("<tr><td>Rose</td><td>20/-</td></tr>");
					}
					else if(flowers[i].equals("lotus"))
					{
						out.print("<tr><td>Lotus</td><td>50/-</td></tr>");
					}
					else if(flowers[i].equals("jas"))
					{
						out.print("<tr><td>Jasmine</td><td>80/-</td></tr>");
					}
					else if(flowers[i].equals("hibi"))
					{
						out.print("<tr><td>Hibiscus</td><td>100/-</td></tr>");
					}
					else if(flowers[i].equals("sun"))
					{
						out.print("<tr><td>Sunflower</td><td>120/-</td></tr>");
					}
				}
				
			}
		}
		else
		{
			out.print("<h1>WELCOME TO THE BILL PAGE</h1><hr color='black'><br><br>");
		}	
		out.print("</table></body></html>");
		//closing html body
	}

}
