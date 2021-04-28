package com.dvlcube.app.jpa.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvlcube.app.manager.data.JobBean;

@Repository
public interface JobRepository extends JpaRepository<JobBean, Long>{
}
