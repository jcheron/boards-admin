package boards.models.org;

public abstract class Model {
	protected String _id;

	public Model() {
		this("");
	}

	public Model(String id) {
		this._id = id;
	}
}
