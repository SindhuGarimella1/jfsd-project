package com.klef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.model.Admin;
import com.klef.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
    private AdminRepository adminRepository;
	@Override
    public Admin checkAdminLogin(String uname, String pwd) {
      
      return adminRepository.checkAdminLogin(uname, pwd);
    }

}
