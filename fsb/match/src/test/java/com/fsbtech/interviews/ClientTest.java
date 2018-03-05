package com.fsbtech.interviews;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fsbtech.interviews.Client;
import com.fsbtech.interviews.ClientImpl;
import com.fsbtech.interviews.entities.Category;
import com.fsbtech.interviews.entities.Event;
import com.fsbtech.interviews.entities.MarketRefType;
import com.fsbtech.interviews.entities.SubCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientTest {
	private static Client client;
	
	@BeforeClass
	public static void setUp(){
		client = new ClientImpl(new ArrayList());
	}
	
	@Test
	public void aAddEvent(){
		Category cat = new Category(1, "Football");
		SubCategory subCat = new SubCategory(1, "Premier League", cat);
		
		List<MarketRefType> marketRefTypes = new ArrayList<MarketRefType>();
		marketRefTypes.add(new MarketRefType(1, "Away"));
		marketRefTypes.add(new MarketRefType(2, "Home"));
		marketRefTypes.add(new MarketRefType(3, "Draw"));
		Event event = new Event(1, "Manchester United v Arsenal", subCat, marketRefTypes, false);
		
		marketRefTypes = new ArrayList<MarketRefType>();
		marketRefTypes.add(new MarketRefType(2, "Home"));
		marketRefTypes.add(new MarketRefType(2, "Draw"));
		Event event2 = new Event(2, "Chelsea v Tottenham", subCat, marketRefTypes, false);
		
		client.addEvent(event);
		client.addEvent(event2);
	}
	
	@Test
	public void bRemoveMarketRefTypeFromEventTest(){
		MarketRefType marketRefType = new MarketRefType(2, "Home");
		client.removeMarketRefTypeFromEvent(1, marketRefType);
	}
	
	@Test
	public void cAttachMarketRefTypeToEventTest(){
		MarketRefType marketRefType = new MarketRefType(2, "Home");
		client.attachMarketRefTypeToEvent(1, marketRefType);
	}
	
	@Test
	public void dEventCompletedTest(){
		client.eventCompleted(1);
	}
	
	@Test
	public void eFutureEventNamesCollectionTest(){
		Collection<String> eventName = client.futureEventNamesCollection("Football", "Premier League", "Away");
		Assert.assertEquals(1, eventName.size());
	}
	
	@Test
	public void fDumpFullStructureTest(){
		String structure = client.dumpFullStructure();;
		Assert.assertNotNull(structure);
	}
}
