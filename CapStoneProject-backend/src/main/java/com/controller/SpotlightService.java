package com.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.QueryParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbOperations.HibernateSpotDBOperation;
import com.model.SpotLight;

@CrossOrigin
//@Transactional
@RestController
//@RequestMapping("/spotlight")
public class SpotlightService {

	@GetMapping("/Spotlight_Details")
	public List<SpotLight> getSL() {
		// System.out.println("getSL");
		HibernateSpotDBOperation hsl = new HibernateSpotDBOperation();
		List<SpotLight> slList = hsl.getAllSL();
		hsl.closeSession();
		return slList;
	}

	@PostMapping("/insert_data")
	public String insertSL(@RequestBody SpotLight sl) {
		System.out.println("getinsert");
		String status = "false";
		HibernateSpotDBOperation hsl = new HibernateSpotDBOperation();
		int i = hsl.insertSL(sl);
		if (i > 0) {
			status = "true";
		}
		hsl.closeSession();
		return status;
	}

	@PutMapping("/update_data")
	public String updateSL(@RequestBody SpotLight sl) {
		String updateflag = "false";
		HibernateSpotDBOperation hsl = new HibernateSpotDBOperation();
		SpotLight spotLight = hsl.getSL(sl.getId());
		if (sl != null) {
			hsl.updateSL(sl);
			updateflag = "true";
		}
		return updateflag;
	}

	@DeleteMapping("/delete_data")
	public boolean DeleteSL(@QueryParam("id") int id) {
		HibernateSpotDBOperation hsl = new HibernateSpotDBOperation();
		boolean flagDelete = hsl.deleteSL(id);
		hsl.closeSession();
		return flagDelete;
	}

	@PostMapping("/multiple_delete")
	public boolean DeleteMultiple(@RequestBody int arr[]) {
		HibernateSpotDBOperation hsl = new HibernateSpotDBOperation();
		boolean flagDelete = hsl.deleteMSL(arr);
		hsl.closeSession();
		return flagDelete;
	}

	// public String ShowSpotlight(String sdate , String edate)
	// { var1 = sdate; var2 = edate;
	// ("select * from spotlight_deatils where enddate=?"); }

}
