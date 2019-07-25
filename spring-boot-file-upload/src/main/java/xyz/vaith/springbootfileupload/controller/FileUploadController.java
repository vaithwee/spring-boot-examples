package xyz.vaith.springbootfileupload.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.vaith.springbootfileupload.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

@Controller
@Log4j2
public class FileUploadController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam("filename") String filename, @RequestParam("file") MultipartFile file) throws IOException {
         log.info("filename: " + filename);
         if (!file.isEmpty()) {
             String path = request.getServletContext().getRealPath("/upload/");
             log.info("path: " + path);
             String originalFilename = file.getOriginalFilename();
             filename = filename + originalFilename.substring(originalFilename.lastIndexOf("."));
             File filepath = new File(path, filename);
             if (!filepath.getParentFile().exists()) {
                 filepath.getParentFile().mkdir();
             }
             file.transferTo(new File(path + File.separator + filename));
             return "success";
         } else  {
             return "error";
         }
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request, @ModelAttribute User user, Model model) throws IOException {
        log.info("username:" + user.getUsername());
        if (!user.getHeadPortrait().isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/");
            log.info("path: " + path);
            String filename = user.getHeadPortrait().getOriginalFilename();
            File file = new File(path, filename);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            user.getHeadPortrait().transferTo(new File(path + File.separator + filename));
            model.addAttribute("user", user);
            return "userInfo";
        } else  {
            return "error";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, String filename, @RequestHeader("User-Agent") String userAgent, Model model) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        File file = new File(path + File.separator + filename);
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.contentLength(file.length());
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        filename = URLEncoder.encode(filename, "UTF-8");
        if (userAgent.indexOf("MSIE") > 0) {
            builder.header("Content-Disposition", "attachment; filename=" + filename);
        } else  {
            builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
        }
        return builder.body(FileUtils.readFileToByteArray(file));
    }
}
