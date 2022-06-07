package com.pci.tardd.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pci.tardd.domain.Household;
import com.pci.tardd.dto.HouseholdDTO;
import com.pci.tardd.model.MasterData;
import com.pci.tardd.repos.HouseholdRepository;

@Service
public class HouseholdService {

	@Autowired
	private HouseholdRepository repository;

	public List<HouseholdDTO> findAll() {
		return repository.findAll().stream().filter(household -> household != null)
				.map(household -> mapToDTO(household, new HouseholdDTO())).collect(Collectors.toList());
	}

	public List<HouseholdDTO> findAllByCLF(String clfName) {
		return repository.findByClf(clfName).stream().map(household -> mapToDTO(household, new HouseholdDTO()))
				.collect(Collectors.toList());
	}

	public List<HouseholdDTO> findAllByVO(String vo) {
		return repository.findByVo(vo).stream().map(household -> mapToDTO(household, new HouseholdDTO()))
				.collect(Collectors.toList());
	}

	public HouseholdDTO get(final Integer id) {
		return repository.findById(id).map(household -> mapToDTO(household, new HouseholdDTO()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Integer create(final HouseholdDTO householdDTO) {
		final Household household = new Household();
		mapToEntity(householdDTO, household);
		return repository.save(household).getId();
	}

	public Integer create(final MasterData data) {
		final Household household = new Household();
		mapMasterToEntity(data, household);
		return repository.save(household).getId();
	}

	public void update(final Integer id, final HouseholdDTO householdDTO) {
		final Household household = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		mapToEntity(householdDTO, household);
		repository.save(household);
	}

	public void delete(final Integer id) {
		repository.deleteById(id);
	}

	private HouseholdDTO mapToDTO(final Household household, final HouseholdDTO householdDTO) {
		householdDTO.setId(household.getId());
		householdDTO.setOnaId(household.getOnaId());
		householdDTO.setToday(household.getToday());
		householdDTO.setDistrict(household.getDistrict());
		householdDTO.setBlock(household.getBlock());
		householdDTO.setClf(household.getClf());
		householdDTO.setPanchayat(household.getPanchayat());
		householdDTO.setVo(household.getVo());
		householdDTO.setVillage(household.getVillage());
		householdDTO.setWard(household.getWard());
		householdDTO.setShg(household.getShg());
		householdDTO.setCaste(household.getCaste());
		householdDTO.setQ101(household.getQ101());
		householdDTO.setQ102(household.getQ102());
		householdDTO.setQ103(household.getQ103());
		householdDTO.setQ104(household.getQ104());
		householdDTO.setQ105(household.getQ105());
		householdDTO.setQ106(household.getQ106());
		householdDTO.setQ106Spy(household.getQ106Spy());
		householdDTO.setQ107(household.getQ107());
		householdDTO.setQ108(household.getQ108());
		householdDTO.setQ109(household.getQ109());
		householdDTO.setQ110(household.getQ110());
		householdDTO.setQ111(household.getQ111());
		householdDTO.setQ112(household.getQ112());
		householdDTO.setVersion(household.getVersion());
		householdDTO.setDuration(household.getDuration());
		householdDTO.setMembersCount(household.getMembersCount());
		householdDTO.setRemarks(household.getRemarks());
		householdDTO.setFormStartTime(household.getFormStartTime());
		householdDTO.setFormEndTime(household.getFormEndTime());
		householdDTO.setEdited(household.getEdited());
		householdDTO.setEditedOn(household.getEditedOn());
		householdDTO.setXformName(household.getXformName());
		householdDTO.setXformId(household.getXformId());
		return householdDTO;
	}

	private Household mapToEntity(final HouseholdDTO householdDTO, final Household household) {
		household.setOnaId(householdDTO.getOnaId());
		household.setToday(householdDTO.getToday());
		household.setDistrict(householdDTO.getDistrict());
		household.setBlock(householdDTO.getBlock());
		household.setClf(householdDTO.getClf());
		household.setPanchayat(householdDTO.getPanchayat());
		household.setVo(householdDTO.getVo());
		household.setVillage(householdDTO.getVillage());
		household.setWard(householdDTO.getWard());
		household.setShg(householdDTO.getShg());
		household.setCaste(householdDTO.getCaste());
		household.setQ101(householdDTO.getQ101());
		household.setQ102(householdDTO.getQ102());
		household.setQ103(householdDTO.getQ103());
		household.setQ104(householdDTO.getQ104());
		household.setQ105(householdDTO.getQ105());
		household.setQ106(householdDTO.getQ106());
		household.setQ106Spy(householdDTO.getQ106Spy());
		household.setQ107(householdDTO.getQ107());
		household.setQ108(householdDTO.getQ108());
		household.setQ109(householdDTO.getQ109());
		household.setQ110(householdDTO.getQ110());
		household.setQ111(householdDTO.getQ111());
		household.setQ112(householdDTO.getQ112());
		household.setVersion(householdDTO.getVersion());
		household.setDuration(householdDTO.getDuration());
		household.setMembersCount(householdDTO.getMembersCount());
		household.setRemarks(householdDTO.getRemarks());
		household.setFormStartTime(householdDTO.getFormStartTime());
		household.setFormEndTime(householdDTO.getFormEndTime());
		household.setEdited(householdDTO.getEdited());
		household.setEditedOn(householdDTO.getEditedOn());
		household.setXformName(householdDTO.getXformName());
		household.setXformId(householdDTO.getXformId());
		return household;
	}

	private Household mapMasterToEntity(MasterData data, Household household) {
		household.setOnaId(String.valueOf(data.getOnaId()));
		household.setToday(LocalDate.parse(data.getToday(), DateTimeFormatter.ISO_LOCAL_DATE));
		household.setDistrict(data.getDistrict());
		household.setBlock(data.getBlock());
		household.setClf(data.getClf());
		household.setPanchayat(data.getPanchayat());
		household.setVo(data.getVo());
		household.setVillage(data.getVillage());
		household.setWard(data.getWard());
		household.setShg(data.getShg());
		household.setCaste(data.getCaste());
		household.setQ101(data.getQ101());
		household.setQ102(data.getQ102());
		household.setQ103(String.valueOf(data.getQ103()));
		household.setQ104(String.valueOf(data.getQ104()));
		household.setQ105(String.valueOf(data.getQ105()));
		household.setQ106(data.getQ106());
		household.setQ106Spy(data.getQ106SPY());
		household.setQ107(data.getQ107());
		household.setQ108(data.getQ108());
		household.setQ109(data.getQ109());
		household.setQ110(data.getQ110());
		household.setQ111(data.getQ111());
		household.setQ112(data.getQ112());
		household.setVersion(data.getVersion());
		household.setDuration(String.valueOf(data.getDuration()));
		household.setMembersCount(data.getMembersCount());
		household.setRemarks(data.getRemarks());
		household.setFormStartTime(data.getFormStartTime());
		household.setFormEndTime(data.getFormEndTime());
		household.setEdited(data.getEdited());
		household.setEditedOn(data.getEditedOn());
		household.setXformName(data.getXformName());
		household.setXformId(data.getXformId());
		return household;
	}

}
