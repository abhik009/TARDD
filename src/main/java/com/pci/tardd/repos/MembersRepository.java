package com.pci.tardd.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pci.tardd.domain.Member;

@Repository
public interface MembersRepository extends JpaRepository<Member, Integer> {
}
