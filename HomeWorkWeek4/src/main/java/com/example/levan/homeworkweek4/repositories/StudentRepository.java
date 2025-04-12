package com.example.levan.homeworkweek4.repositories;

import com.example.levan.homeworkweek4.models.Student;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<List<Student>> findByFullNameContainingIgnoreCase(@NonNull String name);

    Optional<Student> findByPhoneNumber(@NonNull String phoneNumber);
}
