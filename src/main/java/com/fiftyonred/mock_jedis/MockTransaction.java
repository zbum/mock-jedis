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
    public Response<String> select(int index) {
        return pipeline.select(index);
    }

    @Override
    public Response<Long> hset(String key, String field, String value) {
        return pipeline.hset(key, field, value);
    }

    @Override
    public Response<Long> del(String key) {
        return pipeline.del(key);
    }

    @Override
    public Response<Long> del(String... keys) {
        return pipeline.del(keys);
    }

    @Override
    public List<Object> exec() {
        return null;
    }
}
