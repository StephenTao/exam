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
import com.augmentum.exam.dto.RoleDTO;
import com.augmentum.exam.service.RoleService;

@Controller("apiRoleController")
@RequestMapping("/api/role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody RoleDTO roleDTO) throws ValidationException {
        int roleId = roleService.add(roleDTO);
        return JsonMessage.ok(roleId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = roleService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody RoleDTO roleDTO) throws ValidationException {
        boolean result = roleService.update(roleDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        RoleDTO result = roleService.getById(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getByCode(@PathVariable String code) {
        RoleDTO result = roleService.getByCode(code);
        return JsonMessage.ok(result);
    }

}
