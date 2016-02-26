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
import com.augmentum.exam.dto.MessageHistoryDTO;
import com.augmentum.exam.service.MessageHistoryService;

@Controller("apiMessageHistoryController")
@RequestMapping("/api/messagehistory")
public class MessageHistoryController extends BaseController {

    @Resource
    private MessageHistoryService messageHistoryService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody MessageHistoryDTO messageHistoryDTO) throws ValidationException {
        int messageHistoryId = messageHistoryService.add(messageHistoryDTO);
        return JsonMessage.ok(messageHistoryId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = messageHistoryService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody MessageHistoryDTO messageHistoryDTO) throws ValidationException {
        boolean result = messageHistoryService.update(messageHistoryDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        MessageHistoryDTO result = messageHistoryService.getById(id);
        return JsonMessage.ok(result);
    }
}
