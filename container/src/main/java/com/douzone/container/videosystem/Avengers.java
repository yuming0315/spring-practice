package com.douzone.container.videosystem;

public class Avengers implements DigitalVideoDisc {
	private String title = "Avengers";
	private String studio = "MARVLE";
	
	@Override
	public String play() {
		return "Playing Movie "+studio+"'s "+title;
	}

}
