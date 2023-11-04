package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.Warehouse;
import com.PIDEV.demo.repository.ProductRepository;
import com.PIDEV.demo.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	WarehouseRepository iWarehouseRepository;
	@Autowired
	ProductRepository iPorudctRepository;
	@Override
	public Warehouse addWarhouse(Warehouse w) {
		return iWarehouseRepository.save(w);
	}

	@Override
	public Warehouse getWarehouseById(int idWarehouse) {
		return iWarehouseRepository.findById(idWarehouse).orElse(null);
	}

	@Override
	public List<Warehouse> getAllWarehouses() {
		return iWarehouseRepository.findAll();
	}

	@Override
	public void deleteWarehouse(int idWarehouse) {
		iWarehouseRepository.deleteById(idWarehouse);
	}

	@Override
	public Warehouse updateWarhouseById(Warehouse warehouse, int idWarehouse) {
		Warehouse found= iWarehouseRepository.findById(idWarehouse).orElse(null);
		found.setCapacite(warehouse.getCapacite());
		found.setReference(warehouse.getReference());
		iWarehouseRepository.saveAndFlush(found);
		return found;
	}

}
