package edu.pacific.comp55.starter;

import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private SomePane somePane;
	private MenuPane menu;
	private NewTaskPage newTaskPage;
	private newUser newUser;
	
	private static FileWriter file;
	private static JSONParser jsonParser = new JSONParser();

	private int count;
	
	public String currentPane;
	
	static JSONObject jObject = new JSONObject();

	String filePath = "src/main/java/edu/pacific/comp55/starter/tasks.json";
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Hello, world!");
		
		
		try {
			file = new FileWriter("tasks.json");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			jObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
		} catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
			e.printStackTrace();
		} 
		somePane = new SomePane(this);
				try {
					
			menu = new MenuPane(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			newUser = new newUser(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		newTaskPage = new NewTaskPage(this);
		//taskPage = new TaskPage(this);
		setupInteractions();
		switchToMenu();
	}

	public void switchToMenu() {
		playRandomSound();
		count++;
		currentPane = "Menu pane";
		switchToScreen(menu);
	}
	public void switchTonewUser() {
		currentPane = "New User";
		switchToScreen(newUser);
	}
	public void setUser(String user) {
		somePane.setUser(user);
		newTaskPage.setUsername(user);
	}
	public void switchToSome() { //switches to the main Task Board
		playRandomSound();
		currentPane = "Some pane";
		switchToScreen(somePane);
	}
	public void switchToTask() {
		playRandomSound();
		currentPane = "Task pane";
		//count++;
		switchToScreen(newTaskPage);
	}
	
	public String getCurrentPane() {
		return currentPane;
	}
	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuPane();
			}
		});
		
	}
}
