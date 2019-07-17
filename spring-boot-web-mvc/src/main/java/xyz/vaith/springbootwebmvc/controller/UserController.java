package xyz.vaith.springbootwebmvc.controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import xyz.vaith.springbootwebmvc.pojo.User;
import xyz.vaith.springbootwebmvc.validator.UserValidator;
import xyz.vaith.springbootwebmvc.view.PdfExportService;
import xyz.vaith.springbootwebmvc.view.PdfView;

import javax.validation.Valid;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/add")
    public String add() {
        return "user/add";
    }

    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        return user;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @GetMapping("/converter")
    @ResponseBody
    public User getUserByConverter(User user) {
        return user;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> list(@RequestParam(value = "users") List<User> users) {
        return users;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @GetMapping("/validator")
    @ResponseBody
    public Map<String, Object> validator(@Valid User user, Errors errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            for (ObjectError error : errorList) {
                if (error instanceof FieldError) {
                    FieldError fe = (FieldError) error;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else  {
                    map.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
        }
        return map;
    }

    @GetMapping("/export/pdf")
    public ModelAndView exportPdf(String username, String note) {
        List<User> users = new ArrayList<>();
        for (long i = 0; i < 10; ++i) {
            User user = new User();
            user.setId(i);
            user.setUsername("username" + i);
            user.setNote("note" + i);
            users.add(user);
        }
        View view = new PdfView(exportService());
        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("users", users);
        return mv;
    }

    @SuppressWarnings("unchecked")
    private PdfExportService exportService() {
        return (model, document, writer, request, response) -> {
          try {
              document.setPageSize(PageSize.A4);
              document.addTitle("用户信息");
              document.add(new Chunk("\n"));
              PdfPTable table = new PdfPTable(3);
              PdfPCell cell = null;
              Font f8 = new Font();
              f8.setColor(Color.BLUE);
              f8.setStyle(Font.BOLD);

              cell = new PdfPCell(new Paragraph("id", f8));
              cell.setHorizontalAlignment(1);
              table.addCell(cell);

              cell = new PdfPCell(new Paragraph("note", f8));
              cell.setHorizontalAlignment(1);
              table.addCell(cell);

              cell = new PdfPCell(new Paragraph("username", f8));
              cell.setHorizontalAlignment(1);
              table.addCell(cell);

              List<User> users = (List<User>) model.get("users");
              for (User user : users) {
                  document.add(new Chunk("\n"));
                  cell = new PdfPCell(new Paragraph(user.getId()+ ""));
                  table.addCell(cell);
                  cell = new PdfPCell(new Paragraph(user.getNote()+ ""));
                  table.addCell(cell);
                  cell = new PdfPCell(new Paragraph(user.getUsername()+ ""));
                  table.addCell(cell);
              }
              document.add(table);
          } catch (DocumentException e) {
              e.printStackTrace();
          }
        };
    }
}
