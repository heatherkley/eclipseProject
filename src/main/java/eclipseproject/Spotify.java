package eclipseproject;

import org.sikuli.script.*;


public class Spotify {
	
	private static final int WHEEL_DOWN = 0;
	String correctUsername = "freeeaccountt" ;
	String incorrectPassword = "incorrectPassword" ;
	String correctPassword = "freeaccount";
	Screen s = new Screen(); 
	Pattern password = new Pattern("password.png");
	Pattern loginImage = new Pattern("LoginImage.png");
	Pattern loginError = new Pattern("loginError.png");
	Pattern openSpotify = new Pattern("openSpotify.png");
	Pattern openSpotifyDesk = new Pattern("SpotifyDesktop.png");
	Pattern incorrectPasswordPNG = new Pattern("incorrectPassword.png");
	Pattern userLoginSuccessful = new Pattern ("userLoginSuccessful.png");
	Pattern close = new Pattern("close.png");
	Pattern menu = new Pattern ("menu.png");
	Pattern logOut = new Pattern ("logOut.png");
	Pattern search = new Pattern ("search.png");
	//  no pattern needed for Username bc the system will autogenerate the last given username at app opening
	
	
	public static void main(String[]args) throws Exception {

	}
		
		public void openApp() throws Exception {
			if (s.exists(openSpotifyDesk) !=null)
				s.doubleClick(openSpotifyDesk);
			else if(s.exists(openSpotify) !=null)
				s.click(openSpotify);
		}
	
		public void closeApp() throws Exception {
			if (s.exists(close) !=null)
				s.click(close);	
//			else if(s.exists(MAC_IMG) !=null)
//				s.click(MAC_IMG);
			System.out.println("Success: Application closed");
			
		}
		
		public void logout() throws Exception{
			if (s.exists(menu, 10) !=null)
				s.click(menu);	
//			else if(s.exists(MAC_IMG) !=null)
//			s.click(MAC_IMG);
			
			if (s.exists(logOut, 5) !=null)
				s.doubleClick(logOut);	
//			else if(s.exists(MAC_IMG) !=null)
//			s.click(MAC_IMG);
			
			s.exists(loginImage, 15); //verifies the user is taken back to the login page
		}
		
		public void IncorrectLogin()throws Exception{
			
			System.out.println("spotify opening");	
			s.wait(loginImage, 10); //Waits a max 10 secs to verify that you land on the login page via image
			s.find(password);
			s.type(password, incorrectPassword);
			s.type(Key.TAB, KeyModifier.SHIFT);
			s.type(Key.BACKSPACE);
			s.type(correctUsername);
			s.click("login.png");
		
			if(s.exists(loginError, 15) != null) {
				System.out.println("Login error message appears: password is invalid");
			}else {
				throw new Exception("Login error message should appear: password is invalid");
			}
		}
			
		public void validLogin() throws Exception {

			s.wait(password, 10);
			s.type(password, correctPassword);
			s.type(Key.TAB, KeyModifier.SHIFT);
			s.type(Key.BACKSPACE);
			s.type(correctUsername);
			s.click("login.png");
			s.wait(userLoginSuccessful, 15); //this statement will throw an exception if the correct user did not login
	
			
		}
		
		public void searchScenarios() throws Exception {
			
			s.exists(search, 10);
			s.click(search);
			s.type("a", KeyModifier.CTRL);
			s.type(Key.BACKSPACE);
			s.type(search, "M83");
			s.wait("m83.png", 10);
			s.click("m83.png");
			s.wheel("m83scroll.png", WHEEL_DOWN, 4);
			
		}
}
