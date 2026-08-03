package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.web.entity.*;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	public BoardEntity findByNo(int no);	

	@Query(value="SELECT * FROM board ORDER BY no DESC "
		 +"OFFSET :start ROWS FETCH NEXT 10 ROWS ONLY",
		 nativeQuery = true) // SQL을 JPQL로 변경없이 문장 그대로 수행
	public List<BoardEntity> boardListData(@Param("start") Integer start);
	
	
}