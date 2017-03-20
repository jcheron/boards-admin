package boards.models.org;

import org.bson.types.ObjectId;

import com.google.gson.annotations.Expose;

public abstract class Model {
	@Expose
	protected ObjectId _id;

	public Model() {
		this(null);
	}

	public Model(ObjectId id) {
		this._id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj instanceof Model){
			if(_id!=null)
				return _id.equals(((Model)obj).get_id());
		}
		return super.equals(obj);
	}

	public ObjectId get_id() {
		return _id;
	}
}
