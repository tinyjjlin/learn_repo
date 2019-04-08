package com.brs.oa.ad.service.impl;

import com.brs.oa.ad.entry.Person;
import com.brs.oa.ad.repo.PersonRepo;
import com.brs.oa.ad.service.AdService;
import com.brs.oa.staff.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/24
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired(required = false)
    private StaffMapper staffMapper;


    @Override
    public int synchronizeStaffInfo() {
        List<Person> personList = personRepo.getAllPerson();
       return  staffMapper.insert(personList);
    }
}
