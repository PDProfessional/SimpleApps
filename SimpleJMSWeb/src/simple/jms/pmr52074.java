// JMS transaction support check
package simple.jms;

import java.io.IOException;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pmr52074
 */
@WebServlet("/pmr52074")
public class pmr52074 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pmr52074() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("simple.jms.pmr52074.doPost()>");
        QueueSender sender =null;
        QueueSession session = null;
        QueueConnection connection = null;
        try {
                InitialContext  ctx = new InitialContext();
                QueueConnectionFactory qcf = (QueueConnectionFactory)ctx.lookup("java:comp/env/jms/SimpleQCF");
                Queue q = (Queue)ctx.lookup("java:comp/env/jms/SimpleQ");
                connection = qcf.createQueueConnection();
                connection.start();
                boolean transacted = true;
                session = connection.createQueueSession( transacted, Session.AUTO_ACKNOWLEDGE);
                sender = session.createSender(q);
                System.out.println("put message: " + request.getParameter("message"));
                TextMessage message = session.createTextMessage(request.getParameter("message"));
                sender.send(message);
                session.commit();
        } catch (Exception e) {
                e.printStackTrace();
        }finally {
                try{
                        if (sender != null)sender.close();
                        if (session != null) session.close();
                        if (connection != null)connection.close();
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        System.out.println("simple.jms.pmr52074.doPost()<");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
