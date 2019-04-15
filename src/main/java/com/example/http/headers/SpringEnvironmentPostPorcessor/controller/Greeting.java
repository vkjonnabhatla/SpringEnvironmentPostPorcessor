package com.example.http.headers.SpringEnvironmentPostPorcessor.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class Greeting {

    @GetMapping("/header")
    public ResponseEntity<String> greeting(@RequestHeader("custom-header") String customHeader){
        return new ResponseEntity<String>(customHeader,HttpStatus.OK);
    }

    @GetMapping("/multiheader")
    public ResponseEntity<Integer> myNumber(@RequestHeader("my-number") Integer number){
        return new ResponseEntity<Integer>(number,HttpStatus.OK);
    }

    @GetMapping("/listAllHeaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers){
      headers.entrySet().stream().forEach(entry -> System.out.println(entry));
      return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @GetMapping("/multiValue")
    public ResponseEntity<String> multiValue(@RequestHeader MultiValueMap<String, String> multiValueMap){
        multiValueMap.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("| "))));
        });
        return new ResponseEntity<String>(String.format("Listed %d headers", multiValueMap.size()), HttpStatus.OK);
    }

    @GetMapping("/getBaseUrl")
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers){
        InetSocketAddress host = headers.getHost();
        String url = "http://"+host.getHostName()+":"+host.getPort();
        headers.forEach((key,value) -> System.out.println(String.format("'%s = %s'", key, value.stream().collect(Collectors.joining("|")))));
        return new ResponseEntity<String>(url, HttpStatus.OK);
    }

    @GetMapping("/optionalHeader")
    public ResponseEntity<String> evaluteNonRequiredHeader(@RequestHeader(value = "my-number", required = false) Integer value){
        return new ResponseEntity<String>(String.format("Was the optional header present %s ", value == null ? "NO" : "YES"), HttpStatus.OK);
    }

    @GetMapping("defaultValue")
    public ResponseEntity<String> evaluteDefaultHeaderValue(@RequestHeader(value = "my-number", defaultValue = "10") String defaultValue){
        return ResponseEntity.ok().header("Default",defaultValue).body(String.format("default value of header is %s : ", defaultValue));

    }
}
