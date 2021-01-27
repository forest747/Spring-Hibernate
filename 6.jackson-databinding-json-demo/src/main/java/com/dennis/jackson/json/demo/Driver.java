package com.dennis.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String arg[]) {

		try {

			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map/convert to Java POJO:
			// data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());

			// print out address: street and city
			Address tempAddress = theStudent.getAddress();

			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());

			// print out languages
			for (String tempLanguage : theStudent.getLanguages()) {
				System.out.println("Language : " + tempLanguage);
			}

		} catch (Exception exc) {
			exc.printStackTrace();

		}

	}
}
