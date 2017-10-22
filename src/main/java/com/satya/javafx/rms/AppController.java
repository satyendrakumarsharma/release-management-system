package com.satya.javafx.rms;

import com.satya.javafx.rms.ui.main.MainCentralPresenter;
import com.satya.javafx.rms.ui.main.MainCentralViewScreen;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The central controller class for application.
 * 
 * @author Satyendra Sharma
 *
 */
public class AppController extends Application {

	private MainCentralViewScreen mainCentralViewScreen;

	public static void start(String... args) {
		launch(args);
	}

	public void init() {
		BorderPane root = new BorderPane();
		mainCentralViewScreen = new MainCentralViewScreen(root, 500, 700);
		MainCentralPresenter mcp = new MainCentralPresenter(mainCentralViewScreen);
		mcp.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setScene(mainCentralViewScreen); // Default Screen
			primaryStage.setTitle("Release Management System");
			primaryStage.getIcons()
					.add(new Image(getClass().getClassLoader().getResourceAsStream("img/macquarie-logo-small.jpg")));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
