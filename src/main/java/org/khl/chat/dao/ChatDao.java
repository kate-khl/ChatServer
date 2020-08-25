package org.khl.chat.dao;

import org.khl.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDao  extends JpaRepository<Chat, Long> {

}
