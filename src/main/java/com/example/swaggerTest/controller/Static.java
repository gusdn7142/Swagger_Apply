package com.example.swaggerTest.controller;




public class Static {

    public static final String VALID_REQUEST = """
			{
			  "age": "0",
			  "address": "서울시 강남구",
			  "phone": "010-1234-5678",
			  "id": "test1234",
			  "password": "test1234!@"
			}""";

    public static final String INVALID_REQUEST = """
			{
			  "age": "0",
			  "address": "서울시 강남구",
			  "phone": "string",
			  "id": "test1234",
			  "password": "abcabc.com"
			}""";

}
