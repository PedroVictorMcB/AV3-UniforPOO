package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Model.Transacao;

public class TelaExtrato extends Tela {

	private Date extratoEmitidoEm;
	private Date inicio;
	private Date fim;
	private JPanel extratoPanel;
	private String[][] tableData;
	private JTable tableContaExtratoId;
	
	public TelaExtrato (int contaCorrenteId) {
		super (contaCorrenteId);
		this.tableData = new String[0][0];
	}

	private void mudarDataInicialHandler(String inputDate) {
		try {
			this.inicio = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void mudarDataFinalHandler(String inputDate) {
		try {
			this.fim = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void emitirExtratoHandler() {
		List<Transacao> listaExtrato = this.getCoreController().extrato(this.inicio, this.fim);
		ArrayList<ArrayList <String>> extratoData = new ArrayList<ArrayList <String>>();
		for (int i = 0; i < listaExtrato.size(); i++) {
			ArrayList<String> line = new ArrayList<String>();
			line.add(Float.toString(listaExtrato.get(i).getValor()));
			line.add(listaExtrato.get(i).getOperacao().toString());
			line.add(listaExtrato.get(i).getOrigem());
			line.add(listaExtrato.get(i).getDestino());
			line.add(new SimpleDateFormat("dd/MM/yyyy").format(listaExtrato.get(i).getDataTransacao()));
			extratoData.add(line);
		}
		this.tableData = new String[extratoData.size()][];
		for (int i = 0; i < extratoData.size(); i++) {
			this.tableData[i] = extratoData.get(i).toArray(new String[0]);
		}
		System.out.println(Arrays.deepToString(this.tableData));
		
		String [] columns = {
			"Valor",
			"Operacao",
			"Origem",
			"Destino",
			"Data"
		};
		
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		
		for (int i = 0; i < this.tableData.length; i++) {
//			for (int j = 0; j < this.tableData[i].length; j++) {
//				this.tableContaExtratoId.getModel().setValueAt(this.tableData[i][j], i, j);
//			}
			
			model.addRow(this.tableData[i]);
			this.tableContaExtratoId.setModel(model);
		}
		
		this.tableContaExtratoId.repaint();
		this.frame.revalidate();
	}
	
	@Override
	public void render() {
		this.frame = new JFrame("WestBankApp - Extrato");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel inputsPanel = new JPanel();
		inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.X_AXIS));
		inputsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel dataInicioLabel = new JLabel("Data de Inicio: ");
		
		inputsPanel.add(dataInicioLabel);
		
		
		try {
			JFormattedTextField dataInicioInput = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dataInicioInput.setBounds(16, 16, 100, 24);
		    dataInicioInput.addPropertyChangeListener("value", e -> {
		    	String text = e.getNewValue() != null ? e.getNewValue().toString() : "";
		    	this.mudarDataInicialHandler(text);
		    });
			inputsPanel.add(dataInicioInput);
			this.frame.add(inputsPanel, BorderLayout.PAGE_START);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel dataFimLabel = new JLabel("Data de Fim: ");
		
		inputsPanel.add(dataFimLabel);
				
		try {
			JFormattedTextField dataFimInput = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dataFimInput.setBounds(16, 16, 100, 24);
			dataFimInput.addPropertyChangeListener("value", e -> {
		    	String text = e.getNewValue() != null ? e.getNewValue().toString() : "";
		    	this.mudarDataFinalHandler(text);
		    });
			inputsPanel.add(dataFimInput);
			this.frame.add(inputsPanel, BorderLayout.PAGE_START);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.extratoPanel = new JPanel();
		this.extratoPanel.setLayout(new BoxLayout(this.extratoPanel, BoxLayout.Y_AXIS));
//		extratoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JButton extratoBtn = new JButton("Gerar Extrato");
		extratoBtn.addActionListener(e -> {
        	System.out.println(this.inicio.toString());
        	System.out.println(this.fim.toString());
        	this.emitirExtratoHandler();
		});
		this.extratoPanel.add(extratoBtn);
		
		String [] columns = {
			"Valor",
			"Operacao",
			"Origem",
			"Destino",
			"Data"
		};

		this.tableContaExtratoId = new JTable(this.tableData, columns);
		this.tableContaExtratoId.setBounds(16, 16, 300, 100);
		this.tableContaExtratoId.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(this.tableContaExtratoId);
		this.extratoPanel.add(scrollPane);

		this.frame.add(this.extratoPanel, BorderLayout.CENTER);
		this.frame.setSize(800, 600);
		this.frame.setVisible(true);
	}
	
	public void setPosition(Point P) {
		this.frame.setLocation(P);
	}
	
	
}
