package aoc;

import java.util.Observable;

public class Display extends Observable{
	
	private Integer value;
	
	private Channel channel;

	public void update(Generator subject) {
		channel.update(subject);
	}

	
	
}
