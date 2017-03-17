package boards.models.org;

import java.util.ArrayList;
import java.util.List;

public class Story extends Model {
	private String code;
	private String descriptif;
	private Project project;
	private Developer developer;
	private Step step;
	private List<Tag> tags;
	private List<Task> tasks;

	public Story() {
		this("", "NO_CODE", "Aucun", null);
	}

	public Story(String id, String code, String descriptif, Project project) {
		super(id);
		this.code = code;
		this.descriptif = descriptif;
		this.project = project;
		this.tags = new ArrayList<>();
		this.tasks = new ArrayList<>();
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		if (this.developer != null) {
			this.developer.getStories().remove(this);
		}
		this.developer = developer;
		developer.getStories().add(this);
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		String result = code;
		if (developer != null)
			result += "->" + developer;
		return result;
	}

}
