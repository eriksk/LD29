package se.skoggy.input;

public abstract class KeyCodes {

	public abstract int thumbstickLeftAxisX();
	public abstract int thumbstickLeftAxisY();
	
	public abstract int thumbstickRightAxisX();
	public abstract int thumbstickRightAxisY();

	public abstract int triggerLeft();
	public abstract int triggerRight();
	
	public abstract int shoulderLeft();
	public abstract int shoulderRight();

	public abstract int dPadLeft();
	public abstract int dPadUp();
	public abstract int dPadRight();
	public abstract int dPadDown();

	public abstract int button1();
	public abstract int button2();
	public abstract int button3();
	public abstract int button4();

	public abstract int buttonSelect();
	public abstract int buttonStart();
}
