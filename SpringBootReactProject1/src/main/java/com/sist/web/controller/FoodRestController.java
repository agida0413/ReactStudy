package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.Food_house;

@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
@Autowired
private FoodDAO dao;


@GetMapping("/food/list_react")
public Map foodList(int page) {
	Map map=new HashMap<>();
	int rowsize=12;
	int count=(int)dao.count();
	int totalpage=(int)(Math.ceil(count/12.0));
	int start=(rowsize*page)-(rowsize);
	
	final int BLOCK=10;
	int startpage=(page-1)/(BLOCK*BLOCK)+1;
	int endpage=(page-1)/(BLOCK*BLOCK)+BLOCK;
	
	if(endpage>totalpage) {
		endpage=totalpage;
	}
	List<Food_house> list = dao.foodListData(start);
	
	map.put("list", list);
	map.put("startpage", startpage);
	map.put("endpage", endpage);
	map.put("curpage", page);
	map.put("totalpage", totalpage);
	
	return map;
}


@GetMapping("/food/detail_react")
public Food_house foodDetail(int fno) {
	Food_house vo= dao.findByFno(fno);
return vo;
}

@RequestMapping("/food/find_react")
public Map foodfind(int page,String address) {
	Map map=new HashMap<>();
	int rowsize=12;
	
	int totalpage=dao.foodFindTotalPage(address);
	int start=(rowsize*page)-(rowsize);
	
	final int BLOCK=10;
	int startpage=(page-1)/(BLOCK*BLOCK)+1;
	int endpage=(page-1)/(BLOCK*BLOCK)+BLOCK;
	
	if(endpage>totalpage) {
		endpage=totalpage;
	}
	List<Food_house> list = dao.foodFindData(start, address);
	
	
	map.put("list", list);
	map.put("startpage", startpage);
	map.put("endpage", endpage);
	map.put("curpage", page);
	map.put("totalpage", totalpage);
	
	return map;
}
}
