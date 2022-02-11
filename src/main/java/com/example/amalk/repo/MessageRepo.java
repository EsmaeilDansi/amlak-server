package com.example.amalk.repo;

import com.example.amalk.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

}
