package com.michaelackerman.team_collaboration_api.repository;

import com.michaelackerman.team_collaboration_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
