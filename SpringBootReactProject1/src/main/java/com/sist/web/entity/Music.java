package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Music {
	@Id
	private int mno;
	private int idcrement;
	private String title,singer,album,poster,state;
}
