package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AbstractController;

public class MainView extends JFrame implements ActionListener, Observer{
	
	private static final long serialVersionUID = 6313156717813295316L;
	
	private JButton haut;
	private JButton bas;
	private JButton droite;
	private JButton gauche;
	private JLabel vueJeu;

	private AbstractController mControl;

	public MainView(AbstractController controller) {
		super("The game");
		this.mControl = controller;
		this.init();
		this.reactions();
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	private void init() {
		this.setLayout(new GridLayout(0, 1));
		
		this.haut = new JButton("HAUT");
		this.bas = new JButton("BAS");
		this.droite = new JButton("DROIT");
		this.gauche = new JButton("GAUCHE");
		
		JPanel boutonsHaut =new JPanel(new FlowLayout());
		JPanel boutonsBas =new JPanel(new FlowLayout());
		
		boutonsHaut.add(this.haut);
		boutonsBas.add(this.gauche);
		boutonsBas.add(this.bas);
		boutonsBas.add(this.droite);

		JPanel boutons = new JPanel(new FlowLayout());
		
		boutons.add(boutonsHaut);
		boutons.add(boutonsBas);

		JPanel infosPanel = new JPanel(new FlowLayout());
		
		this.vueJeu = new JLabel();
		infosPanel.add(vueJeu);
		
		this.add(boutons);
		this.add(infosPanel);
	}
	
	private void reactions() {
		haut.addActionListener(this);
		bas.addActionListener(this);
		droite.addActionListener(this);
		gauche.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if(o == haut) {
			mControl.move("nord");
		}
		else if(o == bas){
			mControl.move("sud");
		}
		else if(o == droite){
			mControl.move("est");
		}
		else if(o == gauche){
			mControl.move("ouest");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("IL SE PASSE UN TRUC");
		this.vueJeu.setText(mControl.getText());
		
	}

}
