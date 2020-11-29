package com.example.services;

public class PlayerNotFoundExeption extends Exception {

	public PlayerNotFoundExeption() {
		super("error! player not found");
	}
}
