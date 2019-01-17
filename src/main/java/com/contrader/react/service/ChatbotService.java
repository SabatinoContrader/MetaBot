ùpackage com.contrader.react.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrader.react.converter.ConverterChatbot;
import com.contrader.react.converter.ConverterUser;
import com.contrader.react.dto.ChatbotDTO;
import com.contrader.react.dto.UserDTO;
import com.contrader.react.model.Chatbot;
import com.contrader.react.repository.ChatbotRepository;



@Service
public class ChatbotService {

	private final ChatbotRepository chatbotRepository;

	@Autowired
	public ChatbotService(ChatbotRepository chatbotRepository) {
		this.chatbotRepository = chatbotRepository;
	}

	public void deleteChatbotByIdChatbot(Integer IdChatbot) {
		chatbotRepository.deleteById(IdChatbot);
		
	}
	
	
	public void prova() {}
	
	public List<ChatbotDTO> findAll () {
		List<Chatbot> list = new ArrayList<>();
		List<ChatbotDTO> listDTO = new ArrayList<>();
		chatbotRepository.findAll().forEach(list::add);
		list.forEach(i->listDTO.add(ConverterChatbot.toDTO(i)));
	
	return listDTO;
	}
	
	
	public List<ChatbotDTO> findAllChatbotsDTOByIdUser(UserDTO userDTO) {

		final List<Chatbot> list = chatbotRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ChatbotDTO> chatbotDTOs = new ArrayList<>();
		list.forEach(i -> chatbotDTOs.add(ConverterChatbot.toDTO(i)));
		return chatbotDTOs;
	}

	public ChatbotDTO inserisciChatbotDTO(ChatbotDTO chatbotDTO) {
		return ConverterChatbot.toDTO(chatbotRepository.save(ConverterChatbot.toEntity(chatbotDTO)));
//		if (chatbot != null) {
//			return true;
//		}
//		return false;
	}

	public ChatbotDTO findChatbotDTOByIdChatbot(Integer idChatbot) {
		return ConverterChatbot.toDTO(chatbotRepository.findById(idChatbot).get());
	}
	
	public List<ChatbotDTO> findChatbotDTOByNomeChatbot(String nomeChatbot) {
		
		final List<Chatbot> list = chatbotRepository.findAllByNomeChatbot(nomeChatbot);
		final List<ChatbotDTO> chatbotDTOs = new ArrayList<>();
		list.forEach(i -> chatbotDTOs.add(ConverterChatbot.toDTO(i)));
		return chatbotDTOs;
		
	
	}


}
