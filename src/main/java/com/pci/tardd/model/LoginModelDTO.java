package com.pci.tardd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginModelDTO {
	private String username;
	private String userkey;
	private String status;
	private String message;
	private String btn;
}
