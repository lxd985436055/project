package com.bw.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.asm.Type;
import com.bw.entity.Plant;
import com.bw.mapper.PlantMapperDao;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantMapperDao plantMapperDao;

	@Override
	public List<Map<String, Object>> plantList(Map<String, Object> map) {
		return plantMapperDao.plantList(map);
	}

	@Override
	public List<Type> typeList() {
		return plantMapperDao.typeList();
	}

	@Override
	public int addPlant(Plant plant) {
		return plantMapperDao.addPlant(plant);
	}

	@Override
	public int deleteAll(String[] pids) {
		return plantMapperDao.deleteAll(pids);
	}

	@Override
	public int delete(int pid) {
		return plantMapperDao.delete(pid);
	}

	@Override
	public Plant getPlantByPid(int pid) {
		return plantMapperDao.getPlantByPid(pid);
	}

	@Override
	public int updatePlant(Plant plant) {
		return plantMapperDao.updatePlant(plant);
	}
	
	
}
