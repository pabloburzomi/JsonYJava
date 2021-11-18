package com.example.JsonYJava.repositories.repositoryImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.example.JsonYJava.model.Playlist;
import com.example.JsonYJava.model.Song;
import com.example.JsonYJava.model.User;
import com.example.JsonYJava.model.UserPremium;
import com.example.JsonYJava.repositories.IRepository;

public class JsonRepository implements IRepository {

	private JSONObject j = new JSONObject();
	private static JSONObject playlists = new JSONObject();
	private static JSONObject users = new JSONObject();
	private static JSONObject songs = new JSONObject();

	@Override
	public void addSong(Song song) {
		songs.put(song.getId().toString(), song); // este id debe ser String por ser una key
	}

	@Override
	public void addPlaylist(User user) {
		for (Playlist playlist : user.getPlaylistList()) {
			playlists.put(playlist.getId().toString(), playlist);
		}
	}

	@Override
	public void addUser(User user) {
		users.put(user.getId().toString(), user); // Este id debe ser String por ser una key
	}

	// La lectura del JSON se realiza sobre un archivo distinto que la escritura,
	// solo para prevenir posibles conflictos.
	@Override
	public User searchUser(Integer id) {
		JSONParser parser = new JSONParser();
		JSONObject u = new JSONObject();
		JSONObject uAux = new JSONObject();

		Object obj;
		try {
			obj = parser.parse(new FileReader("./src/app2.json"));
			JSONObject users = (JSONObject) obj;

			u = (JSONObject) users.get("Users");
			uAux = (JSONObject) u.get(id.toString());

		} catch (Exception e) {

		}
		return new UserPremium(uAux.get("name").toString(), uAux.get("password").toString(),
				Integer.valueOf(uAux.get("edad").toString()));
	}

	public Song searchSong(Integer id) {

		JSONParser parser = new JSONParser();
		JSONObject s = new JSONObject();
		JSONObject sAux = new JSONObject();
		Object obj;
		try {
			obj = parser.parse(new FileReader("./src/app2.json"));
			JSONObject songs = (JSONObject) obj;
			s = (JSONObject) songs.get("Songs");
			sAux = (JSONObject) s.get(id.toString());

		} catch (Exception e) {

		}
		return new Song(sAux.get("name").toString(), sAux.get("artist").toString(), sAux.get("album").toString(),
				Double.valueOf(sAux.get("duration").toString()));
	}

	@Override
	public Playlist searchPlaylistById(Integer id) {
		List<Song> songsAux;
		JSONParser parser = new JSONParser();
		JSONObject p = new JSONObject();
		JSONObject pAux = new JSONObject();
		Object obj;
		try {
			obj = parser.parse(new FileReader("./src/app2.json"));
			JSONObject playlist = (JSONObject) obj;

			p = (JSONObject) playlist.get("Playlists");
			pAux = (JSONObject) p.get(id.toString());

			songsAux = new ArrayList<Song>();
			songsAux = (List<Song>) pAux.get("songs");
			
			 return new Playlist(pAux.get("name").toString(),
			 Integer.valueOf(pAux.get("size").toString()), songsAux);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void writeJSON() {

		j.put("Songs", songs);
		j.put("Playlists", playlists);
		j.put("Users", users);

		try {
			File file = new File("./src/app1.json");
			String strJson = j.toString();
			FileUtils.writeStringToFile(file, strJson, "UTF-8", true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
