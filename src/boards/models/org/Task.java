package boards.models.org;

public class Task extends Model {
	private String content;
	private Story story;

	public Task() {
		this("", "NO CONTENT");
	}

	public Task(String id, String content) {
		super(id);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return content;
	}

}
