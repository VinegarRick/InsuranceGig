package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}
