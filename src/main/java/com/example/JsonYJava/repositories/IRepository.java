package com.example.JsonYJava.repositories;

import com.example.JsonYJava.model.Playlist;
import com.example.JsonYJava.model.Song;
import com.example.JsonYJava.model.User;

public interface IRepository {

	public void addSong(Song song);

	public void addUser(User user);

	public void addPlaylist(User user);

	public Song searchSong(Integer id);

	public User searchUser(Integer id);

	public Playlist searchPlaylistById(Integer id);

	public void writeJSON();

}
