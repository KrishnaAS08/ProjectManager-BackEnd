package com.cognizant.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.projectmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Modifying
	@Query("UPDATE Task SET status= 'complete' WHERE task_id= :taskId")
	void completeById(@Param("taskId") Long taskId);
	
	@Query("from Task where project_id= :projectId and status!='suspend'")
	List<Task> getTaskById(@Param("projectId") Long projectId);
	
	@Query("select count(task_id) as task_id from Task where project_id= :projectId")
	Long getTaskCount(@Param("projectId") Long projectId);
	
	@Query("select SUM( CASE WHEN status = 'complete' THEN 1 ELSE 0 END ) as status from Task where project_id= :projectId")
	Long getCompletedTaskCount(@Param("projectId") Long projectId);

	@Modifying
	@Query("update Task set status= 'suspend' where project_Id= :projectId")
	void suspendtaskById(@Param("projectId") Long projectId);
	
	@Query("from Task where task_id= :taskId")
	Task getTask(@Param("taskId") Long taskId);
}
