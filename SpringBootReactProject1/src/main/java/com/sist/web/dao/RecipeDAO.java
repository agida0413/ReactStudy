package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Recipe;

@Repository
public interface RecipeDAO extends JpaRepository<Recipe, Integer>{

@Query(value="SELECT * FROM recipe2 " 
		+"ORDER BY no DESC LIMIT :start,12",nativeQuery = true)
public List<Recipe> RecipeListData(@Param("start") int start);
//count() =>count(*)
//save = > insert,updaet
//delete = > delete 

}
