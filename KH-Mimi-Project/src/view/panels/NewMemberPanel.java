package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AccountController;
import io.CheckID;
import model.vo.User;
import view.basicFrame.MyUtil;
import view.mainFrame.MainFrame;

public class NewMemberPanel extends JPanel {

	JButton checkid = new JButton("아이디 조회");
	JButton welcome = new JButton("회원가입");
	JButton back = new JButton("돌아가기");

	JLabel label = new JLabel("생성 아이디    : ");
	JLabel pswrd = new JLabel("생성 비밀번호 : ");

	JTextField txtID = new JTextField(10);
	JPasswordField txtPW = new JPasswordField(10);
	AccountController accountControl = new AccountController();

	String id, pw;
	CheckID checkID;
	boolean empty;

	public NewMemberPanel(JFrame f) {
		txtID.setText("");
		txtPW.setText("");
		welcome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id = txtID.getText();
				pw = txtPW.getText();
				if ((empty == true) && pw.length() >= 4) {
					User user = new User(id, pw);
					accountControl.generate(user);
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					MyUtil.changePanel(f, NewMemberPanel.this, MainFrame.panels[0]);

				} else {
					if (empty == false) {
						JOptionPane.showMessageDialog(null, "아이디 검사 다시하세요");
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 4자리 이상 입력하세요");
					}
				}
			}
		});

		checkid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id = txtID.getText();
				System.out.println("현재 입력 아이디:"+id);
				checkID = new CheckID(id);

				empty = checkID.isEmpty();

				if (empty == false) {
					JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.");
					txtID.setText("");
					id=txtID.getText();
				} else {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				}
			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtPW.setText("");
				MyUtil.changePanel(f, NewMemberPanel.this, MainFrame.panels[0]);
			}
		});

		add(label);
		add(txtID);
		add(pswrd);
		add(txtPW);
		add(checkid);
		add(back);
		add(welcome);
	}
}
