package view;

import controller.CoreController;

public abstract class Tela {
	protected CoreController controller;

	public Tela(int contaCorrenteId) {
		this.controller = new CoreController(contaCorrenteId);
	}

	public CoreController getCoreController() {
		return this.controller;
	}
	
	public abstract void render();
	
}
