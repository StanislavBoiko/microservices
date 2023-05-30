package com.example.messageconsumerservice.repositories;

import com.example.messageconsumerservice.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
