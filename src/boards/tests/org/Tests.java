package boards.tests.org;

import boards.models.org.Developer;
import boards.models.org.Project;

public class Tests {

	public static void main(String[] args) {
		Project monProjet = new Project();

		Developer edouard = new Developer(null, "Edouard");
		Developer vincent = new Developer(null, "Vincent");
		monProjet.addStory();
		System.out.println(monProjet);
		System.out.println(monProjet.getStories());
		monProjet.getStories().get(0).setDeveloper(vincent);
		showDevStories(vincent);
		showDevStories(edouard);

		monProjet.getStories().get(0).setDeveloper(edouard);
		showDevStories(vincent);
		showDevStories(edouard);

	}

	private static void showDevStories(Developer dev) {
		System.out.println("Stories de " + dev);
		System.out.println(dev.getStories());
	}
}