package com.seb.roomrentapplication.repository;

import com.seb.roomrentapplication.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByRole(String role);
}
