package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "recipe2")
@NoArgsConstructor
public class Recipe {
@Id
private int no;
private String title,poster,chef;
private int hit;
}
