package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	public BoardEntity findByNo(int no);	

	@Query(value="SELECT no,subject,name,hit,TO_CHAR(regdate, 'yyyy-MM-dd' as dbday FROM jpaboard ORDER BY no DESC "
		 +"OFFSET :start ROWS FETCH NEXT 10 ROWS ONLY",
		 nativeQuery = true)
	public List<BoardDTO> boardListData(@Param("start") Integer start);
	
	
}