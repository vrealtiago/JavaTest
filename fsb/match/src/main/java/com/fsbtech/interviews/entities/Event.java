package com.fsbtech.interviews.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public class Event implements Serializable
{
    private final Integer id;
    private final String name;
    private final SubCategory subCategory;
    private final Collection<MarketRefType> marketRefTypes;
    private final Boolean completed;

    public Event(Integer id, String name, SubCategory subCategory, Collection<MarketRefType> marketRefTypes, Boolean completed)
    {
        this.id = id;
        this.name = name;
        this.subCategory = subCategory;
        this.marketRefTypes = marketRefTypes;
        this.completed = completed;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public SubCategory getSubCategory()
    {
        return subCategory;
    }

    public Boolean getCompleted() 
    { 
	return completed; 
    }
    
    public Collection<MarketRefType> getMarketRefTypes() {
		return marketRefTypes;
	}
    
    public boolean verifyMarketRefType(String nameMarket){
    	Optional<MarketRefType> optMarketRefType = marketRefTypes.stream().filter(m -> m.getMarketRefName().equals(nameMarket)).findFirst();
    	return optMarketRefType.isPresent();
    }
    
}
