package com.randioo.demo_optimisticframe_server.entity;


public class Action {
	private boolean isKeyFrame;
	private int keyFrame;
	private int targetId;
	private int x;
	private int y;

	public Action() {
	}

	

	public int getKeyFrame() {
		return keyFrame;
	}

	public void setKeyFrame(int keyFrame) {
		this.keyFrame = keyFrame;
	}

	public boolean isKeyFrame() {
		return isKeyFrame;
	}

	public void setKeyFrame(boolean isKeyFrame) {
		this.isKeyFrame = isKeyFrame;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	

}
