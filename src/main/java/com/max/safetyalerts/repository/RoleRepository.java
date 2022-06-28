package com.max.safetyalerts.repository;


import com.max.safetyalerts.model.ERole;
import com.max.safetyalerts.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
