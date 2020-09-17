package controller;

import java.nio.Buffer;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarThread extends Thread{

	private int distance;
	private int maxVelocity;
	private JLabel car;
	private JTextField winner;
	private JTextField looser;
	private int position;

	
	public CarThread(int distance, int maxVelocity, JLabel car, int position, JTextField winner, JTextField looser){
		this.distance = distance;
		this.maxVelocity = maxVelocity;
		this.car = car;
		this.position = position;
		this.winner = winner;
		this.looser = looser;
	}
	
	public void run(){
		race();
	}
	
	private void race(){
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
	}
	
	private void showRanking(){
		if(winner.getText().isEmpty()){
			winner.setText(car.getText());		
		}else {
			looser.setText(car.getText());
		}
	}
	


}
