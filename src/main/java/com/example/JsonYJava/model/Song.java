package com.example.JsonYJava.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Song {

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private Integer id;
	private String name;
	private String artist;
	private String album;
	private double duration;

	public Song() {

	}

	public Song(String nombre, String artista, String album, double duracion) {
		super();
		this.id = atomicInteger.getAndIncrement();
		this.name = nombre;
		this.artist = artista;
		this.album = album;
		this.duration = duracion;
	}

	@Override
	public String toString() {
		return "{ \"id\": \"" + id + "\", \"name\": \"" + name + "\", \"artist\": \"" + artist + "\", \"album\": \""
				+ album + "\", \"duration\": " + duration + "}";
	}

	public String getName() {
		return this.name;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public double getDuration() {
		return duration;
	}

	public Integer getId() {
		return this.id;
	}

}
