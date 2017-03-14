package boards.models.org;

public class Story extends Model {
	private String code;
	private String descriptif;
	private Project project;
	private Developer developer;
	private Step step;
	
	public Story(){
		this(0, "NO_CODE", "Aucun", null);
	}
	
	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		if(this.developer!=null){
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

	public Story(int id,String code, String descriptif, Project project) {
		super(id);
		this.code = code;
		this.descriptif = descriptif;
		this.project = project;
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

	@Override
	public String toString() {
		String result=code;
		if(developer!=null)
			result+="->"+developer;
		return result;
	}
}
