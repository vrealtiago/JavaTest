/*
 * Created on 02-Feb-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package subscribers;

import java.util.*;

public class SubscriberExtent {
	static Map subscribers = new Hashtable();
	static int idCounter = 0;
	public static SubscriberExtent INSTANCE = new SubscriberExtent();
	
	public static String getNextId() {
		return "S" + (idCounter++);
	}
	
	private SubscriberExtent() {
		// Initialise and register library subscribers
		createSubscriber(new Pensioner(getNextId(), "Bill"));
		createSubscriber(new Pensioner(getNextId(), "Elsie"));
		createSubscriber(new Student(getNextId(), "Zach", "De Montfort University"));
		createSubscriber(new Student(getNextId(), "Amelia", "Christchurch College"));
	}
	
	public void createSubscriber(Subscribers subs) {
		subscribers.put(subs.getId(), subs);
	}
	
	public Subscribers findByPrimaryKey(String id) {
		return (Subscribers) subscribers.get(id);
	}

	public Collection getSubscribers() {
		return subscribers.values();
	}
}
