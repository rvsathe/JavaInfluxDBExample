package com.example.influxdbexample;

import com.influxdb.client.InfluxDBClient;

public class App {
    // private static Result oneResult;

    public static void main(String[] args) {

        String token = "5dskc69ENfbtnF_g99CZgI4yDxTrZK45WbDSeY1kuz82uJFclYeEmnHyJxYRUcXVVB4O48rkn9e6p7g525wevQ==";
        String bucket = "myFirstBucket";
        String org = "TestOrg";
        String url = "http://localhost:8086";

        InfluxDBConnectionClass inConn = new InfluxDBConnectionClass();
        InfluxDBClient influxDBClient = inConn.buildConnection(url, token, bucket, org);

        boolean resultSingle = inConn.singlePointWrite(influxDBClient);
        if (resultSingle)
            System.out.println("Single Point write done!!");

        // Multiple Points
        boolean resultMultiple = inConn.writeMultiplePoints(influxDBClient);
        if (resultMultiple)
            System.out.println("Write multiple points done!!");

        // Write using POJO

        boolean resultPOJO = inConn.writePointbyPOJO(influxDBClient);
        if (resultPOJO)
            System.out.println("Writey POJO done");

        inConn.queryData(influxDBClient);

        boolean resultDelete = false;
        inConn.deleteRecord(influxDBClient);

        if (resultDelete)
            System.out.println("Delete Record done!");

        influxDBClient.close();
    }

}