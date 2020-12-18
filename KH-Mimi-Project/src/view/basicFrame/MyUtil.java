package view.basicFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.vo.User;
import view.panels.LoginPanel;
import view.panels.MainPanel;
import view.panels.ResultPanel;
import view.panels.SpecificPanel;

public class MyUtil {
	
	public static void init(JFrame frame, int x, int y, int width, int height) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception useDefault) {
        }
		
		frame.setTitle("과자방 :)");
		frame.setBounds(x, y, width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void changePanel(JFrame f, JPanel current, JPanel next) {
		f.remove(current);
		f.add(next);
		
		//다시그리기 작업
		f.revalidate();
		f.repaint(); // -> 이게 페이지가 바뀌고 있는 것
		
		
	}
}
