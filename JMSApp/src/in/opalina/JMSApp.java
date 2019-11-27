package in.opalina;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class JMSApp {
	public static void main(String[] args) {
		JMSContext context = null;
		try {
			JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
			JmsConnectionFactory cf = ff.createConnectionFactory();

			cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, "10.130.0.8");
			cf.setIntProperty(WMQConstants.WMQ_PORT, 1414);
			cf.setStringProperty(WMQConstants.WMQ_CHANNEL, "PORTAQM1.CHANNEL");
			cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_BINDINGS_THEN_CLIENT);
			cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "PORTAQM1");

			 context = cf.createContext();
			//context = (JMSContext) cf.createConnection();
			Queue destination = context.createQueue("PAYSYSREQUEST1");

			JMSProducer producer = context.createProducer();
			TextMessage message = context.createTextMessage("Hello Mq");
			producer.send(destination, message);
			System.out.println("Message Sent Successfully");

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			context.close();
		}
	}
}
