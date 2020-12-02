package com.collection.list.music.model.vo;

import java.util.Objects;

/**
 * 
 * 
 * 1. vo클래스 작성
	@com.collection.list.music.model.vo.Music.java
	-title:String
	-singer:String
	getter/setter, 기본생성자/파라미터있는생성자, toString 오버라이드

 *
 */
public class Music implements Comparable<Music>{
	
	private String title;
	private String singer;
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
	@Override
	public int compareTo(Music o) {
		return this.singer.compareTo(o.singer);
	}


	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
