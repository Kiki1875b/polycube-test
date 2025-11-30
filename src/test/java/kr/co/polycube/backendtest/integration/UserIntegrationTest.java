package kr.co.polycube.backendtest.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.polycube.backendtest.common.dto.UserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  @DisplayName("POST /user - 사용자 등록 성공")
  void createUser_Success() throws Exception  {
    //given
    UserRequest request = new UserRequest("name");

    // when & then

    mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").exists());
  }

  @Test
  @DisplayName("GET /user/{id} - 사용자 조회 성공")
  void getUser_Success() throws Exception{
    //given
    UserRequest request = new UserRequest("name");

    String response = mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isCreated())
        .andReturn()
        .getResponse()
        .getContentAsString();

    Long id = objectMapper.readTree(response).get("id").asLong();

    // when & then

    mockMvc.perform(get("/users/" + id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.name").value("name"));
  }


  @Test
  @DisplayName("GET /user/{id} - 사용자 조회 실패")
  void getUser_fail_noSuchUser(){
    // given
    Long id = 1L;

    // when & then
  }

  @Test
  @DisplayName("PATCH /user/{id} - 사용자 업데이트 성공")
  void updateUser_Success() throws Exception{
    // given
    UserRequest request = new UserRequest("old");
    String response = mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andReturn()
        .getResponse()
        .getContentAsString();

    Long id = objectMapper.readTree(response).get("id").asLong();

    UserRequest updateRequest = new UserRequest("new");

    // when & then
    mockMvc.perform(patch("/users/" + id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(updateRequest)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.name").value("new"));
  }

}
