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
import com.augmentum.exam.dto.UserMessageDTO;
import com.augmentum.exam.service.UserMessageService;

@Controller("apiUserMessageController")
@RequestMapping("/api/usermessage")
public class UserMessageController extends BaseController {

    @Resource
    private UserMessageService userMessageService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody UserMessageDTO userMessageDTO) throws ValidationException {
        int userMessageId = userMessageService.add(userMessageDTO);
        return JsonMessage.ok(userMessageId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = userMessageService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody UserMessageDTO userMessageDTO) throws ValidationException {
        boolean result = userMessageService.update(userMessageDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        UserMessageDTO result = userMessageService.getById(id);
        return JsonMessage.ok(result);
    }
}
