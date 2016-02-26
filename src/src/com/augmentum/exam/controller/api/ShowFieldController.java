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
import com.augmentum.exam.dto.ShowFieldDTO;
import com.augmentum.exam.service.ShowFieldService;

@Controller("apiShowFieldController")
@RequestMapping("/api/showfield")
public class ShowFieldController extends BaseController {

    @Resource
    private ShowFieldService showFieldService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody ShowFieldDTO showFieldDTO) throws ValidationException {
        int showFieldId = showFieldService.add(showFieldDTO);
        return JsonMessage.ok(showFieldId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody ShowFieldDTO showFieldDTO) throws ValidationException {
        boolean result = showFieldService.update(showFieldDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = showFieldService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        ShowFieldDTO showFieldDTO = showFieldService.getById(id);
        return JsonMessage.ok(showFieldDTO);
    }
}
