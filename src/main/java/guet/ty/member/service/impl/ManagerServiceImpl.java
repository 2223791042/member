package guet.ty.member.service.impl;

import guet.ty.member.dao.ManagerMapper;
import guet.ty.member.entity.Manager;
import guet.ty.member.entity.ManagerExample;
import guet.ty.member.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager getManager(String username) {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andManagerUsernameEqualTo(username);
        List<Manager> managerList = managerMapper.selectByExample(example);
        if (managerList.size() != 0){
            return managerList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void editManager(Manager manager) {
        managerMapper.updateByPrimaryKeySelective(manager);
    }
}
