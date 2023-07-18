package navom.tacocloud.controller;

import static org.hamcrest.Matchers.containsString; import static
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.content; import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@WebMvcTest(HomeController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        try {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"))
                    .andExpect((ResultMatcher) content().string(
                            containsString("Welcome to...")
                    ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
