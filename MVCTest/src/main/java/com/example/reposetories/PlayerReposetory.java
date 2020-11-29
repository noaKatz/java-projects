package com.example.reposetories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Player;

public interface PlayerReposetory extends JpaRepository<Player, Long> {

	List<Player> findByName(String name);
}
