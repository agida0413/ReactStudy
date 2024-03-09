package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;

import jakarta.transaction.Transactional;
@CrossOrigin(origins = "*")
@RestController
public class BoardController {
@Autowired
private BoardDAO dao;

@GetMapping("/board/list_react")
public Map boardList(int page) {
Map map =new HashMap<>();
int rowSize=10;
int start= (rowSize*page)-rowSize;

List<BoardVO> list= dao.boardListData(start);
int  count = (int)dao.count();
int totalpage=(int)(Math.ceil(count/10.0));

map.put("curpage", page);
map.put("totalpage", totalpage);
map.put("list", list);

return map;
	
}


@PostMapping("/board/insert_react")
public String insertBoard(Board vo) {
	String result="";
	try {
		
		dao.save(vo);
		result="YES";
	} catch (Exception e) {
		// TODO: handle exception
		result="NO";
	}
	
	return result;
	
}
@Transactional
@GetMapping("/board/detail_react")
public Board boardDetail(int no) {
	Board vo=dao.findByNo(no);
	vo.setHit(vo.getHit()+1);
	dao.save(vo);
	
	return vo;
}

@GetMapping("/board/update_react")
public Board updateS(int no) {
	Board vo = dao.findByNo(no);
	
	return vo;
}

@PostMapping("/board/update_ok_react")
public String boardUpdate(Board vo) {
Board dvo = dao.findByNo(vo.getNo());
String result= "";
if(vo.getPwd().equals(dvo.getPwd())) {
	
	dao.save(vo);
	result="YES";
}
else {
	result="NO";
}


return result;
}

@PostMapping("/board/delete_react")
public String boarddeleet(int no,String pwd) {
	String result="";
	Board vo=dao.findByNo(no);

	if(vo.getPwd().equals(pwd)) {
			dao.delete(vo);
			result="yes";
		
	}
	else {
		result="no";
	}
	return result;
}


}
