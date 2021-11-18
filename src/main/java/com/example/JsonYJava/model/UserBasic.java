package com.example.JsonYJava.model;


public class UserBasic extends User{
	
	public UserBasic(String name, String password, int edad) {
		super(name, password, edad);
		this.setPremium(false);
		
	}

	@Override
	public void play(Playlist p, String songName) {
		this.playShuffle(p);
	}

	@Override
	public void addSongtoPlaylist(Playlist p, Song s) {
		if(p.getSize() <= 30) {
			p.addSong(s);
		}
	}

}
