package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.RecipeDAO;
import com.sist.web.entity.Recipe;
@CrossOrigin(origins = "*")
@RestController
public class MainRestController {
	
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("/")
	public List<Recipe> recipemain(){
		return dao.RecipeListData(0);
	}
}
