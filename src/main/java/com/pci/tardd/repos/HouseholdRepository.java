package com.pci.tardd.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pci.tardd.domain.Household;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Integer> {
	List<Household> findByVo(String vo);
	List<Household> findByClf(String clf);
}
