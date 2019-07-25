package xyz.vaith.springbootfileupload.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String username;
    private MultipartFile headPortrait;
}
