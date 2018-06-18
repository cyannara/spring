package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("tv")   //lgTV
public class LgTV implements TV{
	
	@Autowired    //DI(dependency Injection) :의존관계에 있는 객체를 주입 
	Speaker speaker;	
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}
	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		//System.out.println("LG TV--볼륨 up");
		speaker.volumeUp();
	}
	public void volumeDown() {
		//System.out.println("LG TV--볼륨 down");
		speaker.volumeDown();
	}	
}
