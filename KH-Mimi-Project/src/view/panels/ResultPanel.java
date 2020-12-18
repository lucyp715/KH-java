package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class ResultPanel extends JPanel {
	
	JPanel thisPanel =ResultPanel.this;
	private JTextField pricesum;
	private JTextField selmenu;
	private JTextField kcalsum;
	

	public ResultPanel(JFrame f) {
		
		thisPanel.setBackground(new Color(211, 211, 211));
		thisPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주문내역");
		lblNewLabel.setBounds(420, 10, 63, 30);
		thisPanel.add(lblNewLabel);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(236, 57, 336, 385);
	
		panel2.setLayout(null);
		
		JLabel storname = new JLabel("과자방 :)");
		storname.setBounds(89, 5, 158, 42);
		storname.setFont(new Font("굴림", Font.BOLD, 36));
		panel2.add(storname);
		
		JLabel total = new JLabel("TOTAL");
		total.setFont(new Font("굴림", Font.BOLD, 23));
		total.setBounds(45, 57, 105, 33);
		panel2.add(total);
		
		//선택메뉴의 총가격 부르기
		pricesum = new JTextField();
		pricesum.setFont(new Font("굴림", Font.BOLD, 20));
		pricesum.setBounds(148, 57, 130, 30);
		panel2.add(pricesum);
		pricesum.setColumns(10);
		
		JLabel line = new JLabel("----------------------------------");
		line.setFont(new Font("굴림", Font.BOLD, 12));
		line.setBounds(12, 121, 312, 15);
		panel2.add(line);
		
		//선택한 메뉴와 수량 정보 부르기
		selmenu = new JTextField();
		selmenu.setBounds(45, 170, 253, 42);
		panel2.add(selmenu);
		selmenu.setColumns(10);
		
		JLabel kcal = new JLabel("kcal");
		kcal.setFont(new Font("굴림", Font.BOLD, 17));
		kcal.setBounds(79, 245, 43, 20);
		panel2.add(kcal);
		
		//칼로리 합을 여기로 부르기
		kcalsum = new JTextField();
		kcalsum.setBounds(134, 240, 147, 33);
		panel2.add(kcalsum);
		kcalsum.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("---------------------------------");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(22, 295, 302, 15);
		panel2.add(lblNewLabel_2);
		
		JLabel thanks = new JLabel("이용해주셔서 감사합니다:)");
		thanks.setFont(new Font("굴림", Font.BOLD, 13));
		thanks.setBounds(94, 320, 184, 23);
		panel2.add(thanks);
		
		JLabel callnum = new JLabel("Call: 050-7132-2564");
		callnum.setFont(new Font("굴림", Font.BOLD, 12));
		callnum.setBounds(104, 353, 147, 22);
		panel2.add(callnum);
		
		JButton backbtn = new JButton("처음으로 돌아가기");
		backbtn.setFont(new Font("굴림", Font.BOLD, 15));
		backbtn.setBounds(306, 455, 201, 46);
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, thisPanel, MainFrame.panels[1]);
			}
		});
		
		
		thisPanel.add(backbtn);
		thisPanel.add(panel2);
		
	}


	public JTextField getPricesum() {
		return pricesum;
	}


	public void setPricesum(JTextField pricesum) {
		this.pricesum = pricesum;
	}


	public JTextField getSelmenu() {
		return selmenu;
	}


	public void setSelmenu(JTextField selmenu) {
		this.selmenu = selmenu;
	}


	public JTextField getKcalsum() {
		return kcalsum;
	}


	public void setKcalsum(JTextField kcalsum) {
		this.kcalsum = kcalsum;
	}

	
	
}
