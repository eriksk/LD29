package se.skoggy.input;


public class InputState {

	public Thumbsticks thumbsticks;
	public Triggers triggers;
	public DPad dPad;
	
	public boolean button1;
	public boolean button2;
	public boolean button3;
	public boolean button4;

	public boolean shoulderLeft;
	public boolean shoulderRight;
	
	public boolean select;
	public boolean start;
	
	public InputState() {
		thumbsticks = new Thumbsticks();
		triggers = new Triggers();
		dPad = new DPad();
	}	
	
	public void copyTo(InputState other){
		other.thumbsticks.left.x = thumbsticks.left.x;
		other.thumbsticks.left.y = thumbsticks.left.y;
		other.thumbsticks.right.x = thumbsticks.right.x;
		other.thumbsticks.right.y = thumbsticks.right.y;
		other.triggers.left = triggers.left;
		other.triggers.right = triggers.right;
		other.dPad.left = dPad.left;
		other.dPad.up = dPad.up;
		other.dPad.right = dPad.right;
		other.dPad.down = dPad.down;
		other.button1 = button1;
		other.button2 = button2;
		other.button3 = button3;
		other.button4 = button4;
		other.select = select;
		other.start = start;
		other.shoulderLeft = shoulderLeft;
		other.shoulderRight = shoulderRight;
	}
}
