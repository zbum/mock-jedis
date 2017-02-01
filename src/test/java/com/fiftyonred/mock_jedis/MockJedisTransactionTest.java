package com.fiftyonred.mock_jedis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author jibumjung
 */
public class MockJedisTransactionTest {

    private Jedis j = null;

    @Before
    public void setUp() {
        j = new MockJedis("test");
    }

    @Test
    public void testSet() {
        Transaction transaction = j.multi();
        transaction.hset("key", "field", "value");
        transaction.exec();

        assertThat(j.hget("key", "field"), is("value"));
    }
}
