package com.cognizant.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.projectmanager.entity.ParentTask;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {
	
	@Query("select a.parentName from parentTask a where a.parentId= :parentId")
	String getParentNameById(@Param("parentId") Long parentId );
}
