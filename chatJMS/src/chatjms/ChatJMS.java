/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatjms;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 *
 * @author jbugarinp
 */
public class ChatJMS {

  private MessageProducer producer;
   private String url = ActiveMQConnection.DEFAULT_BROKER_URL;

   private static String subject = "CHAT";
   private JTextField textField;
   private JTextField textFieldNombre;
   private JTextArea textArea;
   private Session session;

   public static void main(String[] args) throws JMSException {
      new ChatJMS();
   }

   public ChatJMS() throws JMSException {
      JFrame frame = new JFrame("chat");
      textArea = new JTextArea(15, 30);
      JScrollPane scrollPane = new JScrollPane(textArea);
      frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

      textField = new JTextField(30);
      frame.getContentPane().add(textField, BorderLayout.SOUTH);

      textFieldNombre = new JTextField(30);
      frame.getContentPane().add(textFieldNombre, BorderLayout.NORTH);

      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      textField.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            MapMessage map;
            try {
               map = session.createMapMessage();
               map.setString("usuario", textFieldNombre.getText());
               map.setString("texto", textField.getText());
               textField.setText("");
               producer.send(map);

            } catch (JMSException e1) {
               e1.printStackTrace();
            }
         }
      });

      activeMQ();
   }

   private void activeMQ() throws JMSException {
      ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
      Connection connection = connectionFactory.createConnection();
      connection.start();

      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      // Destination represents here our queue 'TESTQUEUE' on the
      // JMS server. You don't have to do anything special on the
      // server to create it, it will be created automatically.
      Destination destination = session.createTopic(subject);

      producer = session.createProducer(destination);

      MessageConsumer consumer = session.createConsumer(destination);
      consumer.setMessageListener(new MessageListener() {

         @Override
         public void onMessage(Message message) {
            if (message instanceof MapMessage) {
               MapMessage map = (MapMessage) message;
               try {
                  String usuario = map.getString("usuario");
                  String texto = map.getString("texto");
                  textArea.append(usuario + ": " + texto + "\n");
               } catch (JMSException e) {
                  e.printStackTrace();
               }
            }

         }
      });
   }
}
