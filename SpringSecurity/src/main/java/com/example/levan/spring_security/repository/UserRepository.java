package com.example.levan.spring_security.repository;

import com.example.levan.spring_security.domain.entity.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT user FROM User user WHERE user.id = ?1")
    @Nonnull
    Optional<User> findById(@Nonnull String id);

    Optional<User> findByUsername(String username);
}
