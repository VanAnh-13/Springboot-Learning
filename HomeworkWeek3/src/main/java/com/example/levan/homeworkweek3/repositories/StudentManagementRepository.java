package com.example.levan.homeworkweek3.repositories;

import com.example.levan.homeworkweek3.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentManagementRepository extends JpaRepository<Student, Long> {
}
