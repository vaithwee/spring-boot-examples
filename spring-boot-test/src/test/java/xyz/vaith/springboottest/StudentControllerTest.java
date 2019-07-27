package xyz.vaith.springboottest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestApplication.class)
public class StudentControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @Transactional
    public void addStudent() throws Exception {
        String json = "{\n" +
                "    \"name\": \"swk\",\n" +
                "    \"address\": \"hgs\",\n" +
                "    \"age\": 700,\n" +
                "    \"sex\": \"男\"\n" +
                "}";
        mvc.perform(MockMvcRequestBuilders.post("/student/save").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8).content(json.getBytes())).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void qryStudent() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/student/get/2").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("swk")).andExpect(MockMvcResultMatchers.jsonPath("$.address").value("hgs")).andDo(MockMvcResultHandlers.print());
    }

}
