package com.dvlcube.app.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dvlcube.app.jpa.repo.JobRepository;
import com.dvlcube.app.manager.data.JobBean;
import com.dvlcube.app.manager.data.vo.MxRestResponse;

@RestController
public class JobService {
	
	@Autowired
	JobRepository jobRepository;
	
	@GetMapping(value = "/jobs")
	public Optional<JobBean> get(@RequestParam(value = "id") String id) {
		Optional<JobBean> jobBean = jobRepository.findById(Long.parseLong(id));
		return jobBean;
	}
	
	@PostMapping(value = "/jobs")
	public MxRestResponse post(JobBean job) {
		JobBean saved = jobRepository.save(job);
		return GenericRestResponse.ok(saved.getId());
	}
	
	@DeleteMapping(value = "/jobs")
	public void delete(@RequestParam(value = "id") String id) {
		jobRepository.deleteById(Long.parseLong(id));
	}
}
