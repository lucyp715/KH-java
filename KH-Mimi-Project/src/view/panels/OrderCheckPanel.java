package view.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import io.ReadingOrder;
import model.vo.Order;
import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class OrderCheckPanel extends JPanel {

	private List<Order> orderList;
	private ReadingOrder reading = new ReadingOrder();
	private JTextArea textArea = new JTextArea();
	private StringBuilder st = new StringBuilder();
	private JTextField textkcal = new JTextField(10);
	private JLabel text2kcal = new JLabel("");

	public OrderCheckPanel(JFrame f) {

		text2kcal.setBounds(280, 50, 100, 30);
		textkcal.setBounds(370, 50, 150, 30);
		add(text2kcal);
		add(textkcal);
		setLayout(null);

		textArea.setText(st.toString());
		textArea.setBounds(100, 100, 600, 600);

		JPanel jp_label = new JPanel();
		jp_label.add(textArea);
		
		JScrollPane scroll = new JScrollPane(jp_label); // 스크롤패널을 선언
		scroll.setBounds(150, 100, 450, 200); // 프레임에 스크롤패널의 위치를 정한다
		scroll.setBackground(Color.white);
		add(scroll); // 스크롤패널 추가

		JButton btn = new JButton("돌아가기");
		btn.setBounds(50, 50, 100, 30);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((MainPanel) (MainFrame.panels[1])).reFresh();
				textArea.setText("");
				orderList = null;
				MyUtil.changePanel(f, OrderCheckPanel.this, MainFrame.panels[1]);
			}
		});

		add(btn);
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public ReadingOrder getReading() {
		return reading;
	}

	public void setReading(ReadingOrder reading) {
		this.reading = reading;
	}

	public StringBuilder getSt() {
		return st;
	}

	public void setSt(StringBuilder st) {
		this.st = st;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextField getTextkcal() {
		return textkcal;
	}

	public void setTextkcal(JTextField textkcal) {
		this.textkcal = textkcal;
	}

	public JLabel getText2kcal() {
		return text2kcal;
	}

	public void setText2kcal(JLabel text2kcal) {
		this.text2kcal = text2kcal;
	}

}
