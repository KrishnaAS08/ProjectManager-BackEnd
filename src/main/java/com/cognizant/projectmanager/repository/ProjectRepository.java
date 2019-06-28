package com.cognizant.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.projectmanager.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	@Modifying
	@Query("update Project set status='suspend' where project_Id= :projectId")
	void suspendById(@Param("projectId") Long projectId);

	@Query("from Project where status='progress'")
	List<Project> findAllProjects();

	@Query("select projectName from Project where project_id= :projectId")
	String getProjectNameById(@Param("projectId") Long projectId);
}
