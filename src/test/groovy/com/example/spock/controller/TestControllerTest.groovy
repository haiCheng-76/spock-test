package com.example.spock.controller

import com.example.spock.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification
import spock.lang.Title

@Title(value = "TestController")
@WebMvcTest(controllers = [TestController.class])
class TestControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    TestService testService

    void setup() {
        testService.uuid() >> "uuid"
        testService.list() >> ['a', 'b', 'c']
    }

    def "test get"() {
        when:
        def resp = mockMvc.perform(MockMvcRequestBuilders.get("/test/get"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
        then:
        println(resp.response.toString())
    }

    def "test list"() {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/list"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
    }
}
