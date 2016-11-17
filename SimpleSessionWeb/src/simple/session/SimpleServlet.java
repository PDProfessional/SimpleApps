package simple.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = 0;
		System.out.println("request.getSession() >");
		HttpSession session = request.getSession();
		System.out.println("request.getSession() <");
		if(session.getAttribute("count") != null){
			System.out.println("request.getAttribute() >");
			count = (Integer) session.getAttribute("count");
			System.out.println("request.getAttribute() <");
			System.out.println("request.setAttribute() >");
			session.setAttribute("count", count+1);
			System.out.println("request.setAttribute() <");
		}else{
			count = 0;
			System.out.println("request.setAttribute() >");
			session.setAttribute("count", count+1);
			System.out.println("request.setAttribute() <");
		}
		System.out.println(count);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
