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
import com.augmentum.exam.dto.LogDTO;
import com.augmentum.exam.service.LogService;

@Controller("apiLogController")
@RequestMapping("/api/log")
public class LogController extends BaseController {

    @Resource
    private LogService LogService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody LogDTO LogDTO) throws ValidationException {
        int tagId = LogService.add(LogDTO);
        return JsonMessage.ok(tagId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = LogService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody LogDTO LogDTO) throws ValidationException {
        boolean result = LogService.update(LogDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        LogDTO result = LogService.getById(id);
        return JsonMessage.ok(result);
    }
}
