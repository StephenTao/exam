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
import com.augmentum.exam.dto.ShowSizeDTO;
import com.augmentum.exam.service.ShowSizeService;

@Controller("apiShowSizeController")
@RequestMapping("/api/showsize")
public class ShowSizeController extends BaseController {

    @Resource
    private ShowSizeService showSizeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public MessageEntry add(@RequestBody ShowSizeDTO showSizeDTO) throws ValidationException {
        int showSizeId = showSizeService.add(showSizeDTO);
        return JsonMessage.ok(showSizeId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public MessageEntry update(@RequestBody ShowSizeDTO showSizeDTO) throws ValidationException {
        boolean result = showSizeService.update(showSizeDTO);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageEntry delete(@PathVariable int id) {
        boolean result = showSizeService.delete(id);
        return JsonMessage.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MessageEntry getById(@PathVariable int id) {
        ShowSizeDTO showSizeDTO = showSizeService.getById(id);
        return JsonMessage.ok(showSizeDTO);
    }

}
