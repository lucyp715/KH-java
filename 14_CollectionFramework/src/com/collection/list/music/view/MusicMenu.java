package com.collection.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.collection.list.music.controller.MusicManager;
import com.collection.list.music.model.vo.Music;
import com.collection.list.music.view.compare.MusicBySingerDecending;
import com.collection.list.music.view.compare.MusicByTitleAscending;
import com.collection.list.music.view.compare.MusicByTitleDecending;

public class MusicMenu {
	private  MusicManager manager = new MusicManager();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {

		int choice;
		while(true) {
			System.out.println("\n================ Music Playlist Menu ================\n"
								+" 1.목록보기\r\n"
								+" 2.마지막에 음악추가\r\n" 
								+" 3.맨처음에 음악추가\r\n"
								+" 4.곡삭제\r\n"
								+" 5.곡변경\r\n" 
								+" 6.곡검색\r\n"
								+" 7.가수검색\r\n"
								+" 8.목록정렬(곡명오름차순)\r\n"
								+" 0.종료\r\n"
								+"================================================================\r\n");
						System.out.print("메뉴선택 : ");
						
			
			choice =sc.nextInt();
		
			boolean result = false;
			switch (choice) {
			case 0 : 
				System.out.println("프로그램이 종료되었습니다");
				return;
			case 1 : 
				//목록보기
				printList(manager.selectList());
					break;
			case 2 : 
				//마지막에 음악주기
				manager.addList(inputMusic());
				break;
			case 3 : 
				//맨처음에 음악추가
				manager.addAtZero(inputMusic());
				break;
			case 4 : 
				//곡삭제
				result = manager.removeMusic(inputTitle());
				System.out.println(result ? "> 삭제 성공!" : "> 삭제 실패! 찾으시는 곡이 없습니다.");
				break;
			case 5 : 
				//곡변경
				result = manager.replaceMusic(inputMusic(), inputMusic());
				System.out.println(result ? "> 수정 성공!" : "> 수정 실패! 찾으시는 곡이 없습니다.");
				break;
			case 6 : 
				//곡검색
				printList(manager.searchMusicByTitle(inputTitle()));
				break;
			case 7 : 
				//가수검색
				printList(manager.searchMusicBySinger(inputSinger()));
				break;
			case 8: orderMenu(); 
				break; 
				
				
			}
		}
	}


	public void orderMenu() {
				
		String orderMenu = "================== 정렬 메뉴 ===================\r\n" + 
				"1. 가수명 오름차순\r\n" + 
				"2. 가수명 내림차순\r\n" + 
				"3. 곡명 오름차순\r\n" + 
				"4. 곡명 내림차순\r\n" + 
				"5. 메인메뉴 돌아가기\r\n" + 
				"================================================\r\n" + 
				" >> 메뉴 선택 : ";
				
				while(true) {				
				System.out.println(orderMenu);
				int choice2 = sc.nextInt();
			
				switch(choice2) {
				case 1:
					printList(manager.orderBy(null));
					break;
				
				case 2:
					printList(manager.orderBy(new MusicBySingerDecending()));
					break;
				case 3:
					printList(manager.orderBy(new MusicByTitleAscending()));
					break;
				case 4:
					printList(manager.orderBy(new MusicByTitleDecending()));
					break;
				case 5: 
					default:
					System.out.println("프로그램이 종료되었습니다");
			}
				
				}
		}
		//리스트 출력		
		public void printList(List<Music> list) {
			System.out.println(list);
		}
		//곡출력
		public String  inputTitle() {
			System.out.println("곡을 입력하세요 : ");
			return sc.nextLine();
		}
		//가수출력
		public String inputSinger() {
			System.out.println("가수를 입력하세요 : ");
			return sc.nextLine();
			
		}
		//둘다출력
		public Music inputMusic() {
			System.out.println("곡을 입력하세요 : ");
			String title = sc.nextLine();
			System.out.print("가수를 입력하세요 : ");
			String singer = sc.nextLine();
			return new Music(title, singer);
			
		}
		
		
	
}
