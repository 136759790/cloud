package org.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class ZipKinServerApp {
    public static void main( String[] args ){
        SpringApplication.run(ZipKinServerApp.class, args);
    }
}
