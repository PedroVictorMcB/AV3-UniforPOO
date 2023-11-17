package Model;

import java.util.Date;

public class Transacao extends EntidadeRelacional implements ITransacao {

	private float valor;
	private Operacao operacao;
	private String origem;
	private String destino;
	private Date dataTransacao;
	
	public Transacao(int id, float valor, Operacao operacao, String origem, String destino, Date dataTransacao) {
		super(id);
		this.valor = valor;
		this.operacao = operacao;
		this.origem = origem;
		this.destino = destino;
		this.dataTransacao = dataTransacao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Operacao getOperacao() {
		return operacao;
	}
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	
	
	
}
