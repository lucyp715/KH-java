package member.model.vo;

public class Gold extends Member{

	
	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gold(String name, String grade, int point) {
		super(name, grade, point);

	}
	@Override
	public double getEjapoint() {
		return super.getPoint() * 0.05;
	}
	
}
