package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.asm.Type;
import com.bw.entity.Plant;

public interface PlantMapperDao {

	List<Map<String, Object>> plantList(Map<String, Object> map);

	List<Type> typeList();

	int addPlant(Plant plant);

	int deleteAll(String[] pids);

	int delete(int pid);

	Plant getPlantByPid(int pid);

	int updatePlant(Plant plant);
}
