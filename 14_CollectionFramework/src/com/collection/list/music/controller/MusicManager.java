package com.collection.list.music.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.model.vo.Music;

public class MusicManager {
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Music> mList = new ArrayList<>();	{
	
	mList.add(new Music("Martini blue", "DPR Live"));
	mList.add(new Music("New Friends", "Maty Noyes"));
	mList.add(new Music("yes & no", "Xylo"));
	mList.add(new Music("GRRRLS", "AViVA"));
	mList.add(new Music("Angry Too", "DLola blanc"));
	}
	//음악리스트 리턴
	public List<Music> selectList() {
		return mList;
	}
	//마지막에 음악추가 : 사용자로부터 곡명과 가수를 입력받아 리스트에 저장하는 메소드. 
	public void addList(Music m) {
		mList.add(m);
	}
	//맨처음에 음악추가 : 리스트 최상위(0번지)에 음악을 추가하는 메소드
	public void addAtZero(Music m) {
		mList.add(0,m); //앞에 삭제되니깐
	}
	// 특정곡을 삭제하는 메소드(제목을 전달받아 검색후, 최초로 검색된 음악을 삭제)
	  //  삭제여부를 리턴
	public boolean removeMusic(String title) {
		//1.리스트를 열람후 곡을 찾음
				for(int i=0; i<mList.size(); i++) {
					//3.해당곡이 있을 경우 삭제
					if(title.equals(mList.get(i).getTitle())) {
						mList.remove(i);
//						mList.remove(mList.get(i));
						return true;
					}
				}
				
				//4.해당곡이 없을 경우에는 찾는 곡이 없는 경우
				return false;
					
			}

		
	//특정곡을 바꾸는 메소드(이전 음악객체, 새 음악객체를 전달해서 교체)
   // 교체 성공여부를 리턴
	public boolean replaceMusic(Music oldMusic, Music newMusic) {
		//1.리스트를 열람후 곡을 찾음
				for(int i=0; i<mList.size(); i++) {
					//3.해당곡이 있을 경우 새로운 music객체(사용자 입력)
					if(oldMusic.equals(mList.get(i))) {
						//대체
						mList.set(i, newMusic);
						return true;
					}
				}
				
				//4.해당곡이 없을 경우;
				return false;
			}

	//특정곡이 있는지 검사하는 메소드 : 복수개의 결과가 나올수 있음. 
	//(곡명일부로 검색해서 해당곡이 있다면, 곡정보(제목/가수)를 출력하고,
	//없다면, "검색결과가 없습니다"출력)
	public List<Music> searchMusicByTitle(String title) {
		List<Music> searchList = new ArrayList<>();
		for(int i=0; i<mList.size(); i++) {
			//2.해당곡이 있을 경우 출력
			if(mList.get(i).getTitle().contains(title)) 
				searchList.add(mList.get(i));
		}
		
		return searchList;
	}


	//7. 가수명으로 검색 메소드 : 복수개의 결과가 나올수 있음.
	public List<Music> searchMusicBySinger(String singer) {
		//검색된 결과를 담을 리스트
		List<Music> searchList = new ArrayList<>();
		
		//1.리스트 순회 
		for(int i=0; i<mList.size(); i++) {
			//2.해당가수의 곡이 있을경우 출력
			if(mList.get(i).getSinger().contains(singer)) {	
				searchList.add(mList.get(i));				
			}
		}
		
		return searchList;
	}

	
	//8. 서브메뉴 - 각 정렬 메소드 : Comparable/Comparator 인터페이스를 적절히 활용할 것
	public List<Music> orderBy(Comparator<Music> c) {
		List<Music> mList = (List<Music>)((ArrayList)this.mList).clone();
		mList.sort(c);
		return mList;
		
	}
	
 
	

}