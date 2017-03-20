package boards.db.tests.org;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import boards.db.org.MyMongo;
import boards.models.org.Developer;
import boards.models.org.Project;
import boards.models.org.Step;
import boards.models.org.Story;
import boards.models.org.Tag;
import boards.models.org.Task;

public class Datas {

	public static void main(String[] args) {
		MyMongo myMongo = new MyMongo();
		try {
			System.out.println(myMongo.connect("boards"));
			System.out.println(myMongo.getDbNames());

//			dropAll(myMongo);
//			createSteps(myMongo);
//			createDevs(myMongo);
//			createProjects(myMongo);
//			createStories(myMongo);
//			createTags(myMongo);
			List<Step> steps = myMongo.load(Step.class);
			System.out.println(steps);
			List<Developer> devs = myMongo.load(Developer.class);
			List<Project> projects = myMongo.load(Project.class);
			List<Story> stories = myMongo.load(Story.class);
			List<Tag> tags = myMongo.load(Tag.class);
			setDevsProjects(projects,devs);
			setProjectsStories(stories,projects);
			System.out.println(devs.get(0).getProjects());
			for(Project prj:projects){
				System.out.println(prj.getStories());
			}
//			stories.get(0).setDeveloper(devs.get(0));
//			stories.get(0).setProject(projects.get(0));
//			stories.get(1).setProject(projects.get(0));
//			stories.get(2).setProject(projects.get(0));
//			stories.get(3).setProject(projects.get(1));
//			projects.get(0).setOwner(devs.get(2));
//			projects.get(1).setOwner(devs.get(0));
//			stories.get(3).setDeveloper(devs.get(2));
//			stories.get(4).setDeveloper(devs.get(2));
//			stories.get(4).setProject(projects.get(2));
//			System.out.println(devs);
//
//			myMongo.save("Story", stories);
//			System.out.println(devs);
//			myMongo.save("Developer", devs);
//			myMongo.save("Project", projects);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setDevsProjects(List<Project> projects,List<Developer> devs){
		for(Project project:projects){
			if(project.getOwner()!=null){
				int devIndex=devs.indexOf(project.getOwner());
				devs.get(devIndex).getProjects().add(project);
			}
		}
	}
	
	private static void setProjectsStories(List<Story> stories,List<Project> projects){
		for(Story story:stories){
			if(story.getProject()!=null){
			int projIndex=projects.indexOf(story.getProject());	
			projects.get(projIndex).getStories().add(story);
			}
		}
	}
	
	/**
	 * @param mongo
	 * @return
	 */
	private static List<Step> createSteps(MyMongo mongo) {
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step(null, "Todo"));
		steps.add(new Step(null, "In progress"));
		steps.add(new Step(null, "Done"));
		mongo.save("Step", steps);
		return steps;
	}

	private static List<Developer> createDevs(MyMongo mongo) {
		List<Developer> devs = new ArrayList<Developer>();
		devs.add(new Developer(null, "Rod Johnson"));
		devs.add(new Developer(null, "James Gosling"));
		devs.add(new Developer(null, "Linus Torvalds"));
		mongo.save("Developer", devs);
		return devs;
	}

	private static List<Project> createProjects(MyMongo mongo) {
		List<Project> projects = new ArrayList<Project>();
		projects.add(new Project("Boards admin", "Administration interface for Boards app with javaFX"));
		projects.add(new Project("Boards analysis", "AngularJS application + REST API"));
		projects.add(new Project("Open-beer", "A free, public database and API for beer information."));
		mongo.save("Project", projects);
		return projects;
	}

	private static List<Story> createStories(MyMongo mongo) {
		List<Story> stories = new ArrayList<Story>();
		stories.add(new Story(null, "B22", "En tant que créateur, je veux ajouter et gérer les réponses d'une question [methods]"));
		stories.add(new Story(null, "E120", "En tant que créateur, je veux créer / Modifier des quiz [methods]"));
		stories.add(new Story(null, "E140", "En tant que créateur, je souhaite gérer les utilisateurs [methods]"));
		Story s4 = new Story(null, "Dev1", "En tant que développeur, je peux consulter mes projets");
		Task t4 = new Task(null, "Rien");
		t4.close();
		s4.getTasks().add(t4);
		Task t5 = new Task(null, "Rien non plus");
		t5.close();
		s4.getTasks().add(t5);
		stories.add(s4);
		stories.add(new Story(null, "Beer1", "affichage de la liste des bières /beers (L'affichage de la bière n'affiche pas le brasseur associé)"));
		mongo.save("Story", stories);
		return stories;
	}

	private static List<Tag> createTags(MyMongo mongo) {
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(new Tag(null, "bug", "#EE0701"));
		tags.add(new Tag(null, "duplicate", "#CCCCCC"));
		tags.add(new Tag(null, "enhancement", "#84B6EB"));
		tags.add(new Tag(null, "help wanted", "#128A0C"));
		tags.add(new Tag(null, "invalid", "#E6E6E6"));
		tags.add(new Tag(null, "question", "#CC317C"));
		tags.add(new Tag(null, "wont fix", "#FFFFFF"));
		mongo.save("Tag", tags);
		return tags;
	}

	private static void dropAll(MyMongo myMongo) {
		myMongo.dropCollections(new Class[] { Developer.class, Step.class, Tag.class, Story.class, Project.class });
	}

}
