package com.assessment.artist;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;

import java.nio.charset.Charset;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.assessment.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ArtistRestControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	
	private final String name = "Mega";
	private final int page_number = 0;
	private final int page_size = 10;
	private final String [] alias = {"Megadeath"};
	
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	
	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
         
    }
	

	@Test
    public void readPagedArtists() throws Exception {
        mockMvc.perform(get("/artist/search/"+name+"/"+page_number+"/"+page_size+""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("results.[0].name", is("Megadeth")))
        		.andExpect(jsonPath("results.[0].country", is("US")))
        		.andExpect(jsonPath("results.[0].alias", hasSize(1)))
        		.andExpect(jsonPath("results.[0].alias", contains(alias)));        		  		
    }

}
