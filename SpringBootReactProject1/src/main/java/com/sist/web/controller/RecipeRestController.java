package com.sist.web.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.RecipeDAO;
import com.sist.web.dao.RecipedetailDAO;
import com.sist.web.entity.Recipe;
import com.sist.web.entity.Recipedetail;
@CrossOrigin(origins = "*")
@RestController
public class RecipeRestController {
@Autowired 
private RecipeDAO dao;
@Autowired
private RecipedetailDAO rDao;

@GetMapping("/recipe/list_react")
public Map recipeListData(int page)
{
	int rowSize=12;
	int start= (rowSize*page)-(rowSize);
	List<Recipe> list = dao.RecipeListData(start);
	Map map =new HashMap<>();
	int count =(int)dao.count();
	int totalpage=(int)(Math.ceil(count/12.0));
	final int BLOCK=10;
	int startpage=((page-1)/BLOCK*BLOCK)+1;
	int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
	if (endpage>totalpage) {
		endpage=totalpage;
	}
	map.put("list",list);
	map.put("totalpage", totalpage);
	map.put("startpage",startpage);
	map.put("endpage", endpage);
	map.put("count",count);
	map.put("curpage", page);
	
	int size=endpage-startpage;
	int [] paging=new int [30];
	int k=0;
	for(int i=start; i<=size; i++) {
		paging[k]=i;
		k++;
	}
	
	map.put("paging", paging);
	return map;
}

@GetMapping("/recipe/detail_react")
public Map recipeDetaildata(int no)
{ 	Map map =new HashMap<>();
	Recipedetail r= rDao.findByNo(no);
	String[] fm=r.getFoodmake().split("\n");
	List<String>make=new ArrayList<>();
	List<String>image=new ArrayList<>();
	
	for (String food : fm) {
		StringTokenizer st=new StringTokenizer(food,"^");
		make.add(st.nextToken());
		image.add(st.nextToken());
	}
	
	
	map.put("recipe", r);
	map.put("make", make);
	map.put("image", image);
	return map; 
}
}
