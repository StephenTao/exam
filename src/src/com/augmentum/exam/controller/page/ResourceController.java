package com.augmentum.exam.controller.page;

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
import com.augmentum.exam.dto.ResourceDTO;
import com.augmentum.exam.service.ResourceService;

@Controller("resourceController")
@RequestMapping("/page/resource")
public class ResourceController extends BaseController {

    @Resource
    private ResourceService resourceService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody ResourceDTO resourceDTO) throws ValidationException {
        int resourceId = resourceService.add(resourceDTO);
        return JsonMessage.ok(resourceId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = resourceService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody ResourceDTO resourceDTO) throws ValidationException {
        boolean result = resourceService.update(resourceDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        ResourceDTO result = resourceService.getById(id);
        return JsonMessage.ok(result);
    }
}
