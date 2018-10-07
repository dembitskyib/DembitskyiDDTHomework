package com.epam.lab.DDTHomeWork.parsers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.lab.DDTHomeWork.dataModels.Message;

public class JAXBParser {
	public static Message getMessage(String usersDataPath) {
		JAXBContext jaxbContext;
		Message message = null;
		try {
			jaxbContext = JAXBContext.newInstance(Message.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			message = (Message) jaxbUnmarshaller.unmarshal(new File(usersDataPath));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return message;
	}
}
