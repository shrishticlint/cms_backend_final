package com.hexaware.cms.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.hexaware.cms.entity.PlanDetails;
@Repository
@EnableJpaRepositories

public interface PlanDetailsRepository extends JpaRepository<PlanDetails, Long> {
	public List<PlanDetails> findByPlanNameAndInsuredAmount(String planName,Long insuredAmount);

}
