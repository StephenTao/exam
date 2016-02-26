package com.augmentum.exam.base;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

import com.augmentum.exam.EContext;
import com.augmentum.exam.dto.UserDTO;

public abstract class BaseController {

    protected int getUserId() {
        return EContext.getContext().getUserId();
    }

    protected UserDTO getUser() {
        return EContext.getContext().getUser();
    }

    protected boolean isLogin() {
        return (null != EContext.getContext().getUser());
    }

    public void uploadFile(MultipartFile file, String fileName) throws IllegalStateException, IOException {
        file.transferTo(new File(fileName));
    }

    public static final String getResourceFileName(String basePath, String fileName) {
        StringBuilder builder = new StringBuilder(basePath);
        Calendar now = Calendar.getInstance();
        String dateStr = now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/";
        builder.append(dateStr);
        File folder = new File(builder.toString());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        builder.append(getRandomCode(fileName).hashCode());
        builder.append(fileName.substring(fileName.lastIndexOf('.')));
        String path = builder.toString();
        int begin = path.indexOf(dateStr);
        return path.substring(begin);
    }

    public static String getRandomCode(String dataStr) {
        char[] array = dataStr.toCharArray();
        char temp;
        String newStr = "";
        for (int i = array.length - 2; i > 0; i--) {
            int index = (int) (Math.random() * array.length - 1);
            temp = array[i + 1];
            array[i + 1] = array[index];
            array[index] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            newStr += array[i];
        }
        return newStr;
    }
}
