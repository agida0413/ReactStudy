package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Music;
import com.sist.web.temp.MusicDAO;
@CrossOrigin(origins = "*")
@RestController
public class MusicRestController {
	@Autowired
	private com.sist.web.dao.MusicDAO dao;
	
	@GetMapping("/music/list")
	public List<Music> musicListdata(){
		System.out.println(dao.musicListData().size());
		return dao.musicListData();
		
	}
}
