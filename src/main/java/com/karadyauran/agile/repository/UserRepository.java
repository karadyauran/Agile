package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findByName(String username);

    @NotNull
    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    Optional<User> findById(@NotNull UUID userId);
}
