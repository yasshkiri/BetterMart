package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.Warehouse;
import com.PIDEV.demo.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	
	@PostMapping("/addWarehouse")
    @ResponseBody
    public Warehouse addWarehouse(@Valid  @RequestBody Warehouse w)
    {
		return warehouseService.addWarhouse(w);
    }
	
	@GetMapping("/getAllWarehouses")
    public List<Warehouse> getAllWarehouses(){
		return warehouseService.getAllWarehouses();
	  
	}
	
	
	@GetMapping ("/getWarehouse/{IdWarehouse}")
	@ResponseBody
   public 	Warehouse getWarehousesById (@PathVariable("IdWarehouse") int idWarehouse)
   {
		return warehouseService.getWarehouseById( idWarehouse);
   }
	@DeleteMapping("/deleteWarehouse/{idWarehouse}")
	@ResponseBody
	void deleteWarehouse(@PathVariable("idWarehouse") int idWarehouse) {
		warehouseService.deleteWarehouse(idWarehouse);
	}
	@PutMapping("/modifyWarehouseByID/{idWarehouse}")
	@ResponseBody
	public Warehouse modifyWarehouseById(@PathVariable("idWarehouse") int idWarehouse,@RequestBody Warehouse warehouse) {
	return warehouseService.updateWarhouseById(warehouse, idWarehouse);
	}
}
