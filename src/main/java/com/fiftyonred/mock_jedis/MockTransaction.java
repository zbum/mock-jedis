package com.fiftyonred.mock_jedis;

import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @author jibumjung
 */
public class MockTransaction extends Transaction {

    private Pipeline pipeline;

    public MockTransaction(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public Response<Long> hset(String key, String field, String value) {
        return pipeline.hset(key, field, value);
    }

    @Override
    public List<Object> exec() {
        return null;
    }
}
