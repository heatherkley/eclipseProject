package eclipseproject;

import org.junit.Test;

public class Tests extends Spotify {

	
	@Test
	public void InvalidLogin() throws Exception {
		System.out.println("InvalidLogin test beginning");
		openApp();
		IncorrectLogin();
		closeApp();
		System.out.println("InvalidLogin test ended");
	}
	
	@Test
	public void ValidLogin() throws Exception {
		System.out.println("ValidLogin test beginning");
		openApp();
		validLogin();
		logout();
		closeApp();
		System.out.println("ValidLogin test ended");
	}
	
	@Test
	public void Artistsearch () throws Exception {
		System.out.println("ArtistSearch test beginning");
		openApp();
		validLogin();
		searchArtist();
		logout();
		closeApp();
		System.out.println("ArtistSearch test ended");
	}

	@Test
	public void searchAndPlay () throws Exception {
		System.out.println("SearchandPlay test beginning");
		openApp();
		validLogin();
		searchAndPlaySong();
		logout();
		closeApp();
		System.out.println("SearchandPlay test ended");
	}
	
	@Test
	public void createNewRadioStation () throws Exception {
		System.out.println("CreateNewRadioStation test beginning");
		openApp();
		validLogin();
		createNewStation();
		logout();
		closeApp();
		System.out.println("CreateNewRadioStation test ended");
	}
	
}
