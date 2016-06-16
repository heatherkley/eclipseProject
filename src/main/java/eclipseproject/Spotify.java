package eclipseproject;

import org.sikuli.script.*;
import org.sikuli.basics.*;

public class Spotify {
	
	
	String correctUsername = "freeeaccountt" ;
	String incorrectPassword = "incorrectPassword" ;
	String correctPassword = "freeaccount";
	Screen s = new Screen(); 
	Pattern password = new Pattern("src/main/resources/password.png");
	Pattern loginImage = new Pattern("src/main/resources/LoginImage.png");
	Pattern login = new Pattern ("src/main/resources/login.png");
	Pattern loginError = new Pattern("src/main/resources/loginError.png");
	Pattern openMacSpotify = new Pattern("src/main/resources/openMacSpotify.png");
	Pattern openWinSpotify = new Pattern("src/main/resources/openWinSpotify.png");
	Pattern incorrectPasswordPNG = new Pattern("src/main/resources/incorrectPassword.png");
	Pattern userLoginSuccessful = new Pattern ("src/main/resources/userLoginSuccessful.png");
	Pattern close = new Pattern("src/main/resources/close.png");
	Pattern macClose = new Pattern ("src/main/resources/macClose.png");
	Pattern menu = new Pattern ("src/main/resources/menu.png");
	Pattern logOut = new Pattern ("src/main/resources/logOut.png");
	Pattern search = new Pattern ("src/main/resources/search.png");
	Pattern m83 = new Pattern ("src/main/resources/m83.png");
	Pattern artistM83 = new Pattern ("src/main/resources/m83scroll.png");
	Pattern songTitle = new Pattern ("src/main/resources/songTitle.png").targetOffset(30,0);
	Pattern paused = new Pattern ("src/main/resources/paused.png");
	Pattern playing = new Pattern ("src/main/resources/playing.png");
	Pattern radio = new Pattern ("src/main/resources/radio.png");
	Pattern createNew = new Pattern ("src/main/resources/createNew.png");
	Pattern searchRadio = new Pattern ("src/main/resources/searchRadio.png");
	Pattern deadmau5 = new Pattern ("src/main/resources/deadmau5.png");
	Pattern artistStation = new Pattern ("src/main/resources/artistRadioDeadmau5.png");
	Pattern settings = new Pattern ("src/main/resources/settings.png");
	Pattern backToLogin = new Pattern ("src/main/resources/backToLogin.png");
	Pattern spoon = new Pattern ("src/main/resources/spoon.png");
	Pattern playSong = new Pattern ("src/main/resources/playSong.png").similar((float) 0.99);
	//  no pattern needed for Username bc the system will autogenerate the last given username at app opening
	
	
	public static void main(String[]args) throws Exception {

	}
		
		public void openApp() throws Exception {
		
			if (s.exists(openMacSpotify, 5) !=null)
				s.doubleClick(openMacSpotify);
			else if(s.exists(openWinSpotify) !=null)
				s.click(openWinSpotify);
			System.out.println("Spotify Opening");
		}
	
		public void closeApp() throws Exception {
			if (s.exists(close) !=null){
				s.click(close);	}
		
			System.out.println("Success: Application closed");	
		}
		
		public void logout() throws Exception{
			s.exists(menu, 25); 
			s.click(menu);	
			s.exists(logOut, 5); 
			s.doubleClick(logOut);	
			s.exists(loginImage, 55); //verifies the user is taken back to the login page
			System.out.println("Success: User logged out!");
		}
		
		public void IncorrectLogin()throws Exception{
			
			System.out.println("spotify opening");	
			s.wait(loginImage, 30); //Waits a max 30 secs to verify that you land on the login page via image
			s.find(password);
			s.type(password, incorrectPassword);
			s.type(Key.TAB, KeyModifier.SHIFT);
			s.type(Key.BACKSPACE);
			s.type(correctUsername);
			s.click(login);
		
			if(s.exists(loginError, 15) != null) {
				System.out.println("Login error message appears: password is invalid");
			}else {
				throw new Exception("Login error message should appear: password is invalid");
			}
			s.click(settings);
			s.exists(backToLogin, 15);
			s.click(backToLogin); //this will reset the password txtbox
			
		}
			
		public void validLogin() throws Exception {

			s.wait(password, 45);
			s.type(password, correctPassword);
			s.type(Key.TAB, KeyModifier.SHIFT);
			s.type(Key.BACKSPACE);
			s.type(correctUsername);
			s.click(login);
			s.wait(userLoginSuccessful, 45); //this statement will throw an exception if the correct user did not login
			System.out.println("User Login Successful!");
		}
		
	public void searchArtist() throws Exception {
			
			s.exists(search, 10);
			s.type(search, "M83");
			s.exists(m83, 15);
			Settings.MoveMouseDelay = 3;
			s.click(m83);
			s.exists(artistM83, 45); //verifies the search directed to the artist's page
			System.out.println("Successful Search!");
		}
		
		public void searchAndPlaySong() throws Exception {
			s.exists(search, 20);
			s.type(search, "don't you evah" + Key.ENTER);
//			Match r = s.exists(songTitle, 15);
//			s.doubleClick(r, 3);
			s.exists(playSong, 30);
			s.doubleClick(playSong);
			s.exists(playing, 5); //this will verify that double clicking the song title will play the song
			Settings.MoveMouseDelay = 6;
			s.click(playing);
			System.out.println("Song Successfully Played");
			s.exists(paused);	
		}
		
		public void createNewStation() throws Exception {
			s.exists(radio, 45);
			s.click(radio);
			s.exists(createNew, 45);
			s.click(createNew);
			s.exists(searchRadio, 30);
			s.click(searchRadio);
			s.type(searchRadio, "deadmau5");
			s.exists(deadmau5, 20);
			s.click(deadmau5);
			s.exists(artistStation, 45); //verifies the search directed to the artist's page
			System.out.println("Station Successfully Created!");			
		}	
}
