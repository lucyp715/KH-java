package io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import model.vo.User;

public class CheckID {
	File f = new File("userAccount/userAccount.txt");
	String loadingId;

	public CheckID() {

	}

	public CheckID(String loadingId) {
		this.loadingId = loadingId;
		//System.out.println("checkID로 넘어온 id" + this.loadingId);
	}

	public boolean checkExistID(List<User> userArr) {

		if (userArr.size() != 0)
			return true;
		else
			return false;
	};

	public boolean isAccountExist(String id, String pw) {
		boolean tf =false;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			List<User> userList = (List<User>) ois.readObject();
			boolean exist = checkExistID(userList);
			if (exist == false) {
				
				return tf;

			} else {
				for (int i = 0; i < userList.size(); i++) {
					String nowID = userList.get(i).getUserId();
					String nowPW = userList.get(i).getPassword();
					
					//	System.out.println("검색 아이디" + nowID);
				//	System.out.println("입력 아이디" + this.loadingId);
					if (nowID.equals(this.loadingId)) {
						if(nowPW.equals(pw)) {
							return true;
						}
						else {
							return false;
						}
					}
				}
				tf=false;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("파일 다 읽음");
			tf = false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return tf;
	}
	
	public boolean isEmpty() {

		boolean tf = false;
		int count = -1;
		ObjectInputStream ois =null;
		if (f.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				List<User> userList = (List<User>) ois.readObject();
				boolean exist = checkExistID(userList);
				if (exist == false) {
					//System.out.println("리스트에 회원이 존재하지 않음");
					tf = true;
					count = 0;
					return true;

				} else {
					//System.out.println("사이즈 : " + userList.size());
					for (int i = 0; i < userList.size(); i++) {
						String nowID = userList.get(i).getUserId();
					//	System.out.println("검색 아이디" + nowID);
					//	System.out.println("입력 아이디" + this.loadingId);
						if (nowID.equals(this.loadingId)) {
						//	System.out.println("아이디 일치하는거 발견");
							return false;
						}
					}
					tf=true;
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				System.out.println("파일 다 읽음");
				tf = true;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("여기옴 :"+tf);
			}
			return tf;
		}

		else {
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(f));
				List<User> userList = new ArrayList<User>();
				oos.writeObject(userList);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
					tf = true;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return tf;

	}

}
