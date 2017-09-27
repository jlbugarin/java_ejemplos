/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clienteamq;

import java.util.*;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 *
 * @author pcsijbug
 */
public class ClienteAMQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JMSException {
        // TODO code application logic here
        		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
		// Create a Connection
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// Create a Session
		javax.jms.Session session = connection.createSession(false,
				javax.jms.Session.AUTO_ACKNOWLEDGE);
		// Create the destination
		Destination destination = session.createQueue("UPC.DSD2");
		// Create a MessageConsumer from the Session to the Queue
		MessageConsumer consumer = session.createConsumer(destination);
		// Wait for a message
		Message message = consumer.receive(1000);
		if (message instanceof TextMessage) {
			
                    TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			System.out.println("Text Message is " + text);
			
			
		} else {
			System.out.println(message);
		}
		consumer.close();
		session.close();
		connection.close();
    }
    
}
