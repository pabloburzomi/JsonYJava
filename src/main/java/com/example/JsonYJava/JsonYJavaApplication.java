package com.example.JsonYJava;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JsonYJava.model.Playlist;
import com.example.JsonYJava.model.Song;
import com.example.JsonYJava.model.User;
import com.example.JsonYJava.model.UserPremium;
import com.example.JsonYJava.repositories.IRepository;
import com.example.JsonYJava.repositories.repositoryImpl.JsonRepository;

@SpringBootApplication
public class JsonYJavaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(JsonYJavaApplication.class, args);
		App();
	}

	public static void App() {

		User user1 = new UserPremium("Pablo", "1234", 39);
		User user2 = new UserPremium("Romina", "12345", 30);
		User user3 = new UserPremium("Pedro", "12345", 30);

		Song song1 = new Song("nameSong1", "artistSong1", "albumSong1", 4.2);
		Song song2 = new Song("nameSong2", "artistSong2", "albumSong2", 4.2);
		Song song3 = new Song("nameSong3", "artistSong3", "albumSong3", 3.1);
		
		Playlist playlist1 = user1.createNewPlaylist("playlist1");
		Playlist playlist2 = user1.createNewPlaylist("playlist2");

		Playlist playlist3 = user2.createNewPlaylist("playlist3");

		Playlist playlist4 = user3.createNewPlaylist("playlist4");

		user1.addSongtoPlaylist(playlist1, song1);
		user1.addSongtoPlaylist(playlist1, song2);
		user1.addSongtoPlaylist(playlist1, song3);

		user1.addSongtoPlaylist(playlist2, song1);

		user2.addSongtoPlaylist(playlist3, song1);
		user2.addSongtoPlaylist(playlist1, song2);

		user3.addSongtoPlaylist(playlist4, song1);
		user3.addSongtoPlaylist(playlist1, song2);
		

		IRepository jp = new JsonRepository(); 

		jp.addSong(song1);
		jp.addSong(song2);
		jp.addSong(song3);
		
		jp.addUser(user1);
		jp.addUser(user2);
		jp.addUser(user3);

		jp.addPlaylist(user1);

		jp.addSong(song2);
		
		//jp.writeJSON();
		
		Song songAux = jp.searchSong(1);
		System.out.println(songAux);
		
		User userAux = jp.searchUser(0);
		System.out.println(userAux);
		
		Playlist pAux = jp.searchPlaylistById(1);
		System.out.println(pAux);
		
	}

}
