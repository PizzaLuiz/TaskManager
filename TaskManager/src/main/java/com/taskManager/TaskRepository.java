package com.taskManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends JpaRepository<Task, Long>, CrudRepository <Task,Long> {

}
