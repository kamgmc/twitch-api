package name.name2;

import static org.toilelibre.libe.curl.Curl.curl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameSearch {
	private String clientID = null;
	private String OAuth = null;
	private Integer imgSize = 500;
	
	public GameSearch(String clientID, String OAuth) {
		this.clientID = clientID;
		this.OAuth = OAuth;
	}
	
	public void setImgSize(int size) {
		this.imgSize = size;
	}
	
	public void connect() {
		String conectionUrl = "-H 'Authorization: OAuth " + this.OAuth+ "' https://id.twitch.tv/oauth2/validate";
		try {
			curl(conectionUrl);
			System.out.println("Connection Stableshed");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection Error");
		}
	}
	
	public Game byID (int id) {
		String searchIdUrl = "-H 'Client-ID: " + this.clientID + "' -X GET 'https://api.twitch.tv/helix/games?id=" + id + "'";
		try {
			HttpResponse response = curl(searchIdUrl);
			try {
				JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
				JSONArray data = json.getJSONArray("data");
				if(data != null) {
		    	    JSONObject dataObject = data.getJSONObject(0);
		    	    String imgUrl = dataObject.getString("box_art_url").replace("{width}", this.imgSize.toString()).replace("{height}", this.imgSize.toString());
		    	    Game game = new Game(dataObject.getInt("id"), dataObject.getString("name"), imgUrl);
		    	    return game;
		    	}
				else {
					return null;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Game byName (String name) {
		String searchNameUrl = "-H 'Client-ID: " + this.clientID + "' -X GET 'https://api.twitch.tv/helix/games?name=" + name + "'";
		try {
			HttpResponse response = curl(searchNameUrl);
			try {
				JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
				JSONArray data = json.getJSONArray("data");
				if(data != null) {
		    	    JSONObject dataObject = data.getJSONObject(0);
		    	    String imgUrl = dataObject.getString("box_art_url").replace("{width}", this.imgSize.toString()).replace("{height}", this.imgSize.toString());
		    	    Game game = new Game(dataObject.getInt("id"), dataObject.getString("name"), imgUrl);
		    	    return game;
		    	}
				else {
					return null;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
