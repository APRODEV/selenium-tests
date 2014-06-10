package com.wikia.webdriver.TestCases.SpecialPagesTests;

import com.wikia.webdriver.Common.Properties.Credentials;
import com.wikia.webdriver.Common.Templates.NewTestTemplate;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.SpecialVideosPageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;

import org.testng.annotations.Test;

public class VideosPageTests extends NewTestTemplate {

	Credentials credentials = config.getCredentials();

	/**
	 * Verify UI elements on the Special:Videos page
	 * Logged-Out
	 *
	 * @author Armon Rabiyan
	 */
	@Test(groups = {"VideosPage", "VideosPageTest_001", "Media"})
	public void VideosPageTest_001() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		SpecialVideosPageObject specialVideos = base.openSpecialVideoPageMostRecent(wikiURL);
		specialVideos.verifyElementsOnPage();
	}

	/**
	 * Checks if a video can successfully be deleted from the Special:Videos page. Specifically, this
	 * test checks if, after the video has been deleted, its title shows up in the delete confirmation
	 * presented by Global Notifications. (Note: This test also adds a video beforehand to make sure
	 * running this test is sustainable).
	 *
	 * @author James Sutterfield
	 */
	@Test(groups = {"VideosPage", "VideosPageTest_002", "Media"})
	public void VideosPageTest_002() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameStaff, credentials.passwordStaff, wikiURL);
		SpecialVideosPageObject specialVideos = base.openSpecialVideoPageMostRecent(wikiURL);
		specialVideos.verifyDeleteViaGlobalNotifications();
	}

	/**
	 * Checks if a video can successfully be deleted from the Special:Videos page. Specifically, this
	 * test checks if, after the video has been deleted, it is no longer present in the list of most
	 * recent videos on Special:Videos. (Note: in order to accomplish this the test also adds a video
	 * before hand to ensure that 1.) the test is sustainable, and 2.) it knows what the most recent
	 * video is).
	 *
	 * * @author James Sutterfield
	 */
	@Test(groups = {"VideosPage", "VideosPageTest_003", "Media"})
	public void VideosPageTest_003() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameStaff, credentials.passwordStaff, wikiURL);
		SpecialVideosPageObject specialVideos = base.openSpecialVideoPageMostRecent(wikiURL);
		specialVideos.verifyDeleteViaVideoNotPresent();
	}

}