package com.sliit.orderpublisher;

import java.util.ArrayList;

public interface OrderServicePublish {
	public Order createOrder(int userId, ArrayList<OrderMedicine> medicines);
	public ArrayList<Order> getOrders();
}
