/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasmq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author pcsijbug
 */
public class LeerMensajeCola {
    
   public static void main (String[] pepito) throws JMSException{
    
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        
        Connection connection = connectionFactory.createConnection();
        
        connection.start();
        
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        
        
        Destination destination = session.createQueue("COLA_UPC_EMAIL_2");
        
        MessageConsumer consumer = session.createConsumer(destination);
        
        Message message = consumer.receive(1000);
        
        if (message instanceof TextMessage){
        
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println("MENSAJE RECIBIDO -> "  + text);
        
        }
        
        
        session.close();
        connection.close();
        
        System.out.println("MENSAJE EN COLA ENTREGADO");
   }
    
}
