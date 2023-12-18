package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class Requests {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //request_id
    private int requestsId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //manager_id
    private int managerId;

    @Column(name = "type")
	private String type;

	@Column(name = "describtion")
	private String describtion;
	
	@Column(name = "date")
	private String date;

	@Column(name = "status")
	private String status;


    public Requests(int requestsId, int managerId, String type, String describtion, String date, String status) { //Constructor
        this.requestsId = requestsId;
        this.managerId = managerId;
        this.type = type;
        this.describtion = describtion;
        this.date = date;
        this.status = status;
    }

    public int getRequestsId() {
        return requestsId;
    }

    public void setRequestsId(int requestsId) {
        this.requestsId = requestsId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
