package Model;

import java.util.Date;

public interface ITransacao {

	public float getValor();
	public void setValor(float valor);
	public Operacao getOperacao();
	public void setOperacao(Operacao operacao);
	public String getOrigem();
	public void setOrigem(String origem);
	public String getDestino();
	public void setDestino(String destino);
	public Date getDataTransacao();
	public void setDataTransacao(Date dataTransacao);
}
