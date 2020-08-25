package org.khl.chat.dao;

import org.khl.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao  extends JpaRepository<User, Long> {

}
