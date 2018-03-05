package com.fsbtech.interviews;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fsbtech.interviews.entities.Event;
import com.fsbtech.interviews.entities.MarketRefType;

public class ClientImpl implements Client {
	private List<Event> eventList;
	
	public ClientImpl(List<Event> eventsList){
		this.eventList = eventsList;
	}
	
	public void addEvent(Event event) {
		eventList.add(event);
	}

	public void eventCompleted(Integer id) {
		Optional<Event> optEvent = eventList.stream().filter(e -> e.getId().equals(id)).findFirst();
		Event event = optEvent.get();
		Event newEvent = new Event(event.getId(), event.getName(), event.getSubCategory(), event.getMarketRefTypes(), true);
		eventList.remove(event);
		eventList.add(newEvent);
	}

	public void attachMarketRefTypeToEvent(Integer id, MarketRefType marketRefType) {
		Optional<Event> optEvent = eventList.stream().filter(e -> e.getId().equals(id)).findFirst();
		Event event = optEvent.get();
		event.getMarketRefTypes().add(marketRefType);
	}

	public void removeMarketRefTypeFromEvent(Integer id, MarketRefType marketRefType) {
		Optional<Event> optEvent = eventList.stream().filter(e -> e.getId().equals(id)).findFirst();
		Event event = optEvent.get();
		event.getMarketRefTypes().remove(marketRefType);
	}

	public Collection<String> futureEventNamesCollection(String cat, String subcat, String marketRefName) {
		return eventList.stream()
				.filter(e -> e.getSubCategory().getCategory().getRef().equals(cat)
						&& e.getSubCategory().getRef().equals(subcat) && e.verifyMarketRefType(marketRefName))
				.map(e -> {return e.getName();})
				.collect(Collectors.toList());
	}

	public String dumpFullStructure() {
		StringBuilder eventInfo = new StringBuilder();
		for (Event event : eventList) {
			eventInfo.append("Name: " + event.getName() + "\n");
			eventInfo.append("Category: " + event.getSubCategory().getCategory().getRef() + "\n");
			eventInfo.append("SubCategory: " + event.getSubCategory().getRef() + "\n");
			eventInfo.append("RefType: " + event.getMarketRefTypes().iterator().next().getMarketRefName() + "\n");
			eventInfo.append("Is Completed: " + event.getCompleted() + "\n\n");
		}
		return eventInfo.toString();
	}
}
