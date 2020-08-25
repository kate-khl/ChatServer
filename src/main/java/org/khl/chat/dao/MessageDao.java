package org.khl.chat.dao;

import org.khl.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageDao extends JpaRepository<Message, Long> {

}
