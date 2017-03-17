package boards.models.org;

public class Step extends Model {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Step(int id, String title) {
		super();
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}
}
