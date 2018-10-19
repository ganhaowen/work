package com.baizhi.work.controller;

import com.baizhi.work.entity.User;
import com.baizhi.work.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("selectAll")
    private String selectAll(Map map) {
        Page<Object> page = PageHelper.startPage(1, 5);
        List<User> list = userService.selectAll();
        /*List<Object> list = page.getResult();*/
        /*logger.info(list.toString());
        logger.warn(list.toString());
        logger.debug(list.toString());
        logger.error(list.toString());*/
        /*for (User user : list) {
            logger.error(user.toString());
        }*/
        map.put("list", list);
        return "index";
    }
}
