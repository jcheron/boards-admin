package boards.models.org;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Model {
	private String identity;
	private List<Story> stories;
	private List<Project> projects;

	public Developer() {
		this("", "NO NAME");
	}

	public Developer(String id, String identity) {
		super(id);
		this.identity = identity;
		stories = new ArrayList<>();
		projects = new ArrayList<>();
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return identity;
	}

}
