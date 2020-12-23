package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.DessertController;
import model.vo.Dessert;
import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class DessertUploadPanel extends JPanel {

	private static final long serialVersionUID = 7L;

	JButton pictureFind = new JButton("사진 찾기");
	JButton back = new JButton("돌아가기");
	JButton apply = new JButton("등록하기");
	JFileChooser chooser = new JFileChooser();
	JLabel imagelabel = new JLabel();

	JPanel test = new JPanel();
	JLabel picture = new JLabel();
	JLabel dessertName = new JLabel("디저트 이름 : ");
	JLabel dessertKcal = new JLabel("디저트 열량 : ");
	JLabel dessertPrice = new JLabel("디저트 가격 : ");
	JLabel dessertExplain = new JLabel("디저트 상품 설명:");

	JTextField dessertNameField = new JTextField(20);
	JTextField dessertKcalField = new JTextField(20);
	JTextField dessertPriceField = new JTextField(20);
	JTextArea dessertExplainField = new JTextArea();

	// 객체 저장
	DessertController dessertController = new DessertController();

	public DessertUploadPanel(JFrame f) {

		// 레이아웃 별도 설정
		setLayout(null);
		// 0.버튼위치
		back.setBounds(100, 400, 100, 30);
		pictureFind.setBounds(150, 300, 100, 30);
		apply.setBounds(400, 400, 100, 30);

		// 1-1.버튼 액션(뒤로가기)
		back.setFont(new Font("굴림", Font.BOLD, 15));
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyUtil.changePanel(f, DessertUploadPanel.this, MainFrame.panels[1]);
				dessertNameField.setText("");
				dessertKcalField.setText("");
				dessertPriceField.setText("");
				dessertExplainField.setText("");
				imagelabel.setIcon(null);
			}
		});
		// 1-2 버튼 액션 (사진 등록)
		pictureFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG & GIF Images", "jpg", "gif",
						"png");

				chooser.setFileFilter(filter);

				int ret = chooser.showOpenDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일선택하지않음", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}

				String filePath = chooser.getSelectedFile().getPath();
				ImageIcon icon = new ImageIcon(filePath);
				// 이미지 수정
				Image beforeImage = icon.getImage();
				Image afterImage = beforeImage.getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(afterImage);
				imagelabel.setIcon(icon);

			}
		});
		// 1-3 버튼 액션 (Dessert 객체 생성)
		apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (imagelabel.getIcon() == null) {
					JOptionPane.showMessageDialog(null, "사진을 등록하세요");
					return;
				} else {
					if ((dessertNameField.getText().length() >= 1) && (dessertKcalField.getText().length() >= 1)
							&& (dessertPrice.getText().length() >= 1)
							|| (dessertExplainField.getText().length() >= 1)) {
						String name = dessertNameField.getText();
						int price;
						int kcal;
						try {
							price = Integer.parseInt(dessertPriceField.getText());
							kcal = Integer.parseInt(dessertKcalField.getText());
						} catch (Exception error) {
							JOptionPane.showMessageDialog(null, "칼로리 혹은 가격란에 정수 입력하세요.");
							return;
						}

						String explain = dessertExplainField.getText();
						JButton btn =new JButton(name);
						Dessert dessert = new Dessert(name, kcal, price, explain, imagelabel,btn);
						System.out.println(dessert.toString());
						dessertController.dessertUploading(dessert);
						JOptionPane.showMessageDialog(null, "상품 등록이 완료되었습니다.");
						((MainPanel)MainFrame.panels[1]).reFresh();
						MyUtil.changePanel(f, DessertUploadPanel.this, MainFrame.panels[1]);
						dessertNameField.setText("");
						dessertKcalField.setText("");
						dessertPriceField.setText("");
						dessertExplainField.setText("");
						imagelabel.setIcon(null);

						return;
					} else {

						JOptionPane.showMessageDialog(null, "각 항목당 최소 1글자 이상은 입력하세요.");
						return;
					}
				}
			}
		});

		// 2.사진패널 위치
		test.setBounds(50, 25, 300, 250);
		test.setBackground(Color.white);
		test.add(imagelabel);

		// 3.라벨 위치
		dessertName.setBounds(400, 100, 100, 30);
		dessertKcal.setBounds(400, 130, 100, 30);
		dessertPrice.setBounds(400, 160, 100, 30);
		dessertExplain.setBounds(400, 220, 200, 30);

		// 4.텍스트입력라벨 위치
		dessertNameField.setBounds(500, 105, 150, 20);
		dessertKcalField.setBounds(500, 135, 150, 20);
		dessertPriceField.setBounds(500, 165, 150, 20);
		dessertExplainField.setBounds(400, 250, 230, 80);

		// 5.라벨을 패널에 더하기
		add(dessertName);
		add(dessertKcal);
		add(dessertPrice);
		add(dessertExplain);
		add(dessertNameField);
		add(dessertKcalField);
		add(dessertPriceField);
		add(dessertExplainField);

		// 6.버튼과 내부 패널을 패널에 더함
		add(test);
		add(back);
		add(pictureFind);
		add(apply);

	}
	

}
