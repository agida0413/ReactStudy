package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Food_house;

public interface FoodDAO extends JpaRepository<Food_house, Integer> {

	@Query(value = "SELECT * FROM food_house ORDER BY fno LIMIT :start,12",nativeQuery = true)
	public List<Food_house> foodListData(@Param("start") int start);
	
	public Food_house findByFno(int fno);
	
	@Query(value="SELECT * FROM food_house WHERE address Like Concat('%',:address,'%') "
			+"ORDER BY fno ASC LIMIT :start,12",nativeQuery = true)
	public List<Food_house> foodFindData(@Param("start") int start,@Param("address") String address);

	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM food_house WHERE address Like Concat('%',:address,'%')",nativeQuery = true)
	public int foodFindTotalPage(@Param("address") String address);
	
	
}
