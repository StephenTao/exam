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
import com.augmentum.exam.dto.UserDTO;
import com.augmentum.exam.service.UserService;

@Controller("apiUserController")
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public MessageEntry add(@RequestBody UserDTO userDTO) throws ValidationException {
        int userId = userService.add(userDTO);
        return JsonMessage.ok(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public MessageEntry delete(@PathVariable int id) {
        boolean result = userService.delete(id);
        return JsonMessage.ok(result);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public MessageEntry update(@RequestBody UserDTO userDTO) throws ValidationException {
        boolean result = userService.update(userDTO);
        return JsonMessage.ok(result);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MessageEntry getById(@PathVariable int id) {
        UserDTO user = userService.getById(id);
        return JsonMessage.ok(user);
    }
}
