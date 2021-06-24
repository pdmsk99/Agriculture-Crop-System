package com.example.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Exceptions.RecordNotFoundException;
import com.example.address.dto.AddressDTO;

@Service
public interface IAddressService {

	public AddressDTO add(AddressDTO address);

	public AddressDTO update(AddressDTO address);

	public AddressDTO delete(Integer id) throws RecordNotFoundException;

	public AddressDTO findById(Integer addressId);

	public List<AddressDTO> getAddress();

}
