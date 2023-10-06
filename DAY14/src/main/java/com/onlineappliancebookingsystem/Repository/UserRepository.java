package com.onlineappliancebookingsystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineappliancebookingsystem.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);

    User findByUid(Long uid);

    void deleteByUid(Long uid);

}

