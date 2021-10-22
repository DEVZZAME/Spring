package vo;

public class PersonVO {
	private String name, tel;
	private int age;
	
	public PersonVO(String name, int age, String tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		System.out.println("--생성자 인젝션을 통해 호출된 생성자--");
	}
	
	//생성자
	public PersonVO() {
		System.out.println("--PersonVO의 생성자가 호출됨--");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("--setName()메서드 호출--");
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
