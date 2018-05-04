package name.name2;

public class App 
{
    public static void main( String[] args )
    {
    	//Begin a connection with the Twitch Server using Client ID and AOUth 
    	GameSearch search = new GameSearch("3l4yov6lh1qodeaesmor0220lzuxoa", "fencxs08zo08f5pl6jinswdzknqonh");
    	search.connect();
    	Game game = search.byName("dota+2");
    	System.out.println("ID: " + game.getId());
    	System.out.println("Name: " + game.getName());
    	System.out.println("Image: " + game.getBox_art_url());
    }
}
