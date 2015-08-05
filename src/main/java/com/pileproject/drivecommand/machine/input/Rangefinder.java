package com.pileproject.drivecommand.machine.input;

import java.util.HashMap;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.DeviceBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

public class Rangefinder extends DeviceBase {

	public Rangefinder(int port, ProtocolBase protocol) {
		super(port, protocol);
	}

	/**
	 * Get the distance between obstacles and this sensor
	 * 
	 * @return distance (in centimeter)
	 */
	public int getDistance() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_RANGEFINDER_DIST, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.RANGEFINDER;
	}

}