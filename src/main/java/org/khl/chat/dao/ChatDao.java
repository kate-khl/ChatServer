package org.khl.chat.dao;

import java.util.List;

import org.khl.chat.entity.Chat;
import org.khl.chat.entity.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDao  extends JpaRepository<Chat, Long> {

	List<Chat> findByUsersId(Long id);
}
