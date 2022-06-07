package com.pci.tardd.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pci.tardd.dto.MembersDTO;
import com.pci.tardd.service.MembersService;

@RestController
@RequestMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
public class MembersController {
	
	@Autowired
	private  MembersService service;
	
	@GetMapping
    public ResponseEntity<List<MembersDTO>> getAllMemberss() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembersDTO> getMembers(@PathVariable final Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<?> createMembers(@RequestBody @Valid final MembersDTO membersDTO) {
        return new ResponseEntity<>(service.create(membersDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMembers(@PathVariable final Integer id,
            @RequestBody @Valid final MembersDTO membersDTO) {
    	service.update(id, membersDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembers(@PathVariable final Integer id) {
    	service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
