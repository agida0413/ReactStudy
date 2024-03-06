package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * FNO int PK 
POSTER text 
NAME text 
TYPE text 
ADDRESS text 
PHONE text 
SCORE double 
THEME text 
PRICE text 
TIME text 
SEAT text 
CONTENT text 
LINK text 
HIT int
 */
@Entity
@Data
@NoArgsConstructor
public class Food_house {
	@Id
	private int fno;
	private String poster,name,type,address,phone;
	private double score;
	private String theme;
	private String price,time,seat,content,link;
	private int hit;

}
