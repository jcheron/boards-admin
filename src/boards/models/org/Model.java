package boards.models.org;

public abstract class Model{
	protected int id;
	public Model(){
		this(0);
	}
	
	public Model(int id){
		this.id=id;
	}
}
