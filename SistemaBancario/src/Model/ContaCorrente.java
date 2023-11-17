package Model;


public class ContaCorrente extends EntidadeRelacional implements IContaCorrente {

	private float saldo;
	
	public ContaCorrente (int id, float saldo) {

		super(id);
		this.saldo = saldo;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
