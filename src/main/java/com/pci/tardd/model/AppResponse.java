package com.pci.tardd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppResponse {
	private String status;
	private String message;
	private Object data;
}
