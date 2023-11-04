package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.Warehouse;

import java.util.List;

public interface WarehouseService {
	Warehouse addWarhouse(Warehouse w);
	Warehouse getWarehouseById(int idWarehouse);
	List<Warehouse> getAllWarehouses();
	 void deleteWarehouse(int idWarehouse);
	 Warehouse updateWarhouseById(Warehouse warehouse,int idWarehouse); 
}
