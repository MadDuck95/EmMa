package de.emma.model;

public class Calendar {
	public String calId;
    public String calTitle;
    public String startDate;
    public String endDate;
    

    public String getCalId() {
        return calId;
    }
    public void setCalId(String id) {
        this.calId = id;
    }
    public String getCalTitle() {
        return calTitle;
    }
    public void setCalTitle(String calTitle) {
        this.calTitle = calTitle;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
