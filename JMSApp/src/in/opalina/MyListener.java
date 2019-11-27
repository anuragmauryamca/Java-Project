package in.opalina;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.Remove;
import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

@MessageDriven(name = "BookMessageHandler", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/BookQueue") })
public class MyListener implements MessageListener {

	@Resource
	private MessageDrivenContext cdctx;

	@EJB
	//LibraryPersistentBeanRemote libraryBean;

	public void LibraryMessageBean() {        
	   }

	/*public void onMessage(Message message) {
	}*/
	
	

	@Override
	public void onMessage(Message arg0) {
		int count = 0;
		try {
			TextMessage textMessage = (TextMessage) arg0;
			System.out.println("Message in Received .." + count + " :" + textMessage.getText().toString());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	Session session = new Session() {

		@Override
		public void unsubscribe(String arg0) throws JMSException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setMessageListener(MessageListener arg0) throws JMSException {
			// TODO Auto-generated method stub

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

		@Override
		public void rollback() throws JMSException {
			// TODO Auto-generated method stub

		}

		@Override
		public void recover() throws JMSException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean getTransacted() throws JMSException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public MessageListener getMessageListener() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getAcknowledgeMode() throws JMSException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Topic createTopic(String arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TextMessage createTextMessage(String arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TextMessage createTextMessage() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TemporaryTopic createTemporaryTopic() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TemporaryQueue createTemporaryQueue() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StreamMessage createStreamMessage() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createSharedDurableConsumer(Topic arg0, String arg1, String arg2) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createSharedDurableConsumer(Topic arg0, String arg1) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createSharedConsumer(Topic arg0, String arg1, String arg2) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createSharedConsumer(Topic arg0, String arg1) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Queue createQueue(String arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageProducer createProducer(Destination arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ObjectMessage createObjectMessage(Serializable arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ObjectMessage createObjectMessage() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Message createMessage() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MapMessage createMapMessage() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TopicSubscriber createDurableSubscriber(Topic arg0, String arg1, String arg2, boolean arg3)
				throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TopicSubscriber createDurableSubscriber(Topic arg0, String arg1) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createDurableConsumer(Topic arg0, String arg1, String arg2, boolean arg3)
				throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createDurableConsumer(Topic arg0, String arg1) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createConsumer(Destination arg0, String arg1, boolean arg2) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createConsumer(Destination arg0, String arg1) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MessageConsumer createConsumer(Destination arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BytesMessage createBytesMessage() throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public QueueBrowser createBrowser(Queue arg0, String arg1) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public QueueBrowser createBrowser(Queue arg0) throws JMSException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void commit() throws JMSException {
			// TODO Auto-generated method stub

		}

		@Override
		public void close() throws JMSException {
			// TODO Auto-generated method stub

		}
	};

}
