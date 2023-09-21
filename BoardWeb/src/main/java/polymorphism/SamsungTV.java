package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	@Autowired    //type
	//@Qualifier("appleSpeaker")  //id
	//@Resource(name="appleSpeaker")   //Resource = Autowired + Quailifier
	private Speaker speaker;
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	/*	public SamsungTV() { 
		System.out.println("samsung 객체 생성");
	}
	public SamsungTV(SonySpeaker speaker) {
		this.speaker = speaker;
		System.out.println("samsung 객체 생성 (스피커)");
	}	
	public SamsungTV(SonySpeaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
		System.out.println("samsung 객체 생성 (스피커,price)");
	}*/
	public void initMethod() {
		System.out.println("객체 초기화");
	}
	public void destoryMethod() {
		System.out.println("객체 삭제전 처리");
	}
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
