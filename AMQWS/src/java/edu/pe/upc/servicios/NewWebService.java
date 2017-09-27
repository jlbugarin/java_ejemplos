/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.pe.upc.servicios;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author pcsijbug
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) throws JMSException {
        //dejar en cola
		// Create a ConnectionFactory
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
        // Create a Connection
       // ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://LC301-06");
        //connectionFactory.setObjectMessageSerializationDefered(true);

        Connection connection = connectionFactory.createConnection();
        connection.start();
        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // Create the destination
        Destination destination = session.createQueue("UPC.DSD2");
        // Create a MessageProducer from the Session to the Queue
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // Create a messages
        TextMessage message = session.createTextMessage(txt);
        producer.send(message);
        session.close();
        connection.close();
        System.out.println("MENSAJE EN COLA ENTREGADO");
        
        return "a";
    }
}
