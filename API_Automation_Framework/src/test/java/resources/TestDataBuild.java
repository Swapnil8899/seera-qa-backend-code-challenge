package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.PropertyCarousel;
import pojo.SearchCriteriaPojo;

public class TestDataBuild {
	
	public PropertyCarousel  property(String checkIn, String checkOut, String sortBy, String sortOrder) {
		PropertyCarousel Carousel = new PropertyCarousel();
		
		SearchCriteriaPojo search = new SearchCriteriaPojo();
		search.setLookupTypeId(2);
		List<Integer> lookup = new ArrayList<Integer>(9);
		lookup.add(9);
		search.setLookupId(lookup);
		List<SearchCriteriaPojo> finalPojo = new ArrayList<SearchCriteriaPojo>();
		finalPojo.add(search);
		//finalPojo.add(lookup);
		Carousel.setSearchCriteria(finalPojo);
		
		Carousel.setCheckIn(checkIn);
		Carousel.setCheckOut(checkOut);
		Carousel.setPageNo("1");
		Carousel.setPageSize("10");
		Carousel.setSortBy(sortBy);
		Carousel.setSortOrder(sortOrder);
		
		
		
		return Carousel;
	}
	
}
