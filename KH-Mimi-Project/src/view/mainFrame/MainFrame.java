package view.mainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.vo.Dessert;
import model.vo.User;
import view.basicFrame.MyUtil;
import view.panels.DessertUploadPanel;
import view.panels.LoginPanel;
import view.panels.MainPanel;
import view.panels.NewMemberPanel;
import view.panels.OrderCheckPanel;
import view.panels.ResultPanel;
import view.panels.SpecificPanel;

public class MainFrame extends JFrame {

	JFrame thisFrame = this;

	public static JPanel[] panels = new JPanel[7];
	public static User user = new User();
	public static Dessert dessert = new Dessert();

	public MainFrame(int x, int y, int width, int height) {
		MyUtil.init(thisFrame, x, y, width, height);

		panels[0] = new LoginPanel(thisFrame);
		panels[1] = new MainPanel<Object>(thisFrame);
		panels[2] = new NewMemberPanel(thisFrame);
		panels[3] = new SpecificPanel(thisFrame);
		panels[4] = new ResultPanel(thisFrame);
		panels[5] = new DessertUploadPanel(thisFrame);
		panels[6] = new OrderCheckPanel(thisFrame);
		add(panels[0]);
	}

	// LoginPage ->MainPage로 UserId 정보 내보내기정보 내보내기
	public void applyUserName() {
		((MainPanel) panels[1]).getAccount().setText(user.getUserId() + "님 환영합니다!");
	}

	// 관리자 계정 아니면 메뉴생성 버튼 안보이게 하기
	public void isManager() {
		String isManager = user.getUserId();
		if (isManager.equals("kang")) {
			((MainPanel) panels[1]).getNewbtn().setVisible(true);
		} else {
			((MainPanel) panels[1]).getNewbtn().setVisible(false);
		}
	}

	
}
