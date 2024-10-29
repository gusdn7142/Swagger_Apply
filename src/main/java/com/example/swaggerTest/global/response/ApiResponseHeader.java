package com.example.swaggerTest.global.response;



public class ApiResponseHeader {

    private int retcode;
    private String message;
    //private static ApiResponseHeader apiResponseHeader = new ApiResponseHeader();  //singleton pattern

    //default Constructor
    private ApiResponseHeader() { }

    //1) (public) method - setting header
    public static ApiResponseHeader of (ResponseCode retCode) {
        ApiResponseHeader apiResponseHeader = new ApiResponseHeader();                  //singleton pattern X
        apiResponseHeader.setRetcode(Integer.parseInt(retCode.getCode()));
        apiResponseHeader.setMessage(retCode.getMsg());
        return apiResponseHeader;
    }

    //3) (public) getter, setter
    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




    //argument 1 Constructor
//	private ApiResponseHeader(ResponseCode retCode) {
//		this.retcode = Integer.parseInt(retCode.getCode());
//		this.message = retCode.getMsg();
//	}

    //mapping method
    //public static ApiResponseHeader of () {
    //	return new ApiResponseHeader();
    //}

/*	public static ApiResponseHeader of (ResponseCode retCode, String transactionID) {
		ApiResponseHeader header = new ApiResponseHeader(retCode);
		return header;
	}*/

/*	public static ApiResponseHeader of (ResponseCode retCode, ResCodeGenerator codeGenerator, String transactionID) {
		ApiResponseHeader header = of (retCode, transactionID);
		return header;
	}*/

    //setter
//	public void setResponseCode(int retcode, String message) {
//		this.retcode = retcode; //Integer.parseInt(retCode.getCode());
//		this.message = message; //retCode.getMsg();
//	}

}
