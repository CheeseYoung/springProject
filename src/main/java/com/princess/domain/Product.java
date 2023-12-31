package com.princess.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.princess.domain.CheckCondition.Display;
import com.princess.domain.CheckCondition.PCategory;
import com.princess.domain.CheckCondition.YorN;

import lombok.Data;
import lombok.ToString;

@DynamicInsert
@Data
@ToString (exclude = {"salesId", "auctionList", "salesList", "reviewList"})
@Entity
public class Product {
	
	@Id @GeneratedValue
	@Column (name = "PNO")
	private Long pNo;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'N'")
	private YorN auction;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'ETC'")
	private PCategory pCategory;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", updatable = false)
	private Member salesId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(length = 2000)
	private String content;
	
	@Column(nullable = false)
	private int price;
	
	@Column(length = 1000)
	private String upload;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'N'")
	private YorN sold;
	
//	@ColumnDefault("1")
	private int AucDuration = 1;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'N'")
	private YorN delivery;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'Y'")
	private Display display;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ColumnDefault("sysdate")
	private Date regdate;
	
	// 연관관계 설정
	
	@OneToMany(mappedBy = "pNo") // Auction
	private List<Auction> auctionList = new ArrayList<Auction>();
	
	@OneToMany(mappedBy = "pNo") // Sales
	private List<Sales> salesList = new ArrayList<Sales>();
	
	@OneToMany(mappedBy = "pNo") // Review
	private List<Review> reviewList = new ArrayList<Review>();
	
	public void setSalesId(Member id) { // Member
		this.salesId = id;
		salesId.getProductList().add(this);
	}
}
