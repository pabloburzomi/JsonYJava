package com.example.JsonYJava.model;


public class UserPremium extends User{
	
	public UserPremium(String name, String password, int edad) {
		super(name, password, edad);
		this.setPremium(true);
	}

	@Override
	public void play(Playlist p, String songName) {

	}

	@Override
	public void addSongtoPlaylist(Playlist p, Song s) {
		p.addSong(s);
	}

}
