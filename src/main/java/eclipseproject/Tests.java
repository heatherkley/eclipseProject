package eclipseproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests extends Spotify {

	
//	@Test
//	public void testLoginInvalid() throws Exception {
//		openApp();
//		IncorrectLogin();
//		closeApp();
//	}
//	
//	@Test
//	public void testLoginValid() throws Exception {
//		openApp();
//		validLogin();
//		logout();
//		closeApp();
//	}
	
//	@Test
//	public void search () throws Exception {
//		openApp();
//		validLogin();
//		searchArtist();
//		logout();
//		closeApp();
//	}

	@Test
	public void searchAndPlay () throws Exception {
		openApp();
		validLogin();
		//searchArtist();
		//closeApp();
		//openApp();
		//searchAndPlaySong();
		logout();
		closeApp();
	}
	
}
