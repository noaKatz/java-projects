package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.beans.Game;
import com.example.beans.Player;
import com.example.reposetories.GameReposetory;
import com.example.reposetories.PlayerReposetory;

@Service
public class TeamService {

	private PlayerReposetory playerReposetory;
	private GameReposetory gameReposetory;
	
	public TeamService(PlayerReposetory playerReposetory, GameReposetory gameReposetory) {
		super();
		this.playerReposetory = playerReposetory;
		this.gameReposetory = gameReposetory;
	}
	
	public void addPlayer(Player player) {
		playerReposetory.save(player);
	}
	
	public Player getPlayerById(long id) throws PlayerNotFoundExeption {
		return playerReposetory.findById(id).orElseThrow(PlayerNotFoundExeption :: new);
	}
	
	public List<Player> getPlayersByName(String name) {
		return playerReposetory.findByName(name);
	}
	
	public List<Player> getAllPlayers(){
		return playerReposetory.findAll();
	}
	
	public List<Game> getAllGames(){
		return gameReposetory.findAll();
	}
	
}
