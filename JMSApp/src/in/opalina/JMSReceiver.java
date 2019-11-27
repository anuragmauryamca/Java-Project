package in.opalina;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class JMSReceiver {
	public static void main(String[] args) {
		try {
			JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
			JmsConnectionFactory cf = ff.createConnectionFactory();

			cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, "10.130.0.8");
			cf.setIntProperty(WMQConstants.WMQ_PORT, 1414);
			cf.setStringProperty(WMQConstants.WMQ_CHANNEL, "PORTAQM1.CHANNEL");
			cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_BINDINGS_THEN_CLIENT);
			cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "PORTAQM1");

			JMSContext context = cf.createContext();

			// JMSContext context = (JMSContext) cf.createConnection();

			Queue destination = context.createQueue("PAYSYSREQUEST1");
			// 4)create QueueReceiver
			JMSConsumer consumer = context.createConsumer(destination);

			// 5) create listener object
			MyListener listener = new MyListener();

			// 6) register the listener object with receiver
			consumer.setMessageListener(listener);

			System.out.println("Receiver1 is ready, waiting for messages...");

			while (true) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
