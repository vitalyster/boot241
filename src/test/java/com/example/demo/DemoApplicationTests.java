package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void multipartUploadTest() throws Exception {
		ClassPathResource newAvatar = new ClassPathResource("static/image.png");
        byte[] newAvatarData = IOUtils.toByteArray(newAvatar.getInputStream());
		mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                .file("avatar", newAvatarData))
        .andExpect(status().isOk());
	}

}
