package com.dvlcube.app.jpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dvlcube.app.manager.data.SkillBean;
import com.dvlcube.app.jpa.BasicRepository;
import com.dvlcube.app.jpa.DvlRepository;

/**
 * @since 4 de jun de 2019
 * @author Ulisses Lima
 */
@Repository
public interface SkillRepository extends DvlRepository<SkillBean, Long>, BasicRepository<SkillBean, Long> {
	
	@Query("select s from SkillBean s where s.name = ?1")
	Optional<SkillBean> findByName(String name);
	
	@Query("select count(s) = 1 from SkillBean s where s.name = ?1")
	boolean ifExistByName(String name);
}
