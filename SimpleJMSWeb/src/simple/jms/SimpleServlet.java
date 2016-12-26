package simple.jms;

import java.io.IOException;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
public class SimpleServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet() {
        super();
    }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                System.out.println("simple.jms.SimpleServlet.doGet() >");
                QueueReceiver receiver =null;
                QueueSession session = null;
                QueueConnection connection = null;
                try {
                        InitialContext  ctx = new InitialContext();
                        QueueConnectionFactory qcf = (QueueConnectionFactory)ctx.lookup("java:comp/env/jms/SimpleQCF");
                        Queue q = (Queue)ctx.lookup("java:comp/env/jms/SimpleQ");
                        connection = qcf.createQueueConnection();
                        connection.start();
                        boolean transacted = false;
                        session = connection.createQueueSession( transacted, Session.AUTO_ACKNOWLEDGE);
                        receiver = session.createReceiver(q);
                        Message message = receiver.receive(10*1000);
                        if (message != null) {
                                if (message instanceof TextMessage) {
                                        TextMessage     msg = (TextMessage) message;
                                        System.out.println("get message: " + msg.getText());
                                } else {
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }finally {
                        try{
                                if (receiver != null)receiver.close();
                                if (session != null)session.close();
                                if (connection != null)connection.close();
                        }catch(Exception e){
                                e.printStackTrace();
                        }
                }
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                System.out.println("simple.jms.SimpleServlet.doGet()<");
        }

 

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                System.out.println("simple.jms.SimpleServlet.doPost()>");
                QueueSender sender =null;
                QueueSession session = null;
                QueueConnection connection = null;
                try {
                        InitialContext  ctx = new InitialContext();
                        QueueConnectionFactory qcf = (QueueConnectionFactory)ctx.lookup("java:comp/env/jms/SimpleQCF");
                        Queue q = (Queue)ctx.lookup("java:comp/env/jms/SimpleQ");
                        connection = qcf.createQueueConnection();
                        connection.start();
                        boolean transacted = false;
                        session = connection.createQueueSession( transacted, Session.AUTO_ACKNOWLEDGE);
                        sender = session.createSender(q);
                        System.out.println("put message: " + request.getParameter("message"));
                        TextMessage message = session.createTextMessage(request.getParameter("message"));
                        sender.send(message);
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
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                System.out.println("simple.jms.SimpleServlet.doPost()<");
        }
}