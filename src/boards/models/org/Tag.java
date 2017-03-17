package boards.models.org;

public class Tag extends Model {
	private String title;

	public Tag() {
		this("", "NO TITLE");
	}

	public Tag(String id, String title) {
		super(id);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}

}
