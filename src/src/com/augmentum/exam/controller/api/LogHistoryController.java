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
import com.augmentum.exam.dto.LogHistoryDTO;
import com.augmentum.exam.service.LogHistoryService;

@Controller("apiLogHistoryController")
@RequestMapping("/api/loghistory")
public class LogHistoryController extends BaseController {

    @Resource
    private LogHistoryService logHistoryService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody LogHistoryDTO logHistoryDTO) throws ValidationException {
        int logHistoryId = logHistoryService.add(logHistoryDTO);
        return JsonMessage.ok(logHistoryId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = logHistoryService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody LogHistoryDTO logHistoryDTO) throws ValidationException {
        boolean result = logHistoryService.update(logHistoryDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        LogHistoryDTO result = logHistoryService.getById(id);
        return JsonMessage.ok(result);
    }
}
