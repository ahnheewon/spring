package com.example.demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor // 생성자
@AllArgsConstructor // 생성자
public class Customer	{ //DB 생성
				
				@Id
				@GeneratedValue(strategy	=	GenerationType.AUTO)
				private Long	id;
				@Column(length	=	20,	nullable	=	false)
				private String	name; 
				@Column(length	=	20,	nullable	=	false,	unique	=	false)
				private String	phone;
				
				//Column은 필수가 아니고 사이즈 조절 및 constraint 설정
				private String addr;
				
				//@ManyToOne() 일대다
				//List<E>
				
				
}