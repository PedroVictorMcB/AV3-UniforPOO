package Model;

public abstract class EntidadeRelacional {

	private int id;

	
	
	public EntidadeRelacional(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
