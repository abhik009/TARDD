package com.pci.tardd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pci.tardd.domain.Household;
import com.pci.tardd.domain.Member;
import com.pci.tardd.dto.MembersDTO;
import com.pci.tardd.model.MemberMaster;
import com.pci.tardd.repos.HouseholdRepository;
import com.pci.tardd.repos.MembersRepository;

@Service
public class MembersService {

	@Autowired
	private MembersRepository repository;
	@Autowired
	private HouseholdRepository hhRepository;

	public List<MembersDTO> findAll() {
		return repository.findAll().stream().map(members -> mapToDTO(members, new MembersDTO()))
				.collect(Collectors.toList());
	}

	public MembersDTO get(final Integer id) {
		return repository.findById(id).map(members -> mapToDTO(members, new MembersDTO()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Member create(final MembersDTO membersDTO) {
		final Member members = new Member();
		mapToEntity(membersDTO, members);
		return repository.save(members);
	}

	public int create(MemberMaster member, int hhId) {
		final Member members = new Member();
		mapMasterToEntity(member, members, hhId);
		return repository.save(members).getId();
	}

	public void update(final Integer id, final MembersDTO membersDTO) {
		final Member members = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		mapToEntity(membersDTO, members);
		repository.save(members);
	}

	public void delete(final Integer id) {
		repository.deleteById(id);
	}

	private MembersDTO mapToDTO(final Member members, final MembersDTO membersDTO) {
		membersDTO.setOnaId(members.getOnaId());
		membersDTO.setQ201(members.getQ201());
		membersDTO.setQ202(members.getQ202());
		membersDTO.setQ203(members.getQ203());
		membersDTO.setQ204(members.getQ204());
		membersDTO.setQ205(members.getQ205());
		membersDTO.setQ206(members.getQ206());
		membersDTO.setQ207(members.getQ207());
		membersDTO.setQ208(members.getQ208());
		membersDTO.setQ209(members.getQ209());
		membersDTO.setQ210(members.getQ210());
		membersDTO.setQ211(members.getQ211());
		membersDTO.setQ212(members.getQ212());
		membersDTO.setQ213(members.getQ213());
		membersDTO.setQ213Spy(members.getQ213Spy());
		membersDTO.setQ214(members.getQ214());
		membersDTO.setQ214Spy(members.getQ214Spy());
		membersDTO.setQ215(members.getQ215());
		membersDTO.setQ215Spy(members.getQ215Spy());
		membersDTO.setQ216(members.getQ216());
		membersDTO.setQ217(members.getQ217());
		membersDTO.setQ218(members.getQ218());
		membersDTO.setS1P(members.getS1P());
		membersDTO.setS1A(members.getS1A());
		membersDTO.setS2P(members.getS2P());
		membersDTO.setS2A(members.getS2A());
		membersDTO.setS3P(members.getS3P());
		membersDTO.setS3A(members.getS3A());
		membersDTO.setS4P(members.getS4P());
		membersDTO.setS4A(members.getS4A());
		membersDTO.setS5P(members.getS5P());
		membersDTO.setS5A(members.getS5A());
		membersDTO.setS6P(members.getS6P());
		membersDTO.setS6A(members.getS6A());
		membersDTO.setHouseholdId(members.getHouseholds() == null ? null : members.getHouseholds().getId());
		return membersDTO;
	}

	private Member mapToEntity(final MembersDTO membersDTO, final Member members) {
		members.setOnaId(membersDTO.getOnaId());
		members.setQ201(membersDTO.getQ201());
		members.setQ202(membersDTO.getQ202());
		members.setQ203(membersDTO.getQ203());
		members.setQ204(membersDTO.getQ204());
		members.setQ205(membersDTO.getQ205());
		members.setQ206(membersDTO.getQ206());
		members.setQ207(membersDTO.getQ207());
		members.setQ208(membersDTO.getQ208());
		members.setQ209(membersDTO.getQ209());
		members.setQ210(membersDTO.getQ210());
		members.setQ211(membersDTO.getQ211());
		members.setQ212(membersDTO.getQ212());
		members.setQ213(membersDTO.getQ213());
		members.setQ213Spy(membersDTO.getQ213Spy());
		members.setQ214(membersDTO.getQ214());
		members.setQ214Spy(membersDTO.getQ214Spy());
		members.setQ215(membersDTO.getQ215());
		members.setQ215Spy(membersDTO.getQ215Spy());
		members.setQ216(membersDTO.getQ216());
		members.setQ217(membersDTO.getQ217());
		members.setQ218(membersDTO.getQ218());
		members.setS1P(membersDTO.getS1P());
		members.setS1A(membersDTO.getS1A());
		members.setS2P(membersDTO.getS2P());
		members.setS2A(membersDTO.getS2A());
		members.setS3P(membersDTO.getS3P());
		members.setS3A(membersDTO.getS3A());
		members.setS4P(membersDTO.getS4P());
		members.setS4A(membersDTO.getS4A());
		members.setS5P(membersDTO.getS5P());
		members.setS5A(membersDTO.getS5A());
		members.setS6P(membersDTO.getS6P());
		members.setS6A(membersDTO.getS6A());
		if (membersDTO.getHouseholdId() != null && (members.getHouseholds() == null
				|| !members.getHouseholds().getId().equals(membersDTO.getHouseholdId()))) {
			final Household household = hhRepository.findById(membersDTO.getHouseholdId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Household not found"));
			members.setHouseholds(household);
		}
		return members;
	}

	private Member mapMasterToEntity(MemberMaster data, Member members, int hhId) {
		members.setOnaId(data.getOnaId());
		members.setQ201(data.getQ201());
		members.setQ202(data.getQ202());
		members.setQ203(String.valueOf(data.getQ203()));
		members.setQ204(data.getQ204());
		members.setQ205(data.getQ205());
		members.setQ206(data.getQ206());
		members.setQ207(String.valueOf(data.getQ207()));
		members.setQ208(data.getQ208());
		members.setQ209(data.getQ209());
		members.setQ210(data.getQ210());
		members.setQ211(data.getQ211());
		members.setQ212(data.getQ212());
		members.setQ213(data.getQ213());
		members.setQ213Spy(data.getQ213Spy());
		members.setQ214(data.getQ214());
		members.setQ214Spy(data.getQ214Spy());
		members.setQ215(data.getQ215());
		members.setQ215Spy(data.getQ215Spy());
		members.setQ216(data.getQ216());
		members.setQ217(data.getQ217());
		members.setQ218(data.getQ218());
		members.setS1P(data.getS1P());
		members.setS1A(data.getS1A());
		members.setS2P(data.getS2P());
		members.setS2A(data.getS2A());
		members.setS3P(data.getS3P());
		members.setS3A(data.getS3A());
		members.setS4P(data.getS4P());
		members.setS4A(data.getS4A());
		members.setS5P(data.getS5P());
		members.setS5A(data.getS5A());
		members.setS6P(data.getS6P());
		members.setS6A(data.getS6A());
		if (hhId != 0 && (members.getHouseholds() == null || !members.getHouseholds().getId().equals(hhId))) {
			final Household household = hhRepository.findById(hhId)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Household not found"));
			members.setHouseholds(household);
		}
		return members;
	}

}
