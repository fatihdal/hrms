package com.dalfatih.hrms;

import com.dalfatih.hrms.dataAccess.abstracts.JobCategoryRepository;
import com.dalfatih.hrms.dto.JobCategoryDTO;
import com.dalfatih.hrms.entities.concretes.JobCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@Category(JobCategoryTests.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = {"spring.profiles.active=test"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JobCategoryTests {

    private final ObjectMapper jsonMapper = new ObjectMapper().findAndRegisterModules()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @LocalServerPort
    private int randomServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @Test
    public void shouldListAllCategories() throws JsonProcessingException, URISyntaxException {
        createJobCategory("Cateogry 1", "Description of Cateogry 1");
        createJobCategory("Cateogry 2", "Description of Cateogry 2");
        createJobCategory("Cateogry 3", "Description of Cateogry 3");

        URI urlOfGetAll = new URI(createURLWithPort("/jobcategory/categories"));
        ResponseEntity<String> listAllCategoryResponse =
                this.testRestTemplate.getForEntity(urlOfGetAll, String.class);

        assertThat(listAllCategoryResponse.getStatusCode(), is(equalTo(HttpStatus.OK)));

        String response = listAllCategoryResponse.getBody();

        List<JobCategoryDTO> actual = Arrays.asList(jsonMapper.readValue(response, JobCategoryDTO[].class));
        System.out.println(actual);

        assertThat(
                actual, hasItem(
                        new JobCategoryDTO(1, "Cateogry 1", "Description of Cateogry 1")

                ));
        assertThat(
                actual, hasItem(
                        new JobCategoryDTO(2, "Cateogry 2", "Description of Cateogry 2")
                ));
        assertThat(
                actual, hasItem(

                        new JobCategoryDTO(3, "Cateogry 3", "Description of Cateogry 3")
                ));
        assertThat(actual, is(hasSize(3)));
    }

    @Test
    public void shouldNotFindJobCategoryToList() throws URISyntaxException, JsonProcessingException {
        URI urlOfGetAll = new URI(createURLWithPort("/jobcategory/categories"));
        ResponseEntity<String> listAllCategoryResponse =
                this.testRestTemplate.getForEntity(urlOfGetAll, String.class);

        String response = listAllCategoryResponse.getBody();

        List<JobCategoryDTO> actual = Arrays.asList(jsonMapper.readValue(response, JobCategoryDTO[].class));

        assertThat(listAllCategoryResponse.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(actual, is(hasSize(0)));
    }

    public void createJobCategory(String title, String description) {
        JobCategory jobCategory = new JobCategory(title, description);
        jobCategoryRepository.save(jobCategory);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + randomServerPort + "/api" + uri;
    }
}