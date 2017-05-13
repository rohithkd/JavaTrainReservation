package com.railway.train;

public interface TrainDAO {

	public int getTrainsBySourceAndDes(String source, String dest);
	public void getListOfTrains();
}
