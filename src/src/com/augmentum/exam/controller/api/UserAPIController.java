package com.augmentum.exam.controller.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseController;
import com.augmentum.exam.base.JsonMessage;
import com.augmentum.exam.base.JsonMessage.MessageEntry;
import com.augmentum.exam.dto.UserAPIDTO;
import com.augmentum.exam.service.UserAPIService;

@Controller("apiUserAPIController")
@RequestMapping("/api/userapi")
public class UserAPIController extends BaseController {

    @Resource
    private UserAPIService userAPIService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody UserAPIDTO userAPIDTO) throws ValidationException {
        int userApiId = userAPIService.add(userAPIDTO);
        return JsonMessage.ok(userApiId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = userAPIService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody UserAPIDTO UserAPIDTO) throws ValidationException {
        boolean result = userAPIService.update(UserAPIDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        UserAPIDTO result = userAPIService.getById(id);
        return JsonMessage.ok(result);
    }
}
