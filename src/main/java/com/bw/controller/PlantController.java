package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.asm.Type;
import com.bw.entity.Plant;
import com.bw.service.PlantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PlantController {

	@Resource
	private PlantService plantService;
	
	@RequestMapping("list.do")
	public String list(Model model,@RequestParam(defaultValue="")String pname,
	@RequestParam(defaultValue="1")int cpage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pname", pname);
		
		PageHelper.startPage(cpage, 3);
		List<Map<String, Object>> plantList = plantService.plantList(map);
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String, Object>>(plantList);
		
		model.addAttribute("plantList", plantList);
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		model.addAttribute("page", pageInfo);
		return "list";
	}
	
	@RequestMapping("toAdd.do")
	public String toAdd() {
		return "add";
	}
	
	@RequestMapping("getTypeList.do")
	@ResponseBody
	public Object getTypeList() {
		List<Type> type2 = plantService.typeList();
		return type2;
	}
	
	@RequestMapping("addPlant.do")
	@ResponseBody
	public Object addPlant(Plant plant) {
		int i = plantService.addPlant(plant);
		return i;
	}
	
	@RequestMapping("deleteAll.do")
	@ResponseBody
	public Object deleteAll(String[] pids) {
		System.out.println(pids);
		int i = plantService.deleteAll(pids);
		return i;
	}
	
	@RequestMapping("delete.do")
	public String delete(int pid) {
		int i = plantService.delete(pid);
		return "redirect:list.do";
	}
	
	@RequestMapping("toUpdate.do")
	public String toUpdate(int pid,Model model) {
		Plant plant = plantService.getPlantByPid(pid);
		List<Type> typeList = plantService.typeList();
		model.addAttribute("plant", plant);
		model.addAttribute("typeList", typeList);
		return "update";
	}
	
	@RequestMapping("updatePlant.do")
	@ResponseBody
	public Object updatePlant(Plant plant) {
		int i = plantService.updatePlant(plant);
		return i;
	}
	
}
