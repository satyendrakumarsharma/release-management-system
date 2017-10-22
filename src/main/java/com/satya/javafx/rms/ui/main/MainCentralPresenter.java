package com.satya.javafx.rms.ui.main;

import com.satya.javafx.rms.business.CommonReleaseBusiness;
import com.satya.javafx.rms.ui.Presenter;

/**
 * @author Satyendra Sharma
 *
 */
public class MainCentralPresenter implements Presenter<MainCentralView> {

	private CommonReleaseBusiness commonReleaseBusiness;
	private MainCentralView mainCentralViewScreen;

	public MainCentralPresenter(CommonReleaseBusiness commonReleaseBusiness, MainCentralView mainCentralViewScreen) {
		this.commonReleaseBusiness = commonReleaseBusiness;
		this.mainCentralViewScreen = mainCentralViewScreen;
	}

	@Override
	public void init() {
		String[] environments = commonReleaseBusiness.getEnvironments();
		this.mainCentralViewScreen.buildScreen(environments);

	}

}
