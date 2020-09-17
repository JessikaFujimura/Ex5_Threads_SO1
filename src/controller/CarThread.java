package controller;


import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarThread extends Thread{

	private int distance;
	private int maxVelocity;
	private JLabel car;
	private JTextField winner;
	private JTextField looser;
	private JButton btnRun;
	private int position;

	
	public CarThread(int distance, int maxVelocity, JLabel car, int position, JTextField winner, JTextField looser, JButton btnRun){
		this.distance = distance;
		this.maxVelocity = maxVelocity;
		this.car = car;
		this.position = position;
		this.winner = winner;
		this.looser = looser;
		this.btnRun = btnRun;
	}
	
	public void run(){
		race();
		
	}
	
	private void race(){
		btnRun.setEnabled(false);
		Random random = new Random();
		int sum = 34;
		while(distance>=sum){
			int velocity = random.nextInt(maxVelocity);
			for (int i = sum; i <= (sum + velocity); i++) {
				car.setLocation(i,position);;
			}
			sum += velocity;
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
		}
		showRanking();
		btnRun.setEnabled(true);
	}
	
	private void showRanking(){
		if(winner.getText().isEmpty()){
			winner.setText(car.getText());		
		}else {
			looser.setText(car.getText());
		}
	}
	


}
