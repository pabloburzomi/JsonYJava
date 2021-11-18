package com.example.JsonYJava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class User {

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private Integer id;
	private String name;
	private String password;
	private int edad;
	private List<Playlist> playlistList;
	private boolean isPremium;

	public User(String name, String password, int edad) {

		this.id = atomicInteger.getAndIncrement();
		this.name = name;
		this.password = password;
		this.edad = edad;
		this.playlistList = new ArrayList<Playlist>();
	}

	@Override
	public String toString() {
		return "{ \"name\": \"" + name + "\", \"password\": \"" + password + "\", \"edad\": " + edad + "}";
	}

	public abstract void play(Playlist p, String songName);

	public Playlist createNewPlaylist(String name) {
		Playlist playlist = new Playlist();
		playlist.setName(name);
		this.playlistList.add(playlist);
		return playlist;
	}

	public void playShuffle(Playlist p) {

	}

	public abstract void addSongtoPlaylist(Playlist p, Song s);

	public void removeSongtoPlaylist(Playlist p, Song s) {
		p.removeSong(s);
	}

	public List<Playlist> getPlaylistList() {
		return playlistList;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public boolean isPremium() {
		return isPremium;
	}

}
