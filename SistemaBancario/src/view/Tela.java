package view;

import javax.swing.JFrame;

import controller.CoreController;

public abstract class Tela {
	protected CoreController controller;
	protected int contaCorrenteId;
	protected JFrame frame;
	

	public Tela(int contaCorrenteId) {
		this.controller = new CoreController(contaCorrenteId);
		this.contaCorrenteId = contaCorrenteId;
	}

	public CoreController getCoreController() {
		return this.controller;
	}
	
	public abstract void render();
	
}
