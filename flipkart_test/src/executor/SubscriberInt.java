package executor;

import java.util.List;

import consumer.Subscriber;
import model.Message;
import model.State;

public interface SubscriberInt {
  public void registerSubscriber(Subscriber subscriber, State state);
  public void deregisterSubscriber(Subscriber subscriber, State state);
  public void notifySubscriber(List<Subscriber> subscribers, Message message);
}
