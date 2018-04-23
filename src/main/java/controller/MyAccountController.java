package controller;

import domain.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pengfei on 2017/9/24.
 */
@Controller
@RequestMapping("/account")
public class MyAccountController {

    private final static Logger logger = Logger.getLogger(MyAccountController.class);

    @RequestMapping("/edit")
    public String editAccount() {
        return "account/accountEdit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(@RequestParam(value = "image", required = false) MultipartFile file,
                              @ModelAttribute("userInfo") UserInfo user, ModelMap model, HttpServletRequest request) throws IOException {

        if (file == null || file.isEmpty())
            throw new RuntimeException("File cannot be null!");

        String rootPath = request.getContextPath();
        writeFile(file, rootPath);

        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();

        //TODO, save user service call.

        model.addAttribute("message", "Save user success!");

        return "account/success";
    }

    private void writeFile(MultipartFile file, String rootPath) {

        try {
            logger.info("Begin save file");
            byte[] fileByte = file.getBytes();

            File tempFile = new File(rootPath + "/temp/" + file.getOriginalFilename());

            FileOutputStream stream = new FileOutputStream(tempFile);

            stream.write(fileByte);
            stream.close();
            logger.info("End file save!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
