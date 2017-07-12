package com.anbu.switchmediaexercise.data.net;

/**
 * API Constants
 */

class ApiConstants {

    public static final int DEFAULT_CONNECT_TIMEOUT = 6000; // milliseconds - timeout in making the initial connection i.e. completing the TCP connection handshake.
    public static final int DEFAULT_READ_TIMEOUT = 10000;   // milliseconds - timeout on waiting to read data. Specifically,
    // if the server fails to send a byte <timeout> seconds after the last byte,
    // a read timeout error will be raised.
    public static final int CACHE_SIZE = 10 * 1024 * 1024;  //in MB's

}
