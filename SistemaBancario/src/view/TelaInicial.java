package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends Tela {

	private int contaCorrenteId;
	private boolean isSaldoVisivel;
	
	public TelaInicial (int contaCorrenteId) {
		super(contaCorrenteId);
		
		this.isSaldoVisivel = false;
	}
	
	private void toggleSaldoHandler() {
		if (this.isSaldoVisivel == true) {
			this.isSaldoVisivel = false;
		} else {
			this.isSaldoVisivel = true;
		}
	}

	@Override
	public void render() {
		JFrame frame = new JFrame("WestBankApp - Tela Principal");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel borderLayoutPanel = new JPanel(new BorderLayout());
		JPanel boxLayoutPanel = new JPanel();
		boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
		JPanel saldoPanel = new JPanel();
		saldoPanel.setLayout(new BoxLayout(saldoPanel, BoxLayout.X_AXIS));
		saldoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
        JLabel titleLabel = new JLabel("Bem-vindo ao WestBankApp!");
        titleLabel.setFont( new Font(Font.SANS_SERIF, Font.BOLD, 26));
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setPreferredSize(new Dimension(400, 128));
        
        JLabel contaNum = new JLabel("Conta Número: " + this.controller.getContaCorrenteNum());

        contaNum.setAlignmentX(Component.LEFT_ALIGNMENT);

        Border border = contaNum.getBorder();
        Border margin = new EmptyBorder(0,16,0,0);
        contaNum.setBorder(new CompoundBorder(border, margin));
        
        JLabel txtSaldo = new JLabel ("Saldo: ");
        txtSaldo.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        
        String btnTxt = this.isSaldoVisivel ? "R$ " + this.controller.getSaldo() : "Clique Aqui";
        
        JButton saldoBtn = new JButton(btnTxt);
        saldoBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        saldoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saldoBtn.addActionListener(e -> {
        	this.toggleSaldoHandler();
        	String newBtnTxt = this.isSaldoVisivel ? "R$ " + this.controller.getSaldo() : "Clique Aqui";
        	saldoBtn.setText(newBtnTxt);
        });
        
        saldoPanel.add(txtSaldo);
        saldoPanel.add(saldoBtn);
        Border borderSaldo = saldoPanel.getBorder();
        Border marginSaldo = new EmptyBorder(16,16,0,0);
        saldoPanel.setBorder(new CompoundBorder(borderSaldo, marginSaldo));
                
        borderLayoutPanel.add(titleLabel, BorderLayout.PAGE_START);
        boxLayoutPanel.add(contaNum);
        boxLayoutPanel.add(saldoPanel); 
       
        borderLayoutPanel.add(boxLayoutPanel, BorderLayout.LINE_START);
        
        JButton extratoBtn = new JButton("Extrato");
        borderLayoutPanel.add(extratoBtn, BorderLayout.PAGE_END);
        
        
        frame.getContentPane().add(borderLayoutPanel, BorderLayout.CENTER);
        
		frame.setSize(400, 600);
		
		
		
		//5. Show it.
		frame.setVisible(true);
	}
}
