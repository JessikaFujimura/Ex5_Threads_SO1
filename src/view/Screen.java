package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CarThread;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JEditorPane;


public class Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Winner;
	private JTextField Looser;
	private JLabel Partida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CarOne = new JLabel("Carro 1");
		CarOne.setHorizontalAlignment(SwingConstants.LEFT);
		CarOne.setForeground(Color.YELLOW);
		CarOne.setFont(new Font("Tahoma", Font.BOLD, 12));
		CarOne.setBounds(34, 47, 46, 14);
		contentPane.add(CarOne);
		
		JLabel CarTwo = new JLabel("Carro 2");
		CarTwo.setHorizontalAlignment(SwingConstants.LEFT);
		CarTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
		CarTwo.setForeground(Color.RED);
		CarTwo.setBounds(34, 97, 46, 14);
		contentPane.add(CarTwo);
		
		JLabel lblVencedor = new JLabel("Vencedor:");
		lblVencedor.setBounds(135, 146, 58, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor:");
		lblPerdedor.setBounds(135, 176, 58, 14);
		contentPane.add(lblPerdedor);
		
		JButton btnRun = new JButton("Correr");
		btnRun.setBounds(10, 216, 89, 23);
		contentPane.add(btnRun);
		
		Winner = new JTextField();
		Winner.setEditable(false);
		Winner.setBounds(203, 143, 86, 20);
		contentPane.add(Winner);
		Winner.setColumns(10);
		
		Looser = new JTextField();
		Looser.setEditable(false);
		Looser.setColumns(10);
		Looser.setBounds(203, 173, 86, 20);
		contentPane.add(Looser);
		
		Partida = new JLabel("Partida");
		Partida.setHorizontalAlignment(SwingConstants.CENTER);
		Partida.setBounds(34, 11, 46, 14);
		contentPane.add(Partida);
		
		JLabel Chegada = new JLabel("Chegada");
		Chegada.setBounds(333, 11, 66, 14);
		contentPane.add(Chegada);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(58, 133, 341, 2);
		contentPane.add(separator);
		
		JEditorPane Pista1 = new JEditorPane();
		Pista1.setBackground(Color.DARK_GRAY);
		Pista1.setBounds(34, 36, 320, 37);
		contentPane.add(Pista1);
		
		JEditorPane Pista2 = new JEditorPane();
		Pista2.setBackground(Color.DARK_GRAY);
		Pista2.setBounds(34, 85, 320, 37);
		contentPane.add(Pista2);
		
		ActionListener startRacer = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread car1 = new CarThread(300,10, CarOne, 47, Winner, Looser, btnRun);
				Thread car2 = new CarThread(300,10,CarTwo,97,  Winner, Looser, btnRun);
				car1.start();
				car2.start();
				
				Winner.setText("");
				Looser.setText("");
				
			}
		};
		btnRun.addActionListener(startRacer);
	}
}
