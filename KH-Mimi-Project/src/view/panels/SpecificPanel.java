package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.OrderController;
import model.vo.Order;
import model.vo.User;
import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class SpecificPanel extends JPanel {
	private JLabel image = new JLabel();
	private JLabel productName = new JLabel();
	private JLabel productKcal = new JLabel();
	private JLabel productPrice = new JLabel();
	private JLabel totalPrice = new JLabel();
	private JPanel picturePanel = new JPanel();
	private JTextField num = new JTextField(10);
	private JTextArea shortExplain = new JTextArea();
	OrderController orderController = new OrderController();
	public SpecificPanel(JFrame f) {
		setLayout(null);

		// 사진+사진패널
		picturePanel.setLayout(null);
		picturePanel.setBackground(Color.white);
		picturePanel.setBounds(100, 50, 300, 300);
		image.setBounds(120, 70, 260, 260);

		picturePanel.add(image);
		add(picturePanel);

		JLabel address = new JLabel("주소지 : ");
		address.setBounds(80, 370, 100, 30);

		JTextField addressInput = new JTextField(100);
		addressInput.setBounds(150, 370, 230, 25);

		add(address);
		add(addressInput);

		// 버튼 생성 뒤로가기 + 결제
		JButton back = new JButton("뒤로 가기");
		back.setBounds(200, 420, 100, 50);
		JButton slash = new JButton("결제");
		slash.setBounds(450, 420, 100, 50);

		num.setBounds(520, 153, 50, 25);

		JButton checkTotal = new JButton("▲");
		JButton checkTotal2 = new JButton("▼");

		checkTotal.setBounds(600, 140, 50, 50);
		checkTotal2.setBounds(650, 140, 50, 50);

		// 2.라벨들
		int xlabel = 450, ylabel = 50, w = 200, h = 30, yterm = 50;
		JLabel pName = new JLabel("이름 :");
		pName.setBounds(xlabel, ylabel, w, h);
		productName.setBounds(xlabel + 60, ylabel, w, h);

		JLabel price = new JLabel("가격 :                 원");
		price.setBounds(xlabel, ylabel + yterm, w, h);
		productPrice.setBounds(xlabel + 60, ylabel + yterm, w, h);

		JLabel quantity = new JLabel("수량 :                 개");
		quantity.setBounds(xlabel, ylabel + yterm * 2, w, h);

		JLabel kcal = new JLabel("kcal :             kcal");
		kcal.setBounds(xlabel, ylabel + yterm * 3, w, h);
		productKcal.setBounds(xlabel + 60, ylabel + yterm * 3, w, h);

		JLabel total = new JLabel("총액 :                 원");
		total.setBounds(xlabel, ylabel + yterm * 4, w, h);
		totalPrice.setBounds(xlabel + 60, ylabel + yterm * 4, w, h);

		// chek버튼 행동추가
		checkTotal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int newnum = Integer.parseInt(num.getText()) + 1;
				num.setText(Integer.toString(newnum));
				String perN = productPrice.getText();
				int tp;
				try {
					tp = Integer.parseInt(perN) * Integer.parseInt(num.getText());
					if (1 > Integer.parseInt(num.getText()) || Integer.parseInt(num.getText()) > 10) {
						JOptionPane.showMessageDialog(null, "주문 가능 개수는 1~10 개 입니다.");
						num.setText("1");
						tp = Integer.parseInt(perN);
					}
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "정수를 입력하세요.");
					num.setText("1");
					tp = Integer.parseInt(perN);
				}

				String TP = Integer.toString(tp);
				totalPrice.setText(TP);
				SpecificPanel.this.add(totalPrice);
			}
		});
		checkTotal2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int newnum = Integer.parseInt(num.getText()) - 1;
				num.setText(Integer.toString(newnum));
				String perN = productPrice.getText();
				int tp;
				try {
					tp = Integer.parseInt(perN) * Integer.parseInt(num.getText());
					if (1 > Integer.parseInt(num.getText()) || Integer.parseInt(num.getText()) > 10) {
						JOptionPane.showMessageDialog(null, "주문 가능 개수는 1~10 개 입니다.");
						num.setText("1");
						tp = Integer.parseInt(perN);
					}
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "정수를 입력하세요.");
					num.setText("1");
					tp = Integer.parseInt(perN);
				}

				String TP = Integer.toString(tp);
				totalPrice.setText(TP);
				SpecificPanel.this.add(totalPrice);
			}
		});

		// 결제버튼 행동추가
		slash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (addressInput.getText().length() <= 10) {
					JOptionPane.showMessageDialog(null, "최소 10자 이상의 상세 주소를 적어주세요.");
					addressInput.setText("");
					return;
				} else {
					
					Order newOrder =new Order(MainFrame.user.getUserId(), 
							new Date(),MainFrame.dessert.getDessertName(),num.getText(),totalPrice.getText(),addressInput.getText(),MainFrame.dessert.getKcal());
					
					orderController.OrderUploading(newOrder);
					
					JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
					addressInput.setText("");
					
					
					
					((ResultPanel)(MainFrame.panels[4])).getPricesum().setText(totalPrice.getText()+"￦");
					((ResultPanel)(MainFrame.panels[4])).getSelmenu().setText(MainFrame.dessert.getDessertName());
					int totalCal=Integer.parseInt(num.getText())*Integer.parseInt(productKcal.getText());
					((ResultPanel)(MainFrame.panels[4])).getKcalsum().setText(Integer.toString(totalCal)+"kcal");
					
					((MainPanel) (MainFrame.panels[1])).reFresh();
					MyUtil.changePanel(f, SpecificPanel.this, MainFrame.panels[4]);
				}
			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addressInput.setText("");
				((MainPanel) (MainFrame.panels[1])).reFresh();
				MyUtil.changePanel(f, SpecificPanel.this, MainFrame.panels[1]);
			}
		});

		// 짤막한 한줄명
		shortExplain.setBounds(xlabel, ylabel + 5 * yterm, 200, 70);

		// 라벨 더하기
		add(pName);
		add(price);
		add(quantity);
		add(kcal);
		add(total);
		add(slash);
		add(back);
		add(num);
		add(checkTotal);
		add(checkTotal2);
		// add(spinner);
	}

		
	
	
	public void imageSizeAdapt(JLabel image, int width, int height) {

		ImageIcon icon = (ImageIcon) image.getIcon();
		Image beforeImage = icon.getImage();
		Image afterImage = beforeImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(afterImage);
		image.setIcon(icon);
	}

	public JLabel getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(JLabel totalPrice) {
		this.totalPrice = totalPrice;
	}

	public JTextField getNum() {
		return num;
	}

	public void setNum(JTextField num) {
		this.num = num;
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}

	public JLabel getProductName() {
		return productName;
	}

	public void setProductName(JLabel productName) {
		this.productName = productName;
	}

	public JLabel getProductKcal() {
		return productKcal;
	}

	public void setProductKcal(JLabel productKcal) {
		this.productKcal = productKcal;
	}

	public JLabel getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(JLabel productPrice) {
		this.productPrice = productPrice;
	}

	public JPanel getPicturePanel() {
		return picturePanel;
	}

	public void setPicturePanel(JPanel picturePanel) {
		this.picturePanel = picturePanel;
	}

	public JTextArea getShortExplain() {
		return shortExplain;
	}

	public void setShortExplain(JTextArea shortExplain) {
		this.shortExplain = shortExplain;
	}

}
