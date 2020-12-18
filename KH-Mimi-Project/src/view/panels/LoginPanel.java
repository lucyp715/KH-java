package view.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import io.CheckID;
import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class LoginPanel extends JPanel {

	JLabel title = new JLabel("과자방에 오신것을 환영합니다. ~ :)");
	JLabel label = new JLabel("ID : ");
	JLabel pswrd = new JLabel("PW : ");

	JTextField txtID = new JTextField(10);
	JPasswordField txtPass = new JPasswordField(10);
	JButton logBtn = new JButton("로그인");

	JButton newMember = new JButton("회원가입");

	public LoginPanel(JFrame f) {

		setLayout(null);
		double xstart = f.getLocation().x;
		double ystart = f.getLocation().y;
		double xwidth = f.getSize().getWidth();
		double yheight = f.getSize().getHeight();

		// 아이디 라벨 위치+크기
		label.setLocation((int) ((xwidth) * 0.30), (int) ((yheight) * 0.25));
		label.setSize(30, 15);

		// 비밀번호 라벨위치 +크기
		pswrd.setLocation(label.getLocation().x, label.getLocation().y + 50);
		pswrd.setSize(40, 15);

		// 아이디 텍스트 파일 위치 및 크기
		txtID.setLocation(label.getLocation().x + 50, label.getLocation().y - 10);
		txtID.setSize(200, 30);

		// 아이디 텍스트 파일 위치 및 크기
		txtPass.setLocation(label.getLocation().x + 50, label.getLocation().y + 50 - 10);
		txtPass.setSize(200, 30);

		// 로그인 버튼 위치
		logBtn.setLocation(label.getLocation().x, label.getLocation().y + 130);
		logBtn.setSize(120, 30);

		// 회원가입 버튼 위치
		newMember.setLocation(label.getLocation().x + 160, label.getLocation().y + 130);
		newMember.setSize(120, 30);

		// 환영문구 위치 크기
		title.setLocation(label.getLocation().x, label.getLocation().y - 100);
		title.setSize(300, 50);
		Font font = new Font(null, Font.PLAIN, 18);
		title.setFont(font);

		txtID.setText("");
		txtPass.setText("");
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String pw = txtPass.getText();
				CheckID checkID = new CheckID(id);
				boolean tf = checkID.isAccountExist(id, pw);
				if (tf == true) {

					JOptionPane.showMessageDialog(null, "로그인 성공!");
					System.out.println(id+"+"+pw);
					MainFrame.user.setUserId(id); //mainframe에있는 static user의 id,pw값을 변경
					MainFrame.user.setPassword(pw);
					
					((MainFrame)f).applyUserName(); //LoginPage ->MainPage로 UserId 정보 내보내기
					((MainFrame)f).isManager();  //mainpanel 이동전 user가 손님주인확인, 메뉴생성버튼을 안보이게 하기위해서
					f.setSize(800, 600);
					MyUtil.changePanel(f, LoginPanel.this, MainFrame.panels[1]);
					txtID.setText("");
					txtPass.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인하세요");
					txtID.setText("");
					txtPass.setText("");
				}

			}
		});

//		logBtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String id = "kang";
//				String pass = "1234";
//
//				if (id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
//					JOptionPane.showMessageDialog(null, "You have logged in Successfully!");
//					MyUtil.changePanel(f, LoginPanel.this,MainFrame.panels[1]);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "로그인 실패함.");
//				}
//					
//			}
//
//		});

		newMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtPass.setText("");
				MyUtil.changePanel(f, LoginPanel.this, MainFrame.panels[2]);
			}
		});

		add(label);
		add(txtID);
		add(pswrd);
		add(txtPass);
		add(logBtn);
		add(newMember);
		add(title);
	}

}
