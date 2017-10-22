package com.satya.javafx.rms.ui.main;

import com.satya.javafx.rms.business.CommonReleaseBusiness;
import com.satya.javafx.rms.business.DatabaseRefreshBusiness;
import com.satya.javafx.rms.ui.Presenter;

/**
 * @author Satyendra Sharma
 *
 */
public class MainCentralPresenter implements Presenter<MainCentralView> {

	private CommonReleaseBusiness commonReleaseBusiness;
	private DatabaseRefreshBusiness databaseRefreshBusiness;
	private MainCentralView mainCentralViewScreen;

	public MainCentralPresenter(MainCentralView mainCentralViewScreen) {
		this.commonReleaseBusiness = new CommonReleaseBusiness();
		this.databaseRefreshBusiness = new DatabaseRefreshBusiness();
		this.mainCentralViewScreen = mainCentralViewScreen;
	}

	@Override
	public void init() {
		String[] environments = commonReleaseBusiness.getEnvironments();
		this.mainCentralViewScreen.buildScreen(environments);

	}

}
