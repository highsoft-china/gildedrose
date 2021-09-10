package com.highsoft.gildedrose.ohs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tests")
public class TestController {
    @GetMapping("")
    private String test() {
        return "test";
    }
}
