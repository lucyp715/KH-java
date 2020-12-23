package run;

import view.mainFrame.MainFrame;

/**
 * 관리자 계정 : kang /1234 
 *
 * 일반 계정 : park /5678
 * 		   seo /7890
 * 
 * refactoring
 */
public class Run {
	public static void main(String[] args) {
		new MainFrame(200,150,700,500).setVisible(true);
	}
}
