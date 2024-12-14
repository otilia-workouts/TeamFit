package com.resourcemanagement.team_fit.repository;

import com.resourcemanagement.team_fit.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByEmail(String email);
}
