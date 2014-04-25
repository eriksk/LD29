package se.skoggy.input.keycodes;

import com.badlogic.gdx.controllers.mappings.Ouya;
import se.skoggy.input.KeyCodes;

/**
 * Created by Erik on 2014-04-19.
 */
public class OUYAControllerKeyCodes extends KeyCodes {
    @Override
    public int thumbstickLeftAxisX() {
        return Ouya.AXIS_LEFT_X;
    }

    @Override
    public int thumbstickLeftAxisY() {
        return Ouya.AXIS_LEFT_Y;
    }

    @Override
    public int thumbstickRightAxisX() {
        return Ouya.AXIS_RIGHT_X;
    }

    @Override
    public int thumbstickRightAxisY() {
        return Ouya.AXIS_RIGHT_Y;
    }

    @Override
    public int triggerLeft() {
        return Ouya.AXIS_LEFT_TRIGGER;
    }

    @Override
    public int triggerRight() {
        return Ouya.AXIS_RIGHT_TRIGGER;
    }

    @Override
    public int shoulderLeft() {
        return Ouya.BUTTON_L1;
    }

    @Override
    public int shoulderRight() {
        return Ouya.BUTTON_R1;
    }

    @Override
    public int dPadLeft() {
        return Ouya.BUTTON_DPAD_LEFT;
    }

    @Override
    public int dPadUp() {
        return Ouya.BUTTON_DPAD_UP;
    }

    @Override
    public int dPadRight() {
        return Ouya.BUTTON_DPAD_RIGHT;
    }

    @Override
    public int dPadDown() {
        return Ouya.BUTTON_DPAD_DOWN;
    }

    @Override
    public int button1() {
        return Ouya.BUTTON_O;
    }

    @Override
    public int button2() {
        return Ouya.BUTTON_A;
    }

    @Override
    public int button3() {
        return Ouya.BUTTON_U;
    }

    @Override
    public int button4() {
        return Ouya.BUTTON_Y;
    }

    @Override
    public int buttonSelect() {
        return Ouya.BUTTON_MENU;
    }

    @Override
    public int buttonStart() {
        return Ouya.BUTTON_MENU;
    }
}
