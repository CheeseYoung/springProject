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

import com.princess.domain.CheckCondition.CmCategory;
import com.princess.domain.CheckCondition.Display;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "userId")
@Entity
public class Board {
	
	@Id @GeneratedValue
	@Column(name = "POSTNUM")
	private Long postNum;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'ETC'")
	private CmCategory cmCategory;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false, updatable = false)
	private Member userId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(length = 1000)
	private String photoPath;
	
	private Long great;
	
	@Enumerated(EnumType.STRING)
	@ColumnDefault("'Y'")
	private Display display;
	
	@Temporal(TemporalType.DATE)
	@ColumnDefault("sysdate")
	private Date regdate;
	
	// 연관관계 설정
	
	@OneToMany (mappedBy = "postNum")
	private List<Reply> replyList = new ArrayList<Reply>();
	
	public void setUserId (Member id) { // Member
		this.userId = id;
		userId.getBoardList().add(this);
	}
	
}
