package com.example.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Game;

public interface GameReposetory extends JpaRepository<Game, Long> {

}
