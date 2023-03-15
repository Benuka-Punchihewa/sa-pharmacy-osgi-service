package com.sliit.orderpublisher;

import java.util.ArrayList;

public interface ServicePublish {
	public Order createOrder(int userId, ArrayList<Medicine> medicines);
}
