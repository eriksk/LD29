package se.skoggy.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

public class InputManager {

	private InputState inputState, inputStateCopy, oldState, oldStateCopy;
	private KeyCodes codes;
	private float deadZone;
	
	public InputManager(KeyCodes codes, float deadZone) {
		this.codes = codes;
		this.deadZone = deadZone;
		inputState = new InputState();
		inputStateCopy = new InputState();
		oldState = new InputState();
		oldStateCopy = new InputState();
	}

    public float deadZone(){
        return deadZone;
    }
	
	public InputState getState(){
		inputState.copyTo(inputStateCopy);
		return inputStateCopy;
	
	}
	
	public InputState getOldState() {
		oldState.copyTo(oldStateCopy);
		return oldStateCopy;
	}
	
	public void update(){
		inputState.copyTo(oldState);
		for (Controller c : Controllers.getControllers()) {
			inputState.button1 = c.getButton(codes.button1());
			inputState.button2 = c.getButton(codes.button2());
			inputState.button3 = c.getButton(codes.button3());
			inputState.button4 = c.getButton(codes.button4());

			inputState.select = c.getButton(codes.buttonSelect());
			inputState.start = c.getButton(codes.buttonStart());

			inputState.dPad.left = c.getButton(codes.dPadLeft());
			inputState.dPad.right = c.getButton(codes.dPadRight());
			inputState.dPad.up = c.getButton(codes.dPadUp());
			inputState.dPad.down = c.getButton(codes.dPadDown());

			inputState.triggers.left = c.getAxis(codes.triggerLeft());
			inputState.triggers.right = c.getAxis(codes.triggerRight());

			inputState.thumbsticks.left.x = getValueForDeadZone(c.getAxis(codes.thumbstickLeftAxisX()));
			inputState.thumbsticks.left.y = getValueForDeadZone(c.getAxis(codes.thumbstickLeftAxisY()));
			
			inputState.thumbsticks.right.x = getValueForDeadZone(c.getAxis(codes.thumbstickRightAxisX()));
			inputState.thumbsticks.right.y = getValueForDeadZone(c.getAxis(codes.thumbstickRightAxisY()));		

			inputState.shoulderLeft = c.getButton(codes.shoulderLeft());
			inputState.shoulderRight = c.getButton(codes.shoulderRight());
			
		}
	}

	private float getValueForDeadZone(float value) {
		if(value < -deadZone)
			return value;
		if(value > deadZone)
			return value;
		return 0f;
	}
}
