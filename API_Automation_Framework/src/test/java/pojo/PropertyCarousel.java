package pojo;

import java.util.List;

public class PropertyCarousel {
	List<SearchCriteriaPojo> searchCriteria;
	private String checkIn;
	private String checkOut;
	private String sortBy;
	private String sortOrder;
	private String pageNo;
	private String pageSize;
	
	
	public List<SearchCriteriaPojo> getSearchCriteria() {
		return searchCriteria;
	}
	public  void setSearchCriteria(List<SearchCriteriaPojo> search) {
		this.searchCriteria = search;
	}
	
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
	
}
