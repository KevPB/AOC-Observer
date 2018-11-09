package aoc;

public class Display implements ObserverGenerator {
	
	private Integer value;
	
	private Channel channel;

	public Display(Channel channel) {
		this.value = 0;
		this.channel = channel;
	}

	public void update(Generator generator) throws Exception {
		value = channel.getValue().get();
	}

	public Integer getValue() {
		return value;
	}

	
	
}
