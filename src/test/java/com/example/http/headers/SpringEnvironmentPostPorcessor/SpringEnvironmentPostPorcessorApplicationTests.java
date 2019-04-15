package com.example.http.headers.SpringEnvironmentPostPorcessor;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.response.ExtractableResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringEnvironmentPostPorcessorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void initialiseRestAssuredMockMvcWebApplicationContext() {
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}

	@Test
	public void contextLoads() {
	}

    @Test
    public void testGreeting(){
		Header header = new Header("custom-header", "Welcome");
        ExtractableResponse res = RestAssured.given().header(header).get("/header").then().assertThat().statusCode(HttpStatus.SC_OK).extract();
		Assert.assertEquals(res.response().body().asString(), "Welcome");
	}

}
