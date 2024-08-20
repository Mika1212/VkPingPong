//package ru.mika.vkpingpong;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import ru.mika.vkpingpong.dto.callback.CallbackAPIMessageDTO;
//import ru.mika.vkpingpong.config.SecretConfig;
//import ru.mika.vkpingpong.controller.CallbackAPIController;
//import ru.mika.vkpingpong.dto.request.SendMessageRequest;
//import ru.mika.vkpingpong.dto.response.SendMessageResponse;
//import ru.mika.vkpingpong.service.MessageHandlerService;
//import ru.mika.vkpingpong.helper.VkRepository;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest(CallbackAPIController.class)
//class VkPingPongApplicationTests {
//	@Autowired
//	private CallbackAPIController controller;
//
//	//@Autowired
//	//private CallbackMessageHelper messageHelper;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	SecretConfig secretConfig;
//
//	@MockBean
//	private MessageHandlerService service;
//	@Captor
//	private ArgumentCaptor<SendMessageRequest> captor;
//
//	@MockBean
//	private VkRepository vkRepository;
//
//	@BeforeEach
//	public void setup() {
//		Mockito.when(secretConfig.getSecretKey()).thenReturn("000000");
//		SendMessageResponse response = new SendMessageResponse();
//		Mockito.when(vkRepository.send(any())).thenReturn(response);
//	}
//
//	@Test
//	void contextLoads() throws Exception {
//		//assertThat(controller).isNotNull();
//
//		HashMap<String, Object> object = new LinkedHashMap<>();
//		HashMap<String, Object> message = new LinkedHashMap<>();
//
//		message.put("date", "0");
//		message.put("id", "1");
//		message.put("peer_id", "2");
//		message.put("from_id", "3");
//		message.put("text", "Test");
//		object.put("message", message);
//		CallbackAPIMessageDTO messageDTO = CallbackAPIMessageDTO.builder()
//				.secret("000000")
//				.type(CallbackAPIMessageDTO.MessageType.message_new)
//		//		.object(object)
//				.build();
//
//		String requestBody = new ObjectMapper().valueToTree(messageDTO).toString();
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String json = ow.writeValueAsString(messageDTO);
//		System.out.println(json);
//		service.messageHandler(messageDTO);
//		verify(service, times(1)).messageHandler(messageDTO);
//		verify(service, times(1)).messageHandler(messageDTO);
//		//verify(captor.capture().getAccessToken());
//
//
//		mockMvc.perform(MockMvcRequestBuilders
//						.post("/callback/message")
//						.accept(MediaType.APPLICATION_JSON)
//						.content(json)
//						.contentType("application/json"))
//				//.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.type").value(CallbackAPIMessageDTO.MessageType.message_new))
//				.andExpect(jsonPath("$.date").value("0"))
//				.andExpect(jsonPath("$.peer_id").value("1"))
//				.andExpect(jsonPath("$.from_id").value("2"))
//				.andExpect(jsonPath("$.text").value("Test"));
//
//	}
//}
