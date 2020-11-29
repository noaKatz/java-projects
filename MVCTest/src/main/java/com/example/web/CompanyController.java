package com.example.web;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Game;
import com.example.beans.Player;
import com.example.services.PlayerNotFoundExeption;
import com.example.services.TeamService;

@RestController
@RequestMapping("teams")
public class CompanyController {

	private TeamService service;

	public CompanyController(TeamService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> addPlayer(@RequestBody Player player){
		try {
		service.addPlayer(player);
		return ResponseEntity.ok(player);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("something got wrong, we can't add the player");
		}
	}
	
	@GetMapping("one/{id}")
	public ResponseEntity<?> getPlayer(@PathVariable long id){
		try {
			Player p=service.getPlayerById(id);
			return ResponseEntity.ok(p);
		} catch (PlayerNotFoundExeption e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("allPlayers")
	public List<Player> getAllPlayers(){
		return service.getAllPlayers();
	}
	
	@GetMapping("allByName/{name}")
	public List<Player> getByName(@PathVariable String name){
		return service.getPlayersByName(name);
	}
	
	
	@GetMapping("allGames")
	public List<Game> getAllgames(){
		return service.getAllGames();
	}
}
