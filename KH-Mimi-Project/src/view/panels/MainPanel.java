package view.panels;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.vo.Dessert;
import model.vo.Order;
import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class MainPanel<E> extends JPanel {

	JButton logout = new JButton("로그아웃");
	private JButton newbtn = new JButton("메뉴 등록하기");
	JButton checkOrder = new JButton("주문내역 확인하기");
	JPanel thisPanel = MainPanel.this;
	JLabel account = new JLabel();
	File f = new File("Dessert/dessert.txt");
	List<Dessert> dessertList;
	JFrame frame;

	public MainPanel(JFrame f) {
		reFresh();
		setLayout(null);
		frame = f;

		checkOrder.setBounds(460, 40, 150, 30);
		logout.setBounds(280, 40, 150, 30);
		newbtn.setBounds(100, 40, 150, 30);

		thisPanel.add(checkOrder);

		checkOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.user.getUserId().equals("kang")) {
					((OrderCheckPanel) (MainFrame.panels[6])).setOrderList(((OrderCheckPanel) (MainFrame.panels[6]))
							.getReading().readingHoleOrder(MainFrame.user.getUserId()));

					List<Order> orderList = ((OrderCheckPanel) (MainFrame.panels[6])).getOrderList();
					StringBuilder hstr = new StringBuilder();
					int totalProfit = 0;
					SimpleDateFormat formatDay = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

					for (Order order : orderList) {
						String str = "구매자: "+order.getUserId() + ", " + order.getProduct() + ", " + order.getQuantity() + "개, "
								+ ": " + order.getTotalPrice() + "￦, " + 
								formatDay.format(order.getOrderDay()).toString() + "\n";
						hstr.append(str);
						totalProfit += Integer.parseInt(order.getTotalPrice());
					}
					((OrderCheckPanel) (MainFrame.panels[6])).getTextArea().setText(hstr.toString());

					((OrderCheckPanel) (MainFrame.panels[6])).getText2kcal().setText("총 수익 :");
					((OrderCheckPanel) (MainFrame.panels[6])).getTextkcal()
							.setText(Integer.toString(totalProfit) + "￦");
//					

					MyUtil.changePanel(f, MainPanel.this, MainFrame.panels[6]);
				}

				else {
					((OrderCheckPanel) (MainFrame.panels[6])).setOrderList(((OrderCheckPanel) (MainFrame.panels[6]))
							.getReading().readingHoleOrder(MainFrame.user.getUserId()));
					List<Order> orderList = ((OrderCheckPanel) (MainFrame.panels[6])).getOrderList();
					StringBuilder hstr = new StringBuilder();
					int totalkcal = 0;
					SimpleDateFormat formatDay = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

					for (Order order : orderList) {
						String str = "구매일:"+formatDay.format(order.getOrderDay()) + "/ " + order.getProduct() + " " + order.getQuantity() + "개/ "
								+ order.getKcal() * Integer.parseInt(order.getQuantity()) + "Kcal\n";
						totalkcal += order.getKcal() * Integer.parseInt(order.getQuantity());
						hstr.append(str);
					}

					((OrderCheckPanel) (MainFrame.panels[6])).getTextArea().setText(hstr.toString());
					((OrderCheckPanel) (MainFrame.panels[6])).getText2kcal().setText("총 섭취량 :");
					((OrderCheckPanel) (MainFrame.panels[6])).getTextkcal()
							.setText(Integer.toString(totalkcal) + "Kcal");
					((OrderCheckPanel) (MainFrame.panels[6])).getTextArea().setText(hstr.toString());
					MyUtil.changePanel(f, MainPanel.this, MainFrame.panels[6]);

				}
			}
		});

		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainPanel.this, MainFrame.panels[0]);
			}
		});

		account.setBounds(100, 15, 200, 20);
		thisPanel.add(account);

		newbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, MainPanel.this, MainFrame.panels[5]);
			}
		});

		add(newbtn);
		add(logout);

	}//여기까지 메인 패널
	
	/*-------------------------------------------------------------------------------------------------------------------------*/
	public void imageSizeAdapt(JLabel image, int width, int height) {

		ImageIcon icon = (ImageIcon) image.getIcon();
		Image beforeImage = icon.getImage();
		Image afterImage = beforeImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(afterImage);
		image.setIcon(icon);
	}

	public void reFresh() {
		if ((f.exists())) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));) {
				dessertList = (List<Dessert>) ois.readObject();

				int xp = 100, yp = 100, xw = 100, yw = 100, byp=100;

				for (int i = 0; i < dessertList.size(); i++) {
					Dessert dessert = dessertList.get(i);
					JLabel image = dessert.getImage();
					image.setBounds(xp, yp, xw, yw);
					imageSizeAdapt(image, xw, yw);
					JButton btn = dessert.getButton();
					btn.setBounds(xp, yp + byp, 100, 30);
					btn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							setting(dessert.getDessertName(), dessert.getKcal(), dessert.getPrice(),
									dessert.getShortSpecific(), dessert.getImage());
							MyUtil.changePanel(frame, MainFrame.panels[1], MainFrame.panels[3]);

						}
					});

					add(image);
					add(btn);
					if((i+1)%5==0) {
						xp=100;
						yp+=150;
					}
					else {
						xp += 120;
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}
	

	public void setting(String name, int kcal, int price, String explain, JLabel image) {
		MainFrame.dessert.setDessertName(name);
		MainFrame.dessert.setKcal(kcal);
		MainFrame.dessert.setPrice(price);
		MainFrame.dessert.setShortSpecific(explain);
		MainFrame.dessert.setImage(image);

		// MainPanel에서 SpecificPanel을 조작

		// 각종라벨
		((SpecificPanel) (MainFrame.panels[3])).getProductName().setText(name);
		((SpecificPanel) (MainFrame.panels[3])).add(((SpecificPanel) (MainFrame.panels[3])).getProductName());
		((SpecificPanel) (MainFrame.panels[3])).getProductPrice().setText(Integer.toString(price));
		((SpecificPanel) (MainFrame.panels[3])).add(((SpecificPanel) (MainFrame.panels[3])).getProductPrice());
		((SpecificPanel) (MainFrame.panels[3])).getProductKcal().setText(Integer.toString(kcal));
		((SpecificPanel) (MainFrame.panels[3])).add(((SpecificPanel) (MainFrame.panels[3])).getProductKcal());

		// 숫자란 조작
		((SpecificPanel) (MainFrame.panels[3])).getNum().setText("1");
		((SpecificPanel) (MainFrame.panels[3])).getTotalPrice().setText(Integer.toString(price));
		((SpecificPanel) (MainFrame.panels[3])).add(((SpecificPanel) (MainFrame.panels[3])).getTotalPrice());

		// 이미지 미리 조작
		((SpecificPanel) (MainFrame.panels[3])).setImage(image);
		((SpecificPanel) (MainFrame.panels[3])).getPicturePanel().removeAll();
		((SpecificPanel) (MainFrame.panels[3])).getImage().setLayout(null);
		((SpecificPanel) (MainFrame.panels[3])).getImage().setBounds(0, 0, 300, 300);

		ImageIcon icon = (ImageIcon) image.getIcon();
		Image beforeImage = icon.getImage();
		Image afterImage = beforeImage.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(afterImage);
		image.setIcon(icon);
		((SpecificPanel) (MainFrame.panels[3])).getPicturePanel().setLayout(null);
		((SpecificPanel) (MainFrame.panels[3])).getPicturePanel().add(image);
		((SpecificPanel) (MainFrame.panels[3])).add(((SpecificPanel) (MainFrame.panels[3])).getPicturePanel());

		// 한줄평
		((SpecificPanel) (MainFrame.panels[3])).getShortExplain().setText(explain);
		((SpecificPanel) (MainFrame.panels[3])).add(((SpecificPanel) (MainFrame.panels[3])).getShortExplain());

	}
	/*-------------------------------------------------------------------------------------------------------------------------*/
	
	public JButton getLogout() {
		return logout;
	}

	public void setLogout(JButton logout) {
		this.logout = logout;
	}

	public JLabel getAccount() {
		return account;
	}

	public void setAccount(JLabel account) {
		this.account = account;
	}

	public JButton getNewbtn() {
		return newbtn;
	}

	public void setNewbtn(JButton newbtn) {
		this.newbtn = newbtn;
	}

}
