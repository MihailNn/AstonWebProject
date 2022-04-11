package com.aston.mihail.dao;

import com.aston.mihail.model.Owner;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface OwnerDao {
    Owner findByEmail (String email);
    Owner save (Owner owner);
    Set<Owner> findAll();
    Owner delete (int id);
}
//    long insertTask(Task task) throws SQLException;
//
//    Optional<Task> findById(Long id) throws SQLException;
//
//    int updateTaskExecutor(Task model, String executor_username) throws SQLException;
//
//    int update(Task task) throws SQLException;
//
//    List<Task> findAllByPrimaryKey(Object pkey) throws SQLException;
//
//    List<Task> findAll() throws SQLException;
//
//    long insertTaskWithoutGoal(Task task, String executor_username) throws SQLException;
//
//    long insertTaskWithGoal(Task task, String executor_username) throws SQLException;
//
//    int deleteTaskById(Long task_id) throws SQLException;