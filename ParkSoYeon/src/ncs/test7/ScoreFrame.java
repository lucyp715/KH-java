package ncs.test7;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class ScoreFrame extends JFrame{

	private JTextField javaScore;
	private JTextField sqlScore;
	private JTextField total;
	private JTextField average;
	private JButton calcBtn;
	
	public ScoreFrame() {
		JFrame frame = new JFrame();
		setTitle("                                       문제7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setResizable(false);
		
		JPanel panel = new JPanel();
		
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("점수를 입력하세요");
		label.setFont(new Font("굴림", Font.BOLD, 45));
		label.setBounds(50, 20, 427, 79);
		panel.add(label);
		
		JLabel label2 = new JLabel("자바 :");
		label2.setFont(new Font("굴림", Font.BOLD, 12));
		label2.setBounds(35, 117, 60, 15);
		panel.add(label2);
		
		JLabel label3 = new JLabel("총점 :");
		label3.setFont(new Font("굴림", Font.BOLD, 12));
		label3.setBounds(35, 250, 60, 15);
		panel.add(label3);
		
		JLabel label4 = new JLabel("SQL :");
		label4.setFont(new Font("굴림", Font.BOLD, 12));
		label4.setBounds(250, 117, 60, 15);
		panel.add(label4);
		
		JLabel label5 = new JLabel("평균 :");
		label5.setFont(new Font("굴림", Font.BOLD, 12));
		label5.setBounds(250, 250, 60, 15);
		panel.add(label5);
		
		javaScore = new JTextField();
		javaScore.setBounds(90, 115, 120, 20);
		panel.add(javaScore);
		javaScore.setColumns(10);
		
		sqlScore = new JTextField();
		sqlScore.setBounds(300, 115, 120, 20);
		panel.add(sqlScore);
		sqlScore.setColumns(10);
		
		total = new JTextField();
		total.setBounds(90, 250, 120, 20);
		panel.add(total);
		total.setColumns(10);
		
		average = new JTextField();
		average.setBounds(300, 250, 120, 20);
		panel.add(average);
		average.setColumns(10);
		
		calcBtn = new JButton("계산하기");
		calcBtn.setFont(new Font("굴림", Font.BOLD, 16));
		calcBtn.setBounds(180, 170, 120, 40);
		panel.add(calcBtn);
		calcBtn.addActionListener(new ActionHandler());
		
	
	
		
		setVisible(true);
	}
	public class ActionHandler implements ActionListener{
	      
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	   if(javaScore.getText() != null && !javaScore.getText()
	    			   .equals("") && sqlScore.getText() != null && !sqlScore
	    			   .getText().equals("")) {

	    		   
	         int java = Integer.parseInt(javaScore.getText());
	         int sql = Integer.parseInt(sqlScore.getText());
	         String sum = Integer.toString(java+sql);
	         String avg = Integer.toString((java+sql)/2);
	         total.setText(sum);
	         average.setText(avg);
	    	   }
	      }
	 }

}
