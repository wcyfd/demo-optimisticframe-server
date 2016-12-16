package com.randioo.demo_optimisticframe_server.entity.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.randioo.randioo_server_base.utils.StringUtils;

public class Role extends GameRole {
	/** 是否准备完成 */
	private boolean prepare;
	/** 拥有的飞机 */
	private String planesStr;
	/** 拥有的飞机列表 */
	private List<Integer> planes = new ArrayList<>();
	/** 使用的飞机 */
	private String usePlanesStr;
	/** 使用的飞机列表 */
	private Map<Integer, Integer> usePlanes = new HashMap<>();
	/** 分数 */
	private int score;

	public void setPrepare(boolean prepare) {
		this.prepare = prepare;
	}

	public boolean isPrepare() {
		return prepare;
	}

	public String getPlanesStr() {
		StringBuilder sb = new StringBuilder();
		for (Integer planeId : planes) {
			sb.append(planeId).append(",");
		}
		planesStr = sb.toString();
		return planesStr;
	}

	public void setPlanesStr(String planesStr) {
		if (planesStr == null || planesStr.equals("")) {
			return;
		}
		this.planesStr = planesStr;
		planes.clear();
		String[] data = planesStr.split(",");
		int i = 0;
		while (i < data.length) {
			planes.add(Integer.parseInt(data[i++]));
		}
	}

	public List<Integer> getPlanes() {
		return planes;
	}

	public String getUsePlanesStr() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Integer> entrySet:usePlanes.entrySet()){
			sb.append(entrySet.getKey()).append(",").append(entrySet.getValue()).append(",");
		}
		this.usePlanesStr = sb.toString();
		return usePlanesStr;
	}

	public void setUsePlanesStr(String usePlanesStr) {
		if(usePlanesStr == null||usePlanesStr.equals("")){
			return;
		}
		this.usePlanesStr = usePlanesStr;
		usePlanes.clear();
		String[] data = usePlanesStr.split(",");
		int i = 0;
		while(i<data.length){
			int index = Integer.parseInt(data[i++]);
			int planeId = Integer.parseInt(data[i++]);
			usePlanes.put(index, planeId);
		}
		
	}

	public Map<Integer, Integer> getUsePlanes() {
		return usePlanes;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		setChange(true);
		this.score = score;
	}

	@Override
	public boolean checkChange() {
		return StringUtils.checkChange(planesStr, getPlanesStr(), usePlanesStr, getUsePlanesStr());
	}

}
