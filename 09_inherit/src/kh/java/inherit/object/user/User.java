package kh.java.inherit.object.user;

/**
 * Override Overriding
 * 자식클래스에서 부모클래스의 메소드를 재작성
 * 1. 메소드명, 파라미터 타입 및 개수, 리턴타입 모두 동일해야함.
 *   - @Override 어노테이션을 통해 컴파일타임 체크
 * 2. 접근제한자는 부모메소드보다 확장할 수 있다.
 *   -default - protected - public
 *   -private 메소드 직접접근 할 수 없어서(getter/setter사용) Override불가
 *   -final메소드는 override불가
 * 3. 부모메소드가 던지는 예외클래스는 더 적은범위로 수정가능
 *   - 개수를 줄잉거나 상속관계를 고려해 자식클래스로 변경
 *
 */
public final class User {
	
	private String username;
	private String password;
	
		

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
/**
 * 복사 생성자
 * 동일한 필드값
 */
	public User(User u) {
		this.username = u.username;
		this.password = u.password;
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "[username = " + username + ", password =" + password +"]";
	}
	
	/**
	 * 필드값 username, password가 같다면 동일한 객체로 취급
	 */
	@Override
	public boolean equals(Object obj) {
		//Obj.username Object타입은 username, password 필드에 접근할수없다
		User other = (User)obj;  //Object 타입을 User타입으로 형변환
		
		if(!username.contentEquals(other.username))
			return false; 
		if(!password.contentEquals(other.password))
			return false;
		return true;
	}
	/**
	 * equals 비교에 사용했던 필드값을 가져와 hashCode 생성에 사용
	 * 문자열 hashCode 생성사용
	 */
	@Override
	public int hashCode() {
		return (username + password).hashCode();
	}
	
	/**
	 * 공변반환타입 Covariant Return Type
	 * 오버라이딩시 부모메서드의 반환타입을 자식클래스타입으로 변경 가능
	 * jdk1.5
	 */
	@Override
	public User clone() {
		//복사 생성자
		return new User(this);
	}

}

//	class UserDetail extends User{} ->final 은 쓸수없다