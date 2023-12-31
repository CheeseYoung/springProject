package com.princess.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.princess.domain.CheckCondition.Display;
import com.princess.domain.CheckCondition.Role;
import com.princess.domain.CheckCondition.YorN;

import lombok.Data;
import lombok.ToString;

@DynamicInsert 
@Data
@ToString (exclude = {"productList", "boardList", "auctionList", "salesList", "reviewList", "likeWishList", "reportList", "replyList"})
@Entity
public class Member {

	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String nickName;
	
	@Column(nullable = false)
	private String location;
	
	
	private int battery = 50;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String birth;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	@ColumnDefault("'N'")
	@Enumerated(EnumType.STRING)
	private YorN agree;
	
	private int deposit = 0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ColumnDefault("SYSDATE")
	private Date regdate = new Date();
	
	@ColumnDefault("'MEMBER'")
	@Enumerated(EnumType.STRING)
	private Role auth;
	
	@ColumnDefault("'Y'")
	@Enumerated(EnumType.STRING)
	private Display enabled;
	
	// 배터리 0~100 제한
	public void setBattery(int battery) {
        if (battery >= 0 && battery <= 100) {
            this.battery = battery;
        } else if(battery<0){
        	this.battery = 0;
        }else if(battery>100){
        	this.battery = 100;
        }
    }
	
	// 연관관계 설정
	
	@OneToMany(mappedBy = "salesId") // Product
	private List<Product> productList = new ArrayList<Product>();
	
	@OneToMany(mappedBy = "userId",cascade = CascadeType.ALL) // Board
	private List<Board> boardList = new ArrayList<Board>();
	
	@OneToMany(mappedBy = "auctionId") // Auction
	private List<Auction> auctionList = new ArrayList<Auction>();
	
	@OneToMany(mappedBy = "buyer") // Sales
	private List<Sales> salesList = new ArrayList<Sales>();
	
	@OneToMany(mappedBy = "receiver") // Review
	private List<Review> reviewList = new ArrayList<Review>();
	
	@OneToMany(mappedBy = "likeId") // LikeWish
	private List<LikeWish> likeWishList = new ArrayList<LikeWish>();
	
	@OneToMany(mappedBy = "rptId") // Report
	private List<Report> reportList = new ArrayList<Report>();
	
	@OneToMany(mappedBy = "userId") // Reply
	private List<Reply> replyList = new ArrayList<Reply>();
	
	
	
}
