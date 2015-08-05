package com.pileproject.drivecommand.machine;

import java.io.IOException;

import com.pileproject.drivecommand.machine.input.ColorSensor;
import com.pileproject.drivecommand.machine.input.GyroSensor;
import com.pileproject.drivecommand.machine.input.LineSensor;
import com.pileproject.drivecommand.machine.input.Rangefinder;
import com.pileproject.drivecommand.machine.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.input.SoundSensor;
import com.pileproject.drivecommand.machine.input.TouchSensor;
import com.pileproject.drivecommand.machine.output.Buzzer;
import com.pileproject.drivecommand.machine.output.Led;
import com.pileproject.drivecommand.machine.output.Motor;
import com.pileproject.drivecommand.machine.output.Servomotor;
import com.pileproject.drivecommand.model.ProtocolBase;

public class Machine {
	private ProtocolBase mProtocol;
	
	public Machine(ProtocolBase protocol) {
		mProtocol = protocol;
	}
	
	/**
	 * Connect to device
	 * 
	 * @throws IOException
	 */
	public void connect() throws IOException {
		mProtocol.open();
	}
	
	/**
	 * Disconnect from device
	 */
	public void disconnect() {
		mProtocol.close();
	}
	
	/**
	 * Transaction apply command
	 * for Pile Robot
	 */
	public void apply() {
		mProtocol.apply();
	}
	
	/**
	 * Create LineSensor
	 * 
	 * @param port
	 * @return
	 */
	public LineSensor createLineSensor(int port) {
		return new LineSensor(port, mProtocol);
	}
	
	/**
	 * Create Motor
	 * 
	 * @param port
	 * @return
	 */
	public Motor createMotor(int port) {
		return new Motor(port, mProtocol);
	}

	/**
	 * Create Servomotor
	 * 
	 * @param port
	 * @return
	 */
	public Servomotor createServomotor(int port) {
		return new Servomotor(port, mProtocol);
	}
	
	/**
	 * Create Buzzer
	 * 
	 * @param port
	 * @return
	 */
	public Buzzer createBuzzer(int port) {
		return new Buzzer(port, mProtocol);
	}

	/**
	 * Create LED
	 * 
	 * @param port
	 * @return
	 */
	public Led createLed(int port) {
		return new Led(port, mProtocol);
	}

	/**
	 * Create GyroSensor
	 * 
	 * @param port
	 * @return
	 */
	public GyroSensor createGyroSensor(int port) {
		return new GyroSensor(port, mProtocol);
	}

	/**
	 * Create TouchSensor
	 * 
	 * @param port
	 * @return
	 */
	public TouchSensor createTouchSensor(int port) {
		return new TouchSensor(port, mProtocol);
	}

	/**
	 * Create ColorSensor
	 * 
	 * @param port
	 * @return
	 */
	public ColorSensor createColorSensor(int port) {
		return new ColorSensor(port, mProtocol);
	}

	/**
	 * Create Rangefinder
	 * 
	 * @param port
	 * @return
	 */
	public Rangefinder createRangefinder(int port) {
		return new Rangefinder(port, mProtocol);
	}

	/**
	 * Create SoundSensor
	 * 
	 * @param port
	 * @return
	 */
	public SoundSensor createSoundSensor(int port) {
		return new SoundSensor(port, mProtocol);
	}

	/**
	 * Create RemoteControlReciever
	 * 
	 * @param port
	 * @return
	 */
	public RemoteControlReceiver createRemoteControlReceiver(int port) {
		return new RemoteControlReceiver(port, mProtocol);
	}
}