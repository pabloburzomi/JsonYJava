package com.example.JsonYJava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Playlist {

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private Integer id;
	private String name;
	private int size; // verificar
	private List<Song> playList = new ArrayList<Song>();

	public Playlist() {
		this.id = atomicInteger.getAndIncrement();
	}

	public Playlist(String name, int size, List<Song> list) {
		this.id = atomicInteger.getAndIncrement();
		this.name = name;
		this.size = size; // verificar
		this.playList = list;
	}

	@Override
	public String toString() {
		return "{ \"name\": \"" + name + "\", \"size\": " + size + ", \"songs\": " + playList + "}";
	}

	public Integer getId() {
		return this.id;
	}

	public void PlayList(String name) {
		this.name = name;
	}

	public void addSong(Song song) {
		this.playList.add(song);
	}

	public void removeSong(Song song) {
		this.playList.add(song);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) { // verficar
		this.size = size;
	}

	public List<Song> getPlayList() {
		return playList;
	}

	public void setPlayList(List<Song> playList) {
		this.playList = playList;
	}

}
