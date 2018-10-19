package com.baizhi.work.service;

import com.baizhi.work.aspect.LogAun;
import com.baizhi.work.controller.UserController;
import com.baizhi.work.dao.UserDao;
import com.baizhi.work.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @LogAun(name = "查询所有")
    @Override
    public List<User> selectAll() {
        logger.error("目标方法");
        return userDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userDao.updateByPrimaryKey(record);
    }
}
